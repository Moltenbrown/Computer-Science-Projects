package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents a Date with it's details--the month as a String and the year as an Integer. The year
 * value must be a four digit number.
 *
 * @author Goch
 */
public class Date {
  private String month;
  private Integer year;

  /**
   * Creates a new date from a month and year.
   * @param month The month of the date as a String.
   * @param year The year of the date as an Integer.
   * @throws InaccurateDateException when the user enters a year that is less than or greater than
   * 4 digits.
   */
  public Date(String month, Integer year) throws InaccurateDateException{
    this.month = month;
    this.year = year;

    if (String.valueOf(year.intValue()).length() < 4 ||
        String.valueOf(year.intValue()).length() > 4){
      throw new InaccurateDateException("Your year is not in the correct format. Please submit a "
          + "4 digit year.");
    }
  }

  /**
   * Returns the month of the date as a string.
   * @return the month of the date.
   */
  public String getMonth() {
    return month;
  }

  /**
   * Returns the year of the date as an Integer.
   * @return the year of the date.
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Evaluates whether the object being compared is the same as the date we are comparing it to.
   * If it is the same as the date being compare, it returns turn, otherwise, it returns false.
   * @param o the object we are comparing the date to.
   * @return true if the object is the same as the date and false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Date)) {
      return false;
    }
    Date date = (Date) o;
    return Objects.equals(month, date.month) &&
        Objects.equals(year, date.year);
  }

  /**
   * Creates an integer hash code from the date.
   * @return the integer hash code. of the date.
   */
  @Override
  public int hashCode() {

    return Objects.hash(month, year);
  }

  /**
   * Creates a string that states the date  if the date of the vehicle.
   * @return the date of the vehicle within a string.
   */
  @Override
  public String toString() {
    return "The vehicle's date is " + month + " " + year +
        '.';
  }
}
