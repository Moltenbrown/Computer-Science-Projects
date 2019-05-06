package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents a new Pair Zero Exception, which extends Exception.
 *
 * @author Goch
 */
public class PairEmptyException extends Exception{

  /**
   * Creates a new pair empty exception when the user tries to replace
   * an empty AbstractUPPair.
   * @param string what the user sees when they try to replace an empty
   * AbstractUPPair.
   */
  public PairEmptyException(String string){
    super(string);
  }
}
