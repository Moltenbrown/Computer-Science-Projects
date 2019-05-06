package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmptyTest {
  Empty empty;
  String sample;

  @Before
  public void setUp() throws Exception {
    this.empty = new Empty();
    this.sample = "sample";
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Empty{}", empty.toString());
  }

  @Test
  public void emptyBagOfWords() {
    Assert.assertTrue(empty.emptyBagOfWords().isEmpty());
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(empty.isEmpty());
  }

  @Test
  public void size() {
    Assert.assertTrue(empty.size() == 0);
  }

  @Test
  public void add() {
    Assert.assertEquals(new BagOfWords(sample, empty), empty.add(sample));
  }

  @Test
  public void contains() {
    Assert.assertFalse(empty.contains(sample));
  }

  @Test
  public void remove() {
    Assert.assertTrue(empty.remove(sample).isEmpty());
  }

  @Test
  public void equals(){
    Assert.assertTrue(empty.equals(new Empty()));
    Assert.assertFalse(empty.equals(sample));
  }
}