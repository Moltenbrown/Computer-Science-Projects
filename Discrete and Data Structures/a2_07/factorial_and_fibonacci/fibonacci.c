// fibonacci.c

#include <stdio.h>
#include <stdlib.h>
#include "fibonacci.h"

int fibonacci(int number) {
    int i;
    int *fibonacci = (int *)malloc(number * sizeof(int));
    fibonacci[0] = 0;
    fibonacci[1] = 1;
    
    for(i = 2; i <= number; i++) {
        fibonacci[i] = fibonacci[i-1] + fibonacci [i -2];
    }

    return fibonacci[number];
}


