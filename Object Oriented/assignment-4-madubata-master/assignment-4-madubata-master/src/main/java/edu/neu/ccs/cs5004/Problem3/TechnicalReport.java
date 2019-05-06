package edu.neu.ccs.cs5004.Problem3;

import java.util.Objects;

/**
 * Represents a Technical Report with its details--the tracking Id (trID) as an integer
 * and the institution publishing the report as a string.
 *
 * @author Goch
 */
public class TechnicalReport extends AbstractPublication {
  private Integer trID;
  private String institution;

  /**
   * Creates a new technical report from a title, an author, a tracking id,
   * an institution, and a year.
   * @param title the title of the technical report.
   * @param author the author of the technical report.
   * @param trID the technical report's tracking id.
   * @param institution the institution publishing the tracking report.
   * @param year the year the report was published.
   * @throws InvalidYearException this is thrown is the year presented is not 4 digits.
   */
  public TechnicalReport(String title, Person author, Integer trID,
      String institution, Integer year) throws InvalidYearException{
    super(title, author, year);
    this.trID = trID;
    this.institution = institution;
  }

  /**
   * Returns the technical report's tracking id.
   * @return the technical report's tracking id.
   */
  public Integer getTrID() {
    return trID;
  }

  /**
   * Returns the institution that published the technical report.
   * @return the institution that published the technical report.
   */
  public String getInstitution() {
    return institution;
  }

  /**
   * Changes a technical report to a journal paper using the journal's name, the
   * journal issue number, the journal's month, and the journal's publication year.
   * @param journalName the journal name that the technical report is being printed in.
   * @param journalIssue the journal issue the technical report is being published in.
   * @param month the month the journal is being published.
   * @param year the year the journal is being published.
   * @return a new journal paper with the information from the original technical report in it's
   * proper place.
   * @throws Exception is thrown when the user enters a year that is not 4 digits long or when the
   * user enter a month that is not a three letter abbreviation.
   */
  public JournalPaper convertToJournalPaper(String journalName, Integer journalIssue,
      String month, Integer year) throws Exception{
    return new JournalPaper(super.getTitle(), super.getAuthor(), journalName,
        journalIssue, month, year);
  }

  /**
   * Evaluates whether the object being compared is the same as the technical report.
   * @param o the object being compared to the technical report.
   * @return true if the object is the same as the technical report, and false otherwise.
   */


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TechnicalReport)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    TechnicalReport that = (TechnicalReport) o;
    return Objects.equals(trID, that.trID) &&
        Objects.equals(institution, that.institution);
  }

  /**
   * Returns the integer hashcode representation of the technical report.
   * @return the integer hashcode representation of the technical report.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), trID, institution);
  }

  /**
   * Return a string describing the technical report, using the institution,
   * the report's tracking id,  year, and title.
   * @return a string describing the technical report.
   */
  @Override
  public String toString() {
    return institution + ", " +
         trID + ", " + super.getYear() + ", " +
        super.getTitle();
  }
}
