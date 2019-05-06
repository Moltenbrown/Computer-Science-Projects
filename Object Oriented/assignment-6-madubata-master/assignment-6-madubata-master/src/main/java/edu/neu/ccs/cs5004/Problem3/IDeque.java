package edu.neu.ccs.cs5004.Problem3;

/**
 * Represents an interface for a deque with all the methods a deque
 * implements.
 *
 * @author Goch
 */
public interface IDeque {

  /**
   * Creates a new empty deque.
   * @return an empty deque.
   */
  IDeque emptyDeque();

  /**
   * Evaluates whether the deque is empty.
   * @return true if the deque is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Returns the amount of elements there are in the deque.
   * @return the amount of elements there are in the deque.
   */
  Integer size();

  /**
   * Returns either an updated LIFO Deque with the n as the first element
   * of the deque and the original deque in original order as the remainder
   * of the deque or throws an unsupported operation exception if the
   * methods is performed on a FIFO Deque.
   * @param n the element to be added to the beginning of the deque.
   * @return an updated LIFO deque with n at the beginning of what was the
   * original LIFO.
   * @throws UnsupportedOperationException if this methods is used on a
   * FIFO deque.
   */
  IDeque addFirst(Integer n) throws UnsupportedOperationException;

  /**
   * Returns either an updated FIFO deque with n as the last element, preceded
   * by the original FIFO or throws an exception if a LIFO deque uses this method.
   * @param n the element to be added to the deque.
   * @return an updated FIFO deque with n as the last element of the original FIFO.
   * @throws UnsupportedOperationException if a LIFO deque uses this method.
   */
  IDeque addLast(Integer n) throws UnsupportedOperationException;

  /**
   * Returns an updated deque with the first element removed or throws an exception
   * if this is used on an empty deque.
   * @return an updated deque with the first element removed.
   * @throws IllegalOperationException if this method is used on an empty deque.
   */
  IDeque removerFirst() throws IllegalOperationException;

  /**
   * Returns the first element of the deque without changing the deque or throws an
   * exception if this method is used on an empty deque.
   * @return the first element of the deque.
   * @throws IllegalOperationException if this method is used on an empty deque.
   */
  Integer peek() throws IllegalOperationException;
}
