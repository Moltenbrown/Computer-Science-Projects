package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateTest {
  String month;
  Integer year;
  Integer year2;
  Integer year3;
  Date date;

  @Before
  public void setUp() throws Exception {
    this.month = "December";
    this.year = new Integer(1996);
    this.year2 = new Integer(123);
    this.date = new Date(month, year);
    this.year3 = new Integer(12384);
  }

  @Test
  public void getMonth() {
    Assert.assertEquals("December", date.getMonth());
  }

  @Test
  public void getYear() {
    Assert.assertEquals(new Integer(1996), date.getYear());
  }

  @Test(expected = InaccurateDateException.class)
  public void testInaccurateDateException() throws Exception {
    Date date2 = new Date(month, year2);
    Date date3 = new Date(month, year3);
  }

  @Test
  public void equals() throws Exception{
    Assert.assertTrue(date.equals(new Date(month, year)));
    Assert.assertFalse(date.equals(new Date (month, new Integer(1997))));
    Assert.assertFalse(date.equals(month));
  }

  @Test
  public void hashCodeTest() throws Exception{
    Assert.assertEquals(date.hashCode(), new Date(month, year).hashCode());
    Assert.assertNotEquals(date.hashCode(), month.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("The vehicle's date is December 1996.", date.toString());
  }
}