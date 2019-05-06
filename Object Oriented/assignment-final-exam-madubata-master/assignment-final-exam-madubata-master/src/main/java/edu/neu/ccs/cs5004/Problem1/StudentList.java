package edu.neu.ccs.cs5004.Problem1;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StudentList {
  private List<Student> students = new ArrayList<>();

  public StudentList(List<Student> students) { this.students = students;
  }

  public StudentList(Student student1, Student student2, Student student3){ this.students.add(student1);
    this.students.add(student2);
    this.students.add(student3);
  }

  Comparator<Student> compareByLastName = new Comparator<Student>() {

    @Override
    public int compare(Student o1, Student o2) {
     return o1.getLastname().compareTo(o2.getLastname()); } };

  /**
   * sortStudents first sorts the students in StudentList by their last name alphabetically,
   * from A to Z. Then it takes the sorted StudentList and returns a list of student last names.
   * @return a list of student last names.
   */
  public List<String> sortStudents(){
    this.students.sort(compareByLastName);
    return this.students.stream().map(Student::getLastname).collect(Collectors.toList());
  }

}
