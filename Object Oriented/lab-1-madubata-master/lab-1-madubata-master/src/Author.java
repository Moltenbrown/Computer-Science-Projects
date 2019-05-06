/**
 * *Represents an Author with their details--name, email and physical address
 *
 * @author therapon
 *
 */

public class Author {
    private Person name;
    private String email;
    private String address;

    /**
     * Creates a new author given the author's name, email and address as strings.
     *
     * @param name the author's name
     * @param email the author's email address
     * @param address the authors physical address
     */
    public Author(String firstName, String lastName, String email, String address) {
        this.name = new Person(firstName, lastName);
        this.email = email;
        this.address = address;


     public Author(Person person, String email, String address) {
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
    public String getEmail() {
        return this.email;
    }
/**
 * @return the address
 */

    public String getAddress() {
        return this.address;
    }
}
