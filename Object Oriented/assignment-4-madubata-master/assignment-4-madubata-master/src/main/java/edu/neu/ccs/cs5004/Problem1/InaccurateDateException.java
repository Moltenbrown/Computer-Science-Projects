package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents an Inaccurate Date Exception which extends Exception.
 *
 * @author Goch
 */
public class InaccurateDateException extends Exception{

  /**
   * Creates an Inaccurate Date Exception from a string.
   * @param string what the Inaccurate Date Exception shows the user when the exception is hit.
   */
  public InaccurateDateException(String string){
    super(string);
  }

}
