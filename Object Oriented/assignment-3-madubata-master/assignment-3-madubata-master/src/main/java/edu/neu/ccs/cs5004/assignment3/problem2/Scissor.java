package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * Represents a Scissor with all it's details.
 *
 * @author Goch
 */
public class Scissor implements States{

  /**
   * Creates a new scissor.
   */
  public Scissor(){}

  /**
   * Runs a game of rock, paper, scissors. Takes input of the other player's choice. If scissor
   * beats the other player's choice, then it returns true. If scissor loses to the other player's
   * choice, then it returns false. If the other player chose scissor as well, the draw exception
   * sends a message.
   * @param random the other player's choice.
   * @return whether or not this player won using scissor.
   * @throws DrawException produces a message if the other player played scissor as well.
   */
  public boolean game(States random) throws DrawException{
    if(random instanceof Rock){
      return false;
    }

    else if(random instanceof Paper){
      return true;
    }

    else{
      throw new DrawException("You both chose the same thing. It's a draw.");
    }
  }
}
