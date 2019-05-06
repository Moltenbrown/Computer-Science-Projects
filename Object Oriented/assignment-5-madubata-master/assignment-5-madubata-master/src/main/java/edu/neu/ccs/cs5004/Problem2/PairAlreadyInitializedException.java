package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents a Pair Already Initialized Exception, which extends Exception.
 *
 * @author Goch
 */
public class PairAlreadyInitializedException extends Exception{

  /**
   * Creates a new pair already initialized exception from a string.
   * @param string what is presented to the user when they hit the exception.
   */
  public PairAlreadyInitializedException(String string){
    super(string);
  }
}
