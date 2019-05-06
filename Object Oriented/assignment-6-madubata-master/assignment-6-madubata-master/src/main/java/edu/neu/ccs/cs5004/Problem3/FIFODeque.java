package edu.neu.ccs.cs5004.Problem3;

/**
 * Represents a FIFODeque which extends an Abstract Deque.
 *
 * @author Goch.
 */
public class FIFODeque extends AbstractDeque {

  /**
   * Creates a new FIFO deque from a first node and a last node.
   */
  public FIFODeque() {
    super();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Node getFirst() {
    return super.getFirst();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void setFirst(Node first) {
    super.setFirst(first);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Node getLast() {
    return super.getLast();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void setLast(Node last) {
    super.setLast(last);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public IDeque emptyDeque() {
    return new FIFODeque();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Boolean isEmpty() {
    return super.isEmpty();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer size() {
    return super.size();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public IDeque addLast(Integer n) throws UnsupportedOperationException {
    Node newFirst = new Node(n, null);
    if (isEmpty()) {
      setFirst(newFirst);
      setLast(newFirst);
    } else {
      Node temp = this.getFirst();
      Node prev = null;
      while (temp != null) {
        prev = temp;
        temp = temp.getNextNode();
      }
      prev.setNextNode(newFirst);
      this.last = prev.nextNode;
    }

    return this;
  }


  /**
   * {@inheritDoc}.
   */
  @Override
  public IDeque addFirst(Integer n) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("You can't perform this function on this deque type."
        + "Please use a LIFO Deque for this function.");
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public IDeque removerFirst() throws IllegalOperationException {
    return super.removerFirst();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer peek() throws IllegalOperationException {
    return super.peek();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object o) {
    return this instanceof FIFODeque && super.equals(o);
  }


  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
//    return this.getFirst().toString();
    return super.toString();
  }
}
