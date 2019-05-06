package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ViolationsHistoryTest {

  ViolationsHistory test;
  ViolationsHistory test2;

  private MovingViolation testViolation;
  private MovingViolation testViolation2;

  private LinkedList<AbstractViolations> testList;
  private LinkedList<AbstractViolations> testList2;

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
    testViolation = new MovingViolation(MovingViolationsType.DUI, testName, testDate);
    testViolation2 = new MovingViolation(MovingViolationsType.SPEEDING, testName, testDate);

    testList = new LinkedList<AbstractViolations>();
    testList.add(testViolation);
    test = new ViolationsHistory(testList);
    testList2 = new LinkedList<AbstractViolations>();
    testList.add(testViolation2);
    test2 = new ViolationsHistory(testList);
  }

  @Test
  public void getViolations() {
    Assert.assertEquals(testList, test.getViolations());
  }

  @Test
  public void equals() {
    assertTrue(test.equals(test));
    assertTrue(test.equals(test2));
    assertFalse(test.equals(null));

    assertFalse(test.equals(new ViolationsHistory(testList2)));


  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Not Supported.", test.toString());
  }
}