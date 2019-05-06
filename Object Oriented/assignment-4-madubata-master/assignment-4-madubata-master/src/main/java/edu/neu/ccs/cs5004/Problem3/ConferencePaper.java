package edu.neu.ccs.cs5004.Problem3;

import java.util.Objects;

/**
 * Represents a paper presented at a conference with all its details--the conference name, the
 * conference location, which requires a city and a country in the following format-"Seattle, USA"-
 * and the month as a three letter abbreviation, as strings.
 *
 * @author Goch
 */
public class ConferencePaper extends AbstractPublication{
  private String conferenceName;
  private String location;
  private String month;

  /**
   * Creates a new conference paper from a title, an author, a conference name, a location, a
   * month, and a year. Throws an invalid month exception is
   *
   * @param title the paper title.
   * @param author the author who presented the paper at the conference.
   * @param conferenceName the name of the conference.
   * @param location where the conference was located.
   * @param month the month when the conference took place.
   * @param year the year when the conference took place.
   * @throws Exception occurs when the year entered does not contain 4 digits, or the month
   * entered is not a three letter abbreviation.
   */
  public ConferencePaper(String title, Person author, String conferenceName,
      String location, String month, Integer year) throws Exception{
    super(title, author, year);
    this.conferenceName = conferenceName;
    this.location = location;
    this.month = month;

    if(month.length() < 3 || month.length() > 3){
      throw new InvalidMonthException("The month must be in three letter abbreviated form.");
    }

  }

  /**
   * Returns the conference name;
   * @return the conference name;
   */
  public String getConferenceName() {
    return conferenceName;
  }

  /**
   * Returns the conference location;
   * @return the conference location;
   */
  public String getLocation() {
    return location;
  }

  /**
   * Returns the conference month;
   * @return the conference month;
   */
  public String getMonth() {
    return month;
  }

  /**
   * Evaluates whether the object being compared is the same as the conference paper.
   * @param o the object being compared to the conference paper.
   * @return true if the object is the same as the conference paper, and false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ConferencePaper)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ConferencePaper that = (ConferencePaper) o;
    return Objects.equals(conferenceName, that.conferenceName) &&
        Objects.equals(location, that.location) &&
        Objects.equals(month, that.month);
  }

  /**
   * Returns the integer hashcode representation of the conference paper.
   * @return the integer hashcode representation of the conference paper.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), conferenceName, location, month);
  }

  /**
   * Return a string describing the conference paper, using the conference name,
   * location, month, year, and title.
   * @return a string describing the conference paper.
   */
  @Override
  public String toString() {
    return  conferenceName + ", " + location + ", "
    + month + ' ' + super.getYear() + ", " + super.getTitle();
  }
}
