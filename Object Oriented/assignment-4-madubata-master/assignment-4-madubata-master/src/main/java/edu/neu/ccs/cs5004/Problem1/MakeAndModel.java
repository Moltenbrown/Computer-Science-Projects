package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents a Abstract Vehicle's Make and Model with it's details--the car make
 * and model as strings.
 *
 * @author Goch
 */
public class MakeAndModel {
  private String make;
  private String model;

  /**
   * Creates a make and model from a make and model.
   * @param make represents the make of the vehicle.
   * @param model represents the model of the vehicle.
   */
  public MakeAndModel(String make, String model) {
    this.make = make;
    this.model = model;
  }

  /**
   * Returns the vehicle's make as a string.
   * @return the vehicle's make.
   */
  public String getMake() {
    return make;
  }

  /**
   * Returns the vehicle's model as a string.
   * @return the vehicle's model.
   */
  public String getModel() {
    return model;
  }

  /**
   * Returns whether or not the make and model being compared is the same as what it's being
   * compared to.
   * @param o the object the make and model is being compared to.
   * @return true if make and model is the same as the object, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MakeAndModel)) {
      return false;
    }
    MakeAndModel that = (MakeAndModel) o;
    return Objects.equals(make, that.make) &&
        Objects.equals(model, that.model);
  }

  /**
   * Returns an integer representing the make and model.
   * @return the integer hashcode of the make and model.
   */
  @Override
  public int hashCode() {

    return Objects.hash(make, model);
  }

  /**
   * Returns a string stating the make and model of the vehicle.
   * @return a string descibing the make and model of a vehicle.
   */
  @Override
  public String toString() {
    return "This vehicle is a "
        + make + " " + model + '.';
  }
}
