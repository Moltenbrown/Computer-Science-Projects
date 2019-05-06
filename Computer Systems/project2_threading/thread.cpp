#include <cstring>
#include <cstdlib>
#include <cstdio>
#include <Logger.h>

#include "List.h"
#include "Thread.h"
#include "Map.h"
#include "GlobalVariables.h"
#include "Lock.h"

const char* readyList = NULL;
const char* sameList = NULL;
const char* sleepingThreads;
int pointInSameList = 0;
int pointPassedInReadyList = 1;


bool comparator(void *thread1, void *thread2) {
    Thread *first = (Thread *)thread1;
    Thread *second = (Thread *)thread2;
    if(first->priority <= second->priority) {
        return true;
    }

    return false;
}

Thread* getThreadHoldingLock(const char* lockId) {
    Thread *thread = (Thread *)GET_FROM_MAP(const char *, threadLockMap, lockId);
    return thread;
}

Thread* createAndSetThreadToRun(char* name, void* (*func)(void*), void* arg, int pri) {
    initializeCallback();

    Thread* ret = (Thread *)malloc(sizeof(Thread));
    ret->name = (char*)malloc(strlen(name)+1);
    strcpy(ret->name, name);
    ret->func = func;
    ret->arg = arg;
    ret->state = CREATED;
    ret->priority = pri;
    ret->originalPriority = pri;

    createThread(ret);
    Thread* holder;

    if(listSize(sameList) > 0){
        holder = (Thread *)listGet(sameList, 0);
        if(ret->priority = holder->priority) {
            addToList(sameList, (void *)ret);
        }

        else {
            addToList(readyList, (void *)ret);
        }
    }

    else {
        addToList(readyList, (void*)ret);
    }

    if(listSize(readyList)>0){
        sortList(readyList, comparator);
    }

    return nextThreadToRun(getCurrentTick());
}

void destroyThread(Thread* thread) {
    if(MAP_CONTAINS(Thread *, sleepingThreads, thread)) {
        REMOVE_FROM_MAP(Thread *, sleepingThreads, thread);
    }

    // in case the thread is in either of my structures or the lock associated with the thread is still locked.
    removeFromList(sameList, (void *)thread);
    removeFromList(readyList, (void *)thread);

    const char *lockToUnLock = (const char *)GET_FROM_MAP(Thread *, threadLockMap, thread);
    if(isLocked(lockToUnLock)) {
        unlock(lockToUnLock);
    }

    free(thread->name);
    free(thread);
}

Thread* nextThreadToRun(int currentTick) {
    char line[1024];
    if (listSize(readyList) == 0 && listSize(sameList) == 0) {
        return NULL;
    }

    Thread* currentRunningThread = getCurrentThread();
    if(currentRunningThread != NULL) {
        if (!MAP_CONTAINS(Thread * , threadLockMap, currentRunningThread)) {
            if (currentRunningThread->priority != currentRunningThread->originalPriority) {
                setMyPriority(currentRunningThread->originalPriority);
            }
        }
    }


    Thread* ret = NULL;
    Thread* holder = NULL;

    do {
        sprintf(line, "Current Tick is %d\n", currentTick);
        verboseLog(line);

        if(listSize(sameList)>0) {// means a same list was generated during a previous use of nextThreadToRun
            if(pointInSameList == listSize(sameList)) {
                pointInSameList = 0;
            };

            holder = ((Thread *)listGet(sameList, pointInSameList++));
            if(listSize(readyList) > 0){
                sortList(readyList, comparator);
                ret = ((Thread *)listGet(readyList, 0));
                if(holder->priority > ret->priority) {
                    ret = holder;
                }
            }
        }

        else {
            sortList(readyList, comparator);
            ret = ((Thread *) listGet(readyList, 0));
            int sizeOfStartingList = listSize(readyList);

            if (sizeOfStartingList > 1) {
                addToList(sameList, (void *) ret);
                removeFromList(readyList, ret);
                do {
                    holder == (Thread *)listGet(readyList, pointPassedInReadyList++);
                    if (ret->priority == holder->priority) {
                        addToList(sameList, (void *) holder);
                        sprintf(line, "%s was passed into same list.", holder->name);
                        verboseLog(line);
                        removeFromList(readyList, holder);
                    }
                }while(pointPassedInReadyList <= sizeOfStartingList);

                pointPassedInReadyList = 1;
            }
        }

        if(ret->state == PAUSED) {
            while(MAP_CONTAINS(Thread*, sleepingThreads, ret)){
                int wakeCheck = *(int *)GET_FROM_MAP(Thread*, sleepingThreads, ret);
                if(currentTick < wakeCheck) {
                    if(listSize(sameList)>1) {
                        holder = ((Thread *)listGet(sameList, pointInSameList++));
                        if(pointInSameList == listSize(sameList)) {
                            pointInSameList = 0;
                        }

                        if(holder->priority >= ret->priority) {
                            ret = holder;
                        }

                        else {
                          if(listSize(readyList) > 0) {
                              ret = ((Thread *) listGet(readyList, 0));
                          }
                        }

                    } else if (listSize(readyList) > 1) {
                        ret = ((Thread *) listGet(readyList, 0));
                    }
                }

                if(currentTick >= wakeCheck) {

                    REMOVE_FROM_MAP(Thread *, sleepingThreads, ret);
                    sprintf(line, "Thread %s is waking up.", ret->name);
                }
            }

            if(MAP_CONTAINS(Thread *, threadLockAttempts, ret)) {
                const char *necessaryLock = (const char *) GET_FROM_MAP(Thread *, threadLockAttempts, ret);
                Thread *priorityThread = (Thread *) GET_FROM_MAP(const char *, lockThreadMap, necessaryLock);

                if (priorityThread == currentRunningThread) {
                    setMyPriority(ret->priority);
                }

                if (MAP_CONTAINS(Thread *, threadLockAttempts, priorityThread)) {
                    Thread *currentThreadToCheck = priorityThread;
                    while (MAP_CONTAINS(Thread *, threadLockAttempts, currentThreadToCheck)) {
                        const char *lockWeAreSearchingFor =
                                (const char *) GET_FROM_MAP(Thread *, threadLockAttempts, currentThreadToCheck);
                        if(currentThreadToCheck->priority < ret->priority) {
                            currentThreadToCheck->priority = ret->priority;
                        }

                        currentThreadToCheck = (Thread *)GET_FROM_MAP(const char *, lockThreadMap,
                                lockWeAreSearchingFor);
                    }
                }
            }
        }



        if (ret->state == TERMINATED && listSize(sameList) > 0) {
            verboseLog("Thread is terminated\n");
            removeFromList(readyList, ret);
            removeFromList(sameList, ret);
            ret = NULL;
        }

        if(ret->state == TERMINATED && listSize(sameList) == 0) {
            verboseLog("Thread is terminated\n");
            removeFromList(readyList, ret);
            ret = NULL;
        }

    } while((listSize(readyList) > 0 || listSize(sameList) > 0) && ret == NULL);

    return ret;
}

void initializeCallback() {
    readyList = createNewList();
    sameList = createNewList();
    sleepingThreads = CREATE_MAP(Thread *);
    lockThreadMap = CREATE_MAP(const char *);
    threadLockMap = CREATE_MAP(Thread *);
    threadLockAttempts = CREATE_MAP(Thread *);
}

void shutdownCallback() {
    int sizeOfReadyList = listSize(readyList);
    int sizeOfSameList = listSize(sameList);
    Thread *threadToDestroy;
    Thread *caughtInDestruction;
    const char *lock;

    for(int i = 0; i < sizeOfReadyList; i++) {
        threadToDestroy = (Thread *)removeFromListAtIndex(readyList, 0);
        if(MAP_CONTAINS(Thread *, sleepingThreads, threadToDestroy)){
            REMOVE_FROM_MAP(Thread *, sleepingThreads, threadToDestroy);
            destroyThread(threadToDestroy);
        }

        if(MAP_CONTAINS(Thread *, threadLockAttempts, threadToDestroy)){
            lock = (const char *)REMOVE_FROM_MAP(Thread *, threadLockAttempts, threadToDestroy);
            REMOVE_FROM_MAP(const char *, lockThreadAttempts, lock);
            caughtInDestruction = (Thread *)REMOVE_FROM_MAP(const char *, lockThreadMap, lock);
            REMOVE_FROM_MAP(Thread *, threadLockMap, caughtInDestruction);
            destroyLock(lock);
            destroyThread(caughtInDestruction);
            destroyThread(threadToDestroy);
        }

        if(MAP_CONTAINS(Thread *, threadLockMap, threadToDestroy)){
            lock = (const char *)REMOVE_FROM_MAP(Thread *, threadLockMap, threadToDestroy);
            REMOVE_FROM_MAP(const char *, lockThreadMap, lock);
            destroyLock(lock);
            destroyThread(threadToDestroy);
        }
    }

    destroyList(readyList);

    for(int i = 0; i < sizeOfSameList; i++) {
        threadToDestroy = (Thread *)removeFromListAtIndex(sameList, 0);
        if(MAP_CONTAINS(Thread *, sleepingThreads, threadToDestroy)){
            REMOVE_FROM_MAP(Thread *, sleepingThreads, threadToDestroy);
            destroyThread(threadToDestroy);
        }

        if(MAP_CONTAINS(Thread *, threadLockAttempts, threadToDestroy)){
            lock = (const char *)REMOVE_FROM_MAP(Thread *, threadLockAttempts, threadToDestroy);
            REMOVE_FROM_MAP(const char *, lockThreadAttempts, lock);
            caughtInDestruction = (Thread *)REMOVE_FROM_MAP(const char *, lockThreadMap, lock);
            REMOVE_FROM_MAP(Thread *, threadLockMap, caughtInDestruction);
            destroyLock(lock);
            destroyThread(caughtInDestruction);
            destroyThread(threadToDestroy);
        }

        if(MAP_CONTAINS(Thread *, threadLockMap, threadToDestroy)){
            lock = (const char *)REMOVE_FROM_MAP(Thread *, threadLockMap, threadToDestroy);
            REMOVE_FROM_MAP(const char *, lockThreadMap, lock);
            destroyLock(lock);
            destroyThread(threadToDestroy);
        }
    }

    destroyList(sameList);


}

int tickSleep(int numTicks) {
    char buffer[1024];
    int currentTickAmount = getCurrentTick();
    int whenThreadNeedsToWake = currentTickAmount + numTicks;
    Thread *currentThreadRunning = getCurrentThread();

    stopExecutingThreadForCycle();

    // Putting thread into a sleep map so I can keep track of when it's supposed to wake up.
    currentThreadRunning->state = PAUSED;
    const char *lockToUnlock = (const char *)REMOVE_FROM_MAP(Thread *, threadLockMap, currentThreadRunning);
    REMOVE_FROM_MAP(const char *, lockThreadMap, lockToUnlock);
    unlock(lockToUnlock);
    PUT_IN_MAP(Thread *, sleepingThreads, currentThreadRunning, (void *)&whenThreadNeedsToWake);
    sprintf(buffer, "Thread %s is going to sleep.", currentThreadRunning->name);

    return currentTickAmount;
}

void setMyPriority(int priority) {
    Thread *currentThread = getCurrentThread();
    currentThread->priority = priority;
    if(listSize(sameList) > 0) {
        Thread *comparatorThread = (Thread *)listGet(sameList, 0);
        if(comparatorThread->priority == currentThread->priority) {
            addToList(sameList, (void *)currentThread);
            removeFromList(readyList, (void *)currentThread);
        }
    }

    else {
        addToList(readyList, currentThread);
    }
}
