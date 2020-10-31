#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include "madlibs.h"

void madlibs() {
    char *noun = (char *)malloc(sizeof(char *));
    char *location = (char *)malloc(sizeof(char *));
    char *adjective = (char *)malloc(sizeof(char *));
    char *landType = (char *)malloc(sizeof(char *));
    printf("For this program, please use words that are 100 characters max.\nPlease give me a weather related noun: \n");
    scanf("%s", noun);

    printf("Please give me a location: \n");
    scanf("%s", location);

    printf("Please give me an adjective: \n");
    scanf("%s", adjective);

    printf("Please give me a land type from amoung these options: plain, mesa, or mountain: \n");
    scanf("%s", landType);

    printf("The %s in %s is %s on the %s.\n", noun, location, adjective, landType);
    free(noun);
    free(location);
    free(adjective);
    free(landType);
}
    
    
