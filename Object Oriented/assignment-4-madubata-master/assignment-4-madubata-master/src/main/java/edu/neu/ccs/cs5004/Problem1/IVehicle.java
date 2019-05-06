package edu.neu.ccs.cs5004.Problem1;


/**
 * This interface contains all methods that all types of AbstractVehicles should support.
 *
 * @author Goch
 */
public interface IVehicle {

  Vehicle vehicleAcceleration(SpeedFactor accelerationFactor) throws InvalidAccelerationException;

  Vehicle vehicleDeceleration(SpeedFactor decelerationFactor) throws InvalidDecelerationException;

  Vehicle vehicleDirectionChange(Direction directionChange) throws InvalidDirectionException;


}
