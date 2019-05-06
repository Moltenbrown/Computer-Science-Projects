package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents an Out of Bounds Exception that extends Exception.
 *
 * @author Goch
 */
public class OutOfBoundsException extends Exception{

  /**
   * Creates a out of bounds exception from a string.
   * @param string will be displayed when the exception is hit.
   */
  public OutOfBoundsException(String string){
    super(string);
  }
}
