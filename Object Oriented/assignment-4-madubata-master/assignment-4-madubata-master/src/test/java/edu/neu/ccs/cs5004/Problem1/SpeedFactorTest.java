package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpeedFactorTest {
  Integer value;
  SpeedFactorType speedFactorType;
  SpeedFactorType speedFactorType2;
  Integer otherValue;
  Integer lastValue;
  SpeedFactor test1;
  SpeedFactor test2;
  SpeedFactor test3;
  Integer testValue;
  Integer testValue2;
  Integer testLow;
  Integer testHigh;

  SpeedFactor test;
  SpeedFactor testEquals2;

  @Before
  public void setUp() throws Exception {
    this.value = new Integer(33);
    this.otherValue = new Integer(9);
    this.lastValue = new Integer(55);
    this.speedFactorType = SpeedFactorType.ACCELERATION;
    this.speedFactorType2 = SpeedFactorType.DECELERATION;
    this.test1 = new SpeedFactor(this.value, speedFactorType);
    this.testValue = new Integer(33);
    this.testValue2 = new Integer(27);
    this.test = new SpeedFactor(testValue, speedFactorType);
    this.testEquals2 = new SpeedFactor(testValue2, speedFactorType2);
  }

  @Test
  public void getValue() {
    Assert.assertEquals(new Integer(33), test1.getValue());
  }

  @Test
  public void getLowBound() {
    Assert.assertEquals(new Integer(10), test1.getLowBound());
    Assert.assertEquals(new Integer(20), testEquals2.getLowBound());
  }

  @Test
  public void getHighBound() {
    Assert.assertEquals(new Integer(50), test1.getHighBound());
    Assert.assertEquals(new Integer(50), testEquals2.getHighBound());
  }

  @Test
  public void equals() throws OutOfBoundsException {
    Assert.assertTrue(test.equals(test1));

    Assert.assertFalse(test1.equals(testEquals2));
    Assert.assertFalse(test.equals(testLow));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(this.test.hashCode(), this.test1.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("The current speed factor is 33, which is between the low bound: "
        + "10, and the high bound: 50.", test1.toString());
  }

  @Test(expected = OutOfBoundsException.class)
  public void testOutOfBoundsException() throws Exception {
    this.test2 = new SpeedFactor(this.otherValue, speedFactorType);
    this.test3 = new SpeedFactor(this.lastValue, speedFactorType2);
  }
}