package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents a Stunt Performer, which extends Abstract Talent, with its details--their former stunt performances as a
 * string.
 *
 * @author Goch
 */
public class StuntPerformer extends AbstractTalent{
  private String formerStuntPerformances;

  /**
   * Creates a stunt performer from a name, last scene, willingness to perform students, and former stunt performances.
   * @param name the name of the stunt performer.
   * @param lastScene the last scene the stunt performer worked on.
   * @param willingnessToPerformStunts the stunt performer's willingness to perform stunts.
   * @param formerStuntPerformances a list of the stunt performer's former performances.
   */
  public StuntPerformer(Person name, LastScene lastScene, WillingnessToPerformStunts willingnessToPerformStunts,
      String formerStuntPerformances){
    super(name, lastScene, willingnessToPerformStunts);
    this.formerStuntPerformances = formerStuntPerformances;
  }

  /**
   * Returns the former stunt performances.
   * @return the stunt performers former stunt performances.
   */
  public String getFormerStuntPerformances() {
    return formerStuntPerformances;
  }

  /**
   * Evaluates whether the object is the same as the stunt performer.
   * @param o the object being compared to the stunt performer.
   * @return true if the object is the same as the stunt performer, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StuntPerformer)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    StuntPerformer that = (StuntPerformer) o;
    return Objects.equals(formerStuntPerformances, that.formerStuntPerformances);
  }

  /**
   * Returns the integer hashcode representation of the stunt performer.
   * @return the integer hashcode representation of the stunt performer.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), formerStuntPerformances);
  }

  /**
   * Returns a string describing the stunt performer, including their name, the last scenes
   * they worked on, their willingness to perform stunts, and former stunt performances they
   * did.
   * @return a string describing the stunt performer.
   */
  @Override
  public String toString() {
    return super.toString() + " These are their former stunt performances: " + formerStuntPerformances +
        '.';
  }
}
