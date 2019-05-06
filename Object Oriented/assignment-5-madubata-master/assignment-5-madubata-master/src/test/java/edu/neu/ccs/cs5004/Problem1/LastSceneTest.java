package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LastSceneTest {
  String name;
  String duration;
  String date;
  LastScene test;
  LastScene test2;

  @Before
  public void setUp() throws Exception {
    this.name = "Kissing Scene";
    this.duration = "35";
    this.date = "December 12, 2017";
    this.test = new LastScene(name, duration, date);
    this.test2 = new LastScene(name, "12", "January 1, 2018");
  }

  @Test
  public void getName() {
    Assert.assertEquals("Kissing Scene", test.getName());
  }

  @Test
  public void getDuration() {
    Assert.assertEquals("35", test.getDuration());
  }

  @Test
  public void getDate() {
    Assert.assertEquals("December 12, 2017", test.getDate());
  }

  @Test
  public void equals() {
    Assert.assertTrue(test.equals(new LastScene(name, duration, date)));
    Assert.assertFalse(test.equals(test2));
    Assert.assertFalse(test.equals(name));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(new LastScene(name, duration, date).hashCode(), test.hashCode());
    Assert.assertNotEquals(test2.hashCode(), test.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("last scene's name is Kissing Scene. It's duration is 35"
        + " and it took place on December 12, 2017.", test.toString());
  }
}