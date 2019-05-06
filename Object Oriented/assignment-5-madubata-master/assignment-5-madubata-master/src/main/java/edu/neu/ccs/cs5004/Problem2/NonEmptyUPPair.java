package edu.neu.ccs.cs5004.Problem2;

public class NonEmptyUPPair extends AbstractUPPair{

  /**
   * {@inheritDoc}.
   */
  public NonEmptyUPPair(String username, String password) {
    super(username, password);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getUsername() {
    return super.getUsername();
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
  public Boolean isEmpty() {
    return super.isEmpty();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractUPPair add(String username, String password)
      throws PairAlreadyInitializedException {
    if(!isEmpty()){
      throw new PairAlreadyInitializedException("This pair has already been initialized.");
    }

    else{
      return new NonEmptyUPPair(username, password);
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractUPPair replace(String username, String password) throws PairEmptyException {
    if(!isEmpty()){
      return new NonEmptyUPPair(username, password);
    }

    else{
      throw new PairEmptyException("This pair is empty. You can't replace an empty pair.");
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractUPPair delete(String username) throws InvalidUsernameException {
    if(isEmpty()){
      return new Empty();
    }

    else if(getUsername() == username){
      return new Empty();
    }

    else{
      throw new InvalidUsernameException("There is not a UPPair that corresponds with this "
          + "username.");
    }
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
  public String getPassword(String username) throws Exception {
    return super.getPassword(username);
  }
}
