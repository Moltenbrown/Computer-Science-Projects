package edu.neu.ccs.cs5004.Problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
  String firstName;
  String lastName;
  Person sam;

  @Before
  public void setUp() throws Exception {
    this.firstName = "Samuel";
    this.lastName = "Malley";
    this.sam = new Person(firstName, lastName);
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals(firstName, sam.getFirstName());
  }

  @Test
  public void getLastName() {
    Assert.assertEquals(lastName, sam.getLastName());
  }

  @Test
  public void equals() {
    Assert.assertTrue(sam.equals(new Person(firstName, lastName)));
    Assert.assertFalse(sam.equals(new Person("Jack", "Malley")));
    Assert.assertFalse(sam.equals(firstName));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(new Person(firstName, lastName).hashCode(),
        sam.hashCode());
    Assert.assertNotEquals(new Person("Jack", "Malley").hashCode(),
        sam.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Samuel Malley", sam.toString());
  }
}