//factorial.c

#include <stdio.h>
#include <stdlib.h>
#include "factorial.h"

int factorial(int number) {
    printf("%d\n", number);
    int factorial = 1;
    int i;
    for(i = 1; i <= number; i++){
	factorial *= i;
    }

    return factorial;
}
