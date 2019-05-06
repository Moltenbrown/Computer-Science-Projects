package edu.neu.ccs.cs5004.Problem3;

import java.util.Objects;

/**
 * Represents a node with its details--the previous node and the next node as nodes and the
 * value of the node as an integer.
 *
 * @author Goch.
 */
public class Node {

  protected Integer value;
  protected Node nextNode;

  /**
   * Creates a new node from a value and a nextNode.
   *
   * @param value the value of the node.
   * @param nextNode the node immediately following the current node.
   */
  public Node(Integer value, Node nextNode) {
    this.value = value;
    this.nextNode = nextNode;
  }

  /**
   * Return the integer value of the node.
   *
   * @return the value of the node.
   */
  public Integer getValue() {
    return value;
  }

  /**
   * Set the value of the node.
   *
   * @param value the value you want to set the node to.
   */
  public void setValue(Integer value) {
    this.value = value;
  }


  /**
   * Returns the current node's next node.
   *
   * @return the next node.
   */
  public Node getNextNode() {
    return nextNode;
  }

  /**
   * Sets the current node's next node to nextNode.
   *
   * @param nextNode the node that will become the current node's next node.
   */
  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Node)) {
      return false;
    }
    Node node = (Node) o;
    return Objects.equals(value, node.value) &&
        Objects.equals(nextNode, node.nextNode);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return Objects.hash(value, nextNode);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Node{" +
        "value=" + value +
        ", nextNode=" + nextNode +
        '}';
  }
}
