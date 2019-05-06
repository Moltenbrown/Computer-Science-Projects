package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

  private Vehicle test;
  private Vehicle test2;

  private Name testName;
  private Date testDate;
  private Driver testDriver;
  private LinkedList<AbstractViolations> testViolations;
  private LinkedList<AbstractViolations> testCrashes;
  private LinkedList<AbstractDriver> testDriversList;
  private License testLicense;


  @Before
  public void setUp() throws Exception {
    testName = new Name("a", "b");
    testDate = new Date(1980, 1, 1);
    testLicense = new License(123, testName, testDate, testDate, testDate, new Address("WA", "US"),
        new Address("OR", "US"));

    testViolations = new LinkedList<AbstractViolations>();
    testViolations.add(new MovingViolation(MovingViolationsType.DUI, new Name("j","d"), new Date()));
    testCrashes = new LinkedList<AbstractViolations>();
    testCrashes.add(new Crash(CrashType.FENDER, new Name("j","d"), new Date()));

    testDriver = new Driver(testName, testDate, testLicense, new ViolationsHistory(testViolations));

    testDriversList = new LinkedList<AbstractDriver>();
    testDriversList.add(testDriver);

    test = new Vehicle("abc", 1990, testName, new Insurance(testName, testDate, testDriversList),
        new ViolationsHistory(testViolations),
        new ViolationsHistory(testCrashes));
    test2 = new Vehicle("abc", 1990, testName, new Insurance(testName, testDate, testDriversList),
        new ViolationsHistory(testViolations),
        new ViolationsHistory(testCrashes));


  }

  @Test
  public void getViolations() {
    Assert.assertEquals(new ViolationsHistory(testViolations), test.getViolations());
  }

  @Test
  public void getCrashes() {
    Assert.assertEquals(new ViolationsHistory(testCrashes), test.getCrashes());
  }

  @Test
  public void getMake() {
    Assert.assertEquals(1990, test.getMake(), .1);
  }

  @Test
  public void getOwner() {
    Assert.assertEquals(testName, test.getOwner());
  }

  @Test
  public void getInsurance() {
    Assert.assertEquals(new Insurance(testName, testDate, testDriversList), test.getInsurance());
  }

  @Test
  public void equals() {
    assertTrue(test.equals(test));
    assertTrue(test.equals(test2));
    assertFalse(test.equals(null));

    assertFalse(test.equals(new Vehicle("abcd", 1990, testName, new Insurance(testName, testDate, testDriversList),
        new ViolationsHistory(testViolations),
        new ViolationsHistory(testCrashes))));
    assertFalse(test.equals(new Vehicle("abc", 1991, testName, new Insurance(testName, testDate, testDriversList),
        new ViolationsHistory(testViolations),
        new ViolationsHistory(testCrashes))));
    assertFalse(test.equals(new Vehicle("abc", 1990, new Name("i,",""), new Insurance(testName, testDate, testDriversList),
        new ViolationsHistory(testViolations),
        new ViolationsHistory(testCrashes))));
    assertFalse(test.equals(new Vehicle("abc", 1990, testName, new Insurance(testName, new Date(), testDriversList),
        new ViolationsHistory(testViolations),
        new ViolationsHistory(testCrashes))));
    assertFalse(test.equals(new Vehicle("abc", 1990, testName, new Insurance(testName, testDate, testDriversList),
        new ViolationsHistory(testCrashes),
        new ViolationsHistory(testCrashes))));
    assertFalse(test.equals(new Vehicle("abc", 1990, testName, new Insurance(testName, testDate, testDriversList),
        new ViolationsHistory(testViolations),
        new ViolationsHistory(testViolations))));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("abc", test.toString());
  }
}