package edu.neu.ccs.cs5004.Problem1;

import java.util.List;
import java.util.ArrayList;

public class HighAchievingStudents {
  private List<Student> students = new ArrayList<>();
  public HighAchievingStudents(List<Student> students) { this.students = students;
  }
  public HighAchievingStudents(Student student1, Student student2, Student student3){ this.students.add(student1);
    this.students.add(student2);
    this.students.add(student3);
  }

  /**
   * Returns a list of the names of all students who have homework grades and exam grades that are
   * over a 3.7.
   *
   * @return a list of the first and last names of student who have homework grades and exam grades
   * that are over a 3.7.
   */
  public List<String> filterHighAchievingStudents(){
    List<Student> holder = new ArrayList<Student>();


    for (Student s : students){ // made the mark off point 3.705 because when it was 3.7, the program was including
      //students who were at 3.7, not just the students who were above 3.7
      if(s.getHomeworkGrade() > 3.705 && s.getExamGrade() > 3.705){
        holder.add(s);
      }
    }

    List<String> currentHighAchievers = new ArrayList<String>();
    for (Student s : holder){
      currentHighAchievers.add(s.getFirstname() + " " + s.getLastname());
    }

    return currentHighAchievers;
  }
}
