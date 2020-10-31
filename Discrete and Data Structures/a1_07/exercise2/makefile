CC=gcc
CFLAGS=-Wall -g -std=c11

TARGET = exer2

all: run

$(TARGET): main.c
	@$(CC) $(CFLAGS) -o $(TARGET) main.c

run: $(TARGET)
	@./$(TARGET)

clean:
	$(RM) $(TARGET)
