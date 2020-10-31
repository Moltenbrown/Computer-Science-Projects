#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <ctype.h>
#include "word_report.h"

int main(int argc, char *argv[]) {
    if(argc < 2) {
	printf("You have to include the file extension in order for this program to work. Please try again.");
    }

    else {
	wordReport(argv[1]);
    }

    return 0;
}
