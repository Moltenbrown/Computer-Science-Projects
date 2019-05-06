package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DriverTest {

  private Driver test;
  private Driver test2;

  private ViolationsHistory testHistory;
  private ViolationsHistory testHistory2;

  private MovingViolation testViolation;
  private MovingViolation testViolation2;

  private LinkedList<AbstractViolations> testList;
  private LinkedList<AbstractViolations> testList2;

  private License testLicense;
  private License testLicense2;
  private Name testName;
  private Date testDate;
  private Name testName2;
  private Date testDate2;
  private Address testAddress;
  private Address testAddress2;

  @Before
  public void setUp() throws Exception {
    testAddress = new Address("a", "b");
    testAddress2 = new Address("a2", "b");
    testName = new Name("a", "b");
    testDate = new Date(1980, 1, 1);
    testName2 = new Name("a", "b2");
    testDate2 = new Date(1980, 12, 1);
    testLicense = new License(123, testName, testDate, testDate2, testDate, testAddress,
        testAddress2);
    testLicense2 = new License(1234, testName, testDate, testDate2, testDate, testAddress,
        testAddress2);

    testViolation = new MovingViolation(MovingViolationsType.DUI, testName, testDate);
    testViolation2 = new MovingViolation(MovingViolationsType.SPEEDING, testName, testDate);

    testList = new LinkedList<AbstractViolations>();
    testList.add(testViolation);
    testHistory = new ViolationsHistory(testList);
    testList2 = new LinkedList<AbstractViolations>();
    testList.add(testViolation2);
    testHistory2 = new ViolationsHistory(testList2);

    test = new Driver(testName, testDate, testLicense, testHistory);
    test2 = new Driver(testName, testDate, testLicense, testHistory);

  }

  @Test
  public void getName() {
    Assert.assertEquals(testName, test.getName());
  }

  @Test
  public void getBirthdate() {
    Assert.assertEquals(testDate, test.getBirthdate());
  }

  @Test
  public void getLicense() {
    Assert.assertEquals(testLicense, test.getLicense());
  }

  @Test
  public void getHistory() {
    Assert.assertEquals(testHistory, test.getHistory());
  }

  @Test
  public void equals() {
    assertTrue(test.equals(test));
    assertTrue(test.equals(test2));
    assertFalse(test.equals(null));

    assertFalse(test.equals(new Driver(testName2, testDate, testLicense, testHistory)));
    assertFalse(test.equals(new Driver(testName, testDate2, testLicense, testHistory)));
    assertFalse(test.equals(new Driver(testName, testDate, testLicense2, testHistory)));
    assertFalse(test.equals(new Driver(testName, testDate, testLicense, testHistory2)));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("a b", test.toString());
  }
}