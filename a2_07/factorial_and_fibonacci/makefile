CC=gcc
CFLAGS=-c -Wall -Werror -fpic
EXTRA_FLAGS=-shared -o

TARGET = fnumbers

LOCATION = /home/ugochi/cs5007/madubata/a2_07/factorial_and_fibonacci

all: $(TARGET)

$(TARGET): main.c
	@$(CC) -Wall -g -std=c11 -o $(TARGET) main.c -lfactorial -lfibonacci

main.c: libfactorial.so libfibonacci.so
	@sudo cp /home/ugochi/cs5007/madubata/a2_07/factorial_and_fibonacci/libfactorial.so /usr/lib
	@sudo chmod 0755 /usr/lib/libfactorial.so
	@sudo cp /home/ugochi/cs5007/madubata/a2_07/factorial_and_fibonacci/libfibonacci.so /usr/lib
	@sudo chmod 0755 /usr/lib/libfibonacci.so
	@sudo ldconfig

libfactorial.so: factorial.o
	@$(CC) $(EXTRA_FLAGS) libfactorial.so factorial.o

factorial.o: factorial.c
	@$(CC) $(CFLAGS) factorial.c

libfibonacci.so: fibonacci.o
	@$(CC) $(EXTRA_FLAGS) libfibonacci.so fibonacci.o

fibonacci.o: fibonacci.c
	@$(CC) $(CFLAGS) fibonacci.c
	

run: $(TARGET)
	@./$(TARGET)

clean:
	$(RM) $(TARGET) libfibonacci.so fibonacci.o libfactorial.so factorial.o
