package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DirectorTest {
  Person name;
  LastScene lastScene;
  LastScene lastScene2;
  Director one;
  Director two;

  @Before
  public void setUp() throws Exception {
    this.name = new Person("Samuel", "Matthews");
    this.lastScene = new LastScene("Kissing Scene", "5", "January 12, 2009");
    this.lastScene2 = new LastScene("Fight Scene", "15", "June 9, 2006");
    this.one = new Director(name, lastScene);
    this.two = new Director(name, lastScene2);
  }

  @Test
  public void getName() {
    Assert.assertEquals(name, one.getName());
  }

  @Test
  public void getLastScene() {
    Assert.assertEquals(lastScene, one.getLastScene());
  }

  @Test
  public void equals() {
    Assert.assertTrue(one.equals(new Director(name, lastScene)));
    Assert.assertFalse(one.equals(two));
    Assert.assertFalse(one.equals(name));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(one.hashCode(), new Director(name, lastScene).hashCode());
    Assert.assertNotEquals(one.hashCode(), two.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Samuel Matthews's last scene's name is Kissing Scene."
        + " It's duration is 5 and it took place on January 12, 2009.", one.toString());
  }
}