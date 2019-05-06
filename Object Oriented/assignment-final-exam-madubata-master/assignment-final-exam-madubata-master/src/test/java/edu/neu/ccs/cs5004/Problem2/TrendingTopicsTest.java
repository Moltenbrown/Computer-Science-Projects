package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrendingTopicsTest {
  List<String> list;
  TrendingTopics trendingTopics;

  @Before
  public void setUp() throws Exception {
    String[] string = {"Seattle", "wildfires", "DEFCON26", "NEU", "NEU", "Seattle", "Seattle",
        "NEU", "DEFCON26", "wildfires"};

    for(int i = 0; i < string.length; i++){
      list.add(string[i]);
    }

    trendingTopics = new TrendingTopics(list);
  }

  @Test
  public void countTopics() {
    Map<String, Integer> holder = trendingTopics.countTopics(list);
    Assert.assertEquals(new Integer(3), holder.get("Seattle"));

  }
}