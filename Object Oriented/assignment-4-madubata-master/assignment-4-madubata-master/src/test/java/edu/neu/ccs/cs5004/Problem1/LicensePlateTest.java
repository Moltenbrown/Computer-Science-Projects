package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LicensePlateTest {
  String licensePlateNo;
  String state;
  Date registrationDate;
  Date registrationDate2;
  LicensePlate licensePlate;

  @Before
  public void setUp() throws Exception {
    this.licensePlateNo = "162-ZOZ";
    this.state = "Washington";
    this.registrationDate = new Date ("December", new Integer(1992));
    this.registrationDate2 = new Date ("June", new Integer(1993));
    this.licensePlate = new LicensePlate(licensePlateNo, state, registrationDate);
  }

  @Test
  public void getLicensePlateNumber() {
    Assert.assertEquals(licensePlateNo, licensePlate.getLicensePlateNumber());
  }

  @Test
  public void getState() {
    Assert.assertEquals(state, licensePlate.getState());
  }

  @Test
  public void getDate() {
    Assert.assertEquals(registrationDate, licensePlate.getDate());
  }

  @Test
  public void equals() {
    Assert.assertTrue(licensePlate.equals(new LicensePlate(licensePlateNo, state,
        registrationDate)));
    Assert.assertFalse(licensePlate.equals(new LicensePlate(licensePlateNo, state,
        registrationDate2)));
    Assert.assertFalse(licensePlate.equals(licensePlateNo));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(licensePlate.hashCode(), new LicensePlate(licensePlateNo, state,
        registrationDate).hashCode());
    Assert.assertNotEquals(licensePlate.hashCode(), new LicensePlate(licensePlateNo, state,
        registrationDate2));
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("The vehicle's license plate number is 162-ZOZ. The vehicle was "
        + "registered in Washington and the registration will expire on December 1992.",
        licensePlate.toString());
  }
}