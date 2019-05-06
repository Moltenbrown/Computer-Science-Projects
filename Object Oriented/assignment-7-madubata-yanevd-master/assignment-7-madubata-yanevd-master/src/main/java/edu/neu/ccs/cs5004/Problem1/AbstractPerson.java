package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents a AbstractPerson with its details--the person's first name and last name
 * as strings.
 *
 * @author Goch
 */
public abstract class AbstractPerson {
  protected String firstName;
  protected String lastName;

  /**
   * Creates a person from a first name and a last name.
   * @param firstName the person's first name.
   * @param lastName the person's last name.
   */
  public AbstractPerson(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the person's first name as a string.
   * @return the person's first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the person's last name as a string.
   * @return the person's last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Evaluates whether the object being considered is the same as the
   * person.
   * @param o the object being considered.
   * @return true if the object is the same as the person, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractPerson)) {
      return false;
    }
    AbstractPerson abstractPerson = (AbstractPerson) o;
    return Objects.equals(firstName, abstractPerson.firstName) &&
        Objects.equals(lastName, abstractPerson.lastName);
  }

  /**
   * Creates an integer hashcode representation of a person.
   * @return an integer representing the person.
   */
  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName);
  }

  /**
   * Returns a string representation of the person with their first name
   * and last name.
   * @return a string representation of a person.
   */
  @Override
  public String toString() {
    return "AbstractPerson{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
