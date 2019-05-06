package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubstituteTeacherTest {
  Person maxwell;
  SubstituteTeacher maxwellTeacher;
  Person timmy;
  InfantTeacher timmyTeacher;
  @Before
  public void setUp() throws Exception {
    this.maxwell = new Person("Maxwell", "Santos");
    this.timmy = new Person("Timothy", "Granger");
    this.maxwellTeacher = new SubstituteTeacher(maxwell, "Room 212", timmy,
        20, true);
    this.timmyTeacher = new InfantTeacher(timmy, "Room 212", maxwell, 3,
        1, 2, 8, false);
  }

  @Test
  public void getName(){
    Assert.assertEquals(maxwell, maxwellTeacher.getName());
  }

  @Test
  public void getClassroom(){
    Assert.assertEquals("Room 212", maxwellTeacher.getClassroom());
  }

  @Test
  public void getCoTeacher(){
    Assert.assertEquals(timmy, maxwellTeacher.getCoTeacher());
  }

  @Test
  public void getTeachersVacationStatus(){
    Assert.assertEquals(true, maxwellTeacher.getTeachersVacationStatus());
  }

  @Test
  public void getNumberDaysinClassroom() {
    Assert.assertEquals(20, maxwellTeacher.getNumberDaysinClassroom());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Maxwell Santos has been in Room 212 for 20 days.",
        maxwellTeacher.toString());
  }

  @Test
  public void requestVacationStatus(){
    Assert.assertEquals(false, timmyTeacher.requestVacationStatus(maxwellTeacher));
  }
}