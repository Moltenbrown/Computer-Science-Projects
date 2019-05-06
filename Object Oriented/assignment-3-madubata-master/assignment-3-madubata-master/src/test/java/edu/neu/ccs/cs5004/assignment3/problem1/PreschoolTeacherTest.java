package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PreschoolTeacherTest {

  Person samson;
  Person samuel;
  PreschoolTeacher samsonTeacher;

  @Before
  public void setUp() throws Exception {
    this.samson = new Person("Samson", "Smith");
    this.samuel = new Person("Samuel", "Carriage");
    this.samsonTeacher = new PreschoolTeacher(samson, "Room 245", samuel,
        7, 3, 20, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() throws Exception{
    PreschoolTeacher samuelTeacher;
    samuelTeacher = new PreschoolTeacher(samuel, "Room 234", samson, 15,
        3, 4,  false);
  }

  @Test
  public void getCurrentNoOfReaders() {
    Assert.assertEquals(3, samsonTeacher.getCurrentNoOfReaders());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("There are currently 3 readers in this classroom.",
        samsonTeacher.toString());
  }
}