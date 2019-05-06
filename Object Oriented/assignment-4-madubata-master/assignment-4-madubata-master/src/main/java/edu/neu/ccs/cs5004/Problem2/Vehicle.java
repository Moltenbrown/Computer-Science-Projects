package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

/**
 * Represents a Vehicles with it's details--its size as a size type and it's accessibility as a
 * accessibility type.
 *
 * @author Goch
 */
public class Vehicle {
  private SizeTypes size;
  private AccessibilityTypes accessibility;

  public Vehicle(SizeTypes size, AccessibilityTypes accessibility){
    this.size = size;
    this.accessibility = accessibility;
  }

  /**
   * Returns the size of the vehicle.
   * @return the size of the vehicle.
   */
  public SizeTypes getSize() {
    return size;
  }

  /**
   * Returns the accessibility of the vehicle
   * @return the accessibility of the vehicle.
   */
  public AccessibilityTypes getAccessibility() {
    return accessibility;
  }

  /**
   * Evaluates whether an object being compared is the same as the vehicle it's being compared to.
   * @param o the object being compared to the vehicle.
   * @return true if the object is the same as the vehicle, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Vehicle)) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return size == vehicle.size &&
        accessibility == vehicle.accessibility;
  }

  /**
   * Creates and returns an integer representing the vehicle.
   * @return the integer hash of the vehicle.
   */
  @Override
  public int hashCode() {

    return Objects.hash(size, accessibility);
  }

  /**
   * Creates a string out of the vehicle, stating it's size and accessibility.
   * @return
   */
  @Override
  public String toString() {
    return "This vehicle is "  + size +
        " and " + accessibility +
        " for people with disabilities.";
  }
}
