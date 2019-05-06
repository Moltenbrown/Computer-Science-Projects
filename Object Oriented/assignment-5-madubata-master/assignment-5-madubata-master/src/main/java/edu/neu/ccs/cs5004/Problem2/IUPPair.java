package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents the implementation for a UPPair with most the methods that an
 *  Abstract UPPair will use.
 *
 * @author Goch
 */
public interface IUPPair {

  /**
   * Creates an empty uppair where both the username and password
   * are set to null.
   * @return a new empty uppair.
   */
  AbstractUPPair createEmpty();

  /**
   * Evaluates whether or not the uppair is empty or not.
   * @return true is the uppair is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Returns a new pair with the entered username and password is the current uppair is empty.
   * @param username the username we are trying to put in the new uppair.
   * @param password the password we are trying to put in the new uppair.
   * @return a new uppair from the enter username and password.
   * @throws PairAlreadyInitializedException when the current uppair already has a username and password
   * and isn't empty.
   */
  AbstractUPPair add(String username, String password) throws PairAlreadyInitializedException;

  /**
   * Returns a new uppair from the username and password entered or throws an exception
   * if the current uppair is empty.
   * @param username the username of the new uppair.
   * @param password the password of the new uppair.
   * @return a new uppair using the entered username and password.
   * @throws PairEmptyException if the current pair is empty.
   */
  AbstractUPPair replace(String username, String password) throws PairEmptyException;

  /**
   * Returns a new empty uppair is the username entered matches the username
   * of the current uppair or if the current uppair is empty.
   * @param username the username we are comparing to the username of the
   * current uppair.
   * @return a new empty uppair.
   * @throws InvalidUsernameException if the username of the current uppair is
   * isn't the same as the enter username or the current uppair isn't empty.
   */
  AbstractUPPair delete(String username) throws InvalidUsernameException;

  /**
   * Returns the password of the current uppair if the username matches
   * the username entered into the method. Otherwise, an exception is thrown.
   * @param username the username we are checking for in the AbstractUPPair.
   * @return the password of the uppair.
   * @throws Exception if the uppair is empty or if the uppair username is
   * different from the username entered into the method.
   */
  String getPassword(String username) throws Exception;
}
