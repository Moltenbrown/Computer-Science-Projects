package edu.neu.ccs.cs5004.Problem2;

import static edu.neu.ccs.cs5004.Problem2.CrashType.INJURY;
import static edu.neu.ccs.cs5004.Problem2.MovingViolationsType.DUI;
import static edu.neu.ccs.cs5004.Problem2.MovingViolationsType.SIGNS;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RideSharingSystemTest {

  private RideSharingSystem test;
  private RideSharingSystem test2;

  private Application testApplication;
  private Application testApplication2;

  private AbstractVehicle testVehicle;
  private AbstractDriver testDriver;
  private AbstractDriver testDriver2;
  private LinkedList<AbstractViolations> testViolations;
  private LinkedList<AbstractViolations> testViolationsBad;
  private LinkedList<AbstractViolations> testCrashes;
  private LinkedList<AbstractDriver> testDriversList;
  private ViolationsHistory testHistory;
  private ViolationsHistory testHistoryBad;
  private ViolationsHistory testCrashHistory;

  @Before
  public void setUp() throws Exception {

    testViolations = new LinkedList<>();
    testViolationsBad = new LinkedList<>();
    testCrashes = new LinkedList<>();
    testDriversList = new LinkedList<>();

    testViolations.add(
        new NonMovingViolation(NonMovingViolationsType.PARKING, new Name("j", "d"),
            new Date(100, 1, 1)));
    testViolations.add(new MovingViolation(SIGNS, new Name("j", "d"), new Date(100, 1, 1)));
    testCrashes.add(new Crash(INJURY, new Name("j", "d"), new Date(102, 1, 1)));

    testViolationsBad.add(
        new MovingViolation(MovingViolationsType.DUI, new Name("j", "d"), new Date(118, 3, 1)));

    testHistory = new ViolationsHistory(testViolations);
    testCrashHistory = new ViolationsHistory(testCrashes);
    testHistoryBad = new ViolationsHistory(testViolations);

    testDriver = new Driver(new Name("j", "d"), new Date(90, 1, 1),
        new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(120, 1, 1),
            new Date(95, 1, 1), new Address("WA", "US"), new Address("OR", "US")), testHistory);
    testDriver2 = new Driver(new Name("jjjj", "dd"), new Date(90, 1, 1),
        new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(120, 1, 1),
            new Date(95, 1, 1), new Address("WA", "US"), new Address("OR", "US")), testHistory);

    testDriversList.add(testDriver2);

    testVehicle = new Vehicle("123", 1995, new Name("j", "d"),
        new Insurance(new Name("j", "d"), new Date(120, 1, 1), testDriversList), testHistory,
        testCrashHistory);

    testApplication = new Application(testDriver, testVehicle);
    testApplication2 = new Application(testDriver2, testVehicle);

    test = new RideSharingSystem();
    test.registeredDrivers.add(testApplication);
    test2 = new RideSharingSystem();
    test2.registeredDrivers.add(testApplication);
  }

  @Test
  public void registerDriver() {
    Assert.assertEquals("Your application was accepted. Welcome!",
        test.registerDriver(testDriver, testVehicle));
    test.registerDriver(testDriver, testVehicle);
    Assert.assertEquals("Driver already accepted.",
        test.registerDriver(testDriver, testVehicle));
    //changing driver
    Assert.assertEquals("Your application was denied.",
        test.registerDriver(new Driver(new Name("jj", "d"), new Date(90, 1, 1),
            new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(121, 1, 1),
                new Date(95, 1, 1), new Address("WA", "US"), new Address("OR", "US")),
            testHistory), testVehicle));
    Assert.assertEquals("Your application was denied.",
        test.registerDriver(new Driver(new Name("jj", "d"), new Date(91, 1, 1),
            new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(121, 1, 1),
                new Date(95, 1, 1), new Address("WA", "US"), new Address("OR", "US")),
            testHistory), testVehicle));
    Assert.assertEquals("Your application was denied.",
        test.registerDriver(new Driver(new Name("jj", "d"), new Date(90, 1, 1),
            new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(121, 1, 1),
                new Date(108, 3, 1), new Address("WA", "US"), new Address("OR", "US")),
            testHistory), testVehicle));
    Assert.assertEquals("Your application was denied.",
        test.registerDriver(new Driver(new Name("j", "d"), new Date(110, 1, 1),
            new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(121, 1, 1),
                new Date(95, 1, 1), new Address("WA", "US"), new Address("OR", "US")),
            testHistory), testVehicle));
    Assert.assertEquals("Your application was denied.",
        test.registerDriver(new Driver(new Name("j", "d"), new Date(90, 1, 1),
            new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(91, 1, 1),
                new Date(95, 1, 1), new Address("WA", "US"), new Address("OR", "US")),
            testHistory), testVehicle));
    Assert.assertEquals("Your application was denied.",
        test.registerDriver(new Driver(new Name("j", "d"), new Date(90, 1, 1),
            new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(121, 1, 1),
                new Date(95, 1, 1), new Address("WA", "U"), new Address("OR", "U")),
            testHistory), testVehicle));
    Assert.assertEquals("Your application was denied.",
        test.registerDriver(new Driver(new Name("j", "d"), new Date(90, 1, 1),
            new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(121, 1, 1),
                new Date(95, 1, 1), new Address("WA", "US"), new Address("OR", "US")),
            new ViolationsHistory(testViolationsBad)), testVehicle));

    //changing vehicle
    Assert.assertEquals("Driver already accepted.",
        test.registerDriver(testDriver, testVehicle));

