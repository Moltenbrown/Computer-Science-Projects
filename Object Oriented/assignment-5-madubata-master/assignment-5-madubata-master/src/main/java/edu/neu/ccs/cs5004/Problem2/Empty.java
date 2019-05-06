package edu.neu.ccs.cs5004.Problem2;

/**
 * Represents an Zero Abstract UPPair.
 *
 * @author Goch
 */
public class Empty extends AbstractUPPair {

  /**
   * Creates a new empty abstract uppair.
   */
  public Empty(){
    super(null, null);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getUsername() {
    return null;
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
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return super.toString();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractUPPair createEmpty() {
    return super.createEmpty();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractUPPair add(String username, String password) throws PairAlreadyInitializedException {
    return new NonEmptyUPPair(username, password);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractUPPair replace(String username, String password) throws PairEmptyException {
    throw new PairEmptyException("There is no pair to replace.");
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractUPPair delete(String username) throws InvalidUsernameException {
    return new Empty();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getPassword(String username) throws Exception {
    return super.getPassword(username);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Boolean isEmpty(){
    return super.isEmpty();
  }
}
