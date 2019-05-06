package edu.neu.ccs.cs5004.Problem2;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a crash in a vehicle.
 */
public class Crash extends AbstractViolations {

  private CrashType violation;

  /**
   * Creates a crash, given the type, offender name, and date.
   *
   * @param violation the type of crash
   * @param offender the offender
   * @param date the day
   */
  public Crash(CrashType violation, Name offender, Date date) {
    this.violation = violation;
    this.offender = offender;
    this.date = date;
  }

  /**
   * Gets the crash type.
   *
   * @return the type
   */
  public CrashType getViolation() {
    return violation;
  }

  @Override
  public boolean equals(Object obj) {

    if (!super.equals(obj)) {
      return false;
    }
    Crash crash = (Crash) obj;
    return violation == crash.violation;
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
