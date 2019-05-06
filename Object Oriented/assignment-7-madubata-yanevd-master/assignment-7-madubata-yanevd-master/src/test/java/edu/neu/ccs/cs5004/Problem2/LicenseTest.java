package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LicenseTest {

  private License test;
  private License test2;
  private Name testName;
  private Date testDate;
  private Name testName2;
  private Date testDate2;
  private Date testDate3;
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
    testDate3 = new Date(2222, 12, 1);

    test = new License(123, testName, testDate, testDate2, testDate, testAddress, testAddress2);
    test2 = new License(123, testName, testDate, testDate2, testDate, testAddress, testAddress2);
  }

  @Test
  public void getName() {
    Assert.assertEquals(testName, test.getName());
  }

  @Test
  public void getBirthday() {
    Assert.assertEquals(testDate, test.getBirthday());
  }

  @Test
  public void getExpirationDate() {
    Assert.assertEquals(testDate2, test.getExpirationDate());
  }

  @Test
  public void getIssueAddress() {
    Assert.assertEquals(testAddress2, test.getIssueAddress());
  }

  @Test
  public void getIssueDate() {
    Assert.assertEquals(testDate, test.getIssueDate());
  }

  @Test
  public void equalsTest() {
    assertTrue(test.equals(test));
    assertTrue(test.equals(test2));
    assertFalse(test.equals(null));

    assertFalse(test.equals(
        new License(1234, testName, testDate, testDate2, testDate3, testAddress, testAddress2)));
    assertFalse(test.equals(
        new License(123, testName2, testDate, testDate2, testDate3, testAddress, testAddress2)));
    assertFalse(test.equals(
        new License(123, testName, testDate2, testDate2, testDate3, testAddress, testAddress2)));
    assertFalse(test.equals(
        new License(123, testName, testDate, testDate, testDate3, testAddress, testAddress2)));
//    assertFalse(test.equals(
//        new License(123, testName, testDate, testDate2, testDate2, testAddress, testAddress2)));
    assertFalse(test.equals(
        new License(123, testName, testDate, testDate2, testDate, testAddress2, testAddress2)));
    assertFalse(test.equals(
        new License(123, testName, testDate, testDate2, testDate, testAddress, testAddress)));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("123", test.toString());
  }
}