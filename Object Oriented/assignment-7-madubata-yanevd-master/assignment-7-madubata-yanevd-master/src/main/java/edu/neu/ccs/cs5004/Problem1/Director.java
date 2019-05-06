package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents a Director which is an extension of AbstractPerson.
 *
 * @author Goch.
 */
public class Director extends AbstractPerson {

  /**
   * Creates a new director from a first name and a last name.
   * @param firstName the director's first name.
   * @param lastName the director's last name.
   */
  public Director(String firstName, String lastName){
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
