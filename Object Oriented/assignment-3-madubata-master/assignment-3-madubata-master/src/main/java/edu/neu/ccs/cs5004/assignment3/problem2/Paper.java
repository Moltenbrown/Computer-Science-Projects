package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * Represents a Paper with all it's details.
 *
 * @author Goch
 */
public class Paper implements States{

  /**
   * Creates a new paper.
   */
  public Paper(){}

  /**
   * Runs a game of rock, paper, scissors. Takes input of the other player's choice. If paper
   * beats the other player's choice, then it returns true. If paper loses to the other player's
   * choice, then it returns false. If the other player chose paper as well, the draw exception
   * sends a message.
   * @param random the other player's choice.
   * @return whether or not this player won using paper.
   * @throws DrawException produces a message if the other player played paper as well.
   */
  public boolean game(States random) throws DrawException{
    if(random instanceof Rock){
      return true;
    }

    else if(random instanceof Scissor){
      return false;
    }

    else{
      throw new DrawException("You both chose the same thing. It's a draw.");
    }
  }

}
