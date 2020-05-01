/******************************************************************************
 * Copyright (C) 2017 by Alex Fosdick - University of Colorado
 *
 * Redistribution, modification or use of this software in source or binary
 * forms is permitted as long as the files maintain this copyright. Users are 
 * permitted to modify this and use it to learn about the field of embedded
 * software. Alex Fosdick and the University of Colorado are not liable for any
 * misuse of this material. 
 *
 *****************************************************************************/
/**
 * @file stats.c
 * @brief Perform statistical analysis on a data set. 
 *
 * <Add Extended Description Here>
 *
 * @author Ugochi Madubata
 * @date 4/30/20
 *
 */



#include <stdio.h>
#include "stats.h"

/* Size of the Data Set */
#define SIZE (40)

void main() {

  unsigned char test[SIZE] = { 34, 201, 190, 154,   8, 194,   2,   6,
                              114, 88,   45,  76, 123,  87,  25,  23,
                              200, 122, 150, 90,   92,  87, 177, 244,
                              201,   6,  12,  60,   8,   2,   5,  67,
                                7,  87, 250, 230,  99,   3, 100,  90};
  print_array(test, SIZE);
  print_statistics(test, SIZE);

  /* Other Variable Declarations Go Here */
  /* Statistics and Printing Functions Go Here */

}

/* Add other Implementation File Code Here */
//prints the array
void print_array(unsigned char * array, int length){
	printf("[%d", array[0]);
	for (int i = 1; i < length; i++) {
		printf(", %d", array[i]);	
	}

	printf("]\n\n");
}

//returns the mean of all the elements in the array
unsigned int find_mean(unsigned char * array, int length) {
	unsigned int total = 0;
	for (int i = 0; i < length; i++) {
		unsigned int value = array[i] - '0';
		total += value;	
	}

	total /= length;
	return total;
}

//prints the statistics for the array
void print_statistics(unsigned char * array, int length){
	int mean = find_mean(array, length);
	int minimum = find_minimum(array, length);
	int maximum = find_maximum(array, length);
	int median = find_median(array, length);
	printf("The mean is: %d\n", mean);
	printf("The median is: %d\n", median);
	printf("The minimum is: %d\n", minimum);
	printf("The maximum is: %d\n", maximum);

}

void sort_array(unsigned char * array, int length){
	for (int i = 0; i < length; i++){
		for (int j = i+1; j < length; j++){
			if (array[i] < array[j]) {
				unsigned char temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			} 
		}
	}
}

unsigned int find_minimum(unsigned char * array, int length) {
	sort_array(array, length);
	return array[length-1];

}

unsigned int find_maximum(unsigned char * array, int length) {
	sort_array(array, length);
	return array[0];
}

unsigned int find_median(unsigned char * array, int length) {
	sort_array(array, length);
	if(length % 2) {
		int middle = length/2;
		return array[middle];
	} else {
		int right = length/2;
		int left = right - 1;
		int median = array[right] + array[left];
		median /= 2;
		return median;
	}
}