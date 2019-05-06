package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WillingnessToPerformStuntsTest {
  boolean beingHitOrKicked;
  boolean beingShotAt;
  boolean jumpingOutAMovingVehicle;
  boolean jumpingFromASkyscraper;
  boolean jumpingFromASkyscraper2;
  WillingnessToPerformStunts one;
  WillingnessToPerformStunts two;

  @Before
  public void setUp() throws Exception {
    this.beingHitOrKicked = true;
    this.beingShotAt = false;
    this.jumpingFromASkyscraper = true;
    this.jumpingFromASkyscraper2 = false;
    this.jumpingOutAMovingVehicle = true;
    this.one = new WillingnessToPerformStunts(beingHitOrKicked, beingShotAt,
        jumpingOutAMovingVehicle, jumpingFromASkyscraper);
    this.two = new WillingnessToPerformStunts(beingHitOrKicked, beingShotAt,
        jumpingOutAMovingVehicle, jumpingFromASkyscraper2);
  }

  @Test
  public void isBeingHitOrKicked() {
    Assert.assertEquals(true, one.isBeingHitOrKicked());
  }

  @Test
  public void isBeingShotAt() {
    Assert.assertEquals(false, one.isBeingShotAt());
  }

  @Test
  public void isJumpingOutAMovingVehicle() {
    Assert.assertEquals(true, one.isJumpingOutAMovingVehicle());
  }

  @Test
  public void isJumpingFromASkyscraper() {
    Assert.assertEquals(true, one.isJumpingFromASkyscraper());
  }

  @Test
  public void equals() {
    Assert.assertTrue(one.equals(new WillingnessToPerformStunts(beingHitOrKicked, beingShotAt,
        jumpingOutAMovingVehicle, jumpingFromASkyscraper)));
    Assert.assertFalse(one.equals(true));
    Assert.assertFalse(one.equals(jumpingFromASkyscraper));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(new WillingnessToPerformStunts(beingHitOrKicked, beingShotAt,
        jumpingOutAMovingVehicle, jumpingFromASkyscraper).hashCode(), one.hashCode());
    Assert.assertNotEquals(one.hashCode(), two.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Willingness To Perform Stunts: "
        + "being hit or kicked: true, being shot at: false, jumping "
            + "out a moving vehicle: true, and jumping from a "
            + "skyscraper: true.", one.toString());
  }
}