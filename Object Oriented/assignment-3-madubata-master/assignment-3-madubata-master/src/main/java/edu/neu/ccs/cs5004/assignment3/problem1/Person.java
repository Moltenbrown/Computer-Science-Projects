package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.Objects;

/**
 *Represents a Person with it's details--the first name and the last name
 * as Strings.
 *
 * @author Goch
 */
public class Person {
  private String firstName;
  private String lastName;

  /**
   * Creates a new person from a first name and a last name
   * @param firstName the person's first name.
   * @param lastName the person's last name.
   */
  public Person(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }


  /**
   * Returns the first name of the person as a string
   * @return the person's first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name of the person as a String
   * @return the person's last name
   */
  public String getLastName() {
    return lastName;
  }

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

  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return  firstName + " " + lastName;
  }
}
