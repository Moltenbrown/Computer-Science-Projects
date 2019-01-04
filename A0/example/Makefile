all: hello

hello: hello.c libgoodbye.dylib libwave.dylib
	gcc -o hello hello.c -lgoodbye -lwave -L./mylib

libgoodbye.dylib: goodbye.c
	gcc -dynamiclib -Wall -Werror -o mylib/libgoodbye.dylib goodbye.c

libwave.dylib: wave.c
	gcc -dynamiclib -Wall -Werror -o mylib/libwave.dylib wave.c

run: hello 
	@echo LD_LIBRARY_PATH $(LD_LIBRARY_PATH)
	LD_LIBRARY_PATH=$LD_LIBRARY_PATH:./mylib ./hello

run_broken: hello 
	@echo LD_LIBRARY_PATH $(LD_LIBRARY_PATH)
	./hello

clean:
	rm *.o mylib/*.dylib hello
