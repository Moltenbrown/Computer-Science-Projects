//
// Created by ugochi on 10/21/18.
//

#ifndef OS_SIMULATOR_GLOBALVARIABLES_H
#define OS_SIMULATOR_GLOBALVARIABLES_H
// structures used by both the functions in the lock file and the functions in the thread file.

extern const char *lockThreadMap;
extern const char *threadLockMap;
extern const char *threadLockAttempts;
extern const char *lockThreadAttempts;
extern const char* readyList;
extern const char* sameList;
extern const char* sleepingThreads;

#endif //OS_SIMULATOR_GLOBALVARIABLES_H
