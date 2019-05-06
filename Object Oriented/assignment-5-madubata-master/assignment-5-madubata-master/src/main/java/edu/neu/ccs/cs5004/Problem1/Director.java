package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents a Director, which is a type of Abstract Movie Collaborator.
 *
 * @author Goch
 */
public class Director extends AbstractMovieCollaborator{

  /**
   * {@inheritDoc}.
   */
  public Director(Person name, LastScene lastScene){
    super(name, lastScene);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Person getName() {
    return super.getName();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public LastScene getLastScene() {
    return super.getLastScene();
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
}
