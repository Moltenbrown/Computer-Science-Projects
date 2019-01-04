#ifndef SORT_MOVIES_H
#define SORT_MOVIES_H
//Example of what the data in the csv file will look like.
//star_rating,title,content_rating,genre,duration,actors_list
//9.3,The Shawshank Redemption,R,Crime,142,"[u'Tim Robbins', u'Morgan Freeman', u'Bob Gunton']"
//9.2,The Godfather,R,Crime,175,"[u'Marlon Brando', u'Al Pacino', u'James Caan']"
//9.1,The Godfather: Part II,R,Crime,200,"[u'Al Pacino', u'Robert De Niro', u'Robert Duvall']"

typedef struct Movie
{
  double star_rating;
  char *title;
  char *content_rating;
  char *genre;
  int duration;
} movie;

// Given the name of a file and the sort method, this function will output the movies, in sorted order based on the tag the user entered. 
void sortMovies (char *file, char *sortMethod);

// A comparator based on star ratings going in descending order.
int cmpRatings (const void *a, const void *b);

// A comparator based on duration going in descending order.
int cmpDuration (const void *a, const void*b);

// A comparator based on title going in ascending order.
int cmpTitle (const void *a, const void *b);

#endif //SORT_MOVIES_H
