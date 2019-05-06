package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

/**
 * Represents an Abstract Queue that implements IQueue.
 *
 * @author Goch.
 */
public abstract class AbstractQueue implements IQueue{
  Integer first;
  IQueue rest;

  /**
   * Creates an Abstract Queue from an integer and an iqueue.
   * @param first the first integer added to the queue.
   * @param rest the rest of the queue.
   */
  public AbstractQueue(Integer first, IQueue rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Returns the first integer in the queue.
   * @return the first integer in the queue.
   */
  public Integer getFirst() {
    return first;
  }

  /**
   * Changes the first integer in the queue.
   * @param first the integer we are changing the first integer in the queue to.
   */
  public void setFirst(Integer first) {
    this.first = first;
  }

  /**
   * Returns the rest of the queue as an iqueue.
   * @return the remainder of the queue.
   */
  public IQueue getRest() {
    return rest;
  }

  /**
   * Changes the rest of the queue to the iqueue the user provided.
   * @param rest the iqueue the user wants to replace the current rest of the queue with.
   */
  public void setRest(IQueue rest) {
    this.rest = rest;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractQueue)) {
      return false;
    }
    AbstractQueue that = (AbstractQueue) o;
    return Objects.equals(first, that.first) &&
        Objects.equals(rest, that.rest);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return Objects.hash(first, rest);
  }

  /**
   * Returns a string listing what is in the queue.
   * @return a string listing what is in the queue.
   */
  @Override
  public String toString() {
    return "AbstractQueue{" +
        "first=" + first +
        ", rest=" + rest +
        '}';
  }
}
