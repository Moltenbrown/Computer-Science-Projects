package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.Objects;

/**
 * Represents an Infant Teacher, which extends Abstract Teacher, with it's details--the current
 * amount of children in the classroom, the current amount of children who are crawlers, the current
 * amount of children who are walkers, and the maximum amount of children who can be in the
 * classroom as integers.
 *
 * @author Goch
 */
public class InfantTeacher extends AbstractTeacher {
  private int currentNoOfChildren;
  private int currentNoOfCrawlers;
  private int currentNoOfWalkers;
  private int maximumNoOfChildren;

  /**
   * Creates a new infant teacher, using the abstract teacher constructor, a name, a classroom,
   * a co-teacher, the current number of children in the classroom, the current number of children
   * who are crawlers, the current number of walking children, the maximum number of children,
   * which should be 8, which represents a situation where each teacher can take a maximum of
   * 4 children  and there are 2 teachers in each classroom, and the teacher's vacation
   * status.
   *
   * @param name the teacher's name
   * @param classroom the classroom the teacher teaches in
   * @param coTeacher the name of the teacher's co-teacher
   * @param currentNoOfChildren the current number of children in the class
   * @param currentNoOfCrawlers the current number of children who are crawling in the class
   * @param currentNoOfWalkers the current number of children who are walking in the class
   * @param maximumNoOfChildren the maximum number of children who can be in the class
   * @param teachersVacationStatus the teacher's current vacation status
   * @throws IllegalArgumentException throws an exception when either the current number if children
   * is higher than 8 or if the maximum number of children isn't 8.
   */
  public InfantTeacher(Person name, String classroom, Person coTeacher, int currentNoOfChildren,
      int currentNoOfCrawlers, int currentNoOfWalkers, int maximumNoOfChildren,
      boolean teachersVacationStatus) throws IllegalArgumentException{
    super(name, classroom, coTeacher, teachersVacationStatus);
    final int maximumInfant = 8;
    this.currentNoOfChildren = currentNoOfChildren;
    if(this.currentNoOfChildren > maximumInfant) {
      throw new IllegalArgumentException("There are too many children in this classroom.");
    }

    this.currentNoOfCrawlers = currentNoOfCrawlers;
    this.currentNoOfWalkers = currentNoOfWalkers;

    this.maximumNoOfChildren = maximumNoOfChildren;
    if(this.maximumNoOfChildren != maximumInfant) {
      throw new IllegalArgumentException("This number is not what the maximum amount should be.");
    }
  }

  /**
   * Returns the current number of children in the classroom.
   * @return the current number of children in the classroom.
   */

  public int getCurrentNoOfChildren() {
    return currentNoOfChildren;
  }

  /**
   * Returns the current number of children who are crawling in the classroom.
   * @return the current number of crawling children in this classroom.
   */
  public int getCurrentNoOfCrawlers(){
    return this.currentNoOfCrawlers;
  }

  /**
   * Returns the current number of children who are walking in the classroom.
   * @return the current number of walking children in this classroom.
   */
  public int getCurrentNoOfWalkers(){
    return this.currentNoOfWalkers;
  }

  /**
   * Returns the maximum number of children who can be in the classroom.
   * @return the maximum number of children who can be in the classroom.
   */

  public int getMaximumNoOfChildren() {
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
    if (!(o instanceof InfantTeacher)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    InfantTeacher that = (InfantTeacher) o;
    return currentNoOfChildren == that.currentNoOfChildren &&
        currentNoOfCrawlers == that.currentNoOfCrawlers &&
        currentNoOfWalkers == that.currentNoOfWalkers &&
        maximumNoOfChildren == that.maximumNoOfChildren;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), currentNoOfChildren, currentNoOfCrawlers,
        currentNoOfWalkers, maximumNoOfChildren);
  }

  @Override
  public String toString() {
    return "Currently, there are " + currentNoOfCrawlers +
        " crawlers and, " + currentNoOfWalkers + " walkers in this classroom.";
  }
}
