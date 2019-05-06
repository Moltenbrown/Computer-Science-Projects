package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonMovingViolationTest {

  private NonMovingViolation test;
  private NonMovingViolation test2;

  private Name testName;
  private Date testDate;
  private Name testName2;
  private Date testDate2;

  @Before
  public void setUp() throws Exception {
    testName = new Name("a", "b");
    testDate = new Date(1980, 1, 1);
    testName2 = new Name("a", "b2");
    testDate2 = new Date(1980, 12, 1);
    test = new NonMovingViolation(NonMovingViolationsType.PARKING, testName, testDate);
    test2 = new NonMovingViolation(NonMovingViolationsType.PARKING, testName, testDate);
  }

  @Test
  public void getDate(){
    Assert.assertEquals(testDate, test.getDate());
  }

  @Test
  public void getViolation() {
    Assert.assertEquals(NonMovingViolationsType.PARKING, test.getViolation());
  }

  @Test
  public void equalsTest() {
    assertTrue(test.equals(test));
    assertTrue(test.equals(test2));
    assertFalse(test.equals(null));

    assertFalse(
        test.equals(new NonMovingViolation(NonMovingViolationsType.PAPERWORK, testName, testDate)));
    assertFalse(
        test.equals(new NonMovingViolation(NonMovingViolationsType.PARKING, testName2, testDate)));
    assertFalse(
        test.equals(new NonMovingViolation(NonMovingViolationsType.PARKING, testName, testDate2)));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("PARKING", test.toString());
  }
}