package edu.neu.ccs.cs5004.Problem2;

import static edu.neu.ccs.cs5004.Problem2.CrashType.INJURY;
import static edu.neu.ccs.cs5004.Problem2.MovingViolationsType.DUI;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {

  private Application test;
  private Application test2;

  private AbstractVehicle testVehicle;
  private AbstractDriver testDriver;
  private LinkedList<AbstractViolations> testViolations;
  private LinkedList<AbstractViolations> testCrashes;
  private LinkedList<AbstractDriver> testDriversList;
  private ViolationsHistory testHistory;
  private ViolationsHistory testCrashHistory;

  @Before
  public void setUp() throws Exception {
    testViolations = new LinkedList<>();
    testCrashes = new LinkedList<>();
    testDriversList = new LinkedList<>();

    testViolations.add(new MovingViolation(DUI, new Name("j", "d"), new Date()));
    testCrashes.add(new Crash(INJURY, new Name("j", "d"), new Date()));

    testHistory = new ViolationsHistory(testViolations);
    testCrashHistory = new ViolationsHistory(testCrashes);

    testDriver = new Driver(new Name("j", "d"), new Date(1, 1, 1990),
        new License(123, new Name("j", "d"), new Date(1, 1, 1990), new Date(1, 1, 2020),
            new Date(1, 1, 2000), new Address("WA", "US"), new Address("OR", "US")), testHistory);

    testVehicle = new Vehicle("123", 1995, new Name("j", "d"),
        new Insurance(new Name("j", "d"), new Date(2020), testDriversList), testHistory,
        testCrashHistory);

    test = new Application(testDriver, testVehicle);
    test2 = new Application(testDriver, testVehicle);
  }

  @Test
  public void getDriver() {
    Assert.assertEquals(testDriver, test.getDriver());
  }

  @Test
  public void getVehicle() {
    Assert.assertEquals(testVehicle, test.getVehicle());
  }

  @Test
  public void equals() {
    AbstractDriver driver2 = new Driver(new Name("j", "d"), new Date(1, 1, 1990),
        new License(1234, new Name("j", "d"), new Date(1, 1, 1990), new Date(1, 1, 2020),
            new Date(1, 1, 2000), new Address("WA", "US"), new Address("OR", "US")), testHistory);

    AbstractVehicle vehicle2 = testVehicle = new Vehicle("123abc", 1995, new Name("j", "d"),
        new Insurance(new Name("j", "d"), new Date(2020), testDriversList), testHistory,
        testCrashHistory);

    assertTrue(test.equals(test));
    assertTrue(test.equals(test2));
    assertFalse(test.equals(null));

    assertFalse(test.equals(new Application(testDriver, vehicle2)));
    assertFalse(test.equals(new Application(driver2, testVehicle)));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("j d, 123", test.toString());
  }
}