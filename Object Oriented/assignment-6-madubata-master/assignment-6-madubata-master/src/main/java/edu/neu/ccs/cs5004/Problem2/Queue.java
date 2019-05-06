package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents a Queue, which extends Abstract Queue, with its details--
 * the first integer as an integer and the rest of the queue as an
 * abstract queue.
 *
 * @author Goch.
 */
public class Queue extends AbstractQueue{
  /**
   * Creates a new Queue from an integer and an Abstract Queue.
   * @param first the first integer in the queue.
   * @param rest the remainder of the queue.
   */
  public Queue(Integer first, AbstractQueue rest){
    super(first, rest);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Queue create() {
    return new Queue(null, null);
  }

  /**
   * {@inheritDoc}.
   */
  public Boolean isEmpty(){
    return (this.first == null && this.rest == null);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void enqueue(Integer n){
    if(this.first == null){
      setFirst(n);
      setRest(create());
    }

    else{
      this.rest.enqueue(n);
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer dequeue() throws Exception{
    if(this.first == null){
      throw new IllegalAccessException("There are no integers to remove.");
    }

    else{
      Integer returnNumber = getFirst();
      Queue newQueue = (Queue) this.rest;
      setFirst(newQueue.first);
      setRest(newQueue.rest);
      return returnNumber;
    }
  }

  /**
   * Creates a new queue with the integer removed if the integer is in the queue.
   * @param n the integer to be removed.
   * @return an new queue with the integer removed.
   */
  public Queue removeHelper(Integer n){
    if(isEmpty()){
      return create();
    }

    if(this.first == n){
      Queue newQueue = (Queue) this.rest;
      setFirst(newQueue.first);
      setRest(newQueue.rest);
      return this;
    }

    else{
      Queue newQueue = (Queue) this.rest;
      return new Queue(this.first, newQueue.removeHelper(n));
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void remove(Integer n) throws Exception{
    if(isEmpty()){
      create();
    }

    else{
      if(this.first == n){
        Queue newQueue = (Queue) this.rest;
        setFirst(newQueue.first);
        setRest(newQueue.rest);
      }
      else{
        setFirst(this.first);
        Queue newQueue = (Queue) this.rest;
        setRest(newQueue.removeHelper(n));
      }
    }
  }

  public Integer size(){
    int total = 0;
    if(!isEmpty()){
      total += 1;
      total += this.rest.size();
    }

    else{
      total += 0;
    }

    return new Integer(total);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Returns a string listing what is in the queue.
   *
   * @return a string listing what is in the queue.
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
