package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.Objects;

/**
 * Represents a Preschool Teacher, which extends Abstract Teacher,  with it's details--the current
 * number of children, the current number of readers, and the maximum number of children as
 * integers.
 *
 * @author Goch
 */

public class PreschoolTeacher extends AbstractTeacher {
  private int currentNoOfChildren;
  private int currentNoOfReaders;
  private int maximumNoOfChildren;

  /**
   * Creates a new preschool teacher, using the abstract teacher constructor, a name and a coteacher,
   * a classroom, a current number of children, a current number of readers, a maximum number of
   * children, and a teacher's vacation status. It throws an illegal argument exception when the
   * current number of children is greater than 20, the amount of children a classroom can handle
   * when each teacher can at most handle 10 children and there are two teachers in most rooms, or
   * if the maximum number of children is higher than 20.
   *
   * @param name the name of the teacher.
   * @param classroom the classroom the teacher is assigned to.
   * @param coTeacher the co-teacher who works with the teacher in this classroom.
   * @param currentNoOfChildren the current number of children in the class.
   * @param currentNoOfReaders the current number of children who can read in the class.
   * @param maximumNoOfChildren the maximum number of children who can be in the classroom.
   * @param teachersVacationStatus whether or not the teacher is on vacation.
   * @throws IllegalArgumentException this occurs when either, the current number of children is
   * higher than 20 or the maximum number of children is not 20.
   */
  public PreschoolTeacher(Person name, String classroom, Person coTeacher, int currentNoOfChildren,
      int currentNoOfReaders, int maximumNoOfChildren, Boolean teachersVacationStatus) throws
      IllegalArgumentException {
    super(name, classroom, coTeacher, teachersVacationStatus);
    final int maximumPreschool = 20;
    this.currentNoOfChildren = currentNoOfChildren;

    if(this.currentNoOfChildren > maximumPreschool) {
      throw new IllegalArgumentException ("There are too many children in this classroom.");

    }

    this.currentNoOfReaders = currentNoOfReaders;

    this.maximumNoOfChildren = maximumNoOfChildren;

    if(this.maximumNoOfChildren != maximumPreschool){
      throw new IllegalArgumentException("This number is not what the maximum amount should be.");
    }

  }

  /**
   * Returns the current number of children in the classroom.
   * @return the current number of children in the classroom.
   */
  public int getCurrentNoOfChildren(){
    return this.currentNoOfChildren;
  }

  /**
   * Returns the current number of readers in the classroom.
   * @return the current number of readers in the classroom.
   */
  public int getCurrentNoOfReaders(){
    return this.currentNoOfReaders;
  }

  /**
   * Returns the maximum number of children in the classroom.
   * @return the maximum number of children in the classroom.
   */
  public int getMaximumNoOfChildren(){
    return this.maximumNoOfChildren;
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
    if (!(o instanceof PreschoolTeacher)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    PreschoolTeacher that = (PreschoolTeacher) o;
    return currentNoOfChildren == that.currentNoOfChildren &&
        currentNoOfReaders == that.currentNoOfReaders &&
        maximumNoOfChildren == that.maximumNoOfChildren;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), currentNoOfReaders);
  }

  @Override
  public String toString() {
    return "There are currently " + currentNoOfReaders +
        " readers in this classroom.";
  }
}
