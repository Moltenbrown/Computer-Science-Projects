package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * Represents a Draw Exception that extends exception.
 *
 * @author Goch
 */
public class DrawException extends Exception {

  /**
   * Creates a draw exception with a string.
   * @param string the string that will be displayed when the exception is hit.
   */
  public DrawException(String string){
    super(string);
  }
}
