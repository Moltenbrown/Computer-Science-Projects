package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {
  Integer first;
  Integer second;
  Integer third;
  Queue test;
  Queue completeTest;

  @Before
  public void setUp() throws Exception {
    first = new Integer(1);
    second = new Integer(2);
    third = new Integer (3);
    test = new Queue(null, null);
    completeTest = new Queue(first, test.create());
    completeTest.enqueue(second);
    completeTest.enqueue(third);
  }

  @Test
  public void create() {
    Assert.assertEquals(new Queue(null, null), test.create());
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(test.isEmpty());
    Assert.assertFalse(completeTest.isEmpty());
  }

  @Test
  public void enqueue() {
    test.enqueue(first);
    Assert.assertEquals(new Queue(first, new Queue(null, null)), test);
  }

  @Test
  public void dequeue() throws Exception{
    completeTest.dequeue();
    Assert.assertEquals(new Queue(second, new Queue(third, new Queue(null, null))),
        completeTest);
  }

  @Test
  public void removeHelper() throws Exception {
    Assert.assertEquals(new Queue(first, new Queue(third, new Queue(null, null))),
        completeTest.removeHelper(second));
    Assert.assertEquals(new Queue(null, null), test.removeHelper(second));
  }

  @Test
  public void remove() throws Exception{
    completeTest.remove(second);
    Assert.assertEquals(new Queue(first, new Queue(third, new Queue(null, null))),
        completeTest);
    test.remove(second);
    Assert.assertEquals(new Queue(null, null), test);
  }

  @Test
  public void size() {
    Assert.assertEquals(new Integer(3), completeTest.size());
    Assert.assertEquals(new Integer(0), test.size());
  }

  @Test
  public void equals() {
    Assert.assertTrue(test.equals(new Queue(null, null)));
    Assert.assertTrue(completeTest.equals(new Queue (first, (new Queue(second, new Queue(third,
        new Queue(null, null)))))));
    Assert.assertFalse(test.equals(completeTest));
    Assert.assertFalse(test.equals(first));
    Assert.assertFalse(test.equals(new Queue(first, null)));
    Assert.assertFalse(test.equals(new Queue(null, new Queue(first, null))));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), new Queue(null, null).hashCode());
    Assert.assertNotEquals(test.hashCode(), completeTest.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("AbstractQueue{first=" + "null, rest=" + "null}", test.toString());
  }
}