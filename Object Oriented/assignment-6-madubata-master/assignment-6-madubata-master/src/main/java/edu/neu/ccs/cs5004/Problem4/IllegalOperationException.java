package edu.neu.ccs.cs5004.Problem4;

/**
 * Represents an Illegal Operation Exception, which extends Exception.
 *
 * @author Goch
 */
public class IllegalOperationException extends Exception {

  /**
   * Creates an illegal operation exception from a string.
   * @param string the phrase the user will see when the illegal operation exception is hit.
   */
  public IllegalOperationException (String string) {
    super(string);
  }
}
