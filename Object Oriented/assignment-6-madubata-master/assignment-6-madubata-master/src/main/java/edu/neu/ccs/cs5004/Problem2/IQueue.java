package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents an interface for a Queue, listing all the methods
 * all the queues methods.
 *
 * @author Goch.
 */
public interface IQueue {

  /**
   * Returns an empty queue.
   * @return an empty queue.
   */
  IQueue create();

  /**
   * Returns whether or not the queue is empty.
   * @return true if the queue is empty and false otherwise.
   */
  Boolean isEmpty();

  /**
   * Adds an element into the queue.
   * @param n the element being added to the queue.
   */
  void enqueue(Integer n);

  /**
   * Removes the oldest element from the queue is to the
   * user.
   * @return the oldest element in the queue.
   */
  Integer dequeue() throws Exception;

  /**
   * Removes the selected integer from the queue.
   * @param n the integer we are trying to remove
   * from the queue.
   */
  void remove (Integer n) throws Exception;

  /**
   * Returns how many elements there are in the queue.
   * @return how many elements there are in the queue.
   */
  Integer size();
}
