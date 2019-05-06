package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

/**
 * Represents the first and last name of a driver.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Creates a name, given first and last.
   *
   * @param firstName the first name
   * @param lastName the last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Name name = (Name) obj;
    return Objects.equals(firstName, name.firstName)
        && Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return firstName + ' ' + lastName;
  }
}
