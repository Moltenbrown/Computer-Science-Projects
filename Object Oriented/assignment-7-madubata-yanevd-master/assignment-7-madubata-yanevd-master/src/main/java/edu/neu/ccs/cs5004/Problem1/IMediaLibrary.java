package edu.neu.ccs.cs5004.Problem1;

import java.util.List;

/**
 * Represents the interface for a Media Library with all the methods a media library needs--
 * Directors Library, which, when given a director, lists all the media a director worked on;
 * Add Media which adds a new piece of media to the media library when given an alias for the
 * media and all the elements of the media as defined in Media.java; Increase Streams, which
 * increases the amount of streams of the media associated with the alias entered; Get Stream
 * Statistics, which returns the amount of streams from the media associated with the alias;
 * and, Get Most Streamed, which returns one of the most streamed media.
 *
 * @author Goch.
 */
public interface IMediaLibrary {

  /**
   * Creates a list of all the director's media contributions from a director's name.
   * The list will be sorted from most recent media project to earliest project.
   * @param director the director whose work we are searching for.
   * @return a list of all the director's media contributions sorted from most recent to
   * least recent.
   */
  List<Media> DirectorsLibrary(Director director);

  /**
   * Add a new piece of media to the media library from a alias, a title, a release year, a list
   * of directors, a list of actors, the amount the media has been streamed and the
   * type of media.
   * @param alias alias of the media.
   * @param title title of the media.
   * @param releaseYear the release year of the media.
   * @param directors the directors who contributed to the media.
   * @param actors the main actors of the media.
   * @param amountOfStreams the amount the media has been streamed.
   * @param typeOfMedia the type of media.
   * @throws FourDigitException if the release year entered is not a four digit year.
   * @throws ExistingAliasException if the alias entered already exists in the media library.
   * @throws IllegalArgumentException if the media to be entered already exists in the media
   * library.
   */
  void addMedia(String alias, String title, Integer releaseYear, List directors, List actors,
      Integer amountOfStreams, TypeOfMedia typeOfMedia) throws FourDigitException,
      ExistingAliasException; // allowing the user to enter multiples of the same piece of media
      // with different aliases didn't make sense to me.

  /**
   * Increases the amount of streams of the media associated with the entered string
   * alias.
   * @param alias the alias of the movie we are trying to increase the stream count of.
   * @throws IllegalArgumentException if the user enters an alias that isn't in the
   * media library.
   */
  void increaseStreams (String alias) throws IllegalArgumentException;

  /**
   * Gets the stream statistics of from the media associated with the alias.
   * @param alias the alias of the media we are looking up.
   * @return the stream amount of the media associated with the alias.
   * @throws IllegalArgumentException if the user enters an alias that isn't in the
   * media library.
   */
  Integer getStreamStatistics(String alias) throws IllegalArgumentException;

  /**
   * Returns the most streamed piece of media in the media library.
   * @return the most streamed piece of media in the media library.
   */
  Media getMostStreamed();
}
