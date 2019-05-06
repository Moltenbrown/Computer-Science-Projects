package edu.neu.ccs.cs5004.Problem4;

import static org.junit.Assert.*;
import static edu.neu.ccs.cs5004.Problem4.PlayerListTest.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SoccerTeamTest {
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
  SoccerTeam soccerTeam;

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
    soccerTeam = new SoccerTeam(playerList);
  }

  @Test
  public void getMembers() {
    Assert.assertEquals(playerList, soccerTeam.getMembers());
  }

  @Test
  public void setMembers() {
    soccerTeam.setMembers(test);
    Assert.assertEquals(test, soccerTeam.getMembers());
  }

  @Test
  public void scoreGoal() throws Exception {
    soccerTeam.scoreGoal(soccerPlayer2);
    PlayerList roster = soccerTeam.getMembers();
    SoccerPlayer soccerPlayer = roster.roster.get(1);
    Assert.assertEquals(new Integer(1), soccerPlayer.getGoalsScored());
  }

  @Test
  public void defendGoal() throws Exception {
    soccerTeam.defendGoal(soccerPlayer1);
    PlayerList roster = soccerTeam.getMembers();
    SoccerPlayer soccerPlayer = roster.roster.get(0);
    Assert.assertEquals(new Integer(1), soccerPlayer.getGoalsDefended());
  }

  @Test
  public void receivePenalty() throws Exception {
    soccerTeam.receivePenalty(soccerPlayer3, "penalty kick");
    PlayerList roster  = soccerTeam.getMembers();
    SoccerPlayer soccerPlayer = roster.roster.get(2);
    Assert.assertEquals("penalty kick, ", soccerPlayer.getPenalties());
  }

  @Test(expected = PlayerMismatchException.class)
  public void PlayerMismatchException() throws Exception{
    soccerTeam.scoreGoal(soccerPlayer24);
    soccerTeam.defendGoal(soccerPlayer2);
    soccerTeam.defendGoal(soccerPlayer24);
    soccerTeam.receivePenalty(soccerPlayer24, "red card");
  }

  @Test(expected = IllegalOperationException.class)
  public void IllegalOperationException() throws Exception{
    playerList.updatePenalties(soccerPlayer23, "birdy");
  }

  @Test
  public void printMembers() throws Exception {
    ByteArrayOutputStream printout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(printout));
    test.addPlayer(soccerPlayer2);
    test.addPlayer(soccerPlayer24);
    test.addPlayer(soccerPlayer3);
    SoccerTeam testHolder = new SoccerTeam(test);
    testHolder.printMembers();
    Assert.assertEquals("SoccerPlayer{name='Aaron'}\nSoccerPlayer{name='Xander'}"
        + "\nSoccerPlayer{name='Carit'}\n", printout.toString());
  }

  @Test
  public void equals() throws Exception {
    Assert.assertFalse(soccerTeam.equals(test));
    test.addPlayers(playerList.roster);
    SoccerTeam testHolder = new SoccerTeam(test);
    Assert.assertTrue(soccerTeam.equals(testHolder));
    PlayerList testMembersHolder = testHolder.getMembers();
    testMembersHolder.removePlayer(soccerPlayer2);
    testHolder.setMembers(testMembersHolder);
    Assert.assertFalse(soccerTeam.equals(testHolder));
    Assert.assertFalse(soccerTeam.equals(new SoccerTeam(new PlayerList())));
  }

  @Test
  public void hashCodeTest() throws Exception{
    test.addPlayers(playerList.roster);
    SoccerTeam testHolder = new SoccerTeam(test);
    Assert.assertEquals(testHolder.hashCode(), soccerTeam.hashCode());
    Assert.assertNotEquals(soccerTeam.hashCode(), new SoccerTeam(new PlayerList()));
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("SoccerTeam{members=PlayerList{roster=[SoccerPlayer{name='Bjorn'}, "
        + "SoccerPlayer{name='Aaron'}, SoccerPlayer{name='Carit'}, SoccerPlayer{name='Daan'}, "
        + "SoccerPlayer{name='Ebbe'}, SoccerPlayer{name='Fabio'}, SoccerPlayer{name='Gabor'}, "
        + "SoccerPlayer{name='Helle'}, SoccerPlayer{name='Ian'}, SoccerPlayer{name='Jaan'}, "
        + "SoccerPlayer{name='Kaare'}, SoccerPlayer{name='Lago'}, SoccerPlayer{name='Magner'}, "
        + "SoccerPlayer{name='Nandor'}, SoccerPlayer{name='Obed'}, SoccerPlayer{name='Palman'}, "
        + "SoccerPlayer{name='Quentin'}, SoccerPlayer{name='Radi'}, "
        + "SoccerPlayer{name='Sakaria'}, SoccerPlayer{name='Tage'}, SoccerPlayer{name='Ubbe'}, "
        + "SoccerPlayer{name='Vagn'}, SoccerPlayer{name='Willem'}]}}", soccerTeam.toString());
  }
}