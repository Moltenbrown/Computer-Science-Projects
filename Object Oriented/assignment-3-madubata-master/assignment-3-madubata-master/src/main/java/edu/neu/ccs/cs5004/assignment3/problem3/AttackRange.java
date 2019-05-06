package edu.neu.ccs.cs5004.assignment3.problem3;

import java.util.Objects;

/**
 * Represents an Attack Range with it's details--the low and the high as Integers.
 *
 * @author Goch
 */
public class AttackRange {
  private Integer low;
  private Integer high;

  /**
   * Creates a new attack range from a low and a high.
   * @param low the low end of the range.
   * @param high the high end of the range.
   */
  public AttackRange(Integer low, Integer high){
    this.low = low;
    this.high = high;
  }

  /**
   * Returns the low end of the range.
   * @return the low end of the range.
   */
  public Integer getLow() {
    return low;
  }

  /**
   * Returns the high end of the range.
   * @return the high end of the range.
   */
  public Integer getHigh() {
    return high;
  }

  /**
   * Evaluates whether the object is the same thing as the attack range.
   * @param o the object being compared to the attack range.
   * @return true if the object is the same as the attack range, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AttackRange)) {
      return false;
    }
    AttackRange that = (AttackRange) o;
    return Objects.equals(low, that.low) &&
        Objects.equals(high, that.high);
  }

  /**
   * Returns an integer representation of the attack range.
   * @return an integer representation of the attack range.
   */
  @Override
  public int hashCode() {

    return Objects.hash(low, high);
  }

  /**
   * Returns a string representation of the attack range.
   * @return a string representation of the attack range.
   */
  @Override
  public String toString() {
    return
        "low=" + low +
        ", high=" + high;
  }
}
