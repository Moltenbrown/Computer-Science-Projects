package edu.neu.ccs.cs5004.Problem2;

import java.util.Date;
import java.util.Objects;

/**
 * Represents moving violations.
 */
public class MovingViolation extends AbstractViolations {

  private MovingViolationsType violation;

  /**
   * Creates a violation, given the type, offender name, and date.
   *
   * @param violation the type of violation
   * @param offender the offender
   * @param date the day
   */
  public MovingViolation(MovingViolationsType violation, Name offender, Date date) {
    this.violation = violation;
    this.offender = offender;
    this.date = date;
  }

  /**
   * Gets the moving violation.
   *
   * @return violation
   */
  public MovingViolationsType getViolation() {
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
    MovingViolation that = (MovingViolation) obj;
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
