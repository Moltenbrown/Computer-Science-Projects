package edu.neu.ccs.cs5004.Problem4;

/**
 * Represents the interface for a PlayerList with all the methods
 *
 * @author Goch
 */
public interface IPlayerList {

  /**
   * Returns whether or not an IPlayerList is empty or not.
   * @return true if the IPlayerList is empty, false otherwise.
   */
  boolean isEmpty();

  /**
   * Adds a player to the IPlayerList or throws an illegal operation exception.
   * @param playerToAdd the player to add to the player list.
   * @throws IllegalOperationException if the user tries to add a player to a full player list.
   * A full team has 23 players already.
   */
  void addPlayer(SoccerPlayer playerToAdd) throws IllegalOperationException;

  /**
   * Removes a player from an IPlayerList or throws an illegal operation exception.
   * @param playerToRemove the player to remove from the player list.
   * @throws IllegalOperationException if the user tries to remove a player from a empty PlayerList.
   */
  void removePlayer(SoccerPlayer playerToRemove) throws IllegalOperationException;

  /**
   * Returns the amount of players in the PlayerList.
   * @return the amount of players in the PlayerList.
   */
  Integer teamCount() throws TooManyPlayersException;

  /**
   * Calculates how many of the players in the PlayerList are goalkeepers.
   * @return the amount of goalkeepers in the PlayerList.
   * @throws TooManyPlayersException if there are more than three goal keepers in the
   * player list.
   */
  Integer goalkeeperCount() throws TooManyPlayersException;

  /**
   * Increases the goal amount for the soccer player.
   * @param scoringPlayer the soccer player whose goal scored field we are increasing.
   * @throws PlayerMismatchException when the user tries to update a soccer player who isn't
   * in the PlayerList or if the user tries to update a goalkeeper.
   */
  void updateScoreGoal(SoccerPlayer scoringPlayer) throws PlayerMismatchException;

  /**
   * Updates the amount of goals defended by a goal keeper named in the PlayerList.
   * @param goalkeeper the goal keeper's whose goals defended field we are updating.
   * @throws PlayerMismatchException when the user tries to update a goalkeeper who isn't in
   * the PlayerList.
   */
  void updateDefendGoal(SoccerPlayer goalkeeper) throws PlayerMismatchException;

  /**
   * Updates the penalties for the soccer player.
   * @param offendingPlayer the soccer player whose penalties field we are updating.
   * @throws PlayerMismatchException when the user tries to update a soccer player who isn't in the
   * PlayerList.
   */
  void updatePenalties(SoccerPlayer offendingPlayer, String penalty) throws PlayerMismatchException
  , IllegalOperationException;

}
