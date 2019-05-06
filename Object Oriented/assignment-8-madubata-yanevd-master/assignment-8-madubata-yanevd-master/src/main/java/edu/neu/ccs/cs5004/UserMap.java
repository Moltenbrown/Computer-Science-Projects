package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Represents a usermap with's details--a user follow map as a Map between
 * Users and other Users.
 * @author Goch
 */
public class UserMap {
  private Map<Integer, List<Integer>> userFollowMap;

  /**
   * Creates a new user map from a string representing a filepath.
   * @param filePath the file we are creating the user map from.
   */
  public UserMap(String filePath) {
    this.userFollowMap = new HashMap<Integer, List<Integer>>();
    try(BufferedReader fileInput = new BufferedReader(new FileReader(filePath))) {
      String userRelationship = fileInput.readLine();
      while ((userRelationship = fileInput.readLine()) != null) {
        StringTokenizer followerFollowee = new StringTokenizer(userRelationship, ",");
        if (followerFollowee.hasMoreTokens()) {
          int follower = Integer.parseInt(followerFollowee.nextToken());
          int followee = Integer.parseInt(followerFollowee.nextToken());
          if(this.userFollowMap.containsKey(follower)) {
            List<Integer> extenderFolloweeList = this.userFollowMap.get(follower);
            extenderFolloweeList.add(followee);
            this.userFollowMap.put(follower, extenderFolloweeList);
          }
          else {
            List<Integer> followeeList = new ArrayList<Integer>();
            followeeList.add(followee);
            this.userFollowMap.put(follower, followeeList);
          }
        }
      }
    } catch(IOException ioe) {
      System.out.println("There was an issue edges input" + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

  /**
   * Returns the user follow map from the current user map.
   * @return the user follow map from the current user map.
   */
  public Map<Integer, List<Integer>> getUserFollowMap() {
    return userFollowMap;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserMap)) {
      return false;
    }
    UserMap userMap = (UserMap) o;
    return Objects.equals(userFollowMap, userMap.userFollowMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userFollowMap);
  }

  @Override
  public String toString() {
    return "UserMap{" +
        "userFollowMap=" + userFollowMap +
        '}';
  }
}
