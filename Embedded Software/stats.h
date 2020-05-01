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
 * @file stats.h
 * @brief Header file for stats program.
 *
 * This contains all the protoypes necessary for the stats program.
 *
 * @author Ugochi Madubata
 * @date 4/30/20
 *
 */
#ifndef __STATS_H__
#define __STATS_H__

/**
 * @brief Returns a sorted unsigned character array.
 *
 * This function takes as an input a unsigned character array and a integer. 
 * Implement insertion sort to sort all the characters in the array from highest
 * to lowest. It will then return the sorted arrat
 *
 * @param array The array to be sorted.
 * @param length An integer representing the size of the array being analyzed.
 *
 * @return The lowest unsigned character in the array.
 */
void sort_array(unsigned char * array, int length);

/**
 * @brief Returns the minimum value of the unsigned char array.
 *
 * This function takes an unsigned character array and an 8 bit
 * integer. It will use the sort function to sort the array 
 * from highest value to lowest value. 
 *
 * @param array The array to be analyzed.
 * @param length This integer representing the size of the array to be 
 *  analyzed.
 *
 * @return Nothing.
 */

unsigned int find_minimum(unsigned char * array, int length);

/**
 * @brief Returns the maximum value of the unsigned char array.
 *
 * This function takes an unsigned character array and an 8 bit
 * integer. It will use the sort function to sort the array 
 * from highest value to lowest value. It will then return the first character
 * in the array.
 *
 * @param array The array to be analyzed.
 * @param length This integer representing the size of the array to be 
 *  analyzed.
 *
 * @return The highest unsigned character in the array.
 */

unsigned int find_maximum(unsigned char * array, int length);

/**
 * @brief Returns the mean of all the characters in the unsigned character 
 * array.
 *
 * This function takes an unsigned character array and an 8 bit integer. It 
 * will add all the values in the array together and then divide that value by 
 * the length of the array to get the mean of the all the values in the array.
 * It will then return that mean value. 
 *
 * @param array The array to be analyzed.
 * @param length This integer representing the size of the array to be 
 *  analyzed.
 *
 * @return The mean of all the characters in the array.
 */

unsigned int find_mean(unsigned char * array, int length);

/**
 * @brief Returns the median of all the characters in the unsigned character 
 * array.
 *
 * This function takes an unsigned character array and an 8 bit integer. It 
 * will use the sort_function to return a sorted array from highest to 
 * lowest value. It will then either return the value in the middle of the 
 * array or it will add the two values in the middle together and then divide
 * that value by 2 to get the median of the array. It will then return that
 * value as an integer. 
 *
 * @param array The array to be analyzed.
 * @param length This integer representing the size of the array to be 
 *  analyzed.
 *
 * @return The median of all the characters in the array.
 */

unsigned int find_median(unsigned char * array, int length);


/**
 * @brief Prints the original array to the screen. 
 *
 * This function takes an unsigned character array and an 8 bit integer. It 
 * will go through each element of the array and then print that character to
 * the screen until the entire array appears on the screen.  
 *
 * @param array The array to be printed.
 * @param length This integer representing the size of the array to be 
 *  printed.
 *
 * @return Nothing.
 */

void print_array(unsigned char * array, int length);

/**
 * @brief Prints the minimum, maximum, mean, and median on the screen. 
 *
 * This function takes an unsigned character array and an 8 bit integer. It 
 * will go use print_array() to print the original array. It will then use
 * find_mean to get the mean of the array and save that as it's own value. It
 * will then use sort_array to sort the array and then use that sorted array.
 * With the sorted array, it will use find_minimum and find_maximum to get the
 * minimum and maximum from the array and return them as their own individual
 * variables. It will then determine whether the length is even or odd. If the
 * length if even, it will add the two values in the middle together and
 * divide that value by two to get the median. If the value is odd, it will
 * find the divide the length by two get the location of the median value of
 * the array. It will then save the median as it's own variable and the
 * function will print the minimum, maximum, mean, and median to the screen. 
 *
 * @param array The array whose statistics will be printed.
 * @param length This integer representing the size of the array.
 *
 * @return Nothing.
 */

void print_statistics(unsigned char * array, int length);



#endif /* __STATS_H__ */
