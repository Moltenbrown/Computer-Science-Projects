package edu.neu.ccs.cs5004.assignment3.problem3;

/**
 * Represents a Dead Ship Exception, which will appear when the ship is dead.
 *
 * @author Goch
 */
public class DeadShipException extends Exception {
  public DeadShipException(String string){
    super(string);
  }
}
