package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents an Abstract Talent with its details--their willingness to perform stunts as a willingness to perform stunts.
 *
 * @author Goch
 */
public abstract class AbstractTalent extends AbstractMovieCollaborator{
  protected WillingnessToPerformStunts willingnessToPerformStunts;

  /**
   * Creates a new abstract talent from the talent's name, last scene, and willingness to perform stunts.
   * @param name the abstract talent's name.
   * @param lastScene the last scene the abstract talent worked on.
   * @param willingnessToPerformStunts the abstract talent's willingness to do stunts.
   */
  public AbstractTalent(Person name, LastScene lastScene, WillingnessToPerformStunts willingnessToPerformStunts){
    super(name, lastScene);
    this.willingnessToPerformStunts = willingnessToPerformStunts;
  }

  /**
   * Returns the abstract talent's willingness to perform stunts.
   * @return the abstract talent's willingness to do stunts.
   */
  public WillingnessToPerformStunts getWillingnessToPerformStunts() {
    return willingnessToPerformStunts;
  }

  /**
   * Evaluates whether the object being compared is the same as the abstract talent.
   * @param o the object being compared to the abstract talent.
   * @return true if the object is the same as the abstract talent, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractTalent)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    AbstractTalent that = (AbstractTalent) o;
    return Objects.equals(willingnessToPerformStunts, that.willingnessToPerformStunts);
  }

  /**
   * Returns an integer hashcode representation of the abstract class.
   * @return an integer hashcode representation of the abstract class.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), willingnessToPerformStunts);
  }

  /**
   * Returns a string describing the abstract talent.
   * @return a string stating the abstract talent's name, last scene performed and
   * willingness to perform stunts.
   */
  @Override
  public String toString() {
    return super.toString() + " " + willingnessToPerformStunts;
  }
}
