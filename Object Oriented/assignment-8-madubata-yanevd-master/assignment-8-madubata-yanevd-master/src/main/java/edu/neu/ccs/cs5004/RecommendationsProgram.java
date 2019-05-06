package edu.neu.ccs.cs5004;

import java.util.*;

/**
 * Creates the output recommendations file from a csv containing the nodes in the
 * network, the connections between the nodes in the network, and the user input.
 * @throws Exception is any of the exceptions for UserQueue or UserMap are hit.
 * @author Goch
 */
public class RecommendationsProgram {
  public static void main(String[] args) throws Exception {
    Scanner console = new Scanner(System.in);

    System.out.print("Please provide an absolute path to your nodes csv file followed by enter.\n");
    String nodes = console.next();

    System.out.print("Please provide an absolute path to your edges csv file followed by enter.\n");
    String edges = console.next();

    System.out.print("Please provide an absolute path to your output csv file followed by enter.\n");
    String output = console.next();

    System.out.print("Please provide how you want to go through the nodes file. Use"
        + "s for \nfrom the beginning to the end, e for from the end to the beginning "
        + "and r for at random. \nIf you don't want to choose an option please just "
        + "press enter null.\n");

    String processingFlag = console.next();
    if(processingFlag == "null") {
      processingFlag = null;
    }

    System.out.print("Please provide the amount of users you want to generate recommendations for.\n"
        + "Enter a number from and including 0 to 100 and press enter.\nIf you don't want to choose"
        + "an option, please just enter null.\n");

    Integer amountOfUsersToProcess = 0;
    String amountOfUsers = console.next();
    try{
      amountOfUsersToProcess = Integer.parseInt(amountOfUsers);
    } catch (NumberFormatException number){
      amountOfUsersToProcess = null;
    }

    System.out.print("Please provide the amount of recommendations you want to generate \n"
        + "for each user. Enter a number from and including 0 to 100 and press enter.\nIf you don't"
        + "want to choose an option, please just enter null.\n");

    Integer amountOfRecommendations = 0;
    String recommendationsString = console.next();
    try{
      amountOfRecommendations = Integer.parseInt(recommendationsString);
    } catch (NumberFormatException number){
      amountOfRecommendations = null;
    }

    Recommender recommender = new Recommender();
    recommender.RecommendationList(nodes, edges, output, processingFlag, amountOfUsersToProcess,
        amountOfRecommendations);
  }
}
