package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.applet.Main;

public class MediaTest {
  String title;
  Integer releaseYear;
  List<Director> directorList;
  List<MainActor> actorList;
  Integer amountOfStream;
  TypeOfMedia typeOfMedia;
  TypeOfMedia typeOfMedia2;
  Media test;
  Media test2;

  @Before
  public void setUp() throws Exception {
    this.title = "Heroes";
    this.releaseYear = new Integer(1999);
    this.directorList = new ArrayList<Director>();
    this.directorList.add(new Director("Martin", "Pharos"));
    this.actorList = new ArrayList<MainActor>();
    this.actorList.add(new MainActor("Conas", "Atatu"));
    this.amountOfStream = new Integer(0);
    this.typeOfMedia = TypeOfMedia.TVShow;
    this.typeOfMedia2 = TypeOfMedia.Movie;
    this.test = new Media(title, releaseYear, directorList, actorList, amountOfStream, typeOfMedia);
    this.test2 = new Media(title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia2);
  }

  @Test(expected = FourDigitException.class)
  public void FourDigitExceptionTest() throws Exception{
    new Media(title, new Integer(203), directorList, actorList, amountOfStream, typeOfMedia);
    new Media(title, new Integer(20078), directorList, actorList, amountOfStream,
        typeOfMedia);
  }

  @Test
  public void getTitle() {
    Assert.assertEquals(title, test.getTitle());
  }

  @Test
  public void getReleaseYear() {
    Assert.assertEquals(releaseYear, test.getReleaseYear());
  }

  @Test
  public void getDirectors() {
    Assert.assertEquals(directorList, test.getDirectors());
  }

  @Test
  public void getAmountOfStreams() {
    Assert.assertEquals(new Integer(0), test.getAmountOfStreams());
  }

  @Test
  public void isDirector() {
    Assert.assertFalse(test.isDirector(new Director("Michael", "Jandson")));
    Assert.assertTrue(test.isDirector(new Director("Martin", "Pharos")));
  }

  @Test
  public void equals() throws Exception {
    Assert.assertTrue(test.equals(new Media(title, releaseYear, directorList, actorList,
        amountOfStream, typeOfMedia)));
    Assert.assertFalse(test.equals(test2));
    Assert.assertFalse(test.equals(directorList));
    Assert.assertFalse(test.equals(new Media("Hamster", releaseYear, directorList, actorList,
        amountOfStream, typeOfMedia)));
    Assert.assertFalse(test.equals(new Media(title, new Integer(2001), directorList,
        actorList, amountOfStream, typeOfMedia)));
    Assert.assertFalse(test.equals(new Media(title, releaseYear, new ArrayList(), actorList,
        amountOfStream, typeOfMedia)));
    Assert.assertFalse(test.equals(new Media(title, releaseYear, directorList, new ArrayList(),
        amountOfStream, typeOfMedia)));
    Assert.assertFalse(test.equals(new Media(title, releaseYear, directorList, actorList,
        new Integer(3), typeOfMedia)));
    Assert.assertFalse(test.equals(new Media(title, releaseYear, directorList, actorList,
        amountOfStream, TypeOfMedia.Movie)));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Media holder = new Media(title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    Assert.assertEquals(holder.hashCode(), test.hashCode());
    Assert.assertNotEquals(test.hashCode(), test2.hashCode());
  }

  @Test

  public void toStringTest() {
    Assert.assertEquals("AbstractMedia{title='Heroes', releaseYear=1999, directors=" +
        directorList + ", actors=" + actorList + ", amountOfStreams=0, mediaType=" + typeOfMedia
        + '}', test.toString());
  }
}