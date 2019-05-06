package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

/**
 * Represents a parking spot with its details--that parking spot name, the size of the parking lot
 * as a size type, the accessibility of the parking lot as an accessibility type and the
 * availability of the parking spot as a boolean. If the parking spot is available, the availability
 * will be true, otherwise it it will be false.
 */
public class ParkingSpot {
  private String name;
  private SizeTypes size;
  private AccessibilityTypes accessibility;
  private boolean availability;

  /**
   * Creates a new parking spot from a size, accessibility, and availability.
   * @param name the name of the parking spot.
   * @param size the size of the parking spot.
   * @param accessibility the accesibility of the parking spot.
   * @param availability the availability of the parking spot.
   */
  public ParkingSpot(String name, SizeTypes size, AccessibilityTypes accessibility, boolean availability){
    this.name = name;
    this.size = size;
    this.accessibility = accessibility;
    this.availability = availability;
  }

  /**
   * Returns the parking spot's name.
   * @return the parking spot name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the parking spot's size type.
   * @return the parking spot size.
   */
  public SizeTypes getSize() {
    return size;
  }

  /**
   * Returns the parking spot's accessibility type.
   * @return the parking spot accessibility.
   */
  public AccessibilityTypes getAccessibility() {
    return accessibility;
  }

  /**
   * Returns the parking spot's availability.
   * @return the parking spots availability.
   */
  public boolean isAvailability() {
    return availability;
  }

  /**
   * Evaluates whether the object being compared to the parking spot is the same as the parking
   * spot.
   * @param o the object being compared to the parking spot.
   * @return true if the object is the same as the parking spot, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ParkingSpot)) {
      return false;
    }
    ParkingSpot that = (ParkingSpot) o;
    return accessibility == that.accessibility &&
        size == that.size &&
        name == that.name;
  }

  /**
   * Returns the integer hashcode of the parking spot.
   * @return the integer hashcode of the parking spot.
   */
  @Override
  public int hashCode() {

    return Objects.hash(name, size, accessibility);
  }

  /**
   * Returns a message about the parking spot as a string, stating the size, accessibility, and
   * availability of the parking spot.
   * @return a string describing the parking spot.
   */
  @Override
  public String toString() {
    return name + " is " + size +
        ", " + accessibility +
        ", and its accessibility is currently " + availability  +
          '.';
  }
}
