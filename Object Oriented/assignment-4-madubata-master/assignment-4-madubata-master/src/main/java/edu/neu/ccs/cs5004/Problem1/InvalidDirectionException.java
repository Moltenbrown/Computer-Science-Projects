package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents an Invalid Direction Exception that extends Exception.
 *
 * @author Goch
 */
public class InvalidDirectionException extends Exception {

  /**
   * Creates an invalid direction exception from a string.
   * @param string this will be displayed when the exception is hit.
   */
  public InvalidDirectionException(String string){
    super(string);
  }

}
