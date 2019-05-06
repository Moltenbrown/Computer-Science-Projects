package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.Objects;

/**
 * Represents a Substitute Teacher, which extends Abstract Teacher,  with it's details--the number
 * of days the substitute teacher has been in the classroom as an integer.
 *
 * @author Goch
 */
public class SubstituteTeacher extends AbstractTeacher {
  private int numberDaysInClassroom;

  /**
   * Creates a new substitute teacher, using the abstract teacher constructor, a name, a classroom,
   * a co-teacher, the number of days the substitute teacher's had in the classroom, and the
   * teacher's current vacation status.
   * @param name the name of the substitute teacher.
   * @param classroom the current classroom the substitute teacher is teaching in.
   * @param coTeacher the substitute teacher's co-teacher.
   * @param numberDaysInClassroom the number of days the substitute teacher has been teaching in
   * their classroom.
   * @param teachersVacationStatus the substitute teacher's vacation status.
   */
  public SubstituteTeacher(Person name, String classroom, Person coTeacher,
      int numberDaysInClassroom, Boolean teachersVacationStatus){

      super(name, classroom, coTeacher, teachersVacationStatus);
      this.numberDaysInClassroom = numberDaysInClassroom;
  }


  /**
   * Returns the number of days the substitute teacher has been subbing in their classroom.
   * @return the number of days the substitute teacher has been subbing in their classroom.
   */
  public int getNumberDaysinClassroom() {
    return numberDaysInClassroom;
  }

  @Override
  public boolean requestVacationStatus(AbstractTeacher abstractTeacher)
      throws IllegalArgumentException {
    return super.requestVacationStatus(abstractTeacher);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SubstituteTeacher)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    SubstituteTeacher that = (SubstituteTeacher) o;
    return numberDaysInClassroom == that.numberDaysInClassroom;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), numberDaysInClassroom);
  }

  @Override
  public String toString() {
    return name + " has been in " + classroom + " for " + numberDaysInClassroom +
        " days.";
  }
}
