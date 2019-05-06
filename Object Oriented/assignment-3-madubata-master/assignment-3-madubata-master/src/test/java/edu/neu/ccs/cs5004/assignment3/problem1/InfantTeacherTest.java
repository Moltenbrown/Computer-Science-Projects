package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InfantTeacherTest {

  Person theresa;
  Person margaret;
  InfantTeacher margaretTeacher;

  @Before
  public void setUp() throws Exception {
    this.theresa = new Person("Theresa", "May");
    this.margaret = new Person("Margaret", "Thatcher");
    this.margaretTeacher = new InfantTeacher(margaret, "Room 234", theresa,
        4, 2, 2, 8,
        true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArgumentException() throws Exception{
    InfantTeacher theresaTeacher;
    theresaTeacher = new InfantTeacher(theresa, "Room 234", margaret, 15,
        3, 4, 9, false);
  }

  @Test
  public void getCurrentNoOfCrawlers() {
    Assert.assertEquals(2, margaretTeacher.getCurrentNoOfCrawlers());
  }

  @Test
  public void getCurrentNoOfWalkers() {
    Assert.assertEquals(2, margaretTeacher.getCurrentNoOfWalkers());
  }


  @Test
  public void toStringTest() {
    Assert.assertEquals("Currently, there are 2 crawlers and, 2 walkers in this "
        + "classroom.", margaretTeacher.toString());
  }
}