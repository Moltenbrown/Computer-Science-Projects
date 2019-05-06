package edu.neu.ccs.cs5004.Problem3;

/**
 * Represents a LIFO deque which extends an Abstract Deque.
 *
 * @author Goch.
 */
public class LIFODeque extends AbstractDeque{

  /**
   * Creates a new LIFO deque from a first node and a last node.
   */
  public LIFODeque(){
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
    return new LIFODeque();
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
  public IDeque addFirst(Integer n) {
    Node newFirst = new Node(n, null);
    if (isEmpty()) {
      setFirst(newFirst);
      setLast(newFirst);
    }

    else {
      newFirst.setNextNode(first);
      setFirst(newFirst);
    }
    //System.out.println(this.getFirst()); for testing.

    return this;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public IDeque addLast(Integer n) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This function doesn't work with this type of deque."
        + "Please use a FIFODeque for this method.");
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
    return this instanceof LIFODeque && super.equals(o);
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
    return super.toString();
  }
}
