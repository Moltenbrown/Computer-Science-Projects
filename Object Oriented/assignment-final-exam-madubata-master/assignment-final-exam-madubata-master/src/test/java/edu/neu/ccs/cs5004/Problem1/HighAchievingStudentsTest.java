package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HighAchievingStudentsTest {
  Student student1;
  Student student2;
  Student student3;
  List<Student> studentList;
  HighAchievingStudents highAchievingStudents;

  @Before
  public void setUp() throws Exception {
    student3 = new Student("Sam", "Garfield", "001", new Float(4.0),
        new Float(2.5), new Float(3.8));
    student1 = new Student("Patrick", "Smith", "002", new Float(2.6),
        new Float(3.8), new Float(4.0));
    student2 = new Student("Rod", "Stewart", "003", new Float(3.9),
        new Float(2.0), new Float(3.7));
    studentList = new ArrayList<Student>();
    studentList.add(student1);
    studentList.add(student2);
    studentList.add(student3);
    highAchievingStudents = new HighAchievingStudents(studentList);
  }

  @Test
  public void filterHighAchievingStudents() {
    List<String> test = new ArrayList<>();
    test.add("Sam Garfield");
    Assert.assertEquals(test, highAchievingStudents.filterHighAchievingStudents());
//    Student student = new Student("Michelle", "Hammerstein", "004", new Float(3.8),
//        new Float(4.0), new Float(4.0));
//    Student student1 = new Student("Micheal", "Phelps", "005", new Float(3.75),
//        new Float(2.0), new Float(3.95));



  }
}