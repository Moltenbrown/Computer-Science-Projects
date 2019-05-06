package edu.neu.ccs.cs5004.Problem2;

import java.util.List;
import java.util.Objects;

/**
 * Represents a vehicle in the Ride Sharing System.
 */
public abstract class AbstractVehicle implements IVehicle {

  protected String model;
  protected Integer make;
  protected Name owner;
  protected Insurance insurance;
  protected ViolationsHistory violations;
  protected ViolationsHistory crashes;

  /**
   * Gets the list of driving violations on this vehicle and who committed them.
   *
   * @return violations history
   */
  public ViolationsHistory getViolations() {
    return violations;
  }

  /**
   * Gets the list of crashes and who committed them.
   *
   * @return crash history
   */
  public ViolationsHistory getCrashes() {
    return crashes;
  }

  /**
   * Gets the make (year) of the vehicle.
   *
   * @return the make year
   */
  public Integer getMake() {
    return make;
  }

  /**
   * Gets the vehicle owner's name.
   *
   * @return owner's name
   */
  public Name getOwner() {
    return owner;
  }

  /**
   * Gets the vehicle's insurance.
   *
   * @return insurance
   */
  public Insurance getInsurance() {
    return insurance;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractVehicle that = (AbstractVehicle) obj;
    return Objects.equals(make, that.make)
        && Objects.equals(model, that.model)
        && Objects.equals(owner, that.owner)
        && Objects.equals(violations, that.violations)
        && Objects.equals(crashes, that.crashes)
        && Objects.equals(insurance, that.insurance);
  }

  @Override
  public int hashCode() {

    return Objects.hash(make, model, owner, insurance, violations, crashes);
  }

  @Override
  public String toString() {
    return model;
  }
}
