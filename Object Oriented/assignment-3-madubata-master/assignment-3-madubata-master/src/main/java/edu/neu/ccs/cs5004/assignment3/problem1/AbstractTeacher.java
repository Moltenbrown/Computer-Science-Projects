package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.Objects;

/**
 * Represents a Abstract Teacher with it's details--the name and a co-teacher as an Person
 * , the classroom as a String, and the teacher's vacation status as a boolean.
 *
 * @author Goch
 */
public abstract class AbstractTeacher implements Teacher {

  protected Person name;
  protected String classroom;
  protected Person coTeacher;
  protected Boolean teachersVacationStatus;

  /**
   * Creates an abstract teacher from the teacher's name, their classroom, their co-teacher,
   * and the teacher's vacation status.
   * @param name the teacher's name
   * @param classroom the teacher's classroom
   * @param coTeacher the teacher's co-teacher for that classroom
   * @param teachersVacationStatus whether or not the teacher is on vacation
   */
  public AbstractTeacher(Person name, String classroom, Person coTeacher,
      Boolean teachersVacationStatus){
    this.name = name;
    this.classroom = classroom;
    this.coTeacher = coTeacher;
    this.teachersVacationStatus = teachersVacationStatus;

  }

  /**
   * Returns the teacher's name
   * @return the teacher's name
   */
  public Person getName() {
    return name;
  }

  /**
   * Returns the teacher's classroom
   * @return the teacher's classroom
   */
  public String getClassroom() {
    return classroom;
  }

  /**
   * Returns the teacher's co-teacher
   * @return the teacher's co-teacher
   */
  public Person getCoTeacher() {
    return coTeacher;
  }


  /**
   * Returns the teacher's vacation status
   * @return the teacher's vacation status
   */
  public Boolean getTeachersVacationStatus() {
    return teachersVacationStatus;
  }

  /**
   * Returns whether or not the teacher can take vacation. If the method returns true, the teacher
   * can take vacation. If the method returns false, the teacher cannot take vacation.
   * @param abstractTeacher the co-teacher you are checking to see whether is currently on vacation.
   * @return whether or not the requesting teacher can take vacation.
   * @throws IllegalArgumentException if the user enters the wrong co-teacher.
   */
  public boolean requestVacationStatus(AbstractTeacher abstractTeacher) throws
      IllegalArgumentException{
    if(this.coTeacher.equals(abstractTeacher.getName())){
      if(abstractTeacher.getTeachersVacationStatus().equals(true)){
        return false;
      }

      else{
        return true;
      }
    }

    else{
      throw new IllegalArgumentException("The teacher entered is not the teacher's co-teacher."
          + "Please enter the proper co-teacher.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractTeacher)) {
      return false;
    }
    AbstractTeacher that = (AbstractTeacher) o;
    return
        Objects.equals(teachersVacationStatus, that.teachersVacationStatus) &&
        Objects.equals(name, that.name) &&
        Objects.equals(classroom, that.classroom) &&
        Objects.equals(coTeacher, that.coTeacher);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, classroom, coTeacher, teachersVacationStatus);
  }

  @Override
  public String toString() {
    return name +
        "is the teacher of classroom" + classroom + ". Their coTeacher is" + coTeacher +
        ". Their current vacation status is " + teachersVacationStatus +
        '.';
  }
}
