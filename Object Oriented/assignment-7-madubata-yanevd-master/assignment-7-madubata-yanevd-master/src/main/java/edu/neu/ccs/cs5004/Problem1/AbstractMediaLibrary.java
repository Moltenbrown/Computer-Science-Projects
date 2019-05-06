package edu.neu.ccs.cs5004.Problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents an Abstract Media Library which implements the methods from IMedia Library
 * with it's details--a media library as a map.
 *
 * @author Goch.
 */
public abstract class AbstractMediaLibrary implements IMediaLibrary {
  private Map<String, Media> mediaLibrary;

  /**
   * Creates an empty abstract media library.
   */
  public AbstractMediaLibrary(){
    this.mediaLibrary = new HashMap<String, Media>();
  }

  /**
   * Evaluates whether or not the media library is empty.
   * @return true if the library is empty, false otherwise.
   */
  public boolean isEmpty(){
    return this.mediaLibrary == new HashMap<String, Media>();
  }

  /**
   * Returns the media library.
   * @return the media library.
   */
  public Map<String, Media> getMediaLibrary() {
    if(!isEmpty()){
      return mediaLibrary;
    }
     return new HashMap<String, Media>();
  }

  /**
   * {@inheritDoc}.
   */
  public void addMedia(String alias, String title, Integer releaseYear, List directors, List actors,
      Integer amountOfStreams, TypeOfMedia typeOfMedia) throws FourDigitException, ExistingAliasException,
      IllegalArgumentException{
    if(this.mediaLibrary.containsKey(alias)){
      throw new ExistingAliasException("This alias already exists in the system. Please reenter your media with "
          + "a new unique alias.");
    }

    if(this.mediaLibrary.containsValue(new Media(title, releaseYear, directors, actors, amountOfStreams, typeOfMedia))){
      throw new IllegalArgumentException("This piece of media already exists in the system under a different alias.");
    }

    this.mediaLibrary.put(alias, new Media(title, releaseYear, directors, actors, amountOfStreams, typeOfMedia));
  }

  /**
   * {@inheritDoc}.
   */
  public List<Media> DirectorsLibrary(Director director) {
    List<Media> holder = new ArrayList<Media>();
    Map<String, Media> mediaLibraryHolder = this.mediaLibrary;
    for (Map.Entry h : mediaLibraryHolder.entrySet()) {
      Media comparator = (Media) h.getValue();
      if (comparator.isDirector(director)) {
        holder.add(comparator);
      }
    }

    Collections.sort(holder, new SortByYear());
    return holder;
  }

  /**
   * {@inheritDoc}.
   */
  public void increaseStreams (String alias) throws IllegalArgumentException{
      if(this.mediaLibrary.containsKey(alias)){
        Media newValue = this.mediaLibrary.get(alias);
        newValue.setAmountOfStreams(newValue.getAmountOfStreams() + 1);
        this.mediaLibrary.put(alias, newValue);
      }

      else{
        throw new IllegalArgumentException("This alias does not exist in the media library.");
      }
  }

  /**
   * {@inheritDoc}.
   */
  public Integer getStreamStatistics(String alias) throws IllegalArgumentException{
    if(this.mediaLibrary.containsKey(alias)){
      return this.mediaLibrary.get(alias).getAmountOfStreams();
    }

    else{
      throw new IllegalArgumentException("This alias does not exist in the media library.");
    }
  }

  /**
   * {@inheritDoc}.
   */
  public  Media getMostStreamed(){
    List<Media> streamList = new ArrayList<Media>();
    Map<String, Media> mediaLibraryHolder = this.mediaLibrary;
    for(Map.Entry h : mediaLibraryHolder.entrySet()){
      streamList.add((Media) h.getValue());
    }

    Collections.sort(streamList, new SortByStream());
    return streamList.get(0);
  }

  /**
   * Evaluates whether the object being compared is the same as the abstract media library.
   * @param o the object being compared to the abstract media library.
   * @return true if the object is the same as the abstract media library, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractMediaLibrary)) {
      return false;
    }
    AbstractMediaLibrary that = (AbstractMediaLibrary) o;
    return Objects.equals(mediaLibrary, that.mediaLibrary);
  }

  /**
   * Returns an integer hashcode representation of the media library.
   * @return an integer hashcode representation of the media library.
   */
  @Override
  public int hashCode() {

    return Objects.hash(mediaLibrary);
  }

  /**
   * Returns a string describing the abstract media library.
   * @return a string describing the abstract media library.
   */
  @Override
  public String toString() {
    return "AbstractMediaLibrary{" +
        "mediaLibrary=" + mediaLibrary +
        '}';
  }
}
