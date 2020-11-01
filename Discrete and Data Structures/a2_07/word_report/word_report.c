#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <ctype.h>
#include "word_report.h"

void largestAndSmallest(char *file, int choice) {
  if(strlen(file) < 5) {
    printf("The function requires a file. Please type again.");
  }

  if (isalpha(choice)) {
    printf("A number is required for the choice variable. Please try again.");
    exit(1);
  }

  if (isdigit(choice)) {
    if (choice == 0 || choice > 2) {
      printf("The only options that allowed for choice are a 1 or 2. Please check the code base.");
    }
  }

  FILE *openFile = fopen(file, "r");
  char *biggest = (char *)malloc(1024 * sizeof(char *));
  char *smallest = (char *)malloc(1024 * sizeof(char *));
  fscanf(openFile, "%s", biggest);
  smallest = biggest;
  int biggestSize = strlen(biggest);
  int smallestSize = biggestSize;

  char *word = (char *)malloc(1024 * sizeof(char *));

  while(fscanf(openFile, "%s", word) != EOF) {
     int comparator = strlen(word);
     
     // this function holds the first instance of the largest word of a given
     // size and doesn't change unless there is a larger word.
     if(biggestSize < comparator) { 
        biggest = word;
        biggestSize = comparator;
     }

     if(smallestSize > comparator) {
      smallest = word;
      // printf("%s\n", word);
      smallestSize = comparator;
     }
  }

  fclose(openFile);

  if (choice == 1) {
    printf("%s\n", biggest);
  } else {
    printf("%s\n", smallest);
  }

  // free(word);
  // free(biggest);
  // free(smallest);
}

void wordReport(char *file){
    printf("Longest word: ");
    largestAndSmallest(file, 1);
    printf("Shortest word: ");
    largestAndSmallest(file, 2);

}
