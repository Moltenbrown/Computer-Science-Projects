package edu.neu.ccs.cs5004.assignment3.problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AttackRangeTest {
  Integer low;
  Integer high;
  AttackRange attackRange;

  @Before
  public void setUp() throws Exception {
    this.low = 0;
    this.high = 40;
    this.attackRange = new AttackRange(low, high);
  }

  @Test
  public void getLow() {
    Assert.assertEquals(low, attackRange.getLow());
  }

  @Test
  public void getHigh() {
    Assert.assertEquals(high, attackRange.getHigh());
  }

  @Test
  public void equals() {
    Assert.assertTrue(attackRange.equals(new AttackRange(low, high)));
    Assert.assertFalse(attackRange.equals(new AttackRange(low, 10)));
    Assert.assertFalse(attackRange.equals(new AttackRange(10, high)));
    Assert.assertFalse(attackRange.equals(low));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertEquals(attackRange.hashCode(), new AttackRange(low, high).hashCode());
    Assert.assertNotEquals(attackRange.hashCode(), new AttackRange(low, 10).hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("low=0, high=40", attackRange.toString());
  }
}