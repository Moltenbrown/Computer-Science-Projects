package edu.neu.ccs.cs5004.Problem1;
import java.util.Comparator;

/**
 * Represents Sort By Stream, an implementation of Comparator for Media
 * so I can sort media by their stream amount from highest to lowest.
 *
 * @author Goch.
 */
public class SortByStream implements Comparator<Media> {

  /**
   * Compares media a to media b and returns a -1 if media b was streamed more
   * than media a.
   * @param a the first media we are comparing.
   * @param b the second media we are comparing.
   * @return -1 if the b was streamed more than a, a 1 if b was streamed less
   * than a, or a 0 if b and a were streamed the same amount..
   */
  public int compare(Media a, Media b){
    return b.amountOfStreams.compareTo(a.amountOfStreams);
  }
}