//    Assert.assertEquals("Your application was denied.",
//        test.registerDriver(testDriver, new Vehicle("123", 1555, new Name("j", "d"),
//            new Insurance(new Name("j", "d"), new Date(120, 1, 1), testDriversList), testHistory,
//            testCrashHistory)));
    Assert.assertEquals("Your application was denied.",
        test.registerDriver(testDriver, new Vehicle("123", 1995, new Name("j", "d"),
            new Insurance(new Name("jv", "d"), new Date(120, 1, 1), testDriversList), testHistory,
            testCrashHistory)));
    Assert.assertEquals("Your application was denied.",
        test.registerDriver(testDriver, new Vehicle("123", 1995, new Name("j", "d"),
            new Insurance(new Name("j", "d"), new Date(20, 1, 1), testDriversList), testHistory,
            testCrashHistory)));
    Assert.assertEquals("Your application was denied.",
        test.registerDriver(testDriver, new Vehicle("123", 1995, new Name("jqwd", "d"),
            new Insurance(new Name("jgrg", "d"), new Date(120, 1, 1), testDriversList), testHistory,
            testCrashHistory)));
    Assert.assertEquals("Driver already accepted.",
        test.registerDriver(testDriver, new Vehicle("123", 1995, new Name("j", "d"),
            new Insurance(new Name("j", "d"), new Date(120, 1, 1), testDriversList), testHistoryBad,
            testCrashHistory)));

    testViolationsBad = new LinkedList<>();
    testViolationsBad.add(
        new MovingViolation(MovingViolationsType.INVALIDLICENSE, new Name("j", "d"),
            new Date(108, 3, 1)));

    Assert.assertEquals("Your application was denied.",
        test.registerDriver(new Driver(new Name("j", "d"), new Date(90, 1, 1),
            new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(121, 1, 1),
                new Date(95, 1, 1), new Address("WA", "US"), new Address("OR", "US")),
            new ViolationsHistory(testViolationsBad)), testVehicle));

    testViolationsBad = new LinkedList<>();
    testViolationsBad.add(
        new MovingViolation(MovingViolationsType.SPEEDING, new Name("j", "d"),
            new Date(108, 3, 1)));

    Assert.assertEquals("Your application was denied.",
        test.registerDriver(new Driver(new Name("j", "d"), new Date(90, 1, 1),
            new License(123, new Name("j", "d"), new Date(90, 1, 1), new Date(121, 1, 1),
                new Date(95, 1, 1), new Address("WA", "US"), new Address("OR", "US")),
            new ViolationsHistory(testViolationsBad)), testVehicle));

  }

  @Test
  public void equals() {
    assertTrue(test.equals(test));
    assertTrue(test.equals(test2));
    assertFalse(test.equals(null));

    assertFalse(test.equals((new RideSharingSystem()).registeredDrivers.add(testApplication2)));
    assertFalse(test.equals((new RideSharingSystem()).acceptedDrivers.add(testApplication2)));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Welcome to the Ride Sharing system!", test.toString());
  }
}