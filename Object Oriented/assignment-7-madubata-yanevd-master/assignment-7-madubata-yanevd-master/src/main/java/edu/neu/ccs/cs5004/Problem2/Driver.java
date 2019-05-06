package edu.neu.ccs.cs5004.Problem2;

import java.util.Date;

/**
 * Represents a driver in the system, with a name, birthdate, license, and history.
 */
public class Driver extends AbstractDriver {

  /**
   * Creates a new driver, given the name, birthdate, license, and history of the driver.
   *
   * @param name the driver's name
   * @param birthdate the driver's birthdate
   * @param license the driver's license info
   * @param history the driver's history info
   */
  public Driver(Name name, Date birthdate, License license,
      ViolationsHistory history) {
    this.name = name;
    this.birthdate = birthdate;
    this.license = license;
    this.history = history;
  }

}
