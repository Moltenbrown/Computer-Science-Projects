package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

/**
 * Represents a driver-vehicle combo, which consists of a driver and a vehicle.
 */
public class Application {

  private AbstractDriver driver;
  private AbstractVehicle vehicle;

  /**
   * Creates a new application, given the applying driver and the car.
   *
   * @param driver the applying driver
   * @param vehicle the vehicle/car the driver will use
   */
  public Application(AbstractDriver driver, AbstractVehicle vehicle) {
    this.driver = driver;
    this.vehicle = vehicle;
  }

  /**
   * Gets the driver of the application.
   *
   * @return the driver
   */
  public AbstractDriver getDriver() {
    return driver;
  }

  /**
   * Gets the vehicle of the application.
   *
   * @return the vehicle
   */
  public AbstractVehicle getVehicle() {
    return vehicle;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Application application = (Application) obj;
    return Objects.equals(driver, application.driver)
        && Objects.equals(vehicle, application.vehicle);
  }

  @Override
  public int hashCode() {

    return Objects.hash(driver, vehicle);
  }

  @Override
  public String toString() {
    return driver.toString() + ", " + vehicle.toString();
  }
}
