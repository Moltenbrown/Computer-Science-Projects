package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents a Vehicle with all it's details-- the color as a string, the make and model of the
 * vehicle as a make and model, the license plate as a license plate, the current velocity, the
 * lower velocity limit and the upper velocity limit as integers, the vehicle types as a vehicle
 * type and the direction as a direction.
 *
 * @author Goch
 *
 */
public class Vehicle implements IVehicle{
  private String color;
  private MakeAndModel makeAndModel;
  private LicensePlate licensePlate;
  private Integer currentVelocity;
  private Integer lowerVelocityLimit;
  private Integer upperVelocityLimit;
  private VehicleTypes vehicleTypes;
  private Direction direction;

  /**
   * Creates a new vehicle using a color, a make and model, a license plate, a current velocity,
   * a vehicle type, and a direction.
   * @param color the color of the vehicle.
   * @param makeAndModel the make and model of the vehicle.
   * @param licensePlate the vehicle's license plate.
   * @param currentVelocity the vehicle's current velocity.
   * @param vehicleTypes the vehicle type.
   * @param direction the vehicle's current direction.
   */
  public Vehicle(String color, MakeAndModel makeAndModel, LicensePlate licensePlate,
      Integer currentVelocity, VehicleTypes vehicleTypes, Direction direction){
    Integer generalLowerVelocity = new Integer(40);
    Integer motorcycleUpperVelocity = new Integer(65);
    Integer automobileUpperVelocity = new Integer(70);
    Integer busAndTruckUpperVelocity = new Integer(60);
    this.color = color;
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.currentVelocity = currentVelocity;
    this.lowerVelocityLimit = generalLowerVelocity;
    this.vehicleTypes = vehicleTypes;
    if(vehicleTypes == VehicleTypes.MOTORCYCLE){
      this.upperVelocityLimit = motorcycleUpperVelocity;
    }

    else if(vehicleTypes == VehicleTypes.AUTOMOBILE){
      this.upperVelocityLimit = automobileUpperVelocity;
    }

    else if(vehicleTypes == VehicleTypes.BUS){
      this.upperVelocityLimit = busAndTruckUpperVelocity;
    }

    else if(vehicleTypes == VehicleTypes.TRUCK){
      this.upperVelocityLimit = busAndTruckUpperVelocity;
    }
    this.direction = direction;
  }

  /**
   * Returns the vehicle's color.
   * @return the vehicle's color.
   */
  public String getColor() {
    return color;
  }

  /**
   * Returns the make and model of the vehicle.
   * @return the make and model of the vehicle.
   */
  public MakeAndModel getMakeAndModel() {
    return makeAndModel;
  }

  /**
   * Returns the vehicle's license plate.
   * @return the vehicle's license plate.
   */
  public LicensePlate getLicensePlate() {
    return licensePlate;
  }

  /**
   * Returns the vehicle's current velocity.
   * @return the vehicle's current velocity.
   */
  public Integer getCurrentVelocity() {
    return currentVelocity;
  }

  /**
   * Returns the vehicle's lower velocity limit.
   * @return the vehicle's lower velocity limit.
   */
  public Integer getLowerVelocityLimit() {
    return lowerVelocityLimit;
  }

  /**
   * Returns the vehicle's upper velocity limit.
   * @return the vehicle's upper velocity limit.
   */
  public Integer getUpperVelocityLimit() {
    return upperVelocityLimit;
  }

  /**
   * Returns the vehicle type.
   * @return the vehicle type.
   */
  public VehicleTypes getVehicleTypes() {
    return vehicleTypes;
  }

  /**
   * Returns the vehicle's current direction.
   * @return the vehicle's current direction.
   */
  public Direction getDirection() {
    return direction;
  }

  /**
   * Returns a new vehicle with an updated current velocity if the velocity is within the limits,
   * or throws and exception is the velocity is not within the limits.
   * @param accelerationFactor the percentage the user wants to increase velocity by.
   * @return a new vehicle with an updated increased velocity.
   * @throws InvalidAccelerationException if the increased velocity is more than the vehicle's
   * upper velocity limit.
   */
  public Vehicle vehicleAcceleration(SpeedFactor accelerationFactor) throws
      InvalidAccelerationException{
    int currentVelocity = this.currentVelocity.intValue();
    double possibleIncrease = accelerationFactor.getValue().intValue() * .01;
    double accelerationFactorMultiplier = possibleIncrease + 1;
    double possibleVelocity = currentVelocity * accelerationFactorMultiplier;
    if (possibleVelocity > this.upperVelocityLimit){
      throw new InvalidAccelerationException("The " + this.vehicleTypes +
          " cannot accelerate this much.");
    }

    else {
      return new Vehicle(this.color, this.makeAndModel, this.licensePlate,
          new Integer((int) possibleVelocity), this.vehicleTypes, this.direction);
    }
  }

