package edu.neu.ccs.cs5004.Problem2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a ride sharing system, which stores lists of accepted and registered drivers.
 */
public abstract class AbstractRideSharingSystem implements IRideSharingSystem,
    IRegistrationValidator {

  protected List<Application> registeredDrivers = new LinkedList<>();
  protected List<Application> acceptedDrivers = new LinkedList<>();

  @Override
  public String registerDriver(AbstractDriver driver, AbstractVehicle vehicle) {
    this.registeredDrivers.add(new Application(driver, vehicle));
    if (IRegistrationValidator.validateDriver(driver) && IRegistrationValidator
        .validateLicense(driver) && IRegistrationValidator.validateVehicle(driver, vehicle)) {
      if (this.getAcceptedDrivers().contains(new Application(driver, vehicle))) {
        return "Driver already accepted.";
      }
      this.getAcceptedDrivers().add(new Application(driver, vehicle));
      return "Your application was accepted. Welcome!";
    } else {
      return "Your application was denied.";
    }
  }

  /**
   * Gets the list of accepted drivers.
   *
   * @return the list of approved and accepted drivers
   */
  private List<Application> getAcceptedDrivers() {
    return acceptedDrivers;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractRideSharingSystem that = (AbstractRideSharingSystem) obj;
    return Objects.equals(registeredDrivers, that.registeredDrivers)
        && Objects.equals(acceptedDrivers, that.acceptedDrivers);
  }

  @Override
  public int hashCode() {

    return Objects.hash(registeredDrivers, acceptedDrivers);
  }

  @Override
  public String toString() {
    return "Welcome to the Ride Sharing system!";
  }
}
