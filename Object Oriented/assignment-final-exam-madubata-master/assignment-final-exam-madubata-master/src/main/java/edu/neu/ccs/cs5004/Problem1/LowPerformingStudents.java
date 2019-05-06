package edu.neu.ccs.cs5004.Problem1;

import java.util.List;
import java.util.ArrayList;

public class LowPerformingStudents {
  private List<Student> students = new ArrayList<>();
  public LowPerformingStudents(List<Student> students) { this.students = students;
  }
  public LowPerformingStudents(Student student1, Student student2, Student student3){ this.students.add(student1);
    this.students.add(student2);
    this.students.add(student3);
  }

  /**
   * Prints out the first name and last name of all students who recieved lower than a 3.0 on either
   * their homework grade, their exam grade, or their codewalk grade.
   */
  void filterLowPerformingStudents(){
    List<Student> holder = new ArrayList<Student>();

    for (Student s : students){
      if(s.getHomeworkGrade() < 3.0 || s.getExamGrade() < 3.0 || s.getCodewalkGrade() < 3.0){
        System.out.println(s.getFirstname() + " " + s.getLastname());
      }
    }
  }
}
