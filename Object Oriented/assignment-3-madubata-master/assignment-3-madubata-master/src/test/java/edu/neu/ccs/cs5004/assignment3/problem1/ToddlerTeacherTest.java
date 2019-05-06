package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToddlerTeacherTest {
  Person marty;
  Person carol;
  ToddlerTeacher carolTeacher;


  @Before
  public void setUp() throws Exception {
    this.marty = new Person("Martin", "Anthropomorphic");
    this.carol = new Person("Carol", "Manson");
    this.carolTeacher = new ToddlerTeacher(carol, "Room 234", marty, 7,
        3, 4, 14, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() throws Exception{
    ToddlerTeacher martyTeacher;
    martyTeacher = new ToddlerTeacher(marty, "Room 234", carol, 15,
        3, 4, 7, false);
  }

  @Test
  public void getCurrentNoOfChildren(){
    Assert.assertEquals(7, carolTeacher.getCurrentNoOfChildren());
  }

  @Test
  public void getCurrentNoOfDiapers() {
    Assert.assertEquals(3, carolTeacher.getCurrentNoOfDiapers());
  }

  @Test
  public void getCurrentNoOfPottyTrained() {
    Assert.assertEquals(4, carolTeacher.getCurrentNoOfPottyTrained());
  }

  @Test
  public void getMaximumNoOfChildren(){
    Assert.assertEquals(14, carolTeacher.getMaximumNoOfChildren());
  }

  @Test
  public void toStringTest() {
  }
}