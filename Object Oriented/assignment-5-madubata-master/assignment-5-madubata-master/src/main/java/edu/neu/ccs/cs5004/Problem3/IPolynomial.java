package edu.neu.ccs.cs5004.Problem3;

/**
 * Represents the implementation for a Polynomial with most the methods that a
 * Polynomial uses.
 *
 * @author Goch
 */
public interface IPolynomial {

  /**
   * Returns a new, updated polynomial with the a new polynomial added to the existing
   * polynomial that contains the coefficient and power.
   * @param coefficient the new polynomial's coefficient.
   * @param power the new polynomial's power.
   * @return a new, updated polynomial with a new polynomial is added.
   */
  Polynomial addTerm(Integer coefficient, Integer power);

  /**
   * Returns a new, updated polynomial with all instances of polynomials of that power
   * removed.
   * @param power the power of the polynomials we are trying to remove.
   * @return a new, updated polynomial without polynomials of that power.
   */
  Polynomial removeTerm(Integer power);

  /**
   * Returns the degree of the polynomial.
   * @return the degree of the polynomial.
   */
  Integer getDegree();

  /**
   * Returns the coefficient associated with the power.
   * @param power the power of the coefficient we are looking for.
   * @return the coefficient associated with that power.
   */
  Integer getCoefficient(Integer power);

  /**
   * Evaluates whether the polynomial is the same and the current polynomial.
   * @return true if the polynomial is the same as the current polynomials,
   * false otherwise.
   */
  Boolean isSame(Polynomial polynomial);

  /**
   * Takes a number, inserts it into the polynomial and returns the total as a double.
   * @param number the current value of the variable.
   * @return the total of the variable,
   */
  double evaluate(double number);

  /**
   * Returns an updated polynomial that is the total of the addition of the
   * current polynomial and the polynomial.
   * @param polynomial the polynomial we are adding to the current polynomial.
   * @return the polynomial total of the current polynomial and the polynomial.
   */
  Polynomial add(Polynomial polynomial);

  /**
   * Returns an updated polynomial that is the total of the multiplication of
   * the current polynomial and the polynomial.
   * @param polynomial the polynomial multiplied to the current polynomial.
   * @return the polynomial total of the current polynomial multiplied by the
   * polynomial.
   */
  Polynomial multiply(Polynomial polynomial);
}
