#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <ctype.h>
#include "sort_movies.h"

#define movieListLength 6000
#define genreLength 100
#define titleLength 100
#define filePath 100
#define movieStringLength 3000
#define durationLength 3
#define contentRatingLength 1
#define starRatingLength 3

int cmpRatings (const void *a, const void *b) {
  movie *first = (movie *) a;
  movie *second = (movie *) b;
  return (second->star_rating - first->star_rating);
}

int cmpDuration (const void *a, const void *b) {
  movie *first = (movie *) a;
  movie *second = (movie *) b;
  return (second->duration - first->duration);
}

int cmpTitle (const void *a, const void *b) {
  movie *first = (movie *) a;
  movie *second = (movie *) b;
  return strcmp(first->title, second->title);
}

void sortMovies (char *file, char *sortMethod) {

  char *path = (char *)malloc(filePath * sizeof (char));
  strcpy(path, "./");
  strcat(path, file);
  FILE *openFile = (FILE *)malloc(sizeof(FILE));
  openFile = fopen(path, "rb");
  if(openFile == NULL) {
    perror("Issue opening the file");
    exit(2);
  }
  free(path);

  movie **movieList = malloc(movieListLength * sizeof(movie *));
  for (int i = 0; i < movieListLength; i++) {
    movieList[i] = malloc(sizeof(movie));
    movieList[i]->title = malloc(titleLength * sizeof(char));
    movieList[i]->genre = malloc(genreLength * sizeof(char));
    movieList[i]->content_rating = malloc(contentRatingLength * sizeof(char));
  }
  
  int movieListAmount = 0;
  char * movieString = malloc(movieStringLength * sizeof(char));
;
  char *token;
  char delimiter[2] = ",";
  
  fgets(movieString, movieStringLength * sizeof(char ), openFile);
  printf("%s\n", movieString);
  int successCheck;

  while((successCheck = fgets(movieString, movieStringLength * sizeof(char), openFile)) != NULL) {
    
    token = strtok(movieString, delimiter);
    if (token == NULL) {
      movieList[movieListAmount]->star_rating = 0.0;
    }
    else {
      movieList[movieListAmount]->star_rating = atof(token);
    }
    
    token = strtok(NULL, delimiter);
    if (token == NULL) {
      strcpy(movieList[movieListAmount]->title, "Unknown");
    }
    else {
      strcpy(movieList[movieListAmount]->title, token);
    }
    
    token = strtok(NULL, delimiter);
    if (token == NULL) {
      strcpy(movieList[movieListAmount]->content_rating, "NA");
    }
    else {
      strcpy(movieList[movieListAmount]->content_rating, token);
    }
    
    token = strtok(NULL, delimiter);
    if (token == NULL) {
      strcpy(movieList[movieListAmount]->genre, "Unknown");
    }
    else {
      strcpy(movieList[movieListAmount]->genre, token);
    }
    
    token = strtok(NULL, delimiter);
    if (token == NULL) {
      movieList[movieListAmount]->duration = 0;
    }
    
    else {
      movieList[movieListAmount]->duration = atoi(token);
    }

    movieListAmount++;
    continue;
  }
  
  fclose(openFile);
  free(openFile);
  movieString = NULL;
  free(movieString);
  int checker;
  
  if ((checker = strcmp(sortMethod, "-r")) == 0) {
    qsort(&movieList, movieListAmount, sizeof(struct movie *), cmpRatings);
  }

  if ((checker = strcmp(sortMethod, "-d")) == 0) {
    qsort(&movieList, movieListAmount, sizeof(struct movie *), cmpDuration);
  }

  if ((checker = strcmp(sortMethod, "-t")) == 0) {
    qsort(&movieList, movieListAmount, sizeof(struct movie *), cmpTitle);
  }
  
  for (int i = 0; i < movieListAmount; i++) {
    printf("%.2f,%s,%s,%s,%d\n", movieList[i]->star_rating, movieList[i]->title, movieList[i]->content_rating, movieList[i]->genre, movieList[i]->duration);
    free(movieList[i]->title);
    free(movieList[i]->genre);
    free(movieList[i]->content_rating);
    free(movieList[i]);
  }

  free(movieList);
} 

  
