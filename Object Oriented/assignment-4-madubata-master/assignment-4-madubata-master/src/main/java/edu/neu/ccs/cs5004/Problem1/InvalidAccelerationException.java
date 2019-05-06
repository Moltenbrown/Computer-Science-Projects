package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents an Invalid Acceleration Exception, which extends Exception.
 *
 * @author Goch
 */
public class InvalidAccelerationException extends Exception {

  /**
   * Creates an out of bounds exception from a string.
   * @param string will be displayed when the exception is hit.
   */
  public InvalidAccelerationException(String string){
    super(string);
  }

}
