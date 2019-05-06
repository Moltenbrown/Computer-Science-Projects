package edu.neu.ccs.cs5004.Problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FIFODequeTest {
  Integer value;
  Integer value2;
  Integer value3;
  FIFODeque test;

  @Before
  public void setUp() throws Exception {
    value = 1;
    value2 = 2;
    value3 = 3;
    test = new FIFODeque();
  }

  @Test
  public void getFirst() {
    test.addLast(value);
    Assert.assertEquals(new Node(value, null), test.getFirst());
  }

  @Test
  public void setFirst() {
    test.setFirst(new Node(value, null));
    Assert.assertEquals(new Node(value, null),
        test.getFirst());
  }

  @Test
  public void getLast() {
    test.addLast(value);
    Assert.assertEquals(new Node(value, null), test.getLast());
  }

  @Test
  public void setLast() {
    test.setLast(new Node(value, null));
    Assert.assertEquals(new Node(value, null),
        test.getLast());
  }

  @Test
  public void emptyDeque() {
    Assert.assertEquals(new FIFODeque(), test.emptyDeque());
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(test.isEmpty());
    test.addLast(value);
    Assert.assertFalse(test.isEmpty());
  }

  @Test
  public void size() {
    Assert.assertEquals(new Integer(0), test.size());
    test.addLast(value);
    Assert.assertEquals(new Integer(1), test.size());
    test.addLast(value2);
    Assert.assertEquals(new Integer(2), test.size());
    test.addLast(value3);
    Assert.assertEquals(new Integer(3), test.size());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void UnsupportedOperationException(){
    test.addFirst(value);
    test.addFirst(value2);
  }

  @Test
  public void addLast() {
    test.addLast(value);
    test.addLast(value2);
    test.addLast(value3);
    Assert.assertNotEquals(new FIFODeque(), test);

    FIFODeque test2 = new FIFODeque();
    test2.addLast(value);
    test2.addLast(value2);
    test2.addLast(value3);
    Assert.assertEquals(test, test2);
  }

  @Test
  public void removerFirst() throws Exception{
    test.addLast(value);
    test.addLast(value2);
    test.addLast(value3);
    test.removerFirst();
    FIFODeque test2 = new FIFODeque();
    test2.addLast(value2);
    test2.addLast(value3);
    Assert.assertEquals(test, test2);
  }

  @Test(expected = IllegalOperationException.class)
  public void IllegalOperationException() throws Exception{
    test.removerFirst();
  }

  @Test
  public void peek() throws Exception {
    test.addLast(value);
    test.addLast(value2);
    test.addLast(value3);
    Assert.assertEquals(test.peek(), value);
  }

  @Test
  public void equals() {
    test.addLast(value);
    test.addLast(value2);
    test.addLast(value3);
    Assert.assertFalse(test.equals(new FIFODeque()));
    Assert.assertFalse(test.equals(value));
    FIFODeque test2 = new FIFODeque();
    test2.addLast(value);
    test2.addLast(value3);
    Assert.assertFalse(test.equals(test2));
    FIFODeque test3 = new FIFODeque();
    test3.addLast(value3);
    test3.addLast(value3);
    Assert.assertFalse(test.equals(test3));
    FIFODeque test4 = new FIFODeque();
    test4.addLast(value);
    test4.addLast(value2);
    test4.addLast(value3);
    Assert.assertTrue(test.equals(test4));
    LIFODeque test5 = new LIFODeque();
    test5.addFirst(value);
    test5.addFirst(value2);
    test5.addFirst(value3);
    Assert.assertFalse(test.equals(test5));
  }

  @Test
  public void hashCodeTest() {
    test.addLast(value);
    test.addLast(value2);
    test.addLast(value3);
    Assert.assertNotEquals(new FIFODeque().hashCode(), test.hashCode());
    FIFODeque test2 = new FIFODeque();
    test2.addLast(value);
    test2.addLast(value2);
    test2.addLast(value3);
    Assert.assertEquals(test.hashCode(), test2.hashCode());

  }

  @Test
  public void toStringTest() {
    test.addLast(value);
    test.addLast(value2);
    test.addLast(value3);
    Assert.assertEquals("AbstractDeque{first value=Node{value=1, nextNode=Node{value=2, "
        + "nextNode=Node{value=3, nextNode=null}}}, last value=Node{value=3, nextNode=null}}", test.toString());
    Assert.assertNotEquals(new FIFODeque().toString(), test.toString());
  }
}