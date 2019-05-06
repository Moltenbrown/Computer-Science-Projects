package edu.neu.ccs.cs5004.Problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a topic index with its details--a map linking strings to a list of integers. The strings represent the
 * keywords and the list of integers represents all the usersID that used those keywords.
 *
 * @author Goch.
 */
public class TopicIndex {
  private Map<String, List<Integer>> topics;

  /**
   * Creates a new topic index from a map where integers are linked to a list of strings.
   * @param map this is aggregated data map of all the keywords each used used. The userIDs are
   * the integers and the keywords each user used are the list of strings.
   */
  public TopicIndex (Map<Integer, List<String>> map){
    Set currentKeys = topics.keySet();
    Map<String, List<Integer>> holder = new HashMap<String, List<Integer>>();
    Iterator<Integer> iter = currentKeys.iterator();
    List<String> stringArrayList = new ArrayList<String>();

    while(iter.hasNext()){
      Integer key = iter.next();
      stringArrayList = map.get(key);

      for (String s : stringArrayList){
        if(holder.containsKey(s)){
          List<Integer> userID = holder.get(s);
          userID.add(key);
          holder.put(s, userID);
        }
        else {
          holder.put(s, new ArrayList<Integer>());
          List<Integer> userID = holder.get(s);
          userID.add(key);
          holder.put(s, userID);
        }
      }
    }

    this.topics = holder;
  }

  /**
   * This returns the reworked map of user habits where each keyword is linked to a list of
   * all the userIDs who use the keyword.
   * @return a map where all the keywords are linked to a list of all the users who used the keyword.
   */
  public Map<String, List<Integer>> returnTopicIndex(){
    return this.topics;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TopicIndex)) {
      return false;
    }
    TopicIndex that = (TopicIndex) o;
    return Objects.equals(topics, that.topics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topics);
  }

  @Override
  public String toString() {
    return "TopicIndex{" +
        "topics=" + topics +
        '}';
  }
}
