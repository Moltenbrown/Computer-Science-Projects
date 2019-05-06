package edu.neu.ccs.cs5004;

import java.util.Objects;

/**
 * Represents a client with it's details -- the client's first name, last name,
 * the name of the company they work at, their address including the street address,
 * city, county, and state, their phone number, an alternative phone number, their
 * email, and a their website as strings and their zipcode as an integer.
 *
 * @author Goch.
 */
public class Client {
  private String firstName;
  private String lastName;
  private String companyName; //company the client works at or is associated with.
  private String address; //street address
  private String city;
  private String county;
  private String state;
  private Integer zip; //zipcode
  private String phoneNumber;
  private String phoneNumber2; //alternative phone number
  private String email;
  private String url; //website

  public static ClientBuilder getBuilder() {
    return new ClientBuilder();
  }

  /**
   * Maintains the fields of a client - the first name, last name,
   * company name, address, city, county, state, zip, phone number,
   * alternative phone number, email and url.
   */
  public static class ClientBuilder {
    private String firstName;
    private String lastName;
    private String companyName;
    private String address;
    private String city;
    private String county;
    private String state;
    private Integer zip;
    private String phoneNumber;
    private String phoneNumber2; //alternative phone number
    private String email;
    private String url;

    /**
     * Creates a client with default values.
     */
    private ClientBuilder() {
      this.firstName = null;
      this.lastName = null;
      this.companyName = null;
      this.address = null;
      this.city = null;
      this.county = null;
      this.state = null;
      this.zip = null;
      this.phoneNumber = null;
      this.phoneNumber2 = null;
      this.email = null;
      this.url = null;
    }

    /**
     * Changes the client's first name.
     *
     * @param firstName the first name we are changing the client's first name to.
     * @return an updated client.
     */
    public ClientBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    /**
     * Changes the client's last name.
     *
     * @param lastName the last name we are changing the client's last name to.
     * @return an updated client.
     */
    public ClientBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    /**
     * Changes the client's company name.
     *
     * @param companyName the company name we are changing the client's company name to.
     * @return an updated client.
     */
    public ClientBuilder companyName(String companyName) {
      this.companyName = companyName;
      return this;
    }

    /**
     * Changes the client's address.
     *
     * @param address the address we are changing the client's address to.
     * @return an updated client.
     */
    public ClientBuilder address(String address) {
      this.address = address;
      return this;
    }

    /**
     * Changes the client's city.
     *
     * @param city the city we are changing the client's city to.
     * @return an updated client.
     */
    public ClientBuilder city(String city) {
      this.city = city;
      return this;
    }

    /**
     * Changes the client's county.
     *
     * @param county the county we are changing the client's county to.
     * @return an updated client.
     */
    public ClientBuilder county(String county) {
      this.county = county;
      return this;
    }

    /**
     * Changes the client's state.
     *
     * @param state the state we are changing the client's state to.
     * @return an updated client.
     */
    public ClientBuilder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Changes the client's zip.
     *
     * @param zip the zip we are changing the client's zip to.
     * @return an updated client.
     */
    public ClientBuilder zip(Integer zip) {
      this.zip = zip;
      return this;
    }

    /**
     * Changes the client's phoneNumber.
     *
     * @param phoneNumber the phoneNumber we are changing the client's phoneNumber to.
     * @return an updated client.
     */
    public ClientBuilder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    /**
     * Changes the client's phoneNumber2.
     *
     * @param phoneNumber2 the phoneNumber2 we are changing the client's phoneNumber2 to.
     * @return an updated client.
     */
    public ClientBuilder phoneNumber2(String phoneNumber2) {
      this.phoneNumber2 = phoneNumber2;
      return this;
    }

    /**
     * Changes the client's email.
     *
     * @param email the email we are changing the client's email to.
     * @return an updated client.
     */
    public ClientBuilder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * Changes the client's url.
     *
     * @param url the url we are changing the client's url to.
     * @return an updated client.
     */
    public ClientBuilder url(String url) {
      this.url = url;
      return this;
    }

    public Client build() {
      return new Client(this);
    }
  }

  public Client(ClientBuilder clientBuilder) {
    this.firstName = clientBuilder.firstName;
    this.lastName = clientBuilder.lastName;
    this.companyName = clientBuilder.companyName;
    this.address = clientBuilder.address;
    this.city = clientBuilder.city;
    this.county = clientBuilder.county;
    this.state = clientBuilder.state;
    this.zip = clientBuilder.zip;
    this.phoneNumber = clientBuilder.phoneNumber;
    this.phoneNumber2 = clientBuilder.phoneNumber2;
    this.email = clientBuilder.email;
    this.url = clientBuilder.url;
  }

    /**
   * Returns the first name of a client.
   * @return the first name of a client.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name of a client.
   * @return the last name of a client.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns the company name of a client.
   * @return the company name of a client.
   */
  public String getCompanyName() {
    return companyName;
  }

  /**
   * Returns the address of a client.
   * @return the address of a client.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Returns the city of a client.
   * @return the city of a client.
   */
  public String getCity() {
    return city;
  }

  /**
   * Returns the county of a client.
   * @return the county of a client.
   */
  public String getCounty() {
    return county;
  }

  /**
   * Returns the state of a client.
   * @return the state of a client.
   */
  public String getState() {
    return state;
  }

  /**
   * Returns the zipcode of a client.
   * @return the zipcode of a client.
   */
  public Integer getZip() {
    return zip;
  }

  /**
   * Returns the phone number of a client.
   * @return the phone number of a client.
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Returns the alternative phone number of a client.
   * @return the alternative phone number of a client.
   */
  public String getPhoneNumber2() {
    return phoneNumber2;
  }

  /**
   * Returns the email of a client.
   * @return the email of a client.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Returns the url of a client.
   * @return the url of a client.
   */
  public String getUrl() {
    return url;
  }

  /**
   * @param o the object being compared to the client.
   * @return true if o is the same as the client, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Client)) {
      return false;
    }
    Client client = (Client) o;
    return Objects.equals(firstName, client.firstName) &&
        Objects.equals(lastName, client.lastName) &&
        Objects.equals(companyName, client.companyName) &&
        Objects.equals(address, client.address) &&
        Objects.equals(city, client.city) &&
        Objects.equals(county, client.county) &&
        Objects.equals(state, client.state) &&
        Objects.equals(zip, client.zip) &&
        Objects.equals(phoneNumber, client.phoneNumber) &&
        Objects.equals(phoneNumber2, client.phoneNumber2) &&
        Objects.equals(email, client.email) &&
        Objects.equals(url, client.url);
  }

  /**
   * @return the numerical hash representation of the client.
   */
  @Override
  public int hashCode() {
    return Objects
        .hash(firstName, lastName, companyName, address, city, county, state, zip, phoneNumber,
            phoneNumber2, email, url);
  }

  /**
   * @return the client represented as a string.
   */
  @Override
  public String toString() {
    return "Client{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", companyName='" + companyName + '\'' +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", county='" + county + '\'' +
        ", state='" + state + '\'' +
        ", zip=" + zip +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", phoneNumber2='" + phoneNumber2 + '\'' +
        ", email='" + email + '\'' +
        ", url='" + url + '\'' +
        '}';
  }
}
