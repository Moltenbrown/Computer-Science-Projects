package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * Represents a rock with all it's details.
 *
 * @author Goch
 */
public class Rock implements States{

  /**
   * Creates a rock.
   */
  public Rock(){

  }

  /**
   * Runs a game of rock, paper, scissors. Takes input of the other player's choice. If rock
   * beats the other player's choice, then it returns true. If rock loses to the other player's
   * choice, then it returns false. If the other player chose rock as well, the draw exception
   * sends a message.
   * @param random the other player's choice.
   * @return whether or not this player won using rock.
   * @throws DrawException produces a message if the other player played rock as well.
   */
  public boolean game(States random) throws DrawException{
    if(random instanceof Paper){
      return false;
    }

    else if(random instanceof Scissor){
      return true;
    }

    else{
      throw new DrawException("You both chose the same thing. It's a draw.");
    }
  }
}
