package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.Objects;



/**
 * Represents a Toddler Teacher, which extends Abstract Teacher,  with it's details--the current
 * number of children, the current number of children in diapers, the current number of children
 * who are potty-trained and the maximum number of children as integers.
 *
 * @author Goch
 */
public class ToddlerTeacher extends AbstractTeacher {
  private int currentNoOfChildren;
  private int currentNoOfDiapers;
  private int currentNoOfPottyTrained;
  private int maximumNoOfChildren;

  /**
   * Creates a new toddler teacher, using the abstract teacher constructor, a name, a classroom,
   * a co-teacher, the current number of children in the classroom, the current number of children
   * in diapers, the current number of potty trained children, the maximum number of children,
   * which should be 14, which represents a situation where the teachers can take a maximum of
   * 7 children each and there are 2 teachers in each classroom, and the teacher's vacation
   * status.
   * @param name the name of the teacher
   * @param classroom the classroom the teacher teaches in
   * @param coTeacher the teacher's co-teacher
   * @param currentNoOfChildren the current number of children in the teacher's classroom
   * @param currentNoOfDiapers the current number of children wearing diapers in the teacher's
   * classroom
   * @param currentNoOfPottyTrained the current number of children who are potty trained in the
   * teacher's classroom
   * @param maximumNoOfChildren the maximum number of children who can be in the teacher's classroom
   * @param teachersVacationStatus the teacher's vacation status
   * @throws IllegalArgumentException throws an exception when either the current number if children
   * is higher than 14 or if the maximum number of children isn't 14.
   */
  public ToddlerTeacher(Person name, String classroom, Person coTeacher, int currentNoOfChildren,
      int currentNoOfDiapers, int currentNoOfPottyTrained, int maximumNoOfChildren,
      Boolean teachersVacationStatus) throws IllegalArgumentException{
    super(name, classroom, coTeacher, teachersVacationStatus);
    final int maximumToddler;
    maximumToddler = 14;
    this.currentNoOfChildren = currentNoOfChildren;
    if(this.currentNoOfChildren > maximumToddler) {
      throw new IllegalArgumentException ("There are too many children in this classroom.");

    }

    this.currentNoOfDiapers = currentNoOfDiapers;
    this.currentNoOfPottyTrained = currentNoOfPottyTrained;


    this.maximumNoOfChildren = maximumNoOfChildren;
    if(this.maximumNoOfChildren != maximumToddler){
      throw new IllegalArgumentException("This number is not what the maximum amount should be.");
    }
  }

  /**
   * Returns the current number of children in the teacher's classroom
   * @return the current number of children
   */

  public int getCurrentNoOfChildren() {
    return currentNoOfChildren;
  }

  /**
   * Returns the current number of children in diapers in the teacher's classroom
   * @return the current number of children in diapers
   */
  public int getCurrentNoOfDiapers(){
    return this.currentNoOfDiapers;
  }

  /**
   * Returns the current number of children who are potty trained in the teacher's classroom
   * @return the current number of children who are potty trained
   */
  public int getCurrentNoOfPottyTrained(){
    return this.currentNoOfPottyTrained;
  }

  /**
   * Returns the maximum number of children who can be in the teacher's classroom.
   * @return the maximum number of children who can be in the classroom.
   */

  public int getMaximumNoOfChildren() {
    return maximumNoOfChildren;
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
    if (!(o instanceof ToddlerTeacher)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ToddlerTeacher that = (ToddlerTeacher) o;
    return currentNoOfChildren == that.currentNoOfChildren &&
        currentNoOfDiapers == that.currentNoOfDiapers &&
        currentNoOfPottyTrained == that.currentNoOfPottyTrained &&
        maximumNoOfChildren == that.maximumNoOfChildren;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), currentNoOfChildren, currentNoOfDiapers,
        currentNoOfPottyTrained, maximumNoOfChildren);
  }

  @Override
  public String toString() {
    return "Currently there are " + currentNoOfDiapers +
        " students and diapers and, " + currentNoOfPottyTrained +
        " students who are potty trained in this classroom.";
  }
}
