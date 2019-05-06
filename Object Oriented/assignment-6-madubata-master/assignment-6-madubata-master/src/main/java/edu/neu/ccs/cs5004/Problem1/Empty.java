package edu.neu.ccs.cs5004.Problem1;

import java.util.HashMap;
import java.util.Objects;

/**
 * Represents an empty bag of words.
 *
 * @author Goch
 */
public class Empty implements IBagOfWords{
  public Empty() {
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public IBagOfWords emptyBagOfWords() {
    return new Empty();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public BagOfWords add(String s) {
    return new BagOfWords(s, new Empty());
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Boolean contains(String s) {
    return false;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public IBagOfWords remove(String s) {
    return new Empty();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Empty){
      return true;
    }

    return false;
  }

  /**
   * Returns a string stating that this is an empty bag of books.
   * @return a string stating that this is an empty bag of books.
   */
  @Override
  public String toString() {
    return "Empty{}";
  }
}
