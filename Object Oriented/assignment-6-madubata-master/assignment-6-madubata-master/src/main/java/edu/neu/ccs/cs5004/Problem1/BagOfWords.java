package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents a Bag of Words with its details--the first word as a string and the remaining
 * words in the bag of words as a Bag of Words.
 *
 * @author Goch
 */
public class BagOfWords implements IBagOfWords{
  private String first;
  private IBagOfWords rest;

  /**
   * Creates a bag of words from a string and a bag of words.
   * @param first the first word in the bag of words.
   * @param rest the remaining words in the bag of words.
   */
  public BagOfWords(String first, IBagOfWords rest){
    this.first = first;
    this.rest = rest;
  }

  /**
   * Returns the first word in the bag of words.
   * @return the first word in the bag of words.
   */
  public String getFirst(){
    return first;
  }

  /**
   * Returns the rest of the words in the bag of words.
   * @return the rest of the words in the bag of words.
   */
  public IBagOfWords getRest(){
    return rest;
  }

  /**
   * {@inheritDoc}.
   */
  public IBagOfWords emptyBagOfWords(){
    return new Empty();
  }

  /**
   * {@inheritDoc}.
   */
  public Boolean isEmpty(){
    return this.equals(new Empty());
  }

  /**
   * {@inheritDoc}.
   */
  public Integer size(){
    int total = 0;
    if(!this.first.equals(new Empty())){
      total += 1;
      total += this.rest.size();
    }

    else {
      total += 0;
    }
    return new Integer(total);
  }

  /**
   * {@inheritDoc}.
   */
  public BagOfWords add(String s){
    return new BagOfWords(s, new BagOfWords(this.first, this.rest));
  }

  /**
   * {@inheritDoc}.
   */
  public Boolean contains(String s){
    if(this.first.equals(s)){
      return new Boolean(true);
    }

    else{
      return this.rest.contains(s);
    }
  }

  /**
   * {@inheritDoc}.
   */
  public IBagOfWords remove(String s){
    if(isEmpty()){
      return new Empty();
    }

    if(this.first == s){
      return this.rest;
    }

    else{
      return new BagOfWords(this.first, this.rest.remove(s));
    }
  }


  /**
   * Evaluates whether an object is the same as a bag of words.
   * @param o the object being compared to the bag of words.
   * @return true if the object is the same as the bag of words, false,
   * otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o){
      return true;
    }

    if (o == null || getClass() != o.getClass()){
      return false;
    }
    if (!(o instanceof IBagOfWords)) {
      return false;
    }

    BagOfWords that = (BagOfWords) o;
    if(!that.contains(getFirst())){
      return false;
    }
    if(that.first == getFirst() && that.rest == getRest()){
      return true;
    }
    if(size() != that.size()){
      return false;
    }

    if(that.contains(getFirst())){
      return that.remove(getFirst()).equals(getRest());
    }

    return true;
  }

  /**
   * Returns the integer hashcode representation of the bag of words.
   * @return the integer hashcode representation of the bag of words.
   */
  @Override
  public int hashCode() {

    return Objects.hash(first, rest);
  }

  /**
   * Returns a string describing the bag of words, with information about the first
   * word and the rest fo the words.
   * @return a string describing the bag of words.
   */
  @Override
  public String toString() {
    return "BagOfWords{" +
        "first='" + first + '\'' +
        ", rest=" + rest +
        '}';
  }
}
