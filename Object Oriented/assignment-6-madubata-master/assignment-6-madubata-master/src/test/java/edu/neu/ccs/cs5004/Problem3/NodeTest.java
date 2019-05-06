package edu.neu.ccs.cs5004.Problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {
  Integer value;
  Integer value2;
  Integer value3;
  Node nextNode;
  Node currentNode;

  @Before
  public void setUp() throws Exception {
    value = 1;
    value2 = 2;
    value3 = 3;
    nextNode = new Node(value3, null);
    currentNode = new Node(value2, nextNode);

  }

  @Test
  public void getValue() {
    Assert.assertEquals(new Integer(2), currentNode.getValue());
  }

  @Test
  public void setValue() {
    currentNode.setValue(value3);
    Assert.assertEquals(new Integer(3), currentNode.getValue());
  }

  @Test
  public void getNextNode() {
    Assert.assertEquals(nextNode, currentNode.getNextNode());
  }

  @Test
  public void setNextNode() {
    currentNode.setNextNode(null);
    Assert.assertEquals(null, currentNode.getNextNode());
  }

  @Test
  public void equals() {
    Assert.assertEquals(new Node(2, nextNode), currentNode);
    Assert.assertNotEquals(value2, currentNode);
    Assert.assertNotEquals(currentNode, new Node(3, nextNode));
    Assert.assertNotEquals(currentNode, new Node(2, null));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(new Node(2, nextNode).hashCode(), currentNode.hashCode());
    Assert.assertNotEquals(currentNode.hashCode(), nextNode.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("Node{value=" + value2 + ", nextNode=" +
        nextNode +'}', currentNode.toString());
  }
}