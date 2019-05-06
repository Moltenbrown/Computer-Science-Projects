package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5004.Problem1.Director;
import edu.neu.ccs.cs5004.Problem1.MainActor;
import edu.neu.ccs.cs5004.Problem1.Media;
import edu.neu.ccs.cs5004.Problem1.TypeOfMedia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MediaLibraryTest {

  String title;
  String title2;
  String title3;
  Integer releaseYear;
  Integer releaseYear2;
  Integer releaseYear3;
  Director director;
  Director director2;
  Director director3;
  Director director4;
  Director director5;
  MainActor mainActor;
  MainActor mainActor2;
  MainActor mainActor3;
  MainActor mainActor4;
  MainActor mainActor5;
  List<Director> directorList;
  List<Director> directorList2;
  List<Director> directorList3;
  List<MainActor> actorList;
  List<MainActor> actorList2;
  List<MainActor> actorList3;
  Integer amountOfStream;
  TypeOfMedia typeOfMedia;
  TypeOfMedia typeOfMedia2;
  Media media1;
  Media media2;
  Media media3;
  String alias;
  String alias2;
  String alias3;
  MediaLibrary mediaLibrary;

  @Before
  public void setUp() throws Exception {
    this.title = "Heroes";
    this.title2 = "The Chronicles of Narnia";
    this.title3 = "Anchorman";
    this.releaseYear = new Integer(1999);
    this.releaseYear2 = new Integer(2002);
    this.releaseYear3 = new Integer(2009);
    this.directorList = new ArrayList<Director>();
    this.directorList2 = new ArrayList<Director>();
    this.directorList3 = new ArrayList<Director>();
    this.director = new Director("Martin", "Pharos");
    this.director2 = new Director("Lindsey", "Matthews");
    this.director3 = new Director("Annie", "Lennox");
    this.director4 = new Director("Chad", "Michaels");
    this.director5 = new Director("Samuel", "Caine");
    this.directorList.add(director);
    this.directorList.add(director2);
    this.directorList2.add(director3);
    this.directorList2.add(director4);
    this.directorList3.add(director5);
    this.directorList3.add(director);
    this.actorList = new ArrayList<MainActor>();
    this.actorList2 = new ArrayList<MainActor>();
    this.actorList3 = new ArrayList<MainActor>();
    this.mainActor = new MainActor("Conas", "Atatu");
    this.mainActor2 = new MainActor("Dia", "Duit");
    this.mainActor3 = new MainActor("b", "c");
    this.mainActor4 = new MainActor("connor", "haines");
    this.mainActor5 = new MainActor("Chad", "Michaels");
    this.actorList.add(mainActor);
    this.actorList.add(mainActor2);
    this.actorList2.add(mainActor3);
    this.actorList2.add(mainActor);
    this.actorList3.add(mainActor4);
    this.actorList3.add(mainActor5);
    this.amountOfStream = new Integer(0);
    this.typeOfMedia = TypeOfMedia.TVShow;
    this.typeOfMedia2 = TypeOfMedia.Movie;
    this.media1 = new Media(title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    this.media2 = new Media(title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    this.media3 = new Media(title3, releaseYear3, directorList3, actorList3, amountOfStream,
        typeOfMedia);
    this.alias = "Heroes";
    this.alias2 = "Narnia";
    this.alias3 = "Anchor";
    this.mediaLibrary = new MediaLibrary();
  }

  @Test
  public void getMediaLibrary() throws Exception {
    Assert.assertEquals(new HashMap<String, Media>(), mediaLibrary.getMediaLibrary());
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    MediaLibrary holder = new MediaLibrary();
    holder.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    Assert.assertEquals(holder, mediaLibrary);
  }

  @Test
  public void addMedia() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    Assert.assertNotEquals(new HashMap<String, Media>(), mediaLibrary);
    Assert.assertTrue(mediaLibrary.getMediaLibrary().containsValue(media1));
  }

  @Test(expected = ExistingAliasException.class)
  public void ExistingAliasExceptionTest() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    mediaLibrary.addMedia(alias, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalArgumentExceptionTest() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    mediaLibrary.addMedia(alias2, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalArgumentExceptionTest2() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    mediaLibrary.addMedia(alias2, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    mediaLibrary.addMedia(alias3, title3, releaseYear3, directorList3, actorList3, amountOfStream,
        typeOfMedia);
    mediaLibrary.increaseStreams(alias3);
    mediaLibrary.increaseStreams(alias3);
    mediaLibrary.increaseStreams(alias3);
    mediaLibrary.getStreamStatistics("Ham");
  }

  @Test
  public void directorsLibrary() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    List<Media> holder = new ArrayList<Media>();
    holder.add(media1);
    Assert.assertEquals(holder, mediaLibrary.DirectorsLibrary(director));
    Assert.assertEquals(new ArrayList<Media>(), mediaLibrary.DirectorsLibrary(director3));
  }

  @Test
  public void increaseStreams() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    mediaLibrary.addMedia(alias2, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    mediaLibrary.addMedia(alias3, title3, releaseYear3, directorList3, actorList3, amountOfStream,
        typeOfMedia);
    mediaLibrary.increaseStreams(alias2);
    Assert.assertEquals(new Media(title2, releaseYear2, directorList2, actorList2,
        new Integer(1), typeOfMedia2), mediaLibrary.getMediaLibrary().get(alias2));
  }

  @Test
  public void getStreamStatistics() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    mediaLibrary.addMedia(alias2, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    mediaLibrary.addMedia(alias3, title3, releaseYear3, directorList3, actorList3, amountOfStream,
        typeOfMedia);
    mediaLibrary.increaseStreams(alias3);
    mediaLibrary.increaseStreams(alias3);
    mediaLibrary.increaseStreams(alias3);
    Assert.assertEquals(new Integer(3),
        mediaLibrary.getStreamStatistics(alias3));
  }

  @Test
  public void getMostStreamed() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    mediaLibrary.addMedia(alias2, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    mediaLibrary.addMedia(alias3, title3, releaseYear3, directorList3, actorList3, amountOfStream,
        typeOfMedia);
    mediaLibrary.increaseStreams(alias3);
    mediaLibrary.increaseStreams(alias3);
    mediaLibrary.increaseStreams(alias3);
    mediaLibrary.increaseStreams(alias2);
    mediaLibrary.increaseStreams(alias2);
    mediaLibrary.increaseStreams(alias);

    Assert.assertEquals(new Media(title3, releaseYear3, directorList3, actorList3,
        new Integer(3), typeOfMedia), mediaLibrary.getMostStreamed());
  }

  @Test
  public void equals() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    mediaLibrary.addMedia(alias2, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    mediaLibrary.addMedia(alias3, title3, releaseYear3, directorList3, actorList3, amountOfStream,
        typeOfMedia);

    MediaLibrary holder = new MediaLibrary();
    holder.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    holder.addMedia(alias2, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    holder.addMedia(alias3, title3, releaseYear3, directorList3, actorList3, amountOfStream,
        typeOfMedia);

    Assert.assertTrue(mediaLibrary.equals(holder));
    Assert.assertFalse(mediaLibrary.equals(new MediaLibrary()));

    MediaLibrary holder2 = new MediaLibrary();

    holder2.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    holder2.addMedia(alias2, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    Assert.assertFalse(mediaLibrary.equals(holder2));
    Assert.assertFalse(mediaLibrary.equals(media1));
  }

  @Test
  public void hashCodeTest() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    mediaLibrary.addMedia(alias2, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    mediaLibrary.addMedia(alias3, title3, releaseYear3, directorList3, actorList3, amountOfStream,
        typeOfMedia);

    MediaLibrary holder = new MediaLibrary();
    holder.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    holder.addMedia(alias2, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    holder.addMedia(alias3, title3, releaseYear3, directorList3, actorList3, amountOfStream,
        typeOfMedia);

    Assert.assertEquals(mediaLibrary.hashCode(), holder.hashCode());
    Assert.assertNotEquals(mediaLibrary.hashCode(), media2.hashCode());
  }

  @Test
  public void toStringTest() throws Exception {
    mediaLibrary.addMedia(alias, title, releaseYear, directorList, actorList, amountOfStream,
        typeOfMedia);
    mediaLibrary.addMedia(alias2, title2, releaseYear2, directorList2, actorList2, amountOfStream,
        typeOfMedia2);
    mediaLibrary.addMedia(alias3, title3, releaseYear3, directorList3, actorList3, amountOfStream,
        typeOfMedia);

    Assert.assertEquals("AbstractMediaLibrary{mediaLibrary=" +
        mediaLibrary.getMediaLibrary() + '}', mediaLibrary.toString());
  }
}