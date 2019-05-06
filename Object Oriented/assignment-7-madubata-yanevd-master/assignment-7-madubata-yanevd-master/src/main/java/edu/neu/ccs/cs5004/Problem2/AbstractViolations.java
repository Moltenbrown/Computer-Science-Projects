package edu.neu.ccs.cs5004.Problem2;

import java.util.Date;
import java.util.Objects;

/**
 * Represents any violation committed, including the name of the driver and the date.
 */
public abstract class AbstractViolations {
  
  protected Name offender;
  protected Date date;

  /**
   * Gets the date the crash took place.
   *
   * @return the date
   */
  public Date getDate() {
    return date;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractViolations that = (AbstractViolations) obj;
    return Objects.equals(offender, that.offender)
        && Objects.equals(date, that.date);
  }

  @Override
  public int hashCode() {

    return Objects.hash(offender, date);
  }
}
