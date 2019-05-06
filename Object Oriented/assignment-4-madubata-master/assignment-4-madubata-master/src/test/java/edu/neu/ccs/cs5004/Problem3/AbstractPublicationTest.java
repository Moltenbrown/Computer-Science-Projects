package edu.neu.ccs.cs5004.Problem3;

import static org.junit.Assert.*;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractPublicationTest {
  String title;
  Person author;
  Integer year;
  AbstractPublication publication;

  @Before
  public void setUp() throws Exception {
    this.title = "Scientific American";
    this.author = new Person("Jack", "Malley");
    this.year = new Integer(2005);
    publication = new AbstractPublication(title, author, year);
  }

  @Test
  public void getTitle() {
    Assert.assertEquals(title, publication.getTitle());
  }

  @Test
  public void getAuthor() {
    Assert.assertEquals(author, publication.getAuthor());
  }

  @Test
  public void getYear() {
    Assert.assertEquals(year, publication.getYear());
  }

  @Test(expected = InvalidYearException.class)
  public void InvalidYearExceptionTest() throws Exception {
    AbstractPublication daisy = new AbstractPublication(title, author, new Integer(123));
    AbstractPublication daisy2 = new AbstractPublication(title, author, new Integer(12345));
  }

  @Test
  public void equals() throws Exception{
    Assert.assertTrue(publication.equals(new AbstractPublication(title, author, year)));
    Assert.assertFalse(publication.equals(new AbstractPublication(title, author,
        new Integer(1234))));
    Assert.assertFalse(publication.equals(title));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertEquals(publication.hashCode(),
        new AbstractPublication(title, author, year).hashCode());
    Assert.assertNotEquals(publication.hashCode(),
        new AbstractPublication(title, author,
            new Integer(1234)).hashCode());
    Assert.assertNotEquals(publication.hashCode(), title.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Scientific American Jack Malley 2005",
        publication.toString());
  }
}