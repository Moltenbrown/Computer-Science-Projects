package edu.neu.ccs.cs5004.Problem3;

/**
 * Represents an Illegal Operation Exception, which extends the Exception class.
 *
 * @author Goch.
 */
public class IllegalOperationException extends Exception {
  /**
   * Creates a new illegal operations exception from a string.
   * @param string what the user sees when someone hits an illegal operations exception.
   */
  public IllegalOperationException (String string){
    super(string);
  }
}
