package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;
import java.lang.String;

/**
 * Class Student contains states and behavior relevant for an object Student, used in Problem 1.
 */
public class Student {
  private String firstname;
  private String lastname;
  private String studentID;
  private Float homeworkGrade;
  private Float codewalkGrade;
  private Float examGrade;

  /**
   * Constructor for an object Student, based on the provided input arguments.
   * @param firstname - String, first name
   * @param lastname - String, last name
   * @param studentID - String, student ID
   * @param homeworkGrade - Float, homework grade
   * @param codewalkGrade - Float, codewalk grade
   * @param examGrade - Float, exam grade
   */
  public Student(String firstname, String lastname, String studentID, Float homeworkGrade,
      Float codewalkGrade, Float examGrade) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.studentID = studentID;
    this.homeworkGrade = homeworkGrade;
    this.codewalkGrade = codewalkGrade;
    this.examGrade = examGrade;
  }

  /**
   * Getter for the property ’firstname’
   * @return Value for property ’firstname’
   */
  public String getFirstname() { return firstname;
  }

  /**
   * Getter for the property ’lastname’
   * @return Value for property ’lastname’
   */
  public String getLastname() { return lastname;
  }

  /**
   * Getter for combined properties ’firstname’ and ’lastname’
   * @return Value for combined first and last name
   */
    public String getName() {
      return this.firstname + " " + this.lastname;
    }
   /**
    * Getter for the property ’homeworkGrade’
    * @return Value for property ’homeworkGrade’
    */
   public Float getHomeworkGrade() { return homeworkGrade;
   }

  /**
   * Getter for the property ’examGrade’
   * @return Value for property ’examGrade’
   */
  public Float getExamGrade() { return examGrade;
  }

  /**
   * Getter for the property ’codewalkGrade’
   * @return Value for property ’examGrade’
   */
  public Float getCodewalkGrade() { return codewalkGrade;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false; Student student = (Student) o;
    return Objects.equals(firstname, student.firstname) &&
        Objects.equals(lastname, student.lastname) && Objects.equals(studentID, student.studentID)
        && Objects.equals(homeworkGrade, student.homeworkGrade) && Objects.equals(codewalkGrade,
        student.codewalkGrade) && Objects.equals(examGrade, student.examGrade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, studentID, homeworkGrade,
        codewalkGrade, examGrade);
  }

  @Override
  public String toString() {
    return "Student{" +
        "firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        '}';
  }
}
