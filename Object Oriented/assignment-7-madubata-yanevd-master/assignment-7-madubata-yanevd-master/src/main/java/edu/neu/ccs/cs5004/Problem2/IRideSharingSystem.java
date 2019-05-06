package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents what a ride sharing system can do. Most importantly, it should be able to register
 * drivers, and either add or reject them to a driver pool.
 */
public interface IRideSharingSystem {

  /**
   * Applies the driver to the ride sharing system.
   *
   * @param driver the applying driver
   * @param vehicle the driver's car
   * @return a message to the applicant on whether the application was accepted or rejected
   */
  String registerDriver(AbstractDriver driver, AbstractVehicle vehicle);
}
