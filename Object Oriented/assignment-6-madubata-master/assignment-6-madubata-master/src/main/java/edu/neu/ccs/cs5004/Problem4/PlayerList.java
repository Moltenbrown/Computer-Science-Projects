package edu.neu.ccs.cs5004.Problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a PlayerList with its details--the roster of soccer players as an ArrayList.
 *
 * @author Goch.
 */
public class PlayerList {
  List<SoccerPlayer> roster;

  /**
   * Creates a new, empty player list.
   */
  public PlayerList() {
    roster = new ArrayList<SoccerPlayer>();
  }

  /**
   * {@inheritDoc}.
   */
  protected boolean isEmpty() {
    return this.roster.isEmpty();
  }

  /**
   * {@inheritDoc}.
   */
  protected void addPlayer (SoccerPlayer playerToAdd) throws IllegalOperationException{
    if (this.roster.size() == 23) {
      throw new IllegalOperationException("You can't add another player to this player list. "
          + "A soccer team can only have 23 players and you've reached that limit.");
    }

    this.roster.add(playerToAdd);
  }

  protected void addPlayers (List <SoccerPlayer> playersToAdd) throws IllegalOperationException {
    if (playersToAdd.size() > 23) {
      throw new IllegalOperationException("You can't add more than 23 players to a player list.");
    }

    this.roster.addAll(playersToAdd);
  }

  /**
   * {@inheritDoc}.
   */
  protected void removePlayer (SoccerPlayer playerToRemove) throws IllegalOperationException {
    if (!this.roster.contains(playerToRemove)) {
      throw new IllegalOperationException("This player isn't in the player list.");
    }

    this.roster.remove(playerToRemove);
  }

  /**
   * {@inheritDoc}.
   */
  protected Integer goalkeeperCount() throws TooManyPlayersException {
    int total = 0;
    for(SoccerPlayer s: this.roster) {
      if (s.getPosition().equals("goalkeeper")) {
        total = total + 1;
      }
    }

    if(total > 3) {
      throw new TooManyPlayersException("This player list has too many goalkeepers. At most"
          + "you can have three goalkeepers.");
    }

    return total;
  }

  /**
   * {@inheritDoc}.
   */
  protected void updateScoreGoal(SoccerPlayer scoringPlayer) throws PlayerMismatchException {
    if (!this.roster.contains(scoringPlayer)) {
      throw new PlayerMismatchException("This player wasn't in the team roster and therefore "
          + "couldn't be updated.");
    }

    else {
      for (SoccerPlayer s : this.roster) {
        if (s.equals(scoringPlayer)) {
          s.setGoalsScored(s.getGoalsScored() + 1);
          break;
        }
      }
    }


  }

  /**
   * {@inheritDoc}.
   */
  protected void updateDefendGoal(SoccerPlayer goalkeeper) throws PlayerMismatchException {
    if (!this.roster.contains(goalkeeper)) {
      throw new PlayerMismatchException("This player wasn't in the team roster and therefore "
          + "couldn't be updated.");
    }

    if (!goalkeeper.getPosition().equals("goalkeeper")) {
      throw new PlayerMismatchException("This function should only be used for goalkeepers.");
    }

    for (SoccerPlayer s : this.roster) {
      if (s.equals(goalkeeper)) {
        s.setGoalsDefended(s.getGoalsDefended() + 1);
        break;
      }
    }
  }

  /**
   * {@inheritDoc}.
   */
  protected void updatePenalties(SoccerPlayer offendingPlayer, String penalty) throws
      PlayerMismatchException, IllegalOperationException {
    List <String> allowedPenaltyList = new ArrayList<String>();
    allowedPenaltyList.add("red card");
    allowedPenaltyList.add("yellow card");
    allowedPenaltyList.add("penalty kick");
    if (!this.roster.contains(offendingPlayer)) {
      throw new PlayerMismatchException("This player wasn't in the team roster and therefore "
          + "couldn't be updated.");
    }

    if (!allowedPenaltyList.contains(penalty)) {
      throw new IllegalOperationException("The only allowed penalties are red card, yellow card, or "
          + "penalty kick.");
    }

    for (SoccerPlayer s : this.roster) {
      if (s.equals(offendingPlayer)) {
        s.setPenalties(s.getPenalties() + penalty + ", ");
        break;
      }
    }
  }

  /**
   * Evaluates whether another object equals the current player list.
   * @param o object being compared to the current player list.
   * @return true if the two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerList)) {
      return false;
    }
    PlayerList that = (PlayerList) o;
    return Objects.equals(roster, that.roster);
  }

  /**
   * Returns the hashcode representation of the player list.
   * @return the hashcode representation of the player list.
   */
  @Override
  public int hashCode() {
    return Objects.hash(roster);
  }

  /**
   * Returns the string representation of the player list.
   * @return the string representation of the player list.
   */
  @Override
  public String toString() {
    return "PlayerList{" +
        "roster=" + roster +
        '}';
  }
}
