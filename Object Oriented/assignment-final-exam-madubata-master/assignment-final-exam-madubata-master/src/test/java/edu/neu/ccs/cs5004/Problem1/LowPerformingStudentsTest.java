package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LowPerformingStudentsTest {
  Student student1;
  Student student2;
  Student student3;
  List<Student> studentList;
  LowPerformingStudents lowPerformingStudents;

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
    lowPerformingStudents = new LowPerformingStudents(studentList);
  }

  @Test
  public void filterLowPerformingStudents() {
   lowPerformingStudents.filterLowPerformingStudents();
   System.out.println("Patrick Smith\nRod Stewart\nSam Garfield");
  }
}