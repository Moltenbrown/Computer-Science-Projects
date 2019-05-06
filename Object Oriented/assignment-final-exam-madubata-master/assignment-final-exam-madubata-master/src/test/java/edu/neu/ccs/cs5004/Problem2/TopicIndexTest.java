package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TopicIndexTest {
  Map<Integer, List<String>> currentData;
  TopicIndex topicIndex;
  List<String> holder;
  List<String> holder2;
  List<String> holder3;
  List<String> holder4;

  @Before
  public void setUp() throws Exception {
    holder = new ArrayList<String>();
    holder2 = new ArrayList<String>();
    holder3 = new ArrayList<String>();
    holder4 = new ArrayList<String>();

    String[] something = new String [] {"#blessed", "#DEFCON26", "#lifegoals", "#NEU"};
    for(int i = 0; i < something.length; i++){
      holder.add(something[i]);
    }

    String[] something2 = new String [] {"#sunnyDay", "#Summer", "#vacation"};

    for(int i = 0; i < something2.length; i++){
      holder2.add(something2[i]);
    }

    String[] something3 = new String [] {"#DEFCON26", "#NEU", "#Seattle"};

    for(int i = 0; i < something3.length; i++){
      holder3.add(something3[i]);
    }

    String[] something4 = new String [] {"#sunnyDay", "#Seattle", "#vacation"};

    for(int i = 0; i < something4.length; i++){
      holder4.add(something4[i]);
    }

    currentData.put(12345, holder);
    currentData.put(23456, holder2);
    currentData.put(34567, holder3);
    currentData.put(45678, holder4);

    topicIndex = new TopicIndex(currentData);
  }

  @Test
  public void returnTopicIndex() {
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(12345);

    Assert.assertEquals(list1, topicIndex.returnTopicIndex().get("#blessed"));
  }

  @Test
  public void equals() {
  }

  @Test
  public void hashCodeTest() {
  }

  @Test
  public void toStringTest() {
  }
}