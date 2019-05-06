package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DayCareCenterTest {
  Person theresa;
  Person margaret;
  Person samson;
  Person samuel;
  Person maxwell;
  Person timmy;
  Person marty;
  Person carol;
  ToddlerTeacher carolTeacher;
  SubstituteTeacher maxwellTeacher;
  PreschoolTeacher samsonTeacher;
  InfantTeacher margaretTeacher;
  DayCareCenter dayCareCenter = new DayCareCenter();

  @Before
  public void setUp() throws Exception {
    this.marty = new Person("Martin", "Anthropomorphic");
    this.carol = new Person("Carol", "Manson");
    this.maxwell = new Person("Maxwell", "Santos");
    this.timmy = new Person("Timothy", "Granger");
    this.samson = new Person("Samson", "Smith");
    this.samuel = new Person("Samuel", "Carriage");
    this.theresa = new Person("Theresa", "May");
    this.margaret = new Person("Margaret", "Thatcher");
    this.margaretTeacher = new InfantTeacher(margaret, "Room 234", theresa,
        4, 2, 2, 8,
        true);
    this.samsonTeacher = new PreschoolTeacher(samson, "Room 245", samuel,
        7, 3, 20, false);
    this.maxwellTeacher = new SubstituteTeacher(maxwell, "Room 212", timmy,
        20, true);
    this.carolTeacher = new ToddlerTeacher(carol, "Room 234", marty, 7,
        3, 4, 14, false);
  }

  @Test
  public void addToSubstituteTeachersList() {
    dayCareCenter.addToSubstituteTeachersList(maxwellTeacher);
    Assert.assertEquals(maxwellTeacher, dayCareCenter.getSubstituteTeachersList().get(0));
  }

  @Test
  public void addToInfantTeachersList() {
    dayCareCenter.addToInfantTeachersList(margaretTeacher);
    Assert.assertEquals(margaretTeacher, dayCareCenter.getInfantTeacherList().get(0));
  }

  @Test
  public void addToToddlerTeachersList() {
    dayCareCenter.addToToddlerTeachersList(carolTeacher);
    Assert.assertEquals(carolTeacher, dayCareCenter.getToddlerTeachersList().get(0));
  }

  @Test
  public void addToPreschoolTeacherList() {
    dayCareCenter.addToPreschoolTeacherList(samsonTeacher);
    Assert.assertEquals(samsonTeacher, dayCareCenter.getPreschoolTeacherList().get(0));
  }

  @Test
  public void getSubstituteTeachersList() {
    dayCareCenter.addToSubstituteTeachersList(maxwellTeacher);
    Assert.assertEquals(maxwellTeacher,
        dayCareCenter.getSubstituteTeachersList().get(0));
  }

  @Test
  public void getInfantTeacherList() {
    dayCareCenter.addToInfantTeachersList(margaretTeacher);
    Assert.assertEquals(margaretTeacher,
        dayCareCenter.getInfantTeacherList().get(0));
  }

  @Test
  public void getToddlerTeachersList() {
    dayCareCenter.addToToddlerTeachersList(carolTeacher);
    Assert.assertEquals(carolTeacher,
        dayCareCenter.getToddlerTeachersList().get(0));
  }

  @Test
  public void getPreschoolTeacherList() {
    dayCareCenter.addToPreschoolTeacherList(samsonTeacher);
    Assert.assertEquals(samsonTeacher,
        dayCareCenter.getPreschoolTeacherList().get(0));
  }

  @Test
  public void convertSubstituteTeacher() {
    Assert.assertEquals(new InfantTeacher(maxwellTeacher.getName(),
        margaretTeacher.getClassroom(), margaretTeacher.getName(),
        margaretTeacher.getCurrentNoOfChildren(), margaretTeacher.getCurrentNoOfCrawlers(),
        margaretTeacher.getCurrentNoOfWalkers(), margaretTeacher.getMaximumNoOfChildren(),
        maxwellTeacher.getTeachersVacationStatus()), dayCareCenter.convertSubstituteTeacher(
            maxwellTeacher, "Infant", margaretTeacher));
  }

  @Test
  public void toStringTest() { //not sure why I have to keep re-adding the names to the lists.
    dayCareCenter.addToSubstituteTeachersList(maxwellTeacher);
    dayCareCenter.addToInfantTeachersList(margaretTeacher);
    dayCareCenter.addToToddlerTeachersList(carolTeacher);
    dayCareCenter.addToPreschoolTeacherList(samsonTeacher);
    Assert.assertEquals("At this day care, these are the substitute teachers [" +
        maxwellTeacher + "], these are the infant teachers [" + margaretTeacher +
        "], these are the toddler teachers [" + carolTeacher + "], and these are the preschool "
        + "teachers [" + samsonTeacher + "].", dayCareCenter.toString());
  }
}