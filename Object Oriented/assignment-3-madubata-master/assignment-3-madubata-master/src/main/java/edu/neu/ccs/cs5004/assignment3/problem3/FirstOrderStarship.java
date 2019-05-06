package edu.neu.ccs.cs5004.assignment3.problem3;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a First Order Starship, which extends Abstract Starship, with its details--
 * the first order ship type as a first order ship type and the attack range as an attack
 * range.
 *
 * @author Goch
 */
public class FirstOrderStarship extends AbstractStarship{
  private FirstOrderShipType firstOrderShipType;
  private AttackRange attackRange;

  /**
   * Creates a new first order starship from a fuel level, destruction level, and first order ship
   * type.
   * @param fuelLevel the starship's fuel level.
   * @param destructionLevel the starship's destruction level.
   * @param firstOrderShipType the starship's first order ship type.
   * @throws Exception if any of the exception causing events for an Abstract Ship occur.
   */
  public FirstOrderStarship(Integer fuelLevel, Integer destructionLevel,
      FirstOrderShipType firstOrderShipType) throws Exception{
    super(fuelLevel, destructionLevel);
    this.firstOrderShipType = firstOrderShipType;
    if(firstOrderShipType == FirstOrderShipType.StarDestroyer){
      this.attackRange = new AttackRange(0, 50);
    }

    else{
      this.attackRange = new AttackRange(0, 25);
    }
  }

  public FirstOrderShipType getFirstOrderShipType() {
    return firstOrderShipType;
  }

  public AttackRange getAttackRange() {
    return attackRange;
  }

  /**
   {@inheritDoc}.
   */
  @Override
  public Integer addFuel(Integer value) throws OutOfBoundsException {
    return super.addFuel(value);
  }

  /**
   {@inheritDoc}.
   */
  @Override
  public Integer subtractFuel(Integer value) throws OutOfBoundsException {
    return super.subtractFuel(value);
  }

  /**
   {@inheritDoc}.
   */
  @Override
  public Integer fuelTracker(Integer value, FuelAction fuelAction) throws Exception {
    return super.fuelTracker(value, fuelAction);
  }

  /**
   * Returns a new first order starship with an updated fuel amount.
   * @param value the amount you want to either raise or lower the fuel level.
   * @param fuelAction whether you want to add or subtract to the fuel level.
   * @return a new first order starship with an updated fuel amount.
   * @throws Exception if the adding or subtracting the fuel amount would trigger an exception.
   */
  public FirstOrderStarship updatedFuel(Integer value, FuelAction fuelAction) throws Exception {
    return new FirstOrderStarship(fuelTracker(value, fuelAction), this.destructionLevel,
        this.firstOrderShipType);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer destructionTracker(Integer value) throws Exception {
    return super.destructionTracker(value);
  }

  /**
   * Return an updated first order starship with an increased destruction level.
   * @param value the amount you want to raise the destruction level by.
   * @return a new first order starship with an increased destruction level.
   * @throws Exception when the destruction level reaches 100 and the ship would be dead.
   */
  public FirstOrderStarship updatedDestruction(Integer  value) throws Exception {
    return new FirstOrderStarship(this.fuelLevel, destructionTracker(value),
        this.firstOrderShipType);
  }

  /**
   * Returns an integer representing the attack.
   * @return an integer representing the attack.
   */
  public Integer attack(){
    Random rand = new Random();
    return new Integer(rand.nextInt(attackRange.getHigh() + 1));
  }

  /**
   * Evaluates whether the object being compared to the first order starship is the same
   * as the first order starship.
   * @param o the object being compared to the first order starship.
   * @return true if the object is the same as the first order starship, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FirstOrderStarship)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    FirstOrderStarship that = (FirstOrderStarship) o;
    return firstOrderShipType == that.firstOrderShipType &&
        Objects.equals(attackRange, that.attackRange);
  }

  /**
   * Returns an integer hashcode representation of the first order starship.
   * @return an integer hashcode representation of the first order starship.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), firstOrderShipType, attackRange);
  }

  /**
   * Returns a string representation of the first order starship.
   * @return a string representation of the first order starship.
   */
  @Override
  public String toString() {
    return "FirstOrderStarship{" +
        "firstOrderShipType=" + firstOrderShipType +
        ", attackRange=" + attackRange +
        '}' + super.toString();
  }
}
