package edu.neu.ccs.cs5004.Problem1;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

/**
 * Represents Abstract Media with its details--the abstract media's title as a string, the release year
 * as a four (4) digit integer, a list of directors, a list of actors, and the amount the movie has been
 * streamed as an integer.
 *
 * @author Goch.
 */
public abstract class AbstractMedia {
  String title;
  Integer releaseYear;
  List directors;
  List actors;
  Integer amountOfStreams;
  TypeOfMedia typeOfMedia;

  /**
   * Create abstract media from a title, release year, a list of directors, a list of actors,
   * and the amount the movie has been streamed. A four digit exception is thrown if the user enters
   * a release year that is anything other than four (4) digits.
   *
   * @param title the abstract media's title.
   * @param releaseYear the abstract media's release year.
   * @param directors the directors who worked on the abstract media.
   * @param actors the main actors of the abstract media.
   * @param amountOfStreams the amount of times the abstract media was streamed.
   * @param typeOfMedia the type of media the abstract media is.
   * @throws FourDigitException if the user enters a release year that is not four (4) digits.
   */
  public AbstractMedia(String title, Integer releaseYear, List directors, List actors,
      Integer amountOfStreams, TypeOfMedia typeOfMedia) throws FourDigitException {
    this.title = title;
    this.releaseYear = releaseYear;
    if(releaseYear.toString().length() != 4){
      throw new FourDigitException("The release year must be four (4) digits.");
    }
    this.directors = directors;
    this.actors = actors;
    this.amountOfStreams = amountOfStreams;
    this.typeOfMedia = typeOfMedia;
  }

  /**
   * Return the abstract media title.
   * @return the abstract media title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Return the abstract media release year.
   * @return the abstract media release year.
   */
  public Integer getReleaseYear() {
    return releaseYear;
  }

  /**
   * Return the abstract media release year.
   * @return the abstract media release year.
   */
  public List getDirectors() {
    return directors;
  }

  /**
   * Returns the amount of times the media was streamed.
   * @return the amount of streams.
   */
  public Integer getAmountOfStreams() {
    return amountOfStreams;
  }

  /**
   * Sets the amount of streams of the media to whatever number is entered.
   * @param amountOfStreams the number that we want to set amount of streams to.
   */
  public void setAmountOfStreams(Integer amountOfStreams) {
    this.amountOfStreams = amountOfStreams;
  }

  /**
   * Returns the type of media the abstract media is.
   * @return the media type.
   */

  public TypeOfMedia getTypeOfMedia() {
    return typeOfMedia;
  }

  /**
   * Returns whether the director entered is a director of the abstract media.
   * @param director the director you are searching for.
   * @return true if the director is one of the directors on the abstract media,
   * false otherwise.
   */
  public Boolean isDirector(Director director){ return this.directors.contains(director);}

  /**
   * Evaluates whether the object o is the same as the abstract media.
   * @param o the object being compared.
   * @return true if the object is the same as the abstract media, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractMedia)) {
      return false;
    }
    AbstractMedia that = (AbstractMedia) o;
    return Objects.equals(title, that.title) &&
        Objects.equals(releaseYear, that.releaseYear) &&
        Objects.equals(directors, that.directors) &&
        Objects.equals(actors, that.actors) &&
        Objects.equals(amountOfStreams, that.amountOfStreams) &&
        Objects.equals(typeOfMedia, that.typeOfMedia);
  }

  /**
   * Creates an integer hashcode representation of the abstract media.
   * @return an integer representing the abstract media.
   */
  @Override
  public int hashCode() {

    return Objects.hash(title, releaseYear, directors, actors, amountOfStreams, typeOfMedia);
  }

  /**
   * Returns a string describing the abstract media.
   * @return a string description of the abstract media.
   */
  @Override
  public String toString() {
    return "AbstractMedia{" +
        "title='" + title + '\'' +
        ", releaseYear=" + releaseYear +
        ", directors=" + directors +
        ", actors=" + actors +
        ", amountOfStreams=" + amountOfStreams +
        ", mediaType=" + typeOfMedia +
        '}';
  }
}
