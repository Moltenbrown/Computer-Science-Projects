package edu.neu.ccs.cs5004;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Represents a recommendation list for a user with it's details--a user list as a list of integers
 * representing their nodeIds and the amount of recommendations in the list as an int.
 * @author Goch.
 */
public class RecommendationList {
  private List<Integer> userList;
  private int amountOfRecommendations;

  /**
   * Creates a recommendation list from a user list and an amount of recommendations.
   * @param userList a list of integers representing the node id's of the users.
   */
  protected RecommendationList(List<Integer> userList) {
    this.userList = userList;
    Iterator<Integer> iterator = userList.iterator();
    Integer newAmountOfRecommendations = 0;
    while(iterator.hasNext()){
      Integer holder = iterator.next();
      newAmountOfRecommendations = newAmountOfRecommendations + 1;
    }

    setAmountOfRecommendations(newAmountOfRecommendations);
  }

  /**
   * Returns the amount of recommendations in the recommendation list.
   * @return the amount of recommendations in the recommendation list.
   */
  protected int getAmountOfRecommendations() {
    return amountOfRecommendations;
  }

  /**
   * Returns the list of user node ids that are being recommended as friends.
   * @return the list of user node ids that are being recommended as friends.
   */
  public List<Integer> getUserList() {
    return userList;
  }

  /**
   * Sets the amount of recommendations in the recommendation list to the input int.
   * @param amountOfRecommendations the amount of recommendations we want to set the amount of
   * the amount of recommendations to.
   * @throws InputMismatchException if the user tries to assign a number to the amount of
   * recommendations that isn't equal to the amount of recommendations in the list.
   */
  protected void setAmountOfRecommendations(int amountOfRecommendations) throws
      InputMismatchException
  {
    Iterator<Integer> iterator = userList.iterator();
    Integer currentAmountOfRecommendations = 0;
    while(iterator.hasNext()){
      Integer holder = iterator.next();
      currentAmountOfRecommendations = currentAmountOfRecommendations + 1;
    }

    if(currentAmountOfRecommendations != amountOfRecommendations) {
      throw new InputMismatchException("The amount of recommendations input does not match how many"
          + "recommendations are in the list.");
    }
    this.amountOfRecommendations = amountOfRecommendations;
  }

  /**
   * Adds a nodeId to the current recommendation list, while updating the amount of
   * users in the recommendation list.
   * @param user the user being added to the recommendation list.
   */
  protected void addUserToRecommendationList (Integer user) {
    this.userList.add(user);
    setAmountOfRecommendations(this.amountOfRecommendations + 1);
  }

  /**
   * Adds a list of nodeIds to the current recommendaiton this, while updating the amount of
   * users in the recommendation list.
   * @param userList the list of nodeIds being added to the recommendation lists.
   */
  protected void addListToRecommendationList (List<Integer> userList) {
    RecommendationList newList = new RecommendationList(userList);
    this.userList.addAll(userList);
    setAmountOfRecommendations(this.amountOfRecommendations + newList.amountOfRecommendations);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RecommendationList)) {
      return false;
    }
    RecommendationList that = (RecommendationList) o;
    return amountOfRecommendations == that.amountOfRecommendations &&
        Objects.equals(userList, that.userList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userList, amountOfRecommendations);
  }

  @Override
  public String toString() {
    Iterator<Integer> reader = userList.iterator();
    StringBuffer holder = new StringBuffer();
    while(reader.hasNext()){
      Integer currentNodeId = reader.next();
      holder.append(currentNodeId);
      holder.append(' ');
    }

    String returnValue = holder.toString();
    return returnValue;
  }
}
