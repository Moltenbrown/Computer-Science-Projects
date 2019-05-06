package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import apple.laf.JRSUIConstants.Size;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingSpotTest {
  String name;
  SizeTypes size;
  AccessibilityTypes accessibility;
  boolean availability;
  ParkingSpot testCase1;
  ParkingSpot testCase2;

  @Before
  public void setUp() throws Exception {
    this.name = "A1";
    this.size = SizeTypes.Small;
    this.accessibility = AccessibilityTypes.Inaccessible;
    this.availability = true;
    testCase1 = new ParkingSpot(name, size, accessibility, availability);
    testCase2 = new ParkingSpot("A2", size, accessibility, availability);
  }

  @Test
  public void getName() {
    Assert.assertEquals(name, testCase1.getName());
  }

  @Test
  public void getSize() {
    Assert.assertEquals(size, testCase1.getSize());
  }

  @Test
  public void getAccessibility() {
    Assert.assertEquals(accessibility, testCase1.getAccessibility());
  }

  @Test
  public void isAvailability() {
    Assert.assertEquals(true, testCase1.isAvailability());
  }

  @Test
  public void equals() {
    Assert.assertTrue(testCase1.equals(new ParkingSpot(name, size, accessibility, true)));
    Assert.assertTrue(testCase1.equals(new ParkingSpot(name, size, accessibility, false)));
    Assert.assertFalse(testCase1.equals(testCase2));
    Assert.assertFalse(testCase1.equals(name));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(testCase1.hashCode(), new ParkingSpot(name, size, accessibility,
        true).hashCode());
    Assert.assertNotEquals(testCase1.hashCode(), testCase2.hashCode());
    Assert.assertEquals(testCase1.hashCode(), new ParkingSpot(name, size, accessibility,
        false).hashCode());

  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("A1 is Small, Inaccessible, and its accessibility is currently"
            + " true.",
        testCase1.toString());
  }
}