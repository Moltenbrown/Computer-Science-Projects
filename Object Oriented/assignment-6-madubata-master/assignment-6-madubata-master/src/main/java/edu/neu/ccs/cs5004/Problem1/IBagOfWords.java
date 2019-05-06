package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents the interface for Bag of Words with all the methods for
 * a Bag of Words.
 *
 * @author Goch
 */
public interface IBagOfWords {
  /**
   * Creates an empty bag of words.
   * @return an empty bag of words.
   */
  IBagOfWords emptyBagOfWords();

  /**
   * Evaluates whether or not the bag of words is empty.
   * @return true if the bag of words is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Returns the amount of words there are in the bag of words
   * as an integer.
   * @return the amount of words in the bag of words.
   */
  Integer size();

  /**
   * Returns an updated bag of words with the new word added to it.
   * @param s the word we are adding to the bag of words.
   * @return an updated bag of words.
   */
  BagOfWords add(String s);

  /**
   * Evaluates whether or not the bag of words contains a word.
   * @param s the word we are searching for.
   * @return true if the bag of words contains the word, false if the
   * bag of words is either empty or doesn't contain the bag of words.
   */
  Boolean contains(String s);

  /**
   * Returns an updated bag of words with the string removed.
   * @param s the string to remove.
   * @return an updated bag of words with the string removed, if
   * the string was part of that word.
   */
  IBagOfWords remove(String s);
}
