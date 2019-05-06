package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents an Invalid Username Exception, which extends Exception.
 *
 * @author Goch
 */
public class InvalidUsernameException extends Exception {

  /**
   * Creates a new invalid username exception from a string when a user
   * the AbstractUPPair is not empty, but the username of the pair is not equal to
   * the username that we are trying to delete.
   * @param string the statement that will be shown to the user when they hit
   * the invalid username exception.
   */
  public InvalidUsernameException(String string){
    super(string);
  }
}
