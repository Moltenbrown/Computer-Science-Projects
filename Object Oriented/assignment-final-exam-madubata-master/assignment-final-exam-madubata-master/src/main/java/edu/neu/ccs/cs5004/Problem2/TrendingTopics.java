package edu.neu.ccs.cs5004.Problem2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents Trending Topics with it's details--a lists of strings
 * representing the trending topics.
 *
 * @author Goch
 */
public class TrendingTopics {
  private List<String> trendingTopics;

  /**
   * Creates a new trending topics object from a list of
   * strings.
   * @param strings the list of string that will becoming
   * the trending topics in trending topics.
   */
  public TrendingTopics(List<String> strings){
    this.trendingTopics = strings;
  }

  /**
   * Given a list of string, returns a map with each string linked to
   * the number of times the string appeared in the list of strings.
   * @param list the list of string being evaluated.
   * @return a map with each string linked to the amount of times the
   * string appeared in the list of strings.
   */
  public Map<String, Integer> countTopics(List<String> list){
    Map<String, Integer> holder = new HashMap<String, Integer>();
    for (String s : list){
      if(holder.containsKey(s)){
        int count = holder.get(s);
        count = count + 1;
        holder.put(s, count);
      }
      else {
        holder.put(s, 1);
      }
    }

    return holder;
  }
}
