package edu.neu.ccs.cs5004.Problem2;

import java.util.Date;
import java.util.Objects;

/**
 * Represents non-moving violations.
 */
public class NonMovingViolation extends AbstractViolations {

  private NonMovingViolationsType violation;

  /**
   * Creates a violation, given the type, offender name, and date.
   *
   * @param violation the type of violation
   * @param offender the offender
   * @param date the day
   */
  public NonMovingViolation(NonMovingViolationsType violation, Name offender, Date date) {
    this.violation = violation;
    this.offender = offender;
    this.date = date;
  }

  /**
   * Gets the non-moving violation.
   *
   * @return violation
   */
  public NonMovingViolationsType getViolation() {
    return violation;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    NonMovingViolation that = (NonMovingViolation) obj;
    return violation == that.violation;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), violation);
  }

  @Override
  public String toString() {
    return violation.toString();
  }
}
