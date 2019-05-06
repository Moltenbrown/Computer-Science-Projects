package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents an Unavailable Spot Exception. When a user tries to park in an unavailable spot, this
 * exception is hit.
 */
public class UnavailableSpotException extends Exception {

  /**
   * Creates a new unavailable spot exception when the exception is hit.
   * @param string what the user sees when they they try to park in an occupied parking spot.
   */
  public UnavailableSpotException(String string){
    super(string);
  }
}
