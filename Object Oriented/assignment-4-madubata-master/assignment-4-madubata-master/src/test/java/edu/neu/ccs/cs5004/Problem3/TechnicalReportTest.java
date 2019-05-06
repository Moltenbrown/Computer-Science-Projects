package edu.neu.ccs.cs5004.Problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TechnicalReportTest {
  String title;
  Person author;
  Integer year;
  String month;
  Integer issueNumber;
  String journalName;
  JournalPaper journalPaper;
  Integer trID;
  String institution;
  TechnicalReport technicalReport;

  @Before
  public void setUp() throws Exception {
    this.title = "Determining whether EST-PCR tags can be used for genetic testing";
    this.author = new Person("Jack", "Malley");
    this.year = new Integer(2005);
    this.month = "Oct";
    this.issueNumber = new Integer(24);
    this.journalName = "Scientific American";
    this.journalPaper = new JournalPaper(title, author, journalName, issueNumber, month,
        year);
    this.trID = new Integer(1224);
    this.institution = "Harvard University";
    this.technicalReport = new TechnicalReport(title, author, trID, institution, year);
  }

  @Test
  public void getTrID() {
    Assert.assertEquals(new Integer(1224), technicalReport.getTrID());
  }

  @Test
  public void getInstitution() {
    Assert.assertEquals("Harvard University", technicalReport.getInstitution());
  }

  @Test
  public void convertToJournalPaper() throws Exception {
    Assert.assertEquals(journalPaper, technicalReport.convertToJournalPaper(journalName,
        issueNumber, month, year));
  }

  @Test
  public void equals() throws Exception{
    Assert.assertTrue(technicalReport.equals(new TechnicalReport(title, author, trID, institution,
        year)));
    Assert.assertFalse(technicalReport.equals(new TechnicalReport(title, author, trID, institution,
        new Integer(1996))));
    Assert.assertFalse(technicalReport.equals(journalPaper));
  }

  @Test
  public void hashCodeTest() throws Exception{
    Assert.assertEquals(technicalReport.hashCode(), new TechnicalReport(title, author, trID,
        institution, year).hashCode());
    Assert.assertNotEquals(technicalReport.hashCode(), new TechnicalReport(title, author, trID,
        institution, new Integer(1996)).hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Harvard University, 1224, 2005, Determining whether EST-PCR tags "
        + "can be used for genetic testing", technicalReport.toString());
  }
}