package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents a Main Actor, an extension of AbstractPerson.
 *
 * @author Goch.
 */
public class MainActor extends AbstractPerson {

  /**
   * Creates a new main actor from a first name and a last name.
   * @param firstName the main actor's first name.
   * @param lastName the main actor's last name.
   */
  public MainActor(String firstName, String lastName){
    super(firstName, lastName);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getFirstName() {
    return super.getFirstName();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getLastName() {
    return super.getLastName();
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
