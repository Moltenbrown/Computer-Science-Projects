/**
 * *Represents an Author with their details--name, email and physical address
 *
 * @author therapon
 */

public class Author {

  private Person name;
  private Email email;
  private String address;

  /**
   * Creates a new author given the author's name, email and address as strings.
   *
   * @param person the author's name
   * @param email the author's email address
   * @param address the authors physical address
   */

  public Author(Person person, Email email, String address) {
    this.name = person;
    this.email = email;
    this.address = address;
  }

  /**
   * @return the name
   */
  public Person getName() {
    return this.name;
  }

  /**
   * @return the email
   */
  public Email getEmail() {
    return this.email;
  }

  /**
   * @return the address
   */

  public String getAddress() {
    return this.address;
  }
}

