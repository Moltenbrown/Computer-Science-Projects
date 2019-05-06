package edu.neu.ccs.cs5004.Problem4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerListTest {
  SoccerPlayer soccerPlayer1;
  SoccerPlayer soccerPlayer2;
  SoccerPlayer soccerPlayer3;
  SoccerPlayer soccerPlayer4;
  SoccerPlayer soccerPlayer5;
  SoccerPlayer soccerPlayer6;
  SoccerPlayer soccerPlayer7;
  SoccerPlayer soccerPlayer8;
  SoccerPlayer soccerPlayer9;
  SoccerPlayer soccerPlayer10;
  SoccerPlayer soccerPlayer11;
  SoccerPlayer soccerPlayer12;
  SoccerPlayer soccerPlayer13;
  SoccerPlayer soccerPlayer14;
  SoccerPlayer soccerPlayer15;
  SoccerPlayer soccerPlayer16;
  SoccerPlayer soccerPlayer17;
  SoccerPlayer soccerPlayer18;
  SoccerPlayer soccerPlayer19;
  SoccerPlayer soccerPlayer20;
  SoccerPlayer soccerPlayer21;
  SoccerPlayer soccerPlayer22;
  SoccerPlayer soccerPlayer23;
  SoccerPlayer soccerPlayer24;
  PlayerList playerList;
  PlayerList test;
  SoccerPlayer soccerTest;

  @Before
  public void setUp() throws Exception {
    soccerPlayer1 = new SoccerPlayer("Bjorn", "goalkeeper", new Integer(0),
        new Integer(0), "");
    soccerPlayer2 = new SoccerPlayer("Aaron", "sweeper", new Integer(0),
        new Integer(0), "");
    soccerPlayer3 = new SoccerPlayer("Carit", "centre-back", new Integer(0),
        new Integer(0), "");
    soccerPlayer4 = new SoccerPlayer("Daan", "full-back", new Integer(0),
        new Integer(0), "");
    soccerPlayer5 = new SoccerPlayer("Ebbe", "full-back", new Integer(0),
        new Integer(0), "");
    soccerPlayer6 = new SoccerPlayer("Fabio", "centre midfield", new Integer(0),
        new Integer(0), "");
    soccerPlayer7 = new SoccerPlayer("Gabor", "left midfield", new Integer(0),
        new Integer(0), "");
    soccerPlayer8 = new SoccerPlayer("Helle", "right midfield", new Integer(0),
        new Integer(0), "");
    soccerPlayer9 = new SoccerPlayer("Ian", "centre forward", new Integer(0),
        new Integer(0), "");
    soccerPlayer10 = new SoccerPlayer("Jaan", "second striker", new Integer(0),
        new Integer(0), "");
    soccerPlayer11 = new SoccerPlayer("Kaare", "winger", new Integer(0),
        new Integer(0), "");
    soccerPlayer12 = new SoccerPlayer("Lago", "goalkeeper", new Integer(0),
        new Integer(0), "");
    soccerPlayer13 = new SoccerPlayer("Magner", "sweeper", new Integer(0),
        new Integer(0), "");
    soccerPlayer14 = new SoccerPlayer("Nandor", "centre-back", new Integer(0),
        new Integer(0), "");
    soccerPlayer15 = new SoccerPlayer("Obed", "full-back", new Integer(0),
        new Integer(0), "");
    soccerPlayer16 = new SoccerPlayer("Palman", "centre midfield", new Integer(0),
        new Integer(0), "");
    soccerPlayer17 = new SoccerPlayer("Quentin", "left midfield", new Integer(0),
        new Integer(0), "");
    soccerPlayer18 = new SoccerPlayer("Radi", "right midfield", new Integer(0),
        new Integer(0), "");
    soccerPlayer19 = new SoccerPlayer("Sakaria", "centre forward", new Integer(0),
        new Integer(0), "");
    soccerPlayer20 = new SoccerPlayer("Tage", "second striker", new Integer(0),
        new Integer(0), "");
    soccerPlayer21 = new SoccerPlayer("Ubbe", "winger", new Integer(0),
        new Integer(0), "");
    soccerPlayer22 = new SoccerPlayer("Vagn", "full-back", new Integer(0),
        new Integer(0), "");
    soccerPlayer23 = new SoccerPlayer("Willem", "goalkeeper", new Integer(0),
        new Integer(0), "");
    soccerPlayer24 = new SoccerPlayer("Xander", "goalkeeper", new Integer(0),
        new Integer(0), "");
    playerList = new PlayerList();
    playerList.addPlayer(soccerPlayer1);
    playerList.addPlayer(soccerPlayer2);
    playerList.addPlayer(soccerPlayer3);
    playerList.addPlayer(soccerPlayer4);
    playerList.addPlayer(soccerPlayer5);
    playerList.addPlayer(soccerPlayer6);
    playerList.addPlayer(soccerPlayer7);
    playerList.addPlayer(soccerPlayer8);
    playerList.addPlayer(soccerPlayer9);
    playerList.addPlayer(soccerPlayer10);
    playerList.addPlayer(soccerPlayer11);
    playerList.addPlayer(soccerPlayer12);
    playerList.addPlayer(soccerPlayer13);
    playerList.addPlayer(soccerPlayer14);
    playerList.addPlayer(soccerPlayer15);
    playerList.addPlayer(soccerPlayer16);
    playerList.addPlayer(soccerPlayer17);
    playerList.addPlayer(soccerPlayer18);
    playerList.addPlayer(soccerPlayer19);
    playerList.addPlayer(soccerPlayer20);
    playerList.addPlayer(soccerPlayer21);
    playerList.addPlayer(soccerPlayer22);
    playerList.addPlayer(soccerPlayer23);
    test = new PlayerList();
  }

  @Test
  public void isEmpty() {
    Assert.assertFalse(playerList.isEmpty());
    Assert.assertTrue(test.isEmpty());
  }

  @Test
  public void addPlayer() throws Exception{
    Assert.assertTrue(test.isEmpty());
    test.addPlayer(soccerPlayer24);
    Assert.assertTrue(test.roster.contains(soccerPlayer24));
  }

  @Test(expected = IllegalOperationException.class)
  public void IllegalOperationException() throws Exception{
    playerList.addPlayer(soccerPlayer24);
    test.removePlayer(soccerPlayer23);
    playerList.updatePenalties(soccerPlayer23, "birdy");
    playerList.addPlayers(playerList.roster);
  }

  @Test
  public void addPlayers() throws Exception {
    test.addPlayers(playerList.roster);
    Assert.assertEquals(playerList, test);
  }

  @Test
  public void removePlayer() throws Exception {
    Assert.assertTrue(playerList.roster.contains(soccerPlayer23));
    playerList.removePlayer(soccerPlayer23);
    Assert.assertFalse(playerList.roster.contains(soccerPlayer23));
  }

  @Test
  public void goalkeeperCount() throws Exception {
    Assert.assertEquals(new Integer(3), playerList.goalkeeperCount());
    Assert.assertEquals(new Integer(0), test.goalkeeperCount());
  }

  @Test(expected = TooManyPlayersException.class)
  public void TooManyPlayersException() throws Exception{
    test.addPlayer(soccerPlayer1);
    test.addPlayer(soccerPlayer12);
    test.addPlayer(soccerPlayer23);
    test.addPlayer(soccerPlayer24);
    test.goalkeeperCount();
  }

  @Test
  public void updateScoreGoal() throws Exception {
    playerList.updateScoreGoal(soccerPlayer2);
    soccerTest = playerList.roster.get(1);
    Assert.assertEquals(soccerTest, soccerPlayer2);
    Assert.assertEquals(new Integer(1), soccerTest.getGoalsScored());
  }

  @Test(expected = PlayerMismatchException.class)
  public void PlayerMismatchException() throws Exception{
    test.updateScoreGoal(soccerPlayer2);
    test.updateDefendGoal(soccerPlayer1);
    test.updatePenalties(soccerPlayer23, "red card");
    playerList.updateDefendGoal(soccerPlayer2);
  }

  @Test
  public void updateDefendGoal() throws Exception {
    playerList.updateDefendGoal(soccerPlayer1);
    soccerTest = playerList.roster.get(0);
    Assert.assertEquals(soccerTest, soccerPlayer1);
    Assert.assertEquals(new Integer(1), soccerTest.getGoalsDefended());
  }

  @Test
  public void updatePenalties() throws Exception {
    playerList.updatePenalties(soccerPlayer12, "yellow card");
    soccerTest = playerList.roster.get(11);
    Assert.assertEquals(soccerTest, soccerPlayer12);
    Assert.assertEquals("yellow card, ", soccerTest.getPenalties());
  }

  @Test
  public void equals() throws Exception {
    Assert.assertFalse(playerList.equals(test));
    test.addPlayers(playerList.roster);
    Assert.assertTrue(playerList.equals(test));
    test.removePlayer(soccerPlayer7);
    Assert.assertFalse(playerList.equals(test));
    Assert.assertFalse(playerList.equals(soccerPlayer2));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertNotEquals(playerList.hashCode(), test.hashCode());
    test.addPlayers(playerList.roster);
    Assert.assertEquals(playerList.hashCode(), test.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("PlayerList{roster=" + playerList.roster + '}',
        playerList.toString());
  }
}