package edu.neu.ccs.cs5004.Problem2;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a general driver, which holds information on the driver's name, history, age, license
 * info.
 */
public abstract class AbstractDriver implements IDriver {

  protected Name name;
  protected Date birthdate;
  protected License license;
  protected ViolationsHistory history;

  /**
   * Gets the name of the driver.
   *
   * @return the driver's name
   */
  public Name getName() {
    return name;
  }

  /**
   * Gets the birthdate of the driver.
   *
   * @return the driver's birthdate
   */
  public Date getBirthdate() {
    return birthdate;
  }

  /**
   * Gets the license of the driver.
   *
   * @return the driver's license
   */
  public License getLicense() {
    return license;
  }

  /**
   * Gets the violation history of the driver.
   *
   * @return the driver's history
   */
  public ViolationsHistory getHistory() {
    return history;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractDriver that = (AbstractDriver) obj;
    return Objects.equals(name, that.name)
        && Objects.equals(birthdate, that.birthdate)
        && Objects.equals(license, that.license)
        && Objects.equals(history, that.history);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, birthdate, license, history);
  }

  @Override
  public String toString() {
    return name.toString();
  }
}
