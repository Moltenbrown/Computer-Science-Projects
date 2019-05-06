package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents a situation where the media release year entered by the user
 * is less than or greater than four digits.
 *
 * @author Goch
 */
public class FourDigitException extends Exception{

  /**
   * Creates a four digit exception from a string.
   * @param s the phrase the user will see when the exception is hit.
   */
  public FourDigitException(String s){
    super(s);
  }

}
