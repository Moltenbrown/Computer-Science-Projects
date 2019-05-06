package edu.neu.ccs.cs5004.Problem3;

import java.util.Objects;

/**
 * Represents a paper in a journal with all its details--the journal name, the
 * journal issue number, and the month as a three letter abbreviation, as strings.
 *
 * @author Goch
 */
public class JournalPaper extends AbstractPublication {
  private String journalName;
  private Integer issueNumber;
  private String month;

  /**
   * Creates a new journal paper from a title, an author, a journal name, a issue number, a month,
   * and a year.
   * @param title the paper title.
   * @param author the author wrote the paper.
   * @param journalName the name of the journal.
   * @param issueNumber the journal issue number.
   * @param month the month when the journal was published.
   * @param year the year when the journal was published.
   * @throws Exception occurs when the year entered does not contain 4 digits, or the month
   * entered is not a three letter abbreviation.
   */
  public JournalPaper(String title, Person author, String journalName,
      Integer issueNumber, String month, Integer year) throws Exception{
    super(title, author, year);
    this.journalName = journalName;
    this.issueNumber = issueNumber;
    this.month = month;

    if(month.length() < 3 || month.length() > 3){
      throw new InvalidMonthException("The month must be in three letter abbreviated form.");
    }
  }

  /**
   * Returns the name of the journal.
   * @return the journal name.
   */
  public String getJournalName() {
    return journalName;
  }

  /**
   * Returns the journal's issue number.
   * @return the journal issue number.
   */
  public Integer getIssueNumber() {
    return issueNumber;
  }

  /**
   * Returns the month the journal was published.
   * @return the month the journal was published.
   */
  public String getMonth() {
    return month;
  }

  /**
   * Evaluates whether the object being compared is the same as the journal paper.
   * @param o the object being compared to the journal paper.
   * @return true if the object is the same as the journal paper, and false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof JournalPaper)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    JournalPaper that = (JournalPaper) o;
    return Objects.equals(journalName, that.journalName) &&
        Objects.equals(issueNumber, that.issueNumber) &&
        Objects.equals(month, that.month);
  }

  /**
   * Returns the integer hashcode representation of the journal paper.
   * @return the integer hashcode representation of the journal paper.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), journalName, issueNumber, month);
  }

  /**
   * Return a string describing the journal paper, using the journal name,
   * the issue number, month, year, and title.
   * @return a string describing the conference paper.
   */
  @Override
  public String toString() {
    return  journalName + ", Issue No. " + issueNumber +
        ", " + month + " " + super.getYear() +
        ", " + super.getTitle();
  }
}
