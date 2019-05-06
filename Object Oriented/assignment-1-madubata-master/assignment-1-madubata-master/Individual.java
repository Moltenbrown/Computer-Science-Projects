/**
 * Represents an Individual with their details
 * --first name and last name
 *
 * @author Goch
 *
 */

public class Individual {
  private String firstName;
  private String lastName;

  /**
   * Creates a new individual given the
   * individual's first name and last name as strings.
   *
   * @param firstName
   * @param lastName
   */
  public Individual(String firstName, String lastName){
      this.firstName = firstName;
      this.lastName = lastName;
  }


  /**
   * @return the first name
   */
  public String getFirstName() {
      return firstName;
  }


  /**
   * @return the last name
   */
  public String getLastName() {
      return lastName;
  }
}
