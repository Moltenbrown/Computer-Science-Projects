package edu.neu.ccs.cs5004.Problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConferencePaperTest {
  String title;
  Person author;
  Integer year;
  String month;
  String location;
  String conferenceName;
  ConferencePaper conferencePaper;

  @Before
  public void setUp() throws Exception {
    this.title = "Determining whether EST-PCR tags can be used for genetic testing";
    this.author = new Person("Jack", "Malley");
    this.year = new Integer(2005);
    this.month = "Oct";
    this.location = "Riverdale, USA";
    this.conferenceName = "USDA Poster Day";
    this.conferencePaper = new ConferencePaper(title, author, conferenceName, location, month,
        year);
  }

  @Test
  public void getConferenceName() {
    Assert.assertEquals(conferenceName, conferencePaper.getConferenceName());
  }

  @Test
  public void getLocation() {
    Assert.assertEquals(location, conferencePaper.getLocation());
  }

  @Test
  public void getMonth() {
    Assert.assertEquals(month, conferencePaper.getMonth());
  }

  @Test
  public void equals() throws Exception {
    Assert.assertTrue(conferencePaper.equals(new ConferencePaper(title, author, conferenceName,
        location, month, year)));
    Assert.assertFalse(conferencePaper.equals(new ConferencePaper(title, author, conferenceName, location, month,
        new Integer(1967))));
    Assert.assertFalse(conferencePaper.equals(year));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertEquals(conferencePaper.hashCode(), new ConferencePaper(title, author, conferenceName, location, month,
        year).hashCode());
    Assert.assertNotEquals(conferencePaper.hashCode(), new ConferencePaper(title, author, conferenceName, location, month,
        new Integer(1967)).hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("USDA Poster Day, Riverdale, USA, Oct 2005, Determining whether "
        + "EST-PCR tags can be used for genetic testing", conferencePaper.toString());
  }
}