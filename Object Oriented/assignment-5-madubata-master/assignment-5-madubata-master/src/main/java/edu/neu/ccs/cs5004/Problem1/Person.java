package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents a Person with its details--their first name and their last name
 * as strings.
 *
 * @author Goch
 */
public class Person {
  private String firstName;
  private String lastName;

  /**
   * Creates a person from a first name and last name.
   * @param firstName the person's first name.
   * @param lastName the person's last name.
   */
  public Person(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the person's first name.
   * @return the first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the person's last name.
   * @return the last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Evaluates whether the object is the same as the person it's being compared
   * to.
   * @param o the object compared to the person.
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
   * Returns an integer hashcode representation of the person.
   * @return the integer hashcode of the person.
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  /**
   * Returns a string listing the person's first name and last name.
   * @return a string about the person.
   */
  @Override
  public String toString() {
    return  firstName + ' ' + lastName;
  }
}
