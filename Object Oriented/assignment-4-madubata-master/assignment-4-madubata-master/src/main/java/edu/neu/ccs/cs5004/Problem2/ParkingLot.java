package edu.neu.ccs.cs5004.Problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a Parking Lot with its details--a list of parking spots.
 *
 * @author Goch
 */
public class ParkingLot {
  private ArrayList parkingSpotList;

  /**
   * Creates an empty parking lot.
   */
  public ParkingLot(ArrayList parkingSpotList){
    this.parkingSpotList = parkingSpotList;
  }

  /**
   * Returns the all the parking spots in the parking lot.
   * @return the parking lot's parking spot list.
   */
  public ArrayList getParkingSpotList() {
    return parkingSpotList;
  }

  /**
   * Adds a parking spot to the parking lot's parking spot list.
   * @param parkingSpot one of the parking spots in the parking lot.
   */
  public void addParkingSpot(ParkingSpot parkingSpot) {
    this.parkingSpotList.add(0, parkingSpot);
  }

  /**
   * Allows a user to park a car in the parking lot.
   * @param vehicle the vehicle the user wants to park in the parking lot.
   * @param parkingSpot the parking spot the user wants to park in.
   * @return an updated parking lot with the parking spot now marked as unavailable.
   * @throws UnavailableSpotException throws an unavailable spot exception if the user choose an
   * unavailable spot
   * @throws InvalidSpotTypeException if the user tries to part in a disability parking spot without
   * driving a car marked as transporting a person with a disability
   * @throws InvalidSpotSizeException if the user tries to park in a small parking spot with a
   * medium sized vehicle or tries to parking in any spot other than a large parking spot with a
   * large vehicle.
   */

  public Boolean parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot) throws Exception{
    if(parkingSpot.isAvailability() == false){
      throw new UnavailableSpotException("The parking spot you've entered is unavailable. Please"
          + "try again with a different parking spot.");
    }

    if(parkingSpot.getAccessibility() == AccessibilityTypes.Accessible){
      if(vehicle.getAccessibility() != AccessibilityTypes.Accessible){
        throw new InvalidSpotTypeException("You've cannot park in a spot reserved for people with "
            + "disabilities. Please try again and choose a regular parking spot.");
      }
    }

    if(vehicle.getSize() == SizeTypes.Medium){
      if(parkingSpot.getSize() == SizeTypes.Small){
        throw new InvalidSpotSizeException("The car you've entered is too big for the parking"
            + "spot selected. Please try again with a medium or large parking spot.");
      }
    }

    if(vehicle.getSize() == SizeTypes.Large){
      if(parkingSpot.getSize() != SizeTypes.Large){
        throw new InvalidSpotSizeException("The car you've entered it too big for the parking"
            + "spot selected. Please try again with a large parking spot.");
      }
    }

    int parkingSpotLocation = this.parkingSpotList.indexOf(parkingSpot);
    this.parkingSpotList.remove(parkingSpot);
    this.parkingSpotList.add(0,
        new ParkingSpot(parkingSpot.getName(), parkingSpot.getSize(),
            parkingSpot.getAccessibility(), false));
//        (ArrayList) this.parkingSpotList.set(parkingSpotLocation,
//        new ParkingSpot(parkingSpot.getName(), parkingSpot.getSize(),
//            parkingSpot.getAccessibility(), false));

    return new Boolean(true);
  }

  /**
   * Evaluates whether the object being compared to the parking lot is the same as the parking lot.
   * @param o the object being compared to the parking lot.
   * @return true is the object is the same as the parking lot, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ParkingLot)) {
      return false;
    }
    ParkingLot that = (ParkingLot) o;
    return Objects.equals(parkingSpotList, that.parkingSpotList);
  }

  /**
   * Returns an integer hash representing the parking lot.
   * @return the integer hash of the parking lot.
   */
  @Override
  public int hashCode() {
    return Objects.hash(parkingSpotList);
  }

  /**
   * Returns a string describing all the parking spots in the parking lot.
   * @return a string describing the parking lot.
   */
  @Override
  public String toString() {
    return "This parking lot contains the following parking spots: " + parkingSpotList +
        '.';
  }
}
