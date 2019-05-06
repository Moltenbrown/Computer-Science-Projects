package edu.neu.ccs.cs5004.Problem2;

import java.util.List;

/**
 * Represents a vehicle that a driver plans to drive.
 */
public class Vehicle extends AbstractVehicle {

  /**
   * Creates a new vehicle, given its model, make, owner, insurance, and history.
   *
   * @param model the model of the vehicle
   * @param make the year the vehicle was made
   * @param owner the owner's name
   * @param insurance the insurance of the vehicle
   * @param crashes the crash history
   * @param violations the violation history
   */
  public Vehicle(String model, Integer make, Name owner,
      Insurance insurance, ViolationsHistory violations, ViolationsHistory crashes) {
    this.model = model;
    this.owner = owner;
    this.insurance = insurance;
    this.make = make;
    this.violations = violations;
    this.crashes = crashes;
  }

}
