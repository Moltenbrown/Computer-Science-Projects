package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserMapTest {
  UserMap test;
  String filePath;

  @Before
  public void setUp() throws Exception {
    this.filePath = "/Users/Goch/Desktop/edges_small.csv";
    this.test = new UserMap(filePath);
  }

  @Test
  public void equals() throws Exception {
    UserMap demo = new UserMap(filePath);
    Assert.assertTrue(test.equals(demo));
    Assert.assertFalse(test.equals(filePath));
    Assert.assertFalse(test.equals(new UserQueue("/Users/Goch/Desktop/node_small.csv")));
    Assert.assertFalse(test.equals(new UserMap("/Users/Goch/Desktop/"
        + "edges_small_decreased.csv")));

  }

  @Test
  public void hashCodeTest() throws Exception {
    UserMap demo = new UserMap(filePath);
    Assert.assertEquals(test.hashCode(), demo.hashCode());
    Assert.assertNotEquals(test.hashCode(), new UserMap("/Users/Goch/Desktop/"
        + "edges_small_decreased.csv"));
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("UserMap{userFollowMap=" + this.test.getUserFollowMap() +
        '}', test.toString());
  }
}