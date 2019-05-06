package edu.neu.ccs.cs5004.assignment3.problem3;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a Resistance Starship, which extends and Abstract Starship, with its details--
 * the resistance ship type as a resistance ship type and the attack range as an attack range.
 *
 * @author Goch
 */
public class ResistanceStarship extends AbstractStarship{
  private ResistanceShipType resistanceShipType;
  private AttackRange attackRange;

  /**
   * Creates a new resistance starship from a fuel level, destruction level, and a
   * resistance ship type.
   * @param fuelLevel the current fuel level of the new resistance ship.
   * @param destructionLevel the current destruction level of the new resistance ship.
   * @param resistanceShipType the resistance ship type the resistance ship is.
   * @throws Exception if the destruction level or fuel level are outside of the
   * required range.
   */
  public ResistanceStarship(Integer fuelLevel, Integer destructionLevel,
      ResistanceShipType resistanceShipType) throws Exception{
    super(fuelLevel, destructionLevel);

    this.resistanceShipType = resistanceShipType;

    if(resistanceShipType == ResistanceShipType.AWingFighter){
      this.attackRange = new AttackRange(0, 30);
    }

    else{
      this.attackRange = new AttackRange(0, 40);
    }
  }

  /**
   * Returns the type of resistance ship the starship is.
   * @return the resistance ship type.
   */
  public ResistanceShipType getResistanceShipType() {
    return resistanceShipType;
  }

  /**
   * Returns the attack range of the resistance ship.
   * @return the resistance ship's attack range.
   */
  public AttackRange getAttackRange() {
    return attackRange;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer addFuel(Integer value) throws OutOfBoundsException {
    return super.addFuel(value);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer subtractFuel(Integer value) throws OutOfBoundsException {
    return super.subtractFuel(value);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer fuelTracker(Integer value, FuelAction fuelAction) throws Exception {
   return super.fuelTracker(value, fuelAction);
  }

  /**
   * Creates an new resistance starship with the updated fuel level.
   * @param value the amount we want to edit the fuel level by.
   * @param fuelAction whether we want to add or substract the fuel from the
   * current fuel level.
   * @return a new resistance starship with the updated fuel level.
   * @throws Exception of one of the exceptions of their the fuel tracker method
   * or the abstract ship construction method is hit.
   */
  public ResistanceStarship updatedFuel(Integer value, FuelAction fuelAction) throws Exception {
    return new ResistanceStarship(fuelTracker(value, fuelAction), this.destructionLevel,
        this.resistanceShipType);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer destructionTracker(Integer value) throws Exception {
    return super.destructionTracker(value);
  }

  /**
   * Returns a new resistance starship with an updated destruction level.
   * @param value the amount we want to increase the destruction level by.
   * @return a new resistance starship with the destruction level increased by the value.
   * @throws Exception if either the requirements for a deadship exception or an out
   * of bounds exception are met.
   */
  public ResistanceStarship updatedDestructionLevel(Integer value) throws Exception {
    return new ResistanceStarship(this.fuelLevel, destructionTracker(value),
        this.resistanceShipType);
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
   * Evaluates an object to see if it is the same as the resistance starship.
   * @param o the object being compared to the resistance starship.
   * @return true if the object is the same as the resistance starship, false
   * otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ResistanceStarship)) {
      return false;
    }
    ResistanceStarship that = (ResistanceStarship) o;
    return resistanceShipType == that.resistanceShipType &&
        Objects.equals(attackRange, that.attackRange) &&
        super.equals(o);
  }

  /**
   * Returns an integer representation of a resistance starship.
   * @return an integer representing a resistance starship.
   */
  @Override
  public int hashCode() {

    return Objects.hash(resistanceShipType, attackRange, this.fuelLevel, this.destructionLevel);
  }

  /**
   * Returns a string describing all attributes of the resistance starship.
   * @return a string describing all attributes of the resistance starship.
   */
  @Override
  public String toString() {
    return "ResistanceStarship{" +
        "resistanceShipType=" + resistanceShipType +
        ", attackRange=" + attackRange + super.toString() +
        '}';
  }
}
