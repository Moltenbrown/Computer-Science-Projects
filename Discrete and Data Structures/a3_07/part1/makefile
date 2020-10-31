CC=gcc
CFLAGS=-Wall -g

TARGET = idFiles

all: $(TARGET)

$(TARGET): main.c id_files2.c
	@$(CC) $(CFLAGS) -o $(TARGET) main.c id_files2.c

clean:
	rm -f $(TARGET) *.o
