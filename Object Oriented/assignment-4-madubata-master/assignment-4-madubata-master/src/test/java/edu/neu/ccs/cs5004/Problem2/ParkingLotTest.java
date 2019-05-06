package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
  ParkingSpot first;
  ParkingSpot second;
  ParkingSpot third;
  Vehicle one;
  Vehicle two;
  Vehicle three;
  ParkingLot parkingLot;
  ArrayList parkingSpotList;
  ParkingSpot fourth;

  @Before
  public void setUp() throws Exception {
    this.first = new ParkingSpot("A1", SizeTypes.Small, AccessibilityTypes.Accessible,
        true);
    this.second = new ParkingSpot("A2", SizeTypes.Medium, AccessibilityTypes.Accessible,
        false);
    this.third = new ParkingSpot("A3", SizeTypes.Large, AccessibilityTypes.Accessible,
        true);
    this.one = new Vehicle(SizeTypes.Large, AccessibilityTypes.Accessible);
    this.two = new Vehicle(SizeTypes.Medium, AccessibilityTypes.Accessible);
    this.three = new Vehicle(SizeTypes.Small, AccessibilityTypes.Inaccessible);
    this.parkingSpotList = new ArrayList();
    this.parkingSpotList.add(0, first);
    this.parkingSpotList.add(0, second);
    this.parkingSpotList.add(0, third);
    this.fourth = new ParkingSpot("A4", SizeTypes.Medium, AccessibilityTypes.Inaccessible,
        false);
    this.parkingLot = new ParkingLot(this.parkingSpotList);
  }

  @Test
  public void getParkingSpotList() {
    Assert.assertEquals(parkingSpotList, this.parkingLot.getParkingSpotList());
  }

  @Test
  public void addParkingSpot() {
    parkingLot.addParkingSpot(fourth);
    Assert.assertTrue(parkingLot.getParkingSpotList().contains(fourth));
  }

  @Test
  public void parkVehicle() throws Exception {
    Assert.assertTrue(parkingLot.parkVehicle(one, third));
  }

  @Test(expected = UnavailableSpotException.class)
  public void UnavailableSpotException() throws Exception {
    parkingLot.parkVehicle(two, second);
  }

  @Test(expected = InvalidSpotTypeException.class)
  public void InvalidSpotTypeException() throws Exception {
    parkingLot.parkVehicle(three, first);
  }

  @Test(expected = InvalidSpotSizeException.class)
  public void InvalidSpotSizeException() throws Exception {
    parkingLot.parkVehicle(one, first);
  }

  @Test
  public void equals() {
    Assert.assertTrue(parkingLot.equals(new ParkingLot(parkingSpotList)));
    Assert.assertFalse(parkingLot.equals(new ParkingLot(new ArrayList())));
    Assert.assertFalse(parkingLot.equals(one));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(parkingLot.hashCode(), new ParkingLot(parkingSpotList).hashCode());
    Assert.assertNotEquals(parkingLot.hashCode(), new ParkingLot(new ArrayList()).hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("This parking lot contains the following parking spots: " +
        parkingSpotList + '.', parkingLot.toString());
  }
}