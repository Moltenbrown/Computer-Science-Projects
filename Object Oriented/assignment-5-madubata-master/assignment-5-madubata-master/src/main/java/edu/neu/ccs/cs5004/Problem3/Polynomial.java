package edu.neu.ccs.cs5004.Problem3;

import java.util.Objects;
import sun.security.util.PolicyUtil;

/**
 * Represents a Polynomial, which implements IPolynomial, with its details--the leading term
 * coeffient and power as Integers and a polynomial containing the remaining terms of the
 * Polynomial as a Polynomial.
 */
public class Polynomial implements IPolynomial{
  Integer coefficient;
  Integer power;
  Polynomial polynomial;

  /**
   * Creates a new polynomial with all fields set to null.
   */
  public Polynomial(){
    this.coefficient = null;
    this.power = null;
    this.polynomial = null;
  }

  /**
   * Creates a new Polynomial with the fourth, third, second, first, and none acting as the
   * respectively, the coefficients for the fourth, third, second, first, and zero powers
   * of the polynomial.
   * @param fourth the coefficient for the fourth power of the polynomial.
   * @param third the coefficient for the third power of the polynomial.
   * @param second the coefficient for the second power of the polynomial.
   * @param first the coefficient for the first power of the polynomial.
   * @param none a constant of the polynomial.
   */
  public Polynomial(Integer fourth, Integer third, Integer second, Integer first, Integer none){
    if(fourth != 0){
      this.coefficient = fourth;
      this.power = new Integer(4);
      this.polynomial = new Polynomial();
    }

    if(third != 0){
      if (fourth != 0){
        this.polynomial = this.polynomial.addTerm(third, new Integer(3));
      }

      else {
        this.coefficient = third;
        this.power = new Integer(3);
        this.polynomial = new Polynomial();
      }
    }

    if(second != 0){
      if(third != 0 || fourth != 0){
        this.polynomial = this.polynomial.addTerm(second, new Integer(2));
      }

      else {
        this.coefficient = second;
        this.power = new Integer(2);
        this.polynomial = new Polynomial();
      }
    }

    if(first != 0){
      if(second != 0 || third != 0 || fourth != 0) {
        this.polynomial = this.polynomial.addTerm(first, new Integer(1));
      }

      else {
        this.coefficient = first;
        this.power = new Integer(1);
        this.polynomial = new Polynomial();
      }
    }

    if(none != 0){
      if(first != 0 || second != 0 || third != 0 || fourth != 0) {
        this.polynomial = this.polynomial.addTerm(none, new Integer(0));
      }

      else {
        this.coefficient = none;
        this.power = new Integer(0);
        this.polynomial = new Polynomial();
      }
    }
  }

  /**
   * Evaluates whether or not a polynomial is an empty polynomial.
   * @return true if the polynomial is empty, false otherwise.
   */
  public boolean isEmpty(){
    if(this.coefficient == null && this.power == null && this.polynomial == null){
      return true;
    }

    else {
      return false;
    }
  }

  /**
   * A private constructor for polynomial so I can define the coefficient, power
   * and polynomial.
   * @param coefficient the front coefficient of the polynomial.
   * @param power the front power of the polynomial.
   * @param polynomial the remainder of the polynomial.
   */
  private Polynomial(Integer coefficient, Integer power, Polynomial polynomial) {
    this.coefficient = coefficient;
    this.power = power;
    this.polynomial = polynomial;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Polynomial addTerm(Integer coefficient, Integer power){
    if(coefficient == 0){
      return this;
    }

    else {
      if (this.power != null) {
        if (power < this.power) {
          return new Polynomial(this.coefficient, this.power,
              this.polynomial.addTerm(coefficient, power));
        } else {
          return new Polynomial(coefficient, power, this);
        }
      }

      else {
        return new Polynomial(coefficient, power, this);
      }
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Polynomial removeTerm(Integer power){
    if(!isEmpty()) {
      if (this.power.equals(power)) {
        return new Polynomial(this.polynomial.coefficient, this.polynomial.power,
            this.polynomial.polynomial);
      } else {
        return new Polynomial(this.coefficient, this.power,
            this.polynomial.removeTerm(power));
      }
    }

    else{
      return new Polynomial(this.coefficient, this.power, this.polynomial);
    }
  }

  /**
   * {@inheritDoc}.
   */
  public Integer getDegree(){
    return this.power;
  }

  /**
   * {@inheritDoc}.
   */
  public Integer getCoefficient(Integer power){
    if(this.power.equals(power)){
      return this.coefficient;
    }

    else{
      return this.polynomial.getCoefficient(power);
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Boolean isSame(Polynomial polynomial){
    Polynomial holder = this;
    while (!holder.isEmpty()) {
      if (!(holder.power.equals(polynomial.power)) ||
          !(holder.coefficient.equals(polynomial.coefficient))) {
        return false;
      }

      holder = holder.polynomial;
      polynomial = polynomial.polynomial;
    }

    if (!polynomial.isEmpty()) {
      return false;
    }

    return true;
  }

  /**
   * Returns the total of when a number if raised the the power of the polynomial and
   * that value is multiplied by the coefficient of the polynomial.
   * @param number the number being raised by the power.
   * @return the total when that number if raised by the power of the polynomial and
   * that value is multipled by the coefficient of the polynomial.
   */
  private double evaluateHelper(double number){
    return coefficient * Math.pow(number, power);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public double evaluate(double number){
    double total = 0;
    Polynomial holder = this;
    while (!holder.isEmpty()){
      total += holder.evaluateHelper(number);
      holder = holder.polynomial;
    }

    return total;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Polynomial add(Polynomial polynomial) {
    Polynomial holder = new Polynomial(null, null, null);
    Polynomial decrease = this;
    Polynomial addition = polynomial;
    if(addition.isEmpty()){
      while(!decrease.isEmpty()){
        holder = holder.addTerm(decrease.coefficient, decrease.power);
        decrease = decrease.polynomial;
      }
    }

    else {
      while (!decrease.isEmpty()) {
        if (decrease.power.equals(addition.power)) {
          Integer newCoefficient = decrease.coefficient + addition.coefficient;
          holder = holder.addTerm(newCoefficient, decrease.power);
          decrease = decrease.polynomial;
          addition = addition.polynomial;
        }

        else {
          if (decrease.power > addition.power) {
            holder = holder.addTerm(decrease.coefficient, decrease.power);
            decrease = decrease.polynomial;
          }

          else {
            holder = holder.addTerm(addition.coefficient, addition.power);
            addition = addition.polynomial;
          }
        }
      }

      if(!addition.isEmpty()){
        while(!addition.isEmpty()){
          holder = holder.addTerm(addition.coefficient, addition.power);
          addition = addition.polynomial;
        }
      }
    }

    return holder;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Polynomial multiply(Polynomial polynomial) {
    Polynomial holder = new Polynomial(null, null, null);
    Polynomial additive = new Polynomial(null, null, null);
    Polynomial decrease = this;
    Polynomial something = polynomial;
    if(something.isEmpty()){
      return holder;
    }

    else {
      while (!something.isEmpty()) {
        while (!decrease.isEmpty()) {
          Integer newCoefficient = decrease.coefficient * something.coefficient;
          Integer newPower = decrease.power + something.power;
          holder = holder.addTerm(newCoefficient, newPower);
          decrease = decrease.polynomial;
        }

        additive = additive.add(holder);
        something = something.polynomial;
        decrease = this;
        holder = new Polynomial();
      }
    }

    return additive;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Polynomial)) {
      return false;
    }
    Polynomial that = (Polynomial) o;
    return Objects.equals(coefficient, that.coefficient) &&
        Objects.equals(power, that.power) &&
        Objects.equals(polynomial, that.polynomial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coefficient, power, polynomial);
  }

  @Override
  public String toString() {
    return "Polynomial{" +
        "coefficient=" + coefficient +
        ", power=" + power +
        ", polynomial=" + polynomial +
        '}';
  }
}
