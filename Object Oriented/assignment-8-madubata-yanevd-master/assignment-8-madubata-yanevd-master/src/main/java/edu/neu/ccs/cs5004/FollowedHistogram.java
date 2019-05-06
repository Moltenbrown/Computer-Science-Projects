package edu.neu.ccs.cs5004;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a histogram carting how much each user is followed with it's details-a map of
 * between integers with one of the values being the key being the nodeId of the users and
 * the value being the amount of times that particular user was followed by other people in the
 * system.
 *
 * @author Goch.
 */
public class FollowedHistogram {
  private Map<Integer, Integer> followAmountMap;

  /**
   * Creates a new followed histogram from a usermap.
   * @param userMap the user map with the user followees connections.
   */
  protected FollowedHistogram(UserMap userMap) {
    this.followAmountMap = new HashMap<Integer, Integer>();
    Set<Integer> nodeIds = userMap.getUserFollowMap().keySet();
    Map<Integer, List<Integer>> followerMapping = userMap.getUserFollowMap();
    Iterator<Integer> nodeIdIterator = nodeIds.iterator();
    while(nodeIdIterator.hasNext()) {
      Integer nodeId = nodeIdIterator.next();
      Integer followedCount = 0;
      for(Map.Entry<Integer, List<Integer>> entry: followerMapping.entrySet()) {
        if(entry.getValue().contains(nodeId)){
          followedCount = followedCount + 1;
        }
      }
      this.followAmountMap.put(nodeId, followedCount);
    }
  }

  /**
   * Returns the map of how many followers the user has.
   * @return the map of how many followers the user has.
   */
  protected Map<Integer, Integer> getFollowAmountMap() {
    return followAmountMap;
  }

  /**
   * Given the amount an amount of check for, returns a list of all the users how have more
   * followers than the amount we are checking for.
   * @param checkAmount the amount of followers we are comparing all the users follower counts to.
   * If the user has more followers than the check amount, the user is included in the influencer
   * list.
   * @return a list of users who are influencers, users who have a number of followers that is over
   * the check amount.
   */
  protected List<Integer> influencerListCreator (Integer checkAmount) {
    List<Integer> influencerList = new ArrayList<Integer>();
    for (Map.Entry<Integer, Integer> entry: getFollowAmountMap().entrySet()) {
      if(entry.getValue() > checkAmount) {
        influencerList.add(entry.getKey());
      }
    }
    return influencerList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FollowedHistogram)) {
      return false;
    }
    FollowedHistogram that = (FollowedHistogram) o;
    return Objects.equals(followAmountMap, that.followAmountMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(followAmountMap);
  }

  @Override
  public String toString() {
    return "FollowedHistogram{" +
        "followAmountMap=" + followAmountMap +
        '}';
  }
}
