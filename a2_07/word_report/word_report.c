#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <ctype.h>
#include "word_report.h"

void largestWord(char *file) {
    FILE *openFile = fopen(file, "r");
    char *biggest = (char *)malloc(1024 * sizeof(char *));
    fscanf(openFile, "%s", biggest);
    int biggestSize = strlen(biggest);

    char *word = (char *)malloc(1024 * sizeof(char *));

    while(fscanf(openFile, "%s", word) != EOF) {
       fscanf(openFile, "%s", word);
       int comparator = strlen(word);
       // this function holds the first instance of the largest word of a given
       // size and doesn't change unless there is a larger word.
       if(biggestSize < comparator) { 
          biggest = word;
          biggestSize = strlen(biggest);
       }
    }

    int i; 
    for(i = 0; i < biggestSize; i++){
        int checker = ispunct(biggest[i]);
	if(!checker) {
	    printf("%c", biggest[i]);
	}

	biggest[i] = 0;
	word[i] = 0;
    } 

    printf("\n");
    fclose(openFile);
    free(biggest);
    //free(word);
}

void smallestWord(char *file) {
    FILE *openFile = fopen(file, "r");
    char *smallest =  (char *)malloc(1024 * sizeof(char *));
    fscanf(openFile, "%s", smallest);
    int smallestSize = strlen(smallest);

    char *word = (char *)malloc(1024 * sizeof(char *));

    while(fscanf(openFile, "%s", word) != EOF) {
       fscanf(openFile, "%s", word);
       int comparator = strlen(word);
       if(smallestSize > comparator) {
	  smallest = word;
          smallestSize = strlen(smallest);
       }
    }

    int i; 
    for(i = 0; i < smallestSize; i++){
        int checker = ispunct(smallest[i]);
	if(!checker) {
	    printf("%c", smallest[i]);
	}

	smallest[i] = 0;
	word[i] = 0;
    } 

    printf("\n");
    fclose(openFile);
    free(smallest);
    //free(word);
}

void wordReport(char *file){
    printf("Longest word: ");
    largestWord(file);
    printf("Shortest word: ");
    smallestWord(file);

}
