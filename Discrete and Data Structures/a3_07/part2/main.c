#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <ctype.h>
#include "sort_movies.h"

int main (int argc, char *argv[]) {
  if (argc < 3) {
    printf ("You have to include the name of the file and a tag representing what type of sorting you want. The tags are -r for sorting by star rating in descending order, -d for sorting by movie duration in descending order, or -t for sorting by title in ascending order.");
    exit(0);
  }

  else if (argc > 3) {
    printf ("You have entered more tags than the program will allow. Please try again.");
    exit(0);
  }

  else {
    sortMovies(argv[1], argv[2]);
  }

  return 0;
}
