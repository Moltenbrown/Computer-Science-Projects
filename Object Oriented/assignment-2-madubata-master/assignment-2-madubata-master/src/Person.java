/**
 * Represents a Person with it's details--a first name and a last name as Strings
 *
 * @author Goch
 */
public class Person {
  private String firstName;
  private String lastName;

  /**
   * Creates a new Person from two strings, the first name and the last name
   * @param firstName represents the first name of a person
   * @param lastName represents the last name of a person
   */
  public Person(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }


  /**
   * Returns the person's first name
   * @return the first name as a string
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the person's last name
   * @return the last name as a string
   */
  public String getLastName() {
    return lastName;
  }
}
