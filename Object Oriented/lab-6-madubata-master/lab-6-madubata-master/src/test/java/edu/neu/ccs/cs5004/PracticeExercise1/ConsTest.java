package edu.neu.ccs.cs5004.PracticeExercise1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import sun.invoke.empty.Empty;

public class ConsTest {

  Integer one;
  Integer two;
  Cons list;
  List emptyList;

  @Before
  public void setUp() throws Exception {
    this.one = new Integer(3);
    this.two = new Integer(4);
    this.emptyList = new Empty();
    this.list = new Cons(one, emptyList);
    this.list.add(two);
  }

  @Test
  public void getFirst() {
    Assert.assertEquals(two, list.getFirst());
  }

  @Test
  public void getRest() {
//    Assert.assertEquals(one, list.getRest());
  }

  @Test
  public void size() {
  }

  @Test
  public void isEmpty() {
  }

  @Test
  public void add() {
  }

  @Test
  public void last() {
  }

  @Test
  public void contains() {
    Assert.assertTrue(list.contains(two));
    Assert.assertTrue(list.contains(one));
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