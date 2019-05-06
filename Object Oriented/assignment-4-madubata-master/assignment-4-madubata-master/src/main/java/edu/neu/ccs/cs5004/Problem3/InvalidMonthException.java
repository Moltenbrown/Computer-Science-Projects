package edu.neu.ccs.cs5004.Problem3;

/**
 * Represents an Invalid Month Exception.
 *
 * @author Goch
 */
public class InvalidMonthException extends Exception{

  /**
   * Creates a new invalid month exception from a string.
   * @param string the phrase that will be displayed when the exception is hit.
   */
  public InvalidMonthException(String string){
    super(string);
  }

}
