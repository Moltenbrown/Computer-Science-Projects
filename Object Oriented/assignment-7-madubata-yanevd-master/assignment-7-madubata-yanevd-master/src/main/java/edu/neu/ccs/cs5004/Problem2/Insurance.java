package edu.neu.ccs.cs5004.Problem2;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Represents the vehicle insurance of an applicant's vehicle.
 */
public class Insurance {

  private Name owner;
  private Date expirationDate;
  private List<AbstractDriver> otherDrivers;

  /**
   * Creates a new insurence document, storing the vehicle's owner, expiration date of the
   * insurance, and the drivers of this vehicle.
   */
  public Insurance(Name owner, Date expirationDate,
      List<AbstractDriver> otherDrivers) {
    this.owner = owner;
    this.expirationDate = expirationDate;
    this.otherDrivers = otherDrivers;
  }

  /**
   * Gets the owner's name.
   *
   * @return the owner name as a string
   */
  public Name getOwner() {
    return owner;
  }

  /**
   * Gets the insurance expiration date.
   *
   * @return expiration date
   */
  public Date getExpirationDate() {
    return expirationDate;
  }

  /**
   * Gets a list of the other drivers on this insurance.
   *
   * @return the other drivers list
   */
  public List<AbstractDriver> getOtherDrivers() {
    return otherDrivers;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Insurance insurance = (Insurance) obj;
    return Objects.equals(owner, insurance.owner)
        && Objects.equals(expirationDate, insurance.expirationDate)
        && Objects.equals(otherDrivers, insurance.otherDrivers);
  }

  @Override
  public int hashCode() {

    return Objects.hash(owner, expirationDate, otherDrivers);
  }

  @Override
  public String toString() {
    return owner +
        "'s insurance";
  }
}
