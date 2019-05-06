package edu.neu.ccs.cs5004.Problem2;

import java.util.Date;

/**
 * This system will accept appropriate driver-vehicle combos into the pool of accepted drivers.
 */
public interface IRegistrationValidator {

  public static final long legalAge = 21;
  public static final long secInYear = 31556952;
  public static final String legalCountry = "US";
  public static final String legalViolation = "DUI";
  public static final String legalViolation2 = "SPEEDING";
  public static final String legalViolation3 = "INVALIDLICENSE";
  public static final long secondsInSixMonths = 31556952 / 2;
  public static final long tooOld = 20;
  public static final long thousand = 1000;


  /**
   * Given the applying driver, check whether the driver is valid.
   *
   * @param driver the applying driver
   * @return true if the driver was accepted, false if otherwise
   */
  static Boolean validateDriver(AbstractDriver driver) {
    //Driver qualification check
    Date today = new Date();
    if (today.getTime() / thousand - (legalAge * secInYear)
        < driver.getBirthdate().getTime() / thousand) {
      return false;
    }

    for (AbstractViolations element : driver.getHistory().getViolations()) {
      switch (element.toString()) {
        case legalViolation:
          return false;
        case legalViolation2:
          return false;
        case legalViolation3:
          return false;
        default:
      }
    }

    //if all checks pass
    return true;
  }

  /**
   * Given the applying driver, check whether the driver's license is valid.
   *
   * @param driver the applying driver
   * @return true if the application was accepted, false if otherwise
   */
  static Boolean validateLicense(AbstractDriver driver) {
    Date today = new Date();
    if (!driver.getName().equals(driver.getLicense().getName())) {
      return false;
    }
    if (!driver.getBirthdate().equals(driver.license.getBirthday())) {
      return false;
    }
    if (!driver.license.getIssueAddress().getCountry().equals(legalCountry)) {
      return false;
    }
    if (driver.getLicense().getIssueDate().getTime() / 1000 + secondsInSixMonths
        > today.getTime() / 1000) {
      return false;
    }
    if ((today).after(driver.getLicense().getExpirationDate())) {
      return false;
    }

    return true;
  }

  /**
   * Given the applying driver and vehicle, check whether the vehicle is valid.
   *
   * @param driver the applying driver
   * @param vehicle the driver's car
   * @return true if the application was accepted, false if otherwise
   */
  static Boolean validateVehicle(AbstractDriver driver, AbstractVehicle vehicle) {
    Date today = new Date();
    if (vehicle.getMake() + tooOld < today.getYear()) {
      return false;
    }
    if (!(driver.getName().equals(vehicle.getInsurance().getOwner()) || (vehicle.getInsurance()
        .getOtherDrivers().contains(driver)))) {
      return false;
    }
    if (vehicle.getInsurance().getExpirationDate().before(today)) {
      return false;
    }
    for (AbstractViolations element : vehicle.getViolations().getViolations()) {
      if (element.getDate().getTime() / thousand + secondsInSixMonths
          > today.getTime() / thousand) {
        return false;
      }
    }
    for (AbstractViolations element : vehicle.getCrashes().getViolations()) {
      if (element.getDate().getTime() / thousand + secondsInSixMonths
          > today.getTime() / thousand) {
        return false;
      }
    }

    return true;
  }
}
