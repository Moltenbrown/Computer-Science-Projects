package edu.neu.ccs.cs5004.Problem3;

import java.util.Objects;

/**
 * Represents a person with its details--the first name and the last name as strings.
 *
 * @author Goch
 */
public class Person {
  private String firstName;
  private String lastName;

  /**
   * Creates a new person from a first name and a last name.
   * @param firstName the person's first name.
   * @param lastName the person's last name.
   */
  public Person (String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the first name of the person.
   * @return the person's first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name of the person.
   * @return the person's last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Evaluates whether the object being compared to a person is the same as the person.
   * @param o the object being compared to the person.
   * @return true if the object is the same as the person, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(firstName, person.firstName) &&
        Objects.equals(lastName, person.lastName);
  }

  /**
   * Returns the integer hashcode of the person.
   * @return the person encoded as a integer hashcode.
   */
  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName);
  }

  /**
   * Returns a string stating the person's first and last name.
   * @return a string stating the person's first and last name.
   */
  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
