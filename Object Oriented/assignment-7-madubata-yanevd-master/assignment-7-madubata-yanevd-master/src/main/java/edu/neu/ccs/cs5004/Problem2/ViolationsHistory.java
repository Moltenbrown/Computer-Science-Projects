package edu.neu.ccs.cs5004.Problem2;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Represents a list of violations the driver has committed.
 */
public class ViolationsHistory {

  private LinkedList<AbstractViolations> violations;

  /**
   * Creates a list of the driver's moving and stationary violations.
   *
   * @param violations the list of violations
   */
  public ViolationsHistory(
      LinkedList<AbstractViolations> violations
  ) {
    this.violations = violations;

  }
  /**
   * Gets the list of violations.
   *
   * @return the violations list
   */
  public LinkedList<AbstractViolations> getViolations() {
    return violations;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    ViolationsHistory that = (ViolationsHistory) obj;
    return Objects.equals(violations, that.violations);
  }

  @Override
  public int hashCode() {

    return Objects.hash(violations);
  }

  @Override
  public String toString() {
    return "Not Supported.";
  }
}
