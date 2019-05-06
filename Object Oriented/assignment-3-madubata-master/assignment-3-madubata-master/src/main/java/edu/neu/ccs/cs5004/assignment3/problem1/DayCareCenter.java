package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a Daycare Center with it's details--a list of all substitute teacher employed at the
 * center, a list of all infant teachers employed at the center, a list of toddler teachers
 * employed at the center, and a list of preschool teachers employed at the center.
 *
 * @author Goch
 */
public class DayCareCenter {
  private ArrayList substituteTeachersList;
  private ArrayList infantTeacherList;
  private ArrayList toddlerTeachersList;
  private ArrayList preschoolTeacherList;


  /**
   * Creates a new daycare center with empty lists for the substitute teachers, the infant teachers,
   * the toddler teachers, and the preschool teachers.
   */
  public DayCareCenter(){
    this.substituteTeachersList = new ArrayList();
    this.infantTeacherList = new ArrayList();
    this.toddlerTeachersList = new ArrayList();
    this.preschoolTeacherList = new ArrayList();
  }

  /**
   * Adds a substitute teacher to the substitute teacher list.
   * @param substituteTeacher to be added to the substitute teacher list.
   */
  public void addToSubstituteTeachersList(SubstituteTeacher substituteTeacher){
    this.substituteTeachersList.add(0, substituteTeacher);
  }

  /**
   * Adds an infant teacher to the infant teacher list.
   * @param infantTeacher to be added to the infant teacher list.
   */
  public void addToInfantTeachersList(InfantTeacher infantTeacher){
    this.infantTeacherList.add(0, infantTeacher);
  }

  /**
   * Adds an toddler teacher to the toddler teacher list.
   * @param toddlerTeacher to be added to the toddler teacher list.
   */
  public void addToToddlerTeachersList(ToddlerTeacher toddlerTeacher){
    this.toddlerTeachersList.add(0, toddlerTeacher);
  }

  /**
   * Adds an preschool teacher to the preschool teacher list.
   * @param preschoolTeacher to be added to the preschool teacher list.
   */
  public void addToPreschoolTeacherList(PreschoolTeacher preschoolTeacher){
    this.preschoolTeacherList.add(0, preschoolTeacher);
  }

  /**
   * Returns a list of the substitute teachers at the daycare center.
   * @return the substitute teacher list.
   */
  public ArrayList getSubstituteTeachersList() {
    return substituteTeachersList;
  }

  /**
   * Returns a list of the infant teachers at the daycare center.
   * @return the infant teacher list.
   */
  public ArrayList getInfantTeacherList() {
    return infantTeacherList;
  }

  /**
   * Returns a list of the toddler teachers at the daycare center.
   * @return the toddler teacher list.
   */
  public ArrayList getToddlerTeachersList() {
    return toddlerTeachersList;
  }

  /**
   * Returns the list of the preschool teachers at the daycare center.
   * @return the preschool teacher list.
   */
  public ArrayList getPreschoolTeacherList() {
    return preschoolTeacherList;
  }

  /**
   * Converts a substitute teacher to a fulltime teacher of the type specified by teacher type.
   * @param substituteTeacher the substitute teacher that is being converted.
   * @param teacherType the teacher type we want the substitute teacher to be converted to.
   * @param coTeacher the substitute teacher's co-teacher.
   * @return the substitute teacher as a new full-time teacher.
   */
  public AbstractTeacher convertSubstituteTeacher(SubstituteTeacher substituteTeacher,
      String teacherType, AbstractTeacher coTeacher){
    Person name = substituteTeacher.getName();
    boolean vacationStatus = substituteTeacher.getTeachersVacationStatus();

    AbstractTeacher newFullTimeTeacher = null;

    if(teacherType.equals("Infant")){
      newFullTimeTeacher = new InfantTeacher(name,  coTeacher.getClassroom(),
          coTeacher.getName(), ((InfantTeacher) coTeacher).getCurrentNoOfChildren(),
          ((InfantTeacher) coTeacher).getCurrentNoOfCrawlers(),
          ((InfantTeacher) coTeacher).getCurrentNoOfWalkers(),
          ((InfantTeacher) coTeacher).getMaximumNoOfChildren(), vacationStatus);
    }

    if(teacherType.equals("Toddler")){
      newFullTimeTeacher = new ToddlerTeacher(name,  coTeacher.getClassroom(),
          coTeacher.getName(), ((ToddlerTeacher) coTeacher).getCurrentNoOfChildren(),
          ((ToddlerTeacher) coTeacher).getCurrentNoOfDiapers(),
          ((ToddlerTeacher) coTeacher).getCurrentNoOfPottyTrained(),
          ((ToddlerTeacher) coTeacher).getMaximumNoOfChildren(), vacationStatus);
    }

    if(teacherType.equals("Preschool")){
      newFullTimeTeacher = new PreschoolTeacher(name,  coTeacher.getClassroom(),
          coTeacher.getName(), ((PreschoolTeacher) coTeacher).getCurrentNoOfChildren(),
          ((PreschoolTeacher) coTeacher).getCurrentNoOfReaders(),
          ((PreschoolTeacher) coTeacher).getMaximumNoOfChildren(), vacationStatus);
    }

    return newFullTimeTeacher;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DayCareCenter)) {
      return false;
    }
    DayCareCenter that = (DayCareCenter) o;
    return Objects.equals(substituteTeachersList, that.substituteTeachersList) &&
        Objects.equals(infantTeacherList, that.infantTeacherList) &&
        Objects.equals(toddlerTeachersList, that.toddlerTeachersList) &&
        Objects.equals(preschoolTeacherList, that.preschoolTeacherList);
  }

  @Override
  public int hashCode() {

    return Objects
        .hash(substituteTeachersList, infantTeacherList, toddlerTeachersList, preschoolTeacherList);
  }

  @Override
  public String toString() {
    return "At this day care, these are the substitute teachers " + substituteTeachersList +
        ", these are the infant teachers " + infantTeacherList +
        ", these are the toddler teachers " + toddlerTeachersList +
        ", and these are the preschool teachers " + preschoolTeacherList +
        '.';
  }
}
