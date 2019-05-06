package edu.neu.ccs.cs5004.Problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LIFODequeTest {
  Integer value;
  Integer value2;
  Integer value3;
  LIFODeque test;

  @Before
  public void setUp() throws Exception {
    value = 1;
    value2 = 2;
    value3 = 3;
    test = new LIFODeque();
  }

  @Test
  public void getFirst() {
    Assert.assertNull(test.getFirst());
    test.setFirst(new Node(value, null));
    Assert.assertEquals(test.getFirst(), new Node(value, null));
  }

  @Test
  public void setFirst() {
    test.setFirst(new Node(value, null));
    Assert.assertEquals(test.getFirst(), new Node(value, null));
  }

  @Test
  public void getLast() {
    Assert.assertNull(test.getLast());
    test.setLast(new Node(value, null));
    Assert.assertEquals(test.getLast(), new Node(value, null));
  }

  @Test
  public void setLast() {
    test.setLast(new Node(value, null));
    Assert.assertEquals(test.getLast(), new Node(value, null));
  }

  @Test
  public void emptyDeque() {
    Assert.assertEquals(test.emptyDeque(), new LIFODeque());
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(test.isEmpty());
    test.addFirst(value);
    Assert.assertFalse(test.isEmpty());
  }

  @Test
  public void size() {
    Assert.assertEquals(test.size(), new Integer(0));
    test.addFirst(1);
    test.addFirst(2);
    test.addFirst(3);
    Assert.assertEquals(test.size(), new Integer(3));
  }

  @Test
  public void addFirst() {
    test.addFirst(1);
    Assert.assertEquals(test.getFirst(), new Node(new Integer(1), null));
    test.addFirst(2);
    Assert.assertEquals(test.getFirst(), new Node(2, new Node(1, null)));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void UnsupportedOperationException(){
    test.addLast(value);
    test.addLast(value2);
  }

  @Test
  public void removerFirst() throws Exception {
    test.addFirst(value);
    test.addFirst(value2);
    test.addFirst(value3);
    test.removerFirst();
    LIFODeque test2 = new LIFODeque();
    test2.addFirst(value);
    test2.addFirst(value2);
    Assert.assertEquals(test, test2);

  }

  @Test(expected = IllegalOperationException.class)
  public void IllegalOperationExcecption () throws Exception {
    test.removerFirst();
    test.peek();
  }

  @Test
  public void peek() throws Exception {
    test.addFirst(value);
    test.addFirst(value2);
    test.addFirst(value3);
    Assert.assertEquals(new Integer(3), test.peek());
  }

  @Test
  public void equals() {
    test.addFirst(value);
    test.addFirst(value2);
    test.addFirst(value3);
    Assert.assertFalse(test.equals(new LIFODeque()));
    Assert.assertFalse(test.equals(value));
    LIFODeque test2 = new LIFODeque();
    test2.addFirst(value);
    test2.addFirst(value3);
    Assert.assertFalse(test.equals(test2));
    LIFODeque test3 = new LIFODeque();
    test3.addFirst(value3);
    test3.addFirst(value3);
    Assert.assertFalse(test.equals(test3));
    LIFODeque test4 = new LIFODeque();
    test4.addFirst(value);
    test4.addFirst(value2);
    test4.addFirst(value3);
    Assert.assertTrue(test.equals(test4));
    FIFODeque test5 = new FIFODeque();
    test5.addLast(value3);
    test5.addLast(value2);
    test5.addLast(value);
    Assert.assertFalse(test.equals(test5));
  }

  @Test
  public void hashCodeTest() {
    test.addFirst(value);
    test.addFirst(value2);
    test.addFirst(value3);
    Assert.assertNotEquals(new LIFODeque().hashCode(), test.hashCode());
    LIFODeque test2 = new LIFODeque();
    test2.addFirst(value);
    test2.addFirst(value2);
    test2.addFirst(value3);
    Assert.assertEquals(test.hashCode(), test2.hashCode());
  }

  @Test
  public void toStringTest() {
    test.addFirst(value);
    test.addFirst(value2);
    test.addFirst(value3);
    Assert.assertEquals("AbstractDeque{first value=Node{value=3, nextNode=Node{value=2, "
        + "nextNode=Node{value=1, nextNode=null}}}, last value=Node{value=1, nextNode=null}}", test.toString());
    Assert.assertNotEquals(new LIFODeque().toString(), test.toString());
  }
}