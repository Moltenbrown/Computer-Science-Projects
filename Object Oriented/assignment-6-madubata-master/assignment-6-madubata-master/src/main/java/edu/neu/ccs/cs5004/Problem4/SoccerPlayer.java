package edu.neu.ccs.cs5004.Problem4;

import java.util.Objects;

/**
 * Class Player represents relevant information about a soccer player
 */
public class SoccerPlayer {private String name; private String position;
  private Integer goalsScored; private Integer goalsDefended; private String penalties;

  /**
   * Constructs a new object SoccerPlayer.
   * @param name - a name of a soccer player, represented as a String
   * @param position - a position of a soccer player, represented as a String
   * @param goalsScored - the number of goals a player scored on the tournament
   * @param goalsDefended - the number of goals a player directly defended (as a goalkeeper)
   * on the tournament
   * @param penalties - the list of penalties a player has been given (yellow card, red card,
   * penalty kick)
   * @return - a new SoccerPlayer object
   */
  public SoccerPlayer(String name, String position, Integer goalsScored, Integer goalsDefended,
      String penalties) {
    this.name = name;
    this.position = position;
    this.goalsScored = goalsScored;
    this.goalsDefended = goalsDefended;
    this.penalties = penalties; }

  /**
   * Returns the name of the player
   * @return - a name of a soccer player, represented as a String
   */
  public String getName() { return name; }

  /**
   * Returns the position of the player
   * @return - a position of a soccer player, represented as a String
   */
  public String getPosition() { return position; }

  /**
   * Returns the number of goals scored by the player
   * @return - the number of goals a player scored on the tournament */
  public Integer getGoalsScored() { return goalsScored; }

  /**
   * Returns the number of goals directly defended by the player
   * @return - the number of goals a player directly defended (as a goalkeeper) on the tournament
   */
  public Integer getGoalsDefended() { return goalsDefended; }

  /**
   * Returns the list of penalties a player has been given (yellow card, red card, penalty kick)
   * @return - the list of penalties a player has been given (yellow card, red card, penalty kick),
   * as a String
   */
  public String getPenalties() { return penalties; }

  /**
   * Sets the name of the player
   * @param name - a name of a soccer player, represented as a String
   */
  public void setName(String name) { this.name = name; }

  /**
   * Sets the position of the player
   * @param position - a position of a soccer player, represented as a String
   */
  public void setPosition(String position) { this.position = position; }

  /**
   * Sets the number of goals scored by the player
   * @param goalsScored - the number of goals scored by the soccer player, represented as a Integer
   */
  public void setGoalsScored(Integer goalsScored) { this.goalsScored = goalsScored; }

  /**
   * Sets the number of goals directly defended by the player
   * @param goalsDefended - the number of goals directly defended by the soccer player, represented
   * as a Integer
   */
  public void setGoalsDefended(Integer goalsDefended) { this.goalsDefended = goalsDefended; }

  /**
   *Sets the list of penalties earned by the player
   *@param penalties - the list of penalties a player has been given (yellow card, red card,
   * penalty kick),
   * as a String
   */
  public void setPenalties(String penalties) { this.penalties = penalties; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SoccerPlayer that = (SoccerPlayer) o;
    return Objects.equals(name, that.name) &&
        Objects.equals(position, that.position) && Objects.equals(goalsScored, that.goalsScored) &&
        Objects.equals(goalsDefended, that.goalsDefended) && Objects.equals(penalties,
        that.penalties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, position, goalsScored, goalsDefended, penalties);
  }

  @Override
  public String toString() { return "SoccerPlayer{" +
      "name='" + name + '\'' + '}'; }
}
