package edu.neu.ccs.cs5004.assignment3.problem3;
import java.util.Objects;
import java.util.Random;

/**
 * Represents a AbstractStarship with it's details--the ship's fuel level, destruction level, and
 * attack power as Integers.
 *
 * @author Goch
 */
public abstract class AbstractStarship implements IStarship{
  protected Integer fuelLevel;
  protected Integer destructionLevel;

  Integer minimumFuelLevel = new Integer(0);
  Integer maximumFuelLevel = new Integer(100);
  Integer minimumDestructionLevel = new Integer(0);
  Integer maximumDestructionLevel = new Integer(100);

  /**
   * Creates a new AbstractStarship from a fuel level, destruction level, and attack power.
   * @param fuelLevel the current fuel level of the starship.
   * @param destructionLevel the current destruction level of the starship.
   * @throws OutOfBoundsException thrown if either the fuel level entered is above
   * the maximum fuel level or the destruction level entered is above the starting
   * destruction level.
   */
  public AbstractStarship(Integer fuelLevel, Integer destructionLevel)
      throws OutOfBoundsException{
    this.fuelLevel = fuelLevel;
    if(fuelLevel > maximumFuelLevel || fuelLevel < minimumFuelLevel){
      throw new OutOfBoundsException("The initial fuel level cannot be more than "
          + maximumFuelLevel + " or less than " + minimumFuelLevel + ".");
    }

    this.destructionLevel = destructionLevel;
    if(destructionLevel > maximumDestructionLevel || fuelLevel < minimumDestructionLevel){
      throw new OutOfBoundsException("The initial destruction level cannot be more than "
          + maximumDestructionLevel + " or less than " + minimumDestructionLevel + ".");
    }
  }

  /**
   * Returns an updated fuel amount that totals the current fuel amount plus the
   * input value.
   * @param value the amount of fuel we are adding to the ship's fuel.
   * @return an updated current fuel amount.
   * @throws OutOfBoundsException when the amount of fuel added would cause the
   * current fuel amount to exceed the maximum allowed fuel amount.
   */
  public Integer addFuel(Integer value) throws OutOfBoundsException{
    Integer updatedValue = value + this.fuelLevel;
    if(updatedValue > maximumFuelLevel){
      throw new OutOfBoundsException("You cannot add this much fuel to the ship. You currently "
          + "have " + this.fuelLevel + " in your ship. Please choose a number that will increase "
          + "fuel level to at most " + maximumFuelLevel + '.');
    }
    return updatedValue;
  }

  /**
   * Returns an updated current fuel amount which totals the current amount of fuel
   * minus the input value.
   * @param value the amount of fuel we are subtracting from the current ship fuel.
   * @return an updated current fuel amount.
   * @throws OutOfBoundsException when the amount of fuel substracted from the current
   * fuel would cause the current amount of fuel to become a negative number.
   */
  public Integer subtractFuel(Integer value) throws OutOfBoundsException{
    Integer updatedValue = this.fuelLevel - value;
    if(updatedValue < minimumFuelLevel){
      throw new OutOfBoundsException("You're substracting too much fuel from the ship.");
    }
    return updatedValue;
  }

  /**
   * Returns an updated fuel level based on whether the fuel action `is add or subtract.
   * @param value the amount we are either adding or subtracting the current fuel level from.
   * @param fuelAction the action we want to do with the value.
   * @return an updated fuel level that has either been increased or decreased.
   * @throws Exception depending on the action and the value input.
   */
  public Integer fuelTracker(Integer value, FuelAction fuelAction) throws Exception{
    Integer newFuel = this.fuelLevel;
    if(fuelAction == FuelAction.add){
      try{
        newFuel = this.addFuel(value);
      }

      catch (OutOfBoundsException e){
        System.err.println(e.getMessage());
      }

      finally {
        if(newFuel > maximumFuelLevel){
          newFuel = maximumFuelLevel;
        }
      }
    }

    else{
      try{
        newFuel = this.subtractFuel(value);
      }

      catch (OutOfBoundsException e){
        System.err.println(e.getMessage());
      }

      finally {
        if(newFuel < minimumFuelLevel){
          newFuel = minimumFuelLevel;
        }
      }
    }
    return newFuel;
  }

  /**
   * Returns an updated destruction level.
   * @param value the amount that is being added to the destruction level.
   * @return an updated destruction level.
   * @throws DeadShipException if the destruction level is greater or equal to the maximum
   * destruction level.
   */
  public Integer destructionTracker(Integer value)
      throws Exception {
    Integer newDestructionAmount = this.destructionLevel + value;
    if(newDestructionAmount >= maximumDestructionLevel){
      throw new DeadShipException("The ship has taken on too much damage. It is dead :(.");
    }
    return newDestructionAmount;
  }

  /**
   * Returns whether or not the object is the same as the abstract starship it's being compared to.
   * @param o the object being compared to the abstract starship.
   * @return true if the object is the same as the abstract starship, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractStarship)) {
      return false;
    }
    AbstractStarship that = (AbstractStarship) o;
    return Objects.equals(fuelLevel, that.fuelLevel) &&
        Objects.equals(destructionLevel, that.destructionLevel) &&
        Objects.equals(minimumFuelLevel, that.minimumFuelLevel) &&
        Objects.equals(maximumFuelLevel, that.maximumFuelLevel) &&
        Objects.equals(minimumDestructionLevel, that.minimumDestructionLevel) &&
        Objects.equals(maximumDestructionLevel, that.maximumDestructionLevel);
  }

  /**
   * Returns an integer hashcode representation of the abstract starship.
   * @return an integer hashcode representation of the abstract starship.
   */
  @Override
  public int hashCode() {

    return Objects.hash(fuelLevel, destructionLevel, minimumFuelLevel, maximumFuelLevel,
        minimumDestructionLevel, maximumDestructionLevel);
  }

  /**
   * A string describing the abstract starship.
   * @return a string describing the abstract starship.
   */
  @Override
  public String toString() {
    return "AbstractStarship{" +
        "fuelLevel=" + fuelLevel +
        ", destructionLevel=" + destructionLevel +
        ", minimumFuelLevel=" + minimumFuelLevel +
        ", maximumFuelLevel=" + maximumFuelLevel +
        ", minimumDestructionLevel=" + minimumDestructionLevel +
        ", maximumDestructionLevel=" + maximumDestructionLevel +
        '}';
  }
}
