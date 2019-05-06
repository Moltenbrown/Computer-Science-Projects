package edu.neu.ccs.cs5004;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a user of the social network with it's details-- the user's nodeId as Integer,
 * the profile creation data as a date, the user's gender as a character, where the character
 * is either 'M', 'F', or 'O', the user's age as an Integer, and the user's city as a string.
 *
 * @author Goch.
 */
public class User {
  private Integer nodeId;
  private LocalDate profileCreationLocalDate;
  private Character gender;
  private Integer age;
  private String city;

  /**
   * Creates a new user from a nodeId, a profile creation date, a gender, an age, and a city.
   * @param nodeId the user's nodeId.
   * @param profileCreationLocalDate the user's profile creation date.
   * @param gender the user's gender.
   * @param age the user's age.
   * @param city the city the user is based in.
   * @throws OutOfRangeException when the user either enters a character other than M, F, or O for gender
   * or the user enters an age outside of the range 0 to 100.
   */
  public User (Integer nodeId, LocalDate profileCreationLocalDate, Character gender, int age,
      String city) throws OutOfRangeException {
    this.nodeId = nodeId;
    this.profileCreationLocalDate = profileCreationLocalDate;
    if (gender.charValue() == 'M' || gender.charValue() == 'F' || gender.charValue() == 'O') {
      this.gender = gender;
    }

    else {
      throw new OutOfRangeException("The gender must be either M, F, or O.");
    }

    if (age < 0 || age > 100) {
      throw new OutOfRangeException("Age must be between 0 and 100.");
    }

    this.age = age;
    this.city = city;
  }

  /**
   * Returns the user's nodeId.
   * @return the user's nodeId.
   */
  public Integer getNodeId() {
    return nodeId;
  }

  /**
   * Sets the nodeId of the user to the nodeID.
   * @param nodeId the integer we are setting the nodeId to.
   */
  public void setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
  }

  /**
   * Sets the profileCreationLocalDate to the profileCreateLocalDate
   * @param profileCreationLocalDate the LocalDate we are setting the profileCreateLocalDate
   * to.
   */
  public void setProfileCreationLocalDate(LocalDate profileCreationLocalDate) {
    this.profileCreationLocalDate = profileCreationLocalDate;
  }

  /**
   * Sets the user's gender to the gender.
   * @param gender the gender we are setting the user's gender to.
   */
  public void setGender(Character gender) {
    this.gender = gender;
  }

  /**
   * Sets the user's age to the age.
   * @param age the age we are setting the user's age to.
   */
  public void setAge(Integer age) {
    this.age = age;
  }

  /**
   * Sets the user's city to the city.
   * @param city the city we are setting the user's city to.
   */
  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(nodeId, user.nodeId) &&
        Objects.equals(profileCreationLocalDate, user.profileCreationLocalDate) &&
        Objects.equals(gender, user.gender) &&
        Objects.equals(age, user.age) &&
        Objects.equals(city, user.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeId, profileCreationLocalDate, gender, age, city);
  }

  @Override
  public String toString() {
    return "User{" +
        "nodeId=" + nodeId +
        ", profileCreationLocalDate=" + profileCreationLocalDate +
        ", gender=" + gender +
        ", age=" + age +
        ", city='" + city + '\'' +
        '}' + "\n";
  }
}
