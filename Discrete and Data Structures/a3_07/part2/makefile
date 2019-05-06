CC=gcc
CFLAGS=-Wall -g -std=c11

TARGET = sort_movies

all: $(TARGET)

$(TARGET): main.c sort_movies.c
	@$(CC) $(CFLAGS) -o $(TARGET) main.c sort_movies.c

clean:
	rm -f $(TARGET) *.o
