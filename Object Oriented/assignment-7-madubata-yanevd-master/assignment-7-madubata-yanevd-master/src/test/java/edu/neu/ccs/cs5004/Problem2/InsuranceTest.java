package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsuranceTest {

  private Insurance test;
  private Insurance test2;

  private Driver testDriver;
  private Driver testDriver2;

  private ViolationsHistory testHistory;
  private MovingViolation testViolation;
  private LinkedList<AbstractViolations> testList;
  private LinkedList<AbstractDriver> testDriversList;
  private LinkedList<AbstractDriver> testDriversList2;
  private License testLicense;
  private Name testName;
  private Date testDate;
  private Address testAddress;

  @Before
  public void setUp() throws Exception {

    testAddress = new Address("a", "b");

    testName = new Name("a", "b");
    testDate = new Date(1980, 1, 1);

    testLicense = new License(123, testName, testDate, testDate, testDate, testAddress,
        testAddress);

    testViolation = new MovingViolation(MovingViolationsType.DUI, testName, testDate);

    testList = new LinkedList<AbstractViolations>();
    testList.add(testViolation);
    testHistory = new ViolationsHistory(testList);

    testList.add(testViolation);

    testDriver = new Driver(testName, testDate, testLicense, testHistory);
    testDriver2 = new Driver(testName, new Date(), testLicense, testHistory);

    testDriversList = new LinkedList<AbstractDriver>();
    testDriversList.add(testDriver2);
    testDriversList2 = new LinkedList<AbstractDriver>();
    testDriversList2.add(testDriver);

    test = new Insurance(new Name("a","b"), testDate, testDriversList);
    test2 = new Insurance(new Name("a","b"), testDate, testDriversList);

  }

  @Test
  public void getOwner() {
    Assert.assertEquals(new Name("a","b"), test.getOwner());
  }

  @Test
  public void getExpirationDate() {
    Assert.assertEquals(testDate, test.getExpirationDate());
  }

  @Test
  public void getOtherDrivers() {
    Assert.assertEquals(testDriversList, test.getOtherDrivers());
  }

  @Test
  public void equals() {
    assertTrue(test.equals(test));
    assertTrue(test.equals(test2));
    assertFalse(test.equals(null));

    assertFalse(test.equals(new Insurance(new Name("a1","b"), testDate, testDriversList)));
    assertFalse(test.equals(new Insurance(new Name("a","b"), new Date(), testDriversList)));
    assertFalse(test.equals(new Insurance(new Name("a","b"), testDate, testDriversList2)));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("a b's insurance", test.toString());
  }
}