#include <cstring>
#include <cstdlib>
#include <cstdio>
#include <Logger.h>
#include <Thread.h>
#include <Map.h>
#include <Lock.h>
#include <List.h>
#include "GlobalVariables.h"

const char *lockThreadMap;
const char *threadLockMap;
const char *threadLockAttempts;
const char *lockThreadAttempts;

void lockCreated(const char* lockId){
    bool lockExistsVariable = lockExists(lockId);
    char buffer[1024];

    if(lockExistsVariable) {// making sure the entered lock exists.
        sprintf(buffer, "Lock %s has just been created.\n", lockId);
        verboseLog(buffer);
    }

    else {
        sprintf(buffer, "Lock %s does not exist.\n", lockId);
        verboseLog(buffer);
    }
}

void lockAttempted(const char* lockId, Thread* thread){
    bool lockExistsVariable = lockExists(lockId);

    if(lockExistsVariable){
        char buffer[1024];
        sprintf(buffer, "Thread %s attempted to lock lock %s.\n", thread->name, lockId);
        verboseLog(buffer);

        bool isLockedCheck = isLocked(lockId);
        if (isLockedCheck) {
            PUT_IN_MAP(Thread *, threadLockAttempts, thread, (void *)lockId);
            PUT_IN_MAP(const char *, lockThreadAttempts, lockId, (void *)thread);
            lockFailed(lockId, thread);
        };

        if(!isLockedCheck){
            if(MAP_CONTAINS(Thread *, threadLockAttempts, thread)) {
                REMOVE_FROM_MAP(Thread *, threadLockAttempts, thread);
            }

            lockAcquired(lockId, thread);
        }
    }
}

void lockAcquired(const char* lockId, Thread* thread){
    char buffer[1024];
    sprintf(buffer, "Thread %s successfully locked lock %s.\n", thread->name, lockId);
    verboseLog(buffer);
    PUT_IN_MAP(const char *, lockThreadMap, lockId, (void *)thread);
    PUT_IN_MAP(Thread *, threadLockMap, thread, (void *)lockId);
}

void lockFailed(const char* lockId, Thread* thread){
    Thread *currentLockHolder = getThreadHoldingLock(lockId);
    char buffer[1024];
    sprintf(buffer, "Lock %s is being used by thread %s. Thread %s failed to acquire the lock.\n", lockId,
            currentLockHolder->name, thread->name);
    verboseLog(buffer);
}

void lockReleased(const char* lockId, Thread* thread){
    char buffer[1024];

    Thread *threadToRelease = (Thread *)REMOVE_FROM_MAP(const char *, lockThreadMap, lockId);
    const char *unlockedLock  = (const char *) REMOVE_FROM_MAP(Thread *, threadLockMap, thread);

    unlock(unlockedLock);

    nextThreadToRun(getCurrentTick());

    if(threadToRelease == thread && unlockedLock == lockId) {
        sprintf(buffer, "Thread %s successfully released lock %s.\n", thread->name, lockId);
        verboseLog(buffer);
    }

    else {
        sprintf(buffer, "There was an unknown issue with the mapping.");
        verboseLog(buffer);
    }
}
