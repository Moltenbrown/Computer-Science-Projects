package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents a License Plate for a Vehicle with it's details--the license plate number and state
 * and strings, and the vehicle registration expiration date as a date.
 *
 * @author Goch
 */
public class LicensePlate {
  private String licensePlateNumber;
  private String state;
  private Date date;

  /**
   * Creates a license plate from a license plate number, a state and a date.
   * @param licensePlateNumber the vehicle's license plate number.
   * @param state the state the vehicle was registered in.
   * @param date when the vehicle registration will expire.
   */
  public LicensePlate(String licensePlateNumber, String state, Date date){
    this.licensePlateNumber = licensePlateNumber;
    this.state = state;
    this.date = date;
  }

  /**
   * Returns the vehicle's license plate number.
   * @return the license plate number.
   */
  public String getLicensePlateNumber() {
    return licensePlateNumber;
  }

  /**
   * Returns the state where the vehicle was registered.
   * @return the vehicle registration state.
   */
  public String getState() {
    return state;
  }

  /**
   * Returns the date the vehicle registration will expire.
   * @return the vehicle registration expiration date.
   */
  public Date getDate() {
    return date;
  }


  /**
   * Evaluates whether the object being compared is the same as the license plate.
   * @param o the object being compared to the license plate.
   * @return true if the object is the same as the license plate, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LicensePlate)) {
      return false;
    }
    LicensePlate that = (LicensePlate) o;
    return Objects.equals(licensePlateNumber, that.licensePlateNumber) &&
        Objects.equals(state, that.state) &&
        Objects.equals(date, that.date);
  }


  /**
   * Returns the integer generated after the license plate goes through the hash code method.
   * @return the integer hash code representing the license plate.
   */
  @Override
  public int hashCode() {

    return Objects.hash(licensePlateNumber, state, date);
  }

  /**
   * Returns a statement amount the license plate number, the state the vehicle was registered in,
   * and the date when the vehicle registration will expire.
   * @return a statement about the vehicle license plate.
   */
  @Override
  public String toString() {
    return "The vehicle's license plate number is " + licensePlateNumber +
        ". The vehicle was registered in " + state +
        " and the registration will expire on " + date.getMonth() + " " + date.getYear() +
        '.';
  }
}
