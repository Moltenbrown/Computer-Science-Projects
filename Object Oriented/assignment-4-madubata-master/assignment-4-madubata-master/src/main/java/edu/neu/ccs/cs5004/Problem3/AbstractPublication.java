package edu.neu.ccs.cs5004.Problem3;

import java.util.Objects;

/**
 * Represents an Abstract Publication with its details--the title and year as strings, and the
 * author as a person.
 *
 * @author Goch
 */
public class AbstractPublication {
  private String title;
  private Person author;
  private Integer year;

  /**
   * Creates a new abstract publication from a title, author, and year.
   * @param title the title of the publication.
   * @param author the author of the publication.
   * @param year the year the publication was published.
   */
  public AbstractPublication (String title, Person author, Integer year) throws
      InvalidYearException {
    int yearLength = 4;
    this.title = title;
    this.author = author;
    this.year = year;
    if(String.valueOf(year.intValue()).length() < yearLength ||
        String.valueOf(year.intValue()).length() > yearLength){
      throw new InvalidYearException("The format of the year must have 4 digits. "
          + "Please try again.");
    }

  }

  /**
   * Returns the publication's title.
   * @return the publication's title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns the publication's author.
   * @return the publication's author.
   */
  public Person getAuthor() {
    return author;
  }

  /**
   * Returns the publication's year.
   * @return the publication's year.
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Evaluates whether the object being compared is the same as the publication it's being compared
   * to.
   * @param o the object being compared to the publication.
   * @return true if the object is the same as the publication and false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractPublication)) {
      return false;
    }
    AbstractPublication that = (AbstractPublication) o;
    return Objects.equals(title, that.title) &&
        Objects.equals(author, that.author) &&
        Objects.equals(year, that.year);
  }

  /**
   * Returns the integer hashcode for the publication.
   * @return the integer representing the hashcode for the publication.
   */
  @Override
  public int hashCode() {

    return Objects.hash(title, author, year);
  }

  /**
   * Returns the publication's information as a string.
   * @return the publication's title, author, and year as a string.
   */
  @Override
  public String toString() {
    return  title + " " + author +
        " " + year;
  }
}
