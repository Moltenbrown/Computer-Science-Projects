package edu.neu.ccs.cs5004.Problem4;

/**
 * Represents a Too Many Players Exception for a PlayerList, which extends Exception.
 *
 * @author Goch
 */
public class TooManyPlayersException extends Exception {

  /**
   * Creates a too many players exceptions from the string.
   * @param string the phrase the user will see if the hit the too many players exception.
   */
  public TooManyPlayersException (String string) {
    super(string);
  }
}
