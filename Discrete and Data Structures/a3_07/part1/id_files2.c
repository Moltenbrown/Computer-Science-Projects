#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <ctype.h>
#include <dirent.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <errno.h>
#include "id_files.h"

#define charNumber 1500

void idFiles(char *directory){
  char *path = "./";
  char *secondaryPath = malloc(charNumber * sizeof(char));
  strcpy(secondaryPath, path);
  strcat(secondaryPath, directory);

  // getting all directories and file that are present under our current directory.
  struct dirent **directoryContents = (struct dirent **)malloc(sizeof(struct dirent *));
  int directoryCapacity = scandir(secondaryPath, &directoryContents, NULL, alphasort);

  if(directoryCapacity == -1) {
    perror("There was an issue scanning the directory.");
    exit(2);
  }


 char **nameHolder = (char **)malloc(charNumber * sizeof(char *)); // array to hold all the names
  for (int i = 0; i < charNumber; i++) {
    nameHolder[i] = malloc(charNumber * sizeof(char));;
  }
  int nameHolderAmount = 0;

  struct stat *directoryInfo = malloc(sizeof(struct stat));
  char *directoryPath = malloc(charNumber * sizeof(char));
  strcpy(directoryPath, secondaryPath);
  DIR *startingDirectory;
  struct dirent *currentDirectory;
  
  char *name = malloc(charNumber * sizeof(char)); 
  strcpy(name, secondaryPath);
  strcat(name, "results.txt");
  FILE *file = fopen(name,"wb");
  if(file == NULL) {
    perror("File creation issue");
  }
  
  for (int i = 0; i < directoryCapacity; i++) {
    if (directoryContents[i]->d_name[0] == '.' || directoryContents[i]->d_name[0] == "~" || directoryContents[i]->d_name[strlen(directoryContents[i]->d_name)-1] == "~") {
      directoryContents[i] = NULL;
      free(directoryContents[i]);
    }

    else {
      strcat(directoryPath, "/");
      strcat(directoryPath, directoryContents[i]->d_name);
      strcat(directoryPath, "/");
      strcpy(nameHolder[nameHolderAmount], directoryContents[i]->d_name);
    
      if((startingDirectory = opendir(directoryPath)) == NULL) {
        nameHolderAmount++;
        strcpy(directoryPath, secondaryPath);
        continue;
      }

      while((currentDirectory = readdir(startingDirectory)) != NULL) {
        strcat(nameHolder[nameHolderAmount], "/");
        strcat(nameHolder[nameHolderAmount], currentDirectory->d_name);
      }

      closedir(startingDirectory);
      strcpy(directoryPath, secondaryPath);
      directoryContents[i] = NULL;
      free(directoryContents[i]);
      nameHolderAmount++;
    }
  }        

  for (int i = 0; i < nameHolderAmount; i++) {
    //printf("%s\n", nameHolder[i]);
    fputs(nameHolder[i], file);
    fputs("\n", file);
  }

  free(nameHolder);
  fclose(file);
}



