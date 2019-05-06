package edu.neu.ccs.cs5004.Problem4;

import java.util.Objects;

/**
 * Class SoccerTeam represents the team of soccer players competing on the World Cup tournament.
 */
public class SoccerTeam {
  private PlayerList members;

  /**
   * Constructs a new object, SoccerTeam, consisting of 23 players (out those 23 players,
   * 3 players are goalkeepers, and at any given time, there can be at most 11 players on the field)
   * @param members - members of the soccer team
   * @return - new object SoccerTeam
   */
  public SoccerTeam(PlayerList members) { this.members = members;
  }

  /**
   * Returns the members of the SoccerTeam as a PlayerList
   * @return - the members of the SoccerTeam as a PlayerList
   */
  public PlayerList getMembers() { return this.members;
  }

  /**
   * Sets the members of the SoccerTeam
   * @param members - the members to set
   */
  public void setMembers(PlayerList members) { this.members = members;
  }

  /**
   * Method updates the information (tally) of scored goals for a player who scored a goal
   * @param scoringPlayer - player who scored a goal
   */
  public void scoreGoal(SoccerPlayer scoringPlayer) throws PlayerMismatchException{
    this.members.updateScoreGoal(scoringPlayer);
    }

    /**
     * Method updates the information (tally) of defended goals for a player who directly (as a
     * goal keeper) defended a goal
     * @param goalkeeper - goalkeeper
     */
    public void defendGoal(SoccerPlayer goalkeeper) throws PlayerMismatchException {
      this.members.updateDefendGoal(goalkeeper);
    }

  /**
   * Method updates the information about the penalites earned by a player
   * @param offendingPlayer - a player that got a penalty
   */
  public void receivePenalty(SoccerPlayer offendingPlayer, String penalty) throws
      PlayerMismatchException, IllegalOperationException { // Updated this because it doesn't specify
    this.members.updatePenalties(offendingPlayer, penalty); //what penalty the person got.
  }

  public void printMembers() {
    PlayerList holder = this.members;
    for(SoccerPlayer s: holder.roster) {
      System.out.println(s);
    }
  }

  /**
   * Returns whether an object is equal to the soccer team.
   * @param o the object being compared to the soccer team.
   * @return true if the object is equal to the soccer team, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SoccerTeam)) {
      return false;
    }
    SoccerTeam that = (SoccerTeam) o;
    return Objects.equals(members, that.members);
  }


  /**
   * Returns the hashcode representation of the soccer team.
   * @return the hashcode representation of the soccer team.
   */
  @Override
  public int hashCode() {
    return Objects.hash(members);
  }

  /**
   * Returns the string representation of the soccer team.
   * @return the string representation of the soccer team.
   */
  @Override
  public String toString() {
    return "SoccerTeam{" +
        "members=" + members +
        '}';
  }
}
