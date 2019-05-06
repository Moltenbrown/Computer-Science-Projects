package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentListTest {
  Student student1;
  Student student2;
  Student student3;
  StudentList studentList;

  @Before
  public void setUp() throws Exception {
    student3 = new Student("Sam", "Garfield", "001", new Float(4.0),
        new Float(2.5), new Float(3.8));
    student1 = new Student("Patrick", "Smith", "002", new Float(2.6),
        new Float(3.8), new Float(4.0));
    student2 = new Student("Rod", "Stewart", "003", new Float(3.9),
        new Float(2.0), new Float(3.7));
    studentList = new StudentList(student1, student2, student3);
  }

  @Test
  public void sortStudents() {
    Assert.assertEquals("Garfield", studentList.sortStudents().get(0));
    Assert.assertEquals("Smith", studentList.sortStudents().get(1));
    Assert.assertEquals("Stewart", studentList.sortStudents().get(2));
  }
}