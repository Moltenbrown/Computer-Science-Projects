package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserQueueTest {
  UserQueue test;
  String filePath;

  @Before
  public void setUp() throws Exception {
    this.filePath = "/Users/Goch/Desktop/node_small.csv";
    this.test = new UserQueue(this.filePath);
  }


  @Test
  public void equals() throws Exception {
    UserQueue test2 = new UserQueue(this.filePath);
    Assert.assertTrue(test.equals(test2));
    Assert.assertFalse(test.equals(this.filePath));
    //created a second csv that misses the last two rows of the csv.
    UserQueue test3 = new UserQueue("/Users/Goch/Desktop/node_small_decreased.csv");
    Assert.assertFalse(test.equals(test3));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertEquals(test.hashCode(), new UserQueue(this.filePath).hashCode());
    Assert.assertNotEquals(test.hashCode(),
        new UserQueue("/Users/Goch/Desktop/node_small_decreased.csv").hashCode());
  }

  @Test
  public void toStringTest() throws Exception {
    Assert.assertEquals(new UserQueue(this.filePath).toString(), test.toString());
  }
}