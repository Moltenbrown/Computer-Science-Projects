package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StuntPerformerTest {
  Person name;
  LastScene lastScene;
  LastScene lastScene2;
  boolean beingHitOrKicked;
  boolean beingShotAt;
  boolean jumpingOutAMovingVehicle;
  boolean jumpingFromASkyscraper;
  boolean jumpingFromASkyscraper2;
  WillingnessToPerformStunts affirming;
  WillingnessToPerformStunts declining;
  String formerStuntPerformances;
  StuntPerformer one;
  StuntPerformer two;

  @Before
  public void setUp() throws Exception {
    this.name = new Person("Samuel", "Matthews");
    this.lastScene = new LastScene("Kissing Scene", "5", "January 12, 2009");
    this.lastScene2 = new LastScene("Fight Scene", "15", "June 9, 2006");
    this.beingHitOrKicked = true;
    this.beingShotAt = false;
    this.jumpingFromASkyscraper = true;
    this.jumpingFromASkyscraper2 = false;
    this.jumpingOutAMovingVehicle = true;
    this.affirming = new WillingnessToPerformStunts(beingHitOrKicked, beingShotAt,
        jumpingOutAMovingVehicle, jumpingFromASkyscraper);
    this.formerStuntPerformances = "Ocean's 8";
    this.one = new StuntPerformer(name, lastScene, affirming, formerStuntPerformances);
    this.two = new StuntPerformer(name, lastScene, affirming, "Alice in Wonderland");
  }

  @Test
  public void getFormerStuntPerformances() {
    Assert.assertEquals(one.getFormerStuntPerformances(), "Ocean's 8");
  }

  @Test
  public void equals() {
    Assert.assertTrue(one.equals(new StuntPerformer(name, lastScene, affirming, formerStuntPerformances)));
    Assert.assertFalse(one.equals(true));
    Assert.assertFalse(one.equals(formerStuntPerformances));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(one.hashCode(), new StuntPerformer(name, lastScene, affirming, formerStuntPerformances).hashCode());
    Assert.assertNotEquals(one.hashCode(), two.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Samuel Matthews's last scene's name is Kissing Scene. It's duration is 5"
        + " and it took place on January 12, 2009. Willingness To Perform Stunts: "
        + "being hit or kicked: true, being shot at: false, jumping "
        + "out a moving vehicle: true, and jumping from a "
        + "skyscraper: true. These are their former stunt performances: Ocean's 8.", one.toString());
  }
}