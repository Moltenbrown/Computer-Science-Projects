package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents an Invalid Spot Size Exception that shows when a user tries to fit a vehicle
 * in a parking space that is too small. Small vehicles can go in any size parking spot, medium
 * size vehicles can only go in medium or large size parking spots, and large vehicles can only
 * go in large parking spots.
 *
 * @author Goch
 */
public class InvalidSpotSizeException extends Exception {

  /**
   * Creates a new invalid spot size exception from a string.
   * @param string what is presented to the user when the invalid spot size exception is hit.
   */
  public InvalidSpotSizeException(String string){
    super(string);
  }

}
