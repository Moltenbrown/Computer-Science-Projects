package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrashTest {

  private Crash test;
  private Crash test2;

  private Name testName;
  private Date testDate;
  private Name testName2;
  private Date testDate2;

  private AbstractViolations testAbs;

  @Before
  public void setUp() throws Exception {
    testName = new Name("a", "b");
    testDate = new Date(1980, 1, 1);
    testName2 = new Name("a", "b2");
    testDate2 = new Date(1980, 12, 1);
    test = new Crash(CrashType.FENDER, testName, testDate);
    test2 = new Crash(CrashType.FENDER, testName, testDate);
    testAbs = test;
  }

  @Test
  public void getViolation() {
    Assert.assertEquals(CrashType.FENDER, test.getViolation());
  }

  @Test
  public void getDate() {
    Assert.assertEquals(testDate, test.getDate());
  }

  @Test
  public void equalsTest() {
    assertTrue(test.equals(test));
    assertTrue(testAbs.equals(testAbs));
    assertFalse(testAbs.equals(null));
    assertTrue(test.equals(test2));
    assertFalse(test.equals(null));

    assertFalse(test.equals(new Crash(CrashType.INJURY, testName, testDate)));
    assertFalse(test.equals(new Crash(CrashType.FENDER, testName2, testDate)));
    assertFalse(test.equals(new Crash(CrashType.FENDER, testName, testDate2)));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("FENDER", test.toString());
  }
}