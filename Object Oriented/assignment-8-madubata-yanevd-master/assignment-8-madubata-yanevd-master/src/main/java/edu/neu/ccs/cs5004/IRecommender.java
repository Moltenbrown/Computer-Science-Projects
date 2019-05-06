package edu.neu.ccs.cs5004;

/**
 * Represents an interface for the recommendation application.
 * @author Goch
 */
public interface IRecommender {


  /**
   * Writes to an output file located at output from the nodes, and edges, processing flag, number
   * of users to process, and number of recommendations the users input.
   * @param nodes the files containing all the nodes in the system.
   * @param edges the files containing all the follower, followee relationships between the users.
   * @param output the filename of the file the program will output data to.
   * @param processingFlag how the user wants the users processed. 's' means the users are processed
   * from the start of the list, 'e' means the users are processed from the end, and 'r' means the
   * users are processed at random. The default is to start from the start of the list.
   * @param numberOfUsersToProcess how many users will receive recommendations from 0 to 100. The
   * default value is 30.
   * @param numberOfRecommendations how many recommendations each user will receive from 0 to 100.
   * The default is 10 unless the users specifies otherwise.
   * @throws Exception if exception requirements for the out of bounds exception are hit.
   */
  void RecommendationList(String nodes, String edges, String output, String processingFlag,
      Integer numberOfUsersToProcess, Integer numberOfRecommendations) throws Exception;
}
