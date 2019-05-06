package edu.neu.ccs.cs5004.Problem3;

/**
 * Represents an Invalid Year Exception which comes when the year is either under 4 digits or
 * greater than 4 digits.
 *
 * @author Goch
 */
public class InvalidYearException extends Exception{

  /**
   * Created a new invalid year exception from a string.
   * @param string the phase that will displayed when the user hits the invalid year exception.
   */
  public InvalidYearException(String string){
    super(string);
  }

}
