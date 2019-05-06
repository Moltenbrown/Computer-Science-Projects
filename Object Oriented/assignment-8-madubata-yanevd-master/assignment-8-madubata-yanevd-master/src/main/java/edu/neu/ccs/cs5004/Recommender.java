package edu.neu.ccs.cs5004;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * Represents the recommender, which extends abstract recommender.
 *
 * @author Goch.
 */
public class Recommender extends AbstractRecommender {

  public Recommender() {
    super();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void RecommendationList(String nodes, String edges, String output,
      String processingFlag, Integer numberOfUsersToProcess, Integer numberOfRecommendations)
  throws Exception {
    if(nodes == null || edges == null || output == null){
      throw new OutOfRangeException("This program requires a complete filepath to a csv containing"
          + "nodes, a complete filepath to a csv containing edges, and a complete filepath to an"
          + "existing file or filename to store the recommendation data in.");
    }

    // creating different classes of objects.
    UserQueue users = new UserQueue(nodes);
    Deque<User> userList  = users.getUserList();
    User[] userListArray = userList.toArray(new User[0]); // necessary for random access.
    UserMap userRelationships = new UserMap(edges);
    Map<Integer, List<Integer>> friendsToLookThrough = userRelationships.getUserFollowMap();
    FollowedHistogram followedHistogram = new FollowedHistogram(userRelationships);

    Recommender recommender = new Recommender();
    RecommendationList friendHolder = new RecommendationList(new ArrayList<Integer>());
    Iterator<User> userTravelor = userList.iterator();
    File file = new File(output);
    if(!file.exists()) {
      throw new FileNotFoundException("User didn't enter an existing file. Please try again.");
    }

    BufferedWriter fileOutput = new BufferedWriter(new FileWriter(output));

    Integer amountOfUsersToProcess = numberOfUsersToProcess;

    if(amountOfUsersToProcess == null) {
      amountOfUsersToProcess = new Integer(30);
    }

    if (amountOfUsersToProcess < 0 || amountOfUsersToProcess> 100) {
      throw new OutOfRangeException("The number of recommendations must be in the range 0 to 100.");
    }

    Integer amountOfRecommendations = numberOfRecommendations;

    if(amountOfRecommendations == null) {
      amountOfRecommendations = new Integer(10);
    }

    if (amountOfRecommendations < 0 || amountOfRecommendations > 100) {
      throw new OutOfRangeException("The number of users to process must be in the range 0 to 100."
      );
    }

    if(processingFlag == null){
      userTravelor = userList.iterator();
    }

    if(processingFlag == "e") {
      userTravelor = userList.descendingIterator();
    }

    if(processingFlag == "r") {
      userTravelor = users.myIterator();
    }

    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock writeLock = lock.writeLock();

    while(recommender.getRecommendations().size() + 1 < amountOfUsersToProcess) {
      User currentSubject = userTravelor.next();
      Integer currentNodeId = currentSubject.getNodeId();
      List<Integer> currentFolloweeList = friendsToLookThrough.get(currentNodeId);

      if(currentFolloweeList != null) {
        Iterator<Integer> currentFriend = currentFolloweeList.iterator();
        while (currentFriend.hasNext() &&
            friendHolder.getAmountOfRecommendations() != amountOfRecommendations) {
          Integer searcher = currentFriend.next();
          List<Integer> results = friendsToLookThrough.get(searcher);
          if (results == null) {
            continue;
          }

          int remainingSpace = amountOfRecommendations-friendHolder.getAmountOfRecommendations();
          results.removeAll(currentFolloweeList);

          if (results.size() > remainingSpace) {
            friendHolder.addListToRecommendationList(results.subList(0, remainingSpace));
          }

          else {
            results.removeAll(currentFolloweeList);
            friendHolder.addListToRecommendationList(results);
          }
        }
      }


      if(friendHolder.getAmountOfRecommendations() < amountOfRecommendations) {
        List<Integer> influencers = followedHistogram.influencerListCreator(15);

        if(userList.size() > 100) {
          influencers = followedHistogram.influencerListCreator(150);
        }

        Iterator<Integer> currentInfluencer = influencers.iterator();

        while(friendHolder.getAmountOfRecommendations() < amountOfRecommendations &&
        currentInfluencer.hasNext()) {
          Integer influencer = currentInfluencer.next();
          if(!friendHolder.getUserList().contains(influencer)) {
            friendHolder.addUserToRecommendationList(influencer);
          }
        }
      }

      if(friendHolder.getAmountOfRecommendations() < amountOfRecommendations) {
        Random randomNumber = new Random();
        while(friendHolder.getAmountOfRecommendations() < amountOfRecommendations) {
          Integer index = randomNumber.nextInt(userList.size());
          if(!friendHolder.getUserList().contains(userListArray[index].getNodeId())) {
            friendHolder.addUserToRecommendationList(userListArray[index].getNodeId());
          }
        }
      }

      recommender.addPairingToRecommendationList(currentNodeId, friendHolder);
      friendHolder = new RecommendationList(new ArrayList<Integer>());
    }

    StringBuffer header = new StringBuffer();
    header.append("User");
    header.append(',');
    header.append("Recommendations");
    header.append('\n');

    for (Map.Entry<Integer, RecommendationList> entry: recommender.getRecommendations().entrySet()) {
      header.append(entry.getKey().intValue());
      header.append(',');
      header.append(entry.getValue());
      header.append('\n');
    }

    fileOutput.write(header.toString());
    fileOutput.close();
  }

  @Override
  public String toString() {
    return "recommendations=" + recommendations +
        '}';
  }
}
