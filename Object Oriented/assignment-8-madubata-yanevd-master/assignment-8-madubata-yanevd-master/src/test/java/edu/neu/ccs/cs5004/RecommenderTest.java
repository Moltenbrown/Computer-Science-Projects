package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecommenderTest {
  String nodes;
  String edges;
  String output;
  String processingFlag;
  Integer numberOfUsersToProcess;
  Integer numberOfRecommendations;
  Recommender recommender;

  @Before
  public void setUp() throws Exception {
    this.nodes = "/Users/Goch/Desktop/node_small.csv";
    this.edges = "/Users/Goch/Desktop/edges_small.csv";
    this.output = "/Users/Goch/Desktop/Sample.csv";
    this.processingFlag = "r";
    this.numberOfUsersToProcess = null;
    this.numberOfRecommendations = null;
    this.recommender = new Recommender();
  }

  @Test
  public void recommendationList() throws Exception {
    // basically, I'm just testing different process flag, number of users to process, and
    // number of recommendations combinations to see if it works.
    recommender.RecommendationList(nodes, edges, output, processingFlag, numberOfUsersToProcess,
        numberOfRecommendations);
  }
}