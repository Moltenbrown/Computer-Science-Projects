/*
 * CS 5007, Assignment 0
 * Summer 2018
 * Northeastern University, Seattle
 *
 * Author: Adrienne Slaughter
 * 
 * Released: July 5, 2018
 * Due date: July 9, 2018
 */
#include "hello_world.h"

#include <stdio.h>

int main(int argc, char* argv[]) {
  int a = -889262067;
  int b = 330223330;

  say_hello(a, b);
  return 0;
}

void say_hello(int foo, int bar) {
  printf("The magic word is: %X\n", foo + bar);
}
