package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
  SizeTypes size;
  AccessibilityTypes accessibility;
  Vehicle testCase1;
  Vehicle testCase2;

  @Before
  public void setUp() throws Exception {
    this.size = SizeTypes.Small;
    this.accessibility = AccessibilityTypes.Accessible;
    this.testCase1 = new Vehicle(size, accessibility);
    this.testCase2 = new Vehicle(SizeTypes.Large, accessibility);
  }

  @Test
  public void getSize() {
    Assert.assertEquals(SizeTypes.Small, testCase1.getSize());
  }

  @Test
  public void getAccessibility() {
    Assert.assertEquals(AccessibilityTypes.Accessible, testCase1.getAccessibility());
  }

  @Test
  public void equals() {
    Assert.assertTrue(testCase1.equals(new Vehicle(SizeTypes.Small,
        AccessibilityTypes.Accessible)));
    Assert.assertFalse(testCase1.equals(testCase2));
    Assert.assertFalse(testCase1.equals(size));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(testCase1.hashCode(), new Vehicle(SizeTypes.Small,
        AccessibilityTypes.Accessible).hashCode());
    Assert.assertNotEquals(testCase1.hashCode(), testCase2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("This vehicle is Small and Accessible for people with "
        + "disabilities.", testCase1.toString());
  }
}