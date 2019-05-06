package edu.neu.ccs.cs5004;

import static org.junit.Assert.*;

import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FollowedHistogramTest {
  UserMap userMap;
  UserMap userMap2;
  String filePath;
  String filePath2;
  FollowedHistogram test;
  FollowedHistogram test2;

  @Before
  public void setUp() throws Exception {
    this.filePath = "/Users/Goch/Desktop/edges_small.csv";
    this.filePath2 = "/Users/Goch/Desktop/edges_small_decreased.csv";
    this.userMap = new UserMap(filePath);
    this.userMap2 = new UserMap(filePath2);
    this.test = new FollowedHistogram(userMap);
    this.test2 = new FollowedHistogram(userMap2);
  }


  @Test
  public void influencerListCreator() {
    //edges_small_decreased removed a single follow for user nodeId 45, so the amount of followers
    // 45 has should be exactly 15, thus it shouldn't be included in the influencer list for test2
    // but should be in the influencer list for test1.
    Assert.assertNotEquals(test.influencerListCreator(15),
        test2.influencerListCreator(15));
    Assert.assertFalse(test2.influencerListCreator(15).contains(45));
    Assert.assertTrue(test.influencerListCreator(15).contains(45));
  }

  @Test
  public void equals() {
    Assert.assertTrue(test.equals(new FollowedHistogram(userMap)));
    Assert.assertFalse(test.equals(test2));
    Assert.assertFalse(test.equals(userMap));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), new FollowedHistogram(userMap).hashCode());
    Assert.assertNotEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("FollowedHistogram{followAmountMap=" + test.getFollowAmountMap() +
        '}', test.toString());
  }
}