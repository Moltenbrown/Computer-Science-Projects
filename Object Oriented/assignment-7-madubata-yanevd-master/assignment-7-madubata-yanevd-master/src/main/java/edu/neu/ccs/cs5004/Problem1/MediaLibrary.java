package edu.neu.ccs.cs5004.Problem1;

import java.util.List;
import java.util.Map;

/**
 * Represents a Media Library which extends Abstract Media Library.
 *
 * @author Goch;
 */
public class MediaLibrary extends AbstractMediaLibrary{

  /**
   * Creates a new media library.
   */
  public MediaLibrary(){
    super();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean isEmpty() {
    return super.isEmpty();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Map<String, Media> getMediaLibrary() {
    return super.getMediaLibrary();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void addMedia(String alias, String title, Integer releaseYear, List directors, List actors,
      Integer amountOfStreams, TypeOfMedia typeOfMedia)
      throws FourDigitException, ExistingAliasException, IllegalArgumentException {
    super.addMedia(alias, title, releaseYear, directors, actors, amountOfStreams, typeOfMedia);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<Media> DirectorsLibrary(Director director) {
    return super.DirectorsLibrary(director);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void increaseStreams(String alias) throws IllegalArgumentException {
    super.increaseStreams(alias);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer getStreamStatistics(String alias) throws IllegalArgumentException {
    return super.getStreamStatistics(alias);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Media getMostStreamed() {
    return super.getMostStreamed();
  }

  /**
   * Evaluates whether the object being compared is the same as the abstract media library.
   *
   * @param o the object being compared to the abstract media library.
   * @return true if the object is the same as the abstract media library, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * Returns an integer hashcode representation of the media library.
   *
   * @return an integer hashcode representation of the media library.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Returns a string describing the abstract media library.
   *
   * @return a string describing the abstract media library.
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
