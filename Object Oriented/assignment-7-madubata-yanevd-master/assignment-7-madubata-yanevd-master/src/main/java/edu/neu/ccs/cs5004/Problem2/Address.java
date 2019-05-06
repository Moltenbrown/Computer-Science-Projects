package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

/**
 * Represents the state and/or country of applicant or license.
 */
public class Address {

  private String state = null; //not all countries have states. Default is null.
  private String country;

  /**
   * Creates a new address, given the state and country of the issue.
   *
   * @param state the state of the issue
   * @param country te country of the issue
   */
  public Address(String state, String country) {
    this.state = state;
    this.country = country;
  }

  /**
   * Gets the country of the issue.
   *
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Address address = (Address) obj;
    return Objects.equals(state, address.state)
        && Objects.equals(country, address.country);
  }

  @Override
  public int hashCode() {

    return Objects.hash(state, country);
  }

  @Override
  public String toString() {
    return state + ", " + country;
  }
}
