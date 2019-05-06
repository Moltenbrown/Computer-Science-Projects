package edu.neu.ccs.cs5004.Problem4;

/**
 * Represents a Player Mismatch Exception, with extends Exception, and occurs whenever someone tries
 * to updated information about a Soccer Team Soccer Player and the Soccer Team doesn't have the
 * Soccer Player.
 *
 * @author Goch.
 */
public class PlayerMismatchException extends Exception {

  /**
   * Creates a player mismatch exception from a string.
   * @param string the phrase a user will see when they try to change a player who doesn't exist in the
   * soccer team.
   */
  public PlayerMismatchException (String string) {
    super(string);
  }
}
