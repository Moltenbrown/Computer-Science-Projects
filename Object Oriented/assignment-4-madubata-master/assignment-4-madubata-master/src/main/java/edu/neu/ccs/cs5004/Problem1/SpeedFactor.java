package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents an Speed Factor with it's details--the speed factor value, the speed factor's
 * low bound,and the speed factor's high bound as integers and the speed factor type as a speed
 * factor type, either acceleration or deceleration.
 *
 * @author Goch
 */
public class SpeedFactor {

  private Integer value;
  private Integer lowBound;
  private Integer highBound;
  private SpeedFactorType speedFactorType;

  /**
   * Creates a new speed fact from a value and a speed factor type.
   * @param value the value of the speed factor.
   * @param speedFactorType the type of speed factor it is
   */
  public SpeedFactor(Integer value, SpeedFactorType speedFactorType) throws
      OutOfBoundsException{
    Integer accelerationLowBound = new Integer(10);
    Integer accelerationHighBound = new Integer(50);
    Integer decelerationLowBound = new Integer(20);
    Integer decelerationHighBound = new Integer(50);
    this.value = value;

    if(speedFactorType == SpeedFactorType.ACCELERATION){
      this.lowBound = accelerationLowBound;
      this.highBound = accelerationHighBound;
    }

    else if(speedFactorType == SpeedFactorType.DECELERATION){
      this.lowBound = decelerationLowBound;
      this.highBound = decelerationHighBound;
    }

    if(this.value.intValue() > this.highBound.intValue() || this.value.intValue() <
        this.lowBound.intValue()){
      throw new OutOfBoundsException("The speed factor you tried to enter is out of bounds. Please"
          + "try again with a different factor that is less than or equal to " + this.highBound +
      "and greater than or equal to " + this.lowBound + '.');
    }
  }


  /**
   * Returns the value of the speed factor as an integer.
   * @return the value of the speed factor.
   */
  public Integer getValue() {
    return value;
  }

  /**
   * Returns the low bound of the speed factor as an integer.
   * @return the low bound of the speed factor.
   */
  public Integer getLowBound() {
    return lowBound;
  }

  /**
   * Returns the high bound of the speed factor as an integer.
   * @return the high bound of the speed factor.
   */
  public Integer getHighBound() {
    return highBound;
  }

  /**
   * Returns the speed factor type.
   * @return the speed factor type.
   */
  public SpeedFactorType getSpeedFactorType() {
    return speedFactorType;
  }

  /**
   * Returns whether or not the speed factor being compared is the same as what it's being
   * compared to.
   * @param o the object you are comparing the speed factor to.
   * @return true if the speed factor is the same as the object, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SpeedFactor)) {
      return false;
    }
    SpeedFactor that = (SpeedFactor) o;
    return Objects.equals(lowBound, that.lowBound) &&
        Objects.equals(highBound, that.highBound) && Objects.equals(value, that.value)
        && Objects.equals(speedFactorType, that.speedFactorType);
  }

  /**
   * Returns an integer representing the speed factor.
   * @return the integer hashcode for the speed factor.
   */
  @Override
  public int hashCode() {

    return Objects.hash(value, lowBound, highBound, speedFactorType);
  }

  /**
   * Returns a string stating what the low and high bound for the speed factor are.
   * @return a statement describing the speed factor.
   */
  @Override
  public String toString() {
    return "The current speed factor is " + value + ", which is between the low bound: " +
        lowBound +
        ", and the high bound: " + highBound +
        '.';
  }
}
