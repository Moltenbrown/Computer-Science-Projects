package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

/**
 * Represents a AbstractUPPair, which implements IUPPair, with its details--
 * its username and its password as strings.
 *
 * @author Goch
 */
public abstract class AbstractUPPair implements IUPPair{
  private String username;
  private String password;

  /**
   * {@inheritDoc}.
   */
  public AbstractUPPair(String username, String password){
    this.username = username;
    this.password = password;
  }

  /**
   * {@inheritDoc}.
   */
  public String getUsername() {
    return username;
  }

  /**
   * {@inheritDoc}.
   */
  public AbstractUPPair createEmpty(){
    return new Empty();
  }

  /**
   * {@inheritDoc}.
   */
  public Boolean isEmpty(){
    if(this.username == null && this.password == null){
      return new Boolean(true);
    }

    return new Boolean(false);
  }

  /**
   * {@inheritDoc}.
   */
  abstract public AbstractUPPair add(String username, String password) throws
      PairAlreadyInitializedException;

  /**
   * {@inheritDoc}.
   */
  abstract public AbstractUPPair replace(String username, String password) throws
      PairEmptyException;

  /**
   * {@inheritDoc}.
   */
  abstract public AbstractUPPair delete(String username) throws InvalidUsernameException;

  /**
   * Evaluates whether an object is equal to the uppair.
   * @param o the object being compared to the uppair.
   * @return true is the object is the same as the uppair, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractUPPair)) {
      return false;
    }
    AbstractUPPair abstractUpPair = (AbstractUPPair) o;
    return Objects.equals(username, abstractUpPair.username) &&
        Objects.equals(password, abstractUpPair.password);
  }

  /**
   * Returns an integer hashcode representation of the uppair.
   * @return an integer hashcode representation of a uppair.
   */
  @Override
  public int hashCode() {

    return Objects.hash(username, password);
  }

  /**
   * Returns a string stating the username and password of the uppair.
   * @return a string stating the username and password of the uppair.
   */
  @Override
  public String toString() {
    return "AbstractUPPair{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  /**
   * {@inheritDoc}.
   */
  public String getPassword(String username) throws Exception{
    if(this.username == null && this.password == null){
      throw new PairEmptyException("This AbstractUPPair is empty, so there is no password.");
    }

    else if (this.username == username){
      return this.password;
    }

    else{
      throw new InvalidUsernameException("The username entered isn't the same as the username"
          + " of the current uppair.");
    }
  }
}
