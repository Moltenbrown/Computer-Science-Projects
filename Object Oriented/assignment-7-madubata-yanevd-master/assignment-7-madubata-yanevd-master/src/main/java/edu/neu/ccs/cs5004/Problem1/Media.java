package edu.neu.ccs.cs5004.Problem1;

import java.util.List;

/**
 * Represents a TV Show, an extension of Abstract Media.
 *
 * @author Goch.
 */
public class Media extends AbstractMedia{

  /**
   * Creates a new tv show from a title, a release year, a list of directors, a list of actors, and
   * the amount the shows has been streamed. The four digit exception is hit if the user entered a release
   * year that is not four digits long.
   * @param title the media's title.
   * @param releaseYear the media's release year.
   * @param directors the directors who worked on the media.
   * @param actors the main actors who worked on the media.
   * @param amountOfStreams the amount of times users streamed the media.
   * @param typeOfMedia the type of media.
   * @throws FourDigitException if the user enters a release year that is not four (4) digits.
   */
  public Media(String title, Integer releaseYear, List directors, List actors,
      Integer amountOfStreams, TypeOfMedia typeOfMedia) throws FourDigitException{
    super(title, releaseYear, directors, actors, amountOfStreams, typeOfMedia);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getTitle() {
    return super.getTitle();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer getReleaseYear() {
    return super.getReleaseYear();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public List getDirectors() {
    return super.getDirectors();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer getAmountOfStreams() {
    return super.getAmountOfStreams();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Boolean isDirector(Director director) {
    return super.isDirector(director);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public TypeOfMedia getTypeOfMedia() {
    return super.getTypeOfMedia();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
