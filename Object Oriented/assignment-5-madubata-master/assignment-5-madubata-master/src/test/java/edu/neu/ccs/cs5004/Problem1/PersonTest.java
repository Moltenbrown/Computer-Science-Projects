package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
  String firstName;
  String lastName;
  Person person;
  Person person2;

  @Before
  public void setUp() throws Exception {
    this.firstName = "Samuel";
    this.lastName = "Matthews";
    this.person = new Person(firstName, lastName);
    this.person2 = new Person("George", "Lucas");
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("Samuel", person.getFirstName());
  }

  @Test
  public void getLastName() {
    Assert.assertEquals("Matthews", person.getLastName());
  }

  @Test
  public void equals() {
    Assert.assertTrue(person.equals(new Person("Samuel", "Matthews")));
    Assert.assertFalse(person.equals(person2));
    Assert.assertFalse(person.equals(firstName));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(new Person("Samuel", "Matthews").hashCode(),
        person.hashCode());
    Assert.assertNotEquals(person.hashCode(), person2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Samuel Matthews", person.toString());
  }
}