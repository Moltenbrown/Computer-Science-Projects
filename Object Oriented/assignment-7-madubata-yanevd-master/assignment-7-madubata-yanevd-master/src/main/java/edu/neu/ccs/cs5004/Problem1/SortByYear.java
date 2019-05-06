package edu.neu.ccs.cs5004.Problem1;
import java.util.Comparator;

/**
 * Represents Sort By Year, an implementation of Comparator for Media
 * so I can sort media by their release date from most recent to least
 * recent.
 *
 * @author Goch.
 */
public class SortByYear implements Comparator<Media> {

  /**
   * Compares media a to media b and returns a -1 if media b has a more
   * recent release date than media a.
   * @param a the first media we are comparing.
   * @param b the second media we are comparing.
   * @return -1 if the b was released after a, a 1 if b was released before a, or a
   * 0 if b and a were released at the same time.
   */
  public int compare(Media a, Media b){
    return b.releaseYear.compareTo(a.releaseYear);
  }
}
