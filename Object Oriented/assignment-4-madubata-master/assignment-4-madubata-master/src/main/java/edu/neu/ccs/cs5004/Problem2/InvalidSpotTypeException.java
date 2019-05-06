package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents an invalid spot type exception which is hit when a regular car, a car not
 * transporting people with disabilities, tries to park in a parking space for customers with
 * disabilities.
 *
 * @author Goch
 */
public class InvalidSpotTypeException extends Exception{

  /**
   * Creates a new invalid spot type exception when the exception is hit.
   * @param string the statement that is presented to the user when the exception is hit.
   */
  public InvalidSpotTypeException(String string){
    super(string);
  }
}
