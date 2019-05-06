package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * This interface contains all methods that all types of Teachers should support.
 *
 * @author Goch
 */
public interface Teacher {

  /**
   * Returns the name of a teacher.
   * @return the name of a teacher
   */
  Person getName();

  /**
   * Returns the classroom associated with a teacher.
   * @return the teacher's classroom.
   */
  String getClassroom();

  /**
   * Returns the co-teacher associated with a teacher.
   * @return the co-teacher.
   */
  Person getCoTeacher();

  /**
   * Returns whether or not the teacher is on vacation. If the status is true, the teacher is on
   * vacation, otherwise, the teacher is not on vacation.
   * @return the teacher's vacation status.
   */
  Boolean getTeachersVacationStatus();



}
