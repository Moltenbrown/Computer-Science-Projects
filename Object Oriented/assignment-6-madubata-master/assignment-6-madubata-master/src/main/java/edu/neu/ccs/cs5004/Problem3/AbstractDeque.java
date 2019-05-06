package edu.neu.ccs.cs5004.Problem3;

import java.util.Objects;

/**
 * Represents an Abstract Deque, which implements IDeque, with it's details--the
 * first node in the deque and the last node in the deque as nodes.
 */
public abstract class AbstractDeque implements IDeque {
  protected Node first;
  protected Node last;

  /**
   * Creates a new empty deque.
   */
  public AbstractDeque(){
    this.first = null;
    this.last = null;
  }

  /**
   * Returns the first integer in the deque.
   * @return the first integer in the deque.
   */
  public Node getFirst() {
    return first;
  }

  /**
   * Sets the first integer in the deque.
   * @param first the integer you want to make the first in the deque.
   */
  public void setFirst(Node first) {
    this.first = first;
  }

  /**
   * Returns the last integer in the deque.
   * @return the last integer in the deque.
   */
  public Node getLast() {
    return last;
  }

  /**
   * Sets the last integer in the deque.
   * @param last the last integer in the deque.
   */
  public void setLast(Node last) {
    this.last = last;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public abstract IDeque emptyDeque();

  /**
   * {@inheritDoc}.
   */
  @Override
  public Boolean isEmpty() {
    return (first == null && last == null);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer size() {
    int total = 0;
    Node following = this.first;
    while (!(following == null)){
      total += 1;
      following = following.nextNode;
    }

    return total;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public IDeque removerFirst() throws IllegalOperationException {
    if (isEmpty()){
      throw new IllegalOperationException ("You can't perform this operation on an empty deque.");
    }

    else {
      if (this.size() > 1) {
        Node holder = this.first;
        holder = holder.nextNode;
        this.first = holder;
      }

      else {
        this.setFirst(null);
        this.setLast(null);
      }
      return this;
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer peek() throws IllegalOperationException {
   if(isEmpty()){
     throw new IllegalOperationException("You can't perform this operation on an empty deque.");
   }

   return this.first.getValue();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractDeque)) {
      return false;
    }
    AbstractDeque that = (AbstractDeque) o;
    return Objects.equals(first, that.first) &&
        Objects.equals(last, that.last);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return Objects.hash(first, last);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "AbstractDeque{" +
        "first value=" + first +
        ", last value=" + last +
        '}';
  }

}
