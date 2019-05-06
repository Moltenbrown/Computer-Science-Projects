/**
 * Represents a Card Owner with it's details--the card owner's name as a person, the card owner's
 * address and the card owner's email as strings.
 *
 * @author Goch
 */
public class CardOwner {
  private Person name;
  private String address;
  private String email;

  /**
   * Creates a new Card Owner given the name of the card owner as a person containing their first
   * and last name, the address of the card owner as a string, and the card owner's email as a
   * string.
   * @param name the name of the card owner as a person, containing the first and last name
   * @param address the card owner's address as a string
   * @param email the card owner's email as a string.
   */
  public CardOwner(Person name, String address, String email){
    this.name = name;
    this.address = address;
    this.email = email;
  }


  /**
   * Returns the card owner's name as a person
   * @return the card owner's name
   */
  public Person getName() {
    return name;
  }

  /**
   * Returns the card owner's address as a string
   * @return the card owner's address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Returns the card owner's email as a string
   * @return the card owner's email
   */
  public String getEmail() {
    return email;
  }
}