  /**
   * Returns a new vehicle with an updated current velocity if the velocity is within the limits,
   * or throws and exception is the velocity is not within the limits.
   * @param decelerationFactor the percentage the user wants to decrease velocity by.
   * @return a new vehicle with an updated decreased velocity.
   * @throws InvalidDecelerationException if the decreased velocity is less than the vehicle's
   * lower velocity limit.
   */
  public Vehicle vehicleDeceleration(SpeedFactor decelerationFactor) throws
      InvalidDecelerationException {
    int currentVelocity = this.currentVelocity.intValue();
    double possibleDecrease = decelerationFactor.getValue().intValue()*.01;
    double decelerationFactorMultiplier = 1 - possibleDecrease;
    double possibleVelocity = currentVelocity * decelerationFactorMultiplier;
    if (possibleVelocity < this.lowerVelocityLimit){
      throw new InvalidDecelerationException("The " + this.vehicleTypes +
          " cannot decelerate this much.");
    }

    else {
      return new Vehicle(this.color, this.makeAndModel, this.licensePlate,
          new Integer((int) possibleVelocity), this.vehicleTypes, this.direction);
    }
  }

  /**
   * Returns a new vehicle with an updated direction is the direction change information was
   * correct.
   * @param directionChange the direction the user want to change car to moving in.
   * @return an new vehicle with an updated direction.
   * @throws InvalidDirectionException if the user's input is not a safe direction change or is the
   * current direction the car is moving in.
   */
  public Vehicle vehicleDirectionChange(Direction directionChange) throws
      InvalidDirectionException {
    if(this.direction == Direction.NORTHBOUND){
      if(directionChange == Direction.EASTBOUND || directionChange == Direction.WESTBOUND){
        throw new InvalidDirectionException("This vehicle cannot move this direction.");
      }

      else if(directionChange == Direction.NORTHBOUND){
        throw new InvalidDirectionException("The vehicle is already going in this direction.");
      }
    }

    else if(this.direction == Direction.SOUTHBOUND){
      if(directionChange == Direction.EASTBOUND || directionChange == Direction.WESTBOUND){
        throw new InvalidDirectionException("This vehicle cannot move this direction.");
      }

      else if(directionChange == Direction.SOUTHBOUND){
        throw new InvalidDirectionException("The vehicle is already going in this direction.");
      }
    }

    else if(this.direction == Direction.EASTBOUND){
      if(directionChange == Direction.NORTHBOUND || directionChange == Direction.SOUTHBOUND){
        throw new InvalidDirectionException("This vehicle cannot move this direction.");
      }

      else if(directionChange == Direction.EASTBOUND){
        throw new InvalidDirectionException("The vehicle is already going in this direction.");
      }
    }

    else if(this.direction == Direction.WESTBOUND){
      if(directionChange == Direction.NORTHBOUND || directionChange == Direction.SOUTHBOUND){
        throw new InvalidDirectionException("This vehicle cannot move this direction.");
      }

      else if(directionChange == Direction.WESTBOUND){
        throw new InvalidDirectionException("The vehicle is already going in this direction.");
      }
    }

    return new Vehicle(this.color, this.makeAndModel, this.licensePlate, this.currentVelocity,
        this.vehicleTypes, directionChange);
  }

  /**
   * Returns whether or not an object being compared to the vehicle is the same as the vehicle.
   * @param o the object being compared to the vehicle.
   * @return whether or not the vehicle is the same as the object.
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
    return Objects.equals(color, vehicle.color) &&
        Objects.equals(makeAndModel, vehicle.makeAndModel) &&
        Objects.equals(licensePlate, vehicle.licensePlate) &&
        Objects.equals(currentVelocity, vehicle.currentVelocity) &&
        Objects.equals(lowerVelocityLimit, vehicle.lowerVelocityLimit) &&
        Objects.equals(upperVelocityLimit, vehicle.upperVelocityLimit) &&
        vehicleTypes == vehicle.vehicleTypes &&
        direction == vehicle.direction;
  }

  /**
   * Returns the integer hashcode for the vehicle.
   * @return the integer hashcode for the vehicle.
   */
  @Override
  public int hashCode() {

    return Objects.hash(color, makeAndModel, licensePlate, currentVelocity, lowerVelocityLimit,
        upperVelocityLimit, vehicleTypes, direction);
  }

  /**
   * Creates a string describing the vehicle using it's color, make and model, vehicle type, license
   * plate number, registration location and registration expiration date, current velocity and
   * direction.
   * @return a string describing the vehicle.
   */
  @Override
  public String toString() {
    return "The vehicle is a " +
         color + " " +
         makeAndModel.getMake() + " " + makeAndModel.getModel() + " " + vehicleTypes +
        ", license plate number " + licensePlate.getLicensePlateNumber() + ". Registered in " +
        licensePlate.getState() + " and expires in " + licensePlate.getDate().getMonth() + " " +
        licensePlate.getDate().getYear()+ ". The current velocity is " + currentVelocity +
        " and it is going in a " + direction + " direction.";
  }
}
