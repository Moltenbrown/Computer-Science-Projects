package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents a movie collaborators Willingness To Perform Stunts with its details--being hit or kicked,
 * being shot at, jumping out a moving vehicle, and jumping from a skyscraper as booleans.
 *
 * @author Goch
 */
public class WillingnessToPerformStunts {
  private boolean beingHitOrKicked;
  private boolean beingShotAt;
  private boolean jumpingOutAMovingVehicle;
  private boolean jumpingFromASkyscraper;

  /**
   * Creates a new willingness to perform stunts from a being hit or kicked, a being shot at,
   * a jumping out a moving vehicle, and a jumping from a skyscraper.
   * @param beingHitOrKicked whether the movie collaborator is willing to be hit or kicked.
   * @param beingShotAt whether the movie collaborator is willing to be shot at.
   * @param jumpingOutAMovingVehicle whether the movie collaborator is willing to jump out of a
   * moving vehicle.
   * @param jumpingFromASkyscraper whether a movie collaborator is willing to jump from a skyscraper.
   */
  public WillingnessToPerformStunts(boolean beingHitOrKicked, boolean beingShotAt, boolean
      jumpingOutAMovingVehicle, boolean jumpingFromASkyscraper){
    this.beingHitOrKicked = beingHitOrKicked;
    this.beingShotAt = beingShotAt;
    this.jumpingOutAMovingVehicle = jumpingOutAMovingVehicle;
    this.jumpingFromASkyscraper = jumpingFromASkyscraper;
  }

  /**
   * Returns whether or not the movie collaborator is willing to be hit or kicked.
   * @return true if the movie collaborator is willing to be hit or kicked, false otherwise.
   */
  public boolean isBeingHitOrKicked() {
    return beingHitOrKicked;
  }

  /**
   * Returns whether or not a movie collaborator is willing to be shot at.
   * @return true if the movie collaborator is willing to be shot at, false otherwise.
   */
  public boolean isBeingShotAt() {
    return beingShotAt;
  }

  /**
   * Returns whether or not a movie collaborator is willing to jump out of a moving vehicle.
   * @return true if the movie collaborator is willing to jump out of a moving vehicle,
   * false otherwise.
   */
  public boolean isJumpingOutAMovingVehicle() {
    return jumpingOutAMovingVehicle;
  }

  /**
   * Returns whether or not a movie collaborator is willing to jump from a skyscraper.
   * @return true if the movie collaborator is willing to jump from a skyscraper, false
   * otherwise.
   */
  public boolean isJumpingFromASkyscraper() {
    return jumpingFromASkyscraper;
  }

  /**
   * Evaluates whether or not the object is the same as the willingness to perform
   * stunts.
   * @param o the object being compared to the willingness to perform stunts.
   * @return true if the object is the same as the willingness to perform stunts,
   * false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WillingnessToPerformStunts)) {
      return false;
    }
    WillingnessToPerformStunts that = (WillingnessToPerformStunts) o;
    return beingHitOrKicked == that.beingHitOrKicked &&
        beingShotAt == that.beingShotAt &&
        jumpingOutAMovingVehicle == that.jumpingOutAMovingVehicle &&
        jumpingFromASkyscraper == that.jumpingFromASkyscraper;
  }

  /**
   * Returns the integer representation of the willingness to perform stunts.
   * @return the integer representation of the willingness to perform stunts
   * throw a hashcode.
   */
  @Override
  public int hashCode() {
    return Objects
        .hash(beingHitOrKicked, beingShotAt, jumpingOutAMovingVehicle, jumpingFromASkyscraper);
  }

  /**
   * Returns a string listing all the stunts the movie collaborator is willing to perform.
   * @return a string describing the willingness to perform stunts.
   */
  @Override
  public String toString() {
    return "Willingness To Perform Stunts: " +
        "being hit or kicked: " + beingHitOrKicked +
        ", being shot at: " + beingShotAt +
        ", jumping out a moving vehicle: " + jumpingOutAMovingVehicle +
        ", and jumping from a skyscraper: " + jumpingFromASkyscraper +
        '.';
  }
}
