#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <ctype.h>
#include <dirent.h>
#include "id_files.h"

int main(int argc, char *argv[]) {
    if(argv < 2) {
	    printf("You much include the directory name for the program to work. Please try again.");
    }

    else {
	    idFiles(argv[1]);
    }

    return 0;
}
