CC=gcc
CFLAGS=-Wall -g -std=c11
EXTRA_FLAGS=-shared -o

TARGET = madlibs

all: $(TARGET)

$(TARGET): main.c madlibs.c
	@$(CC) $(CFLAGS) -o $(TARGET) main.c madlibs.c

clean: 
	rm -f $(TARGET) *.o
