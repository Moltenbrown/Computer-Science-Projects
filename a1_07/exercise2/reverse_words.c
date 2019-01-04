#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <ctype.h>

#define GOAL "The brown fox jumped over the lazy dog."
#define LEN strlen(GOAL)

void swap(char reversed[], int i, int j) {
  char holder = reversed[i];
  reversed[i] = reversed[j];
  reversed[j] = holder;
}

void flip(char reversed[], int low, int hi) {
  while (low < hi) {
    swap(reversed, low++, hi--);
  }
}

void reverse_words() {
  int i;
  int j = 0;
  char *reversed =  malloc(sizeof(char*) * LEN);
  strcpy(reversed, GOAL);
  for (i = 0; i < LEN; i++) {
    if (isspace(reversed[i])) {
      flip(reversed, j, i-1);
      j = i+1;
    }

    if (reversed[i] == '.') {
      flip(reversed, j, i-1);
    }
  }

  char sentence2[LEN];

  strcpy(sentence2, reversed);

  for (i = 0; i < LEN; i++) {
    reversed[i] = 0;
  }

  free(reversed);
  printf("%s\n", sentence2);
}

int main() {
  reverse_words();
  return 0;
}

