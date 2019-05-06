package edu.neu.ccs.cs5004.Problem1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BagOfWordsTest {
  String first;
  String second;
  String third;
  IBagOfWords empty;
  BagOfWords test;

  @Before
  public void setUp() throws Exception {
    this.first = "first";
    this.second = "second";
    this.third = "third";
    this.empty = new Empty();
    this.test = new BagOfWords(first, empty);

  }

  @Test
  public void getFirst() {
    Assert.assertEquals("first", test.getFirst());
  }

  @Test
  public void getRest() {
    Assert.assertEquals(empty, test.getRest());
  }

  @Test
  public void emptyBagOfWords() {
    Assert.assertEquals(new Empty(), test.emptyBagOfWords());
  }

  @Test
  public void isEmpty() {
    Assert.assertFalse(test.isEmpty());
  }

  @Test
  public void size() {
    Assert.assertEquals(new Integer(1), test.size());
    BagOfWords test2 = test.add(second);
    Assert.assertEquals(new Integer(2), test2.size());

  }

  @Test
  public void add() {
    test.add(second);
    Assert.assertEquals(second, test.add(second).getFirst());
  }

  @Test
  public void contains() {
    BagOfWords test2 = test.add(second);
    BagOfWords test3 = test2.add(third);
    Assert.assertTrue(test3.contains(first));
    Assert.assertFalse(test3.contains("fourth").booleanValue());
  }

  @Test
  public void remove() {
    BagOfWords test2 = test.add(second);
    BagOfWords test3 = test2.add(third);
    Assert.assertFalse(test3.remove(first).contains(first));
  }

  @Test
  public void equals() {
    BagOfWords test2 = test.add(second);
    Assert.assertEquals(test, new BagOfWords(first, empty));
    Assert.assertNotEquals(test, test2);
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(),
        new BagOfWords(first, empty).hashCode());
    Assert.assertNotEquals(test.hashCode(), test.add(second).hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals(test.toString(), "BagOfWords{" + "first='" + first + '\'' +
        ", rest=" + empty +
        '}');
  }
}