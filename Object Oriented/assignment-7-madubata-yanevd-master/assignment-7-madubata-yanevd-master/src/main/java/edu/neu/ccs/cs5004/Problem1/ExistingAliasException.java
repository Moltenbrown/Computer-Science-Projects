package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents a situation where the alias entered by the user
 * has already been used.
 *
 * @author Goch
 */
public class ExistingAliasException extends Exception{

  /**
   * Creates a new existing alias exception from a string.
   * @param s the string used to created the existing alias exception.
   */
  public ExistingAliasException(String s){
    super(s);
  }
}
