package edu.neu.ccs.cs5004;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Represents an abstract user list abstract class. This is used to allow the program
 * to create one of three types of user lists based on the user input.
 *
 * @author Goch.
 */
abstract class AbstractRecommender implements IRecommender {
  protected Map<Integer, RecommendationList> recommendations;

  /**
   * Creates a new abstract empty.
   */
  protected AbstractRecommender() {
    this.recommendations = new HashMap<Integer, RecommendationList>();
  }

  /**
   * Returns the recommendations.
   * @return the recommendations.
   */
  public Map<Integer, RecommendationList> getRecommendations() {
    return recommendations;
  }

  /**
   * Adds a user node id and recommendation list as a pair in to the abstract recommender's
   * recommendation list.
   * @param userNodeID the user node id that will act as the key of the pairing.
   * @param recommendationList the recommendation list for the user that will act as value in the
   * pairing.
   */
  protected void addPairingToRecommendationList(Integer userNodeID,
      RecommendationList recommendationList) {
    this.recommendations.put(userNodeID, recommendationList);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public abstract void RecommendationList(String nodes, String edges, String output,
      String processingFlag, Integer numberOfUsersToProcess, Integer numberOfRecommendations) throws
      Exception;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractRecommender)) {
      return false;
    }
    AbstractRecommender that = (AbstractRecommender) o;
    return Objects.equals(recommendations, that.recommendations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recommendations);
  }

  @Override
  public String toString() {
    return "Recommendations=" + recommendations +
        '}';
  }
}
