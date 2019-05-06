package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * This interface contains all operations that all types of states should support.
 *
 * @author Goch
 */
public interface States {

  /**
   * Returns true if the result of comparing two states would be a win, and false if the result of
   * comparing two states would be a lose. The rules of the game are is rock is compared to scissors
   * whoever had rock wins, if scissors is compared to paper, whoever had scissors wins, and if
   * paper is compared to rock, whoever had paper wins. It throws a draw exception if both players
   * use the same state.
   * @return whether the player won of lost.
   * @throws DrawException if both players play the same state.
   */
  boolean game (States state) throws DrawException;

}
