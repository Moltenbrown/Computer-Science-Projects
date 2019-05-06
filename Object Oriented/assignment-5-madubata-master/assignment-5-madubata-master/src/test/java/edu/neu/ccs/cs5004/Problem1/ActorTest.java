package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActorTest {
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
  String currentProjects;
  ActorType actorType;
  Actor one;
  Actor two;
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
    this.currentProjects = "Ocean's 8";
    this.actorType = ActorType.LeadActor;
    this.one = new Actor(name, lastScene, affirming, currentProjects, actorType);
    this.two = new Actor(name, lastScene, affirming, currentProjects, ActorType.SupportingRoleActor);
  }

  @Test
  public void getCurrentProjects() {
    Assert.assertEquals("Ocean's 8", one.getCurrentProjects());
  }

  @Test
  public void getActorType() {
    Assert.assertEquals(ActorType.LeadActor, one.getActorType());
  }

  @Test
  public void equals() {
    Assert.assertTrue(one.equals(new Actor(name, lastScene, affirming, currentProjects, actorType)));
    Assert.assertFalse(one.equals(two));
    Assert.assertFalse(one.equals(actorType));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(one.hashCode(), new Actor(name, lastScene, affirming, currentProjects, actorType).hashCode());
    Assert.assertNotEquals(one.hashCode(), two.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Samuel Matthews's last scene's name is Kissing Scene. It's duration is 5"
        + " and it took place on January 12, 2009. Willingness To Perform Stunts: "
        + "being hit or kicked: true, being shot at: false, jumping "
        + "out a moving vehicle: true, and jumping from a "
        + "skyscraper: true. Their current project is Ocean's 8 and they are a LeadActor.", one.toString());
  }
}