package edu.neu.ccs.cs5004.Problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JournalPaperTest {
  String title;
  Person author;
  Integer year;
  String month;
  Integer issueNumber;
  String journalName;
  JournalPaper journalPaper;

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
  }

  @Test
  public void getJournalName() {
    Assert.assertEquals(journalName, journalPaper.getJournalName());
  }

  @Test
  public void getIssueNumber() {
    Assert.assertEquals(new Integer(24), journalPaper.getIssueNumber());
  }

  @Test
  public void getMonth() {
    Assert.assertEquals(month, journalPaper.getMonth());
  }

  @Test
  public void equals() throws Exception{
    Assert.assertTrue(journalPaper.equals(new JournalPaper(title, author, journalName, issueNumber,
        month, year)));
    Assert.assertFalse(journalPaper.equals(journalPaper.equals(new JournalPaper(title, author,
        journalName, issueNumber, month, new Integer(2009)))));
    Assert.assertFalse(journalPaper.equals(year));
  }

  @Test
  public void hashCodeTest() throws Exception{
    Assert.assertEquals(journalPaper.hashCode(), new JournalPaper(title, author, journalName, issueNumber,
        month, year).hashCode());
    Assert.assertNotEquals(journalPaper.hashCode(), new JournalPaper(title, author, journalName,
        issueNumber, month, new Integer(2009)).hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Scientific American, Issue No. 24, Oct 2005, Determining whether "
        + "EST-PCR tags can be used for genetic testing", journalPaper.toString());
  }
}