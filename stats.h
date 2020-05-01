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
 * @brief RSore
 *
 * This function takes as an input a unsigned character array. It will 
 * use the sort function to sort the array from lowest value to highest value. * It will then return the first character in the array.
 *
 * @param array The array to be sorted and analyzed.
 *
 * @return The lowest unsigned character in the array.
 */

unsigned char find_minimum(unsigned char * array);

/**
 * @brief Returns the minimum value of the unsigned char array.
 *
 * This function takes as an input an unsigned character array and an 8 bit
 * integer containing the . It will use the sort function to sort the array 
 * from lowest value to highest value. It will then return the first character
 * in the array.
 *
 * @param array The array to be sorted and analyzed.
 * @param length This integer representing the size of the array to be 
 *  analyzed.
 *
 * @return The lowest unsigned character in the array.
 */

unsigned char find_minimum(unsigned char * array);
#endif /* __STATS_H__ */
