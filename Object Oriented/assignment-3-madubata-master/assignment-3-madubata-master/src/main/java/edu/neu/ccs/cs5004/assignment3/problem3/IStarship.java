package edu.neu.ccs.cs5004.assignment3.problem3;

public interface IStarship {
  Integer subtractFuel(Integer value) throws OutOfBoundsException;

  Integer addFuel(Integer value) throws OutOfBoundsException;

  Integer fuelTracker(Integer value, FuelAction fuelAction) throws Exception;

  Integer destructionTracker(Integer value) throws Exception;

}
