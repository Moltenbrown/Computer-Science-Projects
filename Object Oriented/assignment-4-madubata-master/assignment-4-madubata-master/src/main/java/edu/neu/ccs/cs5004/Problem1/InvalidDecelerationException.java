package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents an Invalid Deceleration Exception that extends Exception.
 *
 * @author Goch
 */
public class InvalidDecelerationException extends Exception {
  /**
   * Creates an out of bounds exception from a string.
   * @param string will be displayed when the exception is hit.
   */
  public InvalidDecelerationException(String string){
    super(string);}

}
