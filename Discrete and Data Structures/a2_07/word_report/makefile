CC=gcc
CFLAGS=-Wall -g -std=c11
EXTRA_FLAGS=-shared -o

TARGET = wordreport

all: $(TARGET)

$(TARGET): main.c word_report.c
	@$(CC) $(CFLAGS) -o $(TARGET) main.c word_report.c

clean: 
	rm -f $(TARGET) *.o
