package edu.neu.ccs.cs5004;

/**
 * Represents a Out Of Range Exception, that extends Exception. An out of range exception occurs when:
    * a user inputs an age that is less than 0 or greater than 100 for a user in their nodes csv,
    * a user inputs any other character than M, F, or O for the gender of a user in their nodes csv,
    * a user enters null for either the nodes, the edges, or the output csv, or the name used doesn't
    * exist,
    * a user enters any input character other than s, e, or r for the processing flag,
    * a user enters a number that is less than 0 or greater than 100 for the number of users to
    * processes,
    * and a user enters a number that is less than 0 or greater than 100 for the number of
    * recommendations for a singular user.
 *
 * @author Goch.
 */
public class OutOfRangeException extends Exception {

  /**
   * Creates a new out of range exception from a string.
   * @param s the string that the user sees when they either input an age that
   */
  public OutOfRangeException (String s) {
    super(s);
  }
}
