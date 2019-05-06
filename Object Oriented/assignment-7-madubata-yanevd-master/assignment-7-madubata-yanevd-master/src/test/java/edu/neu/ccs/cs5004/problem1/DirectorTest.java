package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DirectorTest {
  String firstName;
  String lastName;
  Director test;

  @Before
  public void setUp() throws Exception {
    this.firstName = "Michael";
    this.lastName = "Phelps";
    this.test = new Director(firstName, lastName);
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("Michael", test.getFirstName());
  }

  @Test
  public void getLastName() {
    Assert.assertEquals("Phelps", test.getLastName());
  }

  @Test
  public void equals() {
    Assert.assertTrue(test.equals(new Director(firstName, lastName)));
    Assert.assertFalse(test.equals(firstName));
    Assert.assertFalse(test.equals(new Director(firstName, "Samuels")));
    Assert.assertFalse(test.equals(new Director("Samuel", lastName)));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), new Director(firstName, lastName).hashCode());
    Assert.assertNotEquals(test.hashCode(), new Director(firstName, "Samuels").hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("AbstractPerson{firstName='Michael', lastName='Phelps'}", test.toString());
  }
}