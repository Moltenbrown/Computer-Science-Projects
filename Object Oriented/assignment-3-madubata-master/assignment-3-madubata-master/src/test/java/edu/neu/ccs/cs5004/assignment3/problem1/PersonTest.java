package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
  Person samson;

  @Before
  public void setUp() throws Exception {
    this.samson = new Person("Samson", "Carthidge");
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("Samson", samson.getFirstName());

  }

  @Test
  public void getLastName() {
    Assert.assertEquals("Carthidge", samson.getLastName());
  }

  @Test
  public void toStringTest(){
    Assert.assertEquals("Samson Carthidge", samson.toString());
  }
}