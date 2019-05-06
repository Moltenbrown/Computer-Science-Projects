package edu.neu.ccs.cs5004.Problem2;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a driver's license, which stores birthday, age, ID, country, state of issuance,
 * address, and expiration date.
 */
public class License {

  private Integer uniqueID;
  private Name name;
  private Date birthday;
  private Date expirationDate;
  private Date issueDate;
  private Address driverAddress;
  private Address issueAddress;

  /**
   * Creates a new license, given all the required info.
   *
   * @param uniqueID the id tag of the license
   * @param name the name of the owner
   * @param birthday the birthday of the owner
   * @param expirationDate the expiration day of the license
   * @param issueDate the issue date of the license
   * @param driverAddress the driver's address
   * @param issueAddress the issue address
   */
  public License(Integer uniqueID, Name name, Date birthday, Date expirationDate, Date issueDate,
      Address driverAddress, Address issueAddress) {
    this.uniqueID = uniqueID;
    this.name = name;
    this.birthday = birthday;
    this.expirationDate = expirationDate;
    this.issueDate = issueDate;
    this.driverAddress = driverAddress;
    this.issueAddress = issueAddress;
  }

  /**
   * Gets the name.
   *
   * @return the name string
   */
  public Name getName() {
    return name;
  }

  /**
   * Gets the driver's birthday.
   *
   * @return the birthday
   */
  public Date getBirthday() {
    return birthday;
  }

  /**
   * Gets the expiration date.
   *
   * @return the expiration date
   */
  public Date getExpirationDate() {
    return expirationDate;
  }

  /**
   * Gets the issued address.
   *
   * @return the issue address
   */
  public Address getIssueAddress() {
    return issueAddress;
  }

  /**
   * Gets the issue date.
   *
   * @return the issue date
   */
  public Date getIssueDate() {
    return issueDate;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    License license = (License) obj;
    return Objects.equals(uniqueID, license.uniqueID)
        && Objects.equals(name, license.name)
        && Objects.equals(birthday, license.birthday)
        && Objects.equals(expirationDate, license.expirationDate)
        && Objects.equals(driverAddress, license.driverAddress)
        && Objects.equals(issueAddress, license.issueAddress);
  }

  @Override
  public int hashCode() {

    return Objects.hash(uniqueID, name, birthday, expirationDate, driverAddress, issueAddress);
  }

  @Override
  public String toString() {
    return uniqueID.toString();
  }
}
