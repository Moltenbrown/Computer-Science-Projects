package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
  String color;
  MakeAndModel makeAndModel;
  LicensePlate licensePlate;
  Integer currentVelocity;
  VehicleTypes vehicleTypes;
  Direction direction;
  Vehicle testvehicle1;
  Vehicle testvehicle2;

  @Before
  public void setUp() throws Exception {
    this.color = "Red";
    this.makeAndModel = new MakeAndModel("Kawasaki", "Strider");
    this.licensePlate = new LicensePlate("1HT-0PI", "Maryland",
        new Date("April", new Integer(2012)));
    this.currentVelocity = new Integer(40);
    this.vehicleTypes = VehicleTypes.MOTORCYCLE;
    this.direction = Direction.NORTHBOUND;
    this.testvehicle1 = new Vehicle(color, makeAndModel, licensePlate, currentVelocity, vehicleTypes,
        direction);
    this.testvehicle2 = new Vehicle("Blue", makeAndModel, licensePlate, new Integer(60),
        vehicleTypes, direction);
  }

  @Test
  public void getColor() {
    Assert.assertEquals("Red", testvehicle1.getColor());
  }

  @Test
  public void getMakeAndModel() {
    Assert.assertEquals(makeAndModel, testvehicle1.getMakeAndModel());
  }

  @Test
  public void getLicensePlate() {
    Assert.assertEquals(licensePlate, testvehicle1.getLicensePlate());
  }

  @Test
  public void getCurrentVelocity() {
    Assert.assertEquals(currentVelocity, testvehicle1.getCurrentVelocity());
  }

  @Test
  public void getLowerVelocityLimit() {
    Assert.assertEquals(new Integer(40), testvehicle1.getLowerVelocityLimit());
  }

  @Test
  public void getUpperVelocityLimit() {
    Assert.assertEquals(new Integer(65), testvehicle1.getUpperVelocityLimit());
  }

  @Test
  public void getVehicleTypes() {
    Assert.assertEquals(VehicleTypes.MOTORCYCLE, testvehicle1.getVehicleTypes());
  }

  @Test
  public void getDirection() {
    Assert.assertEquals(Direction.NORTHBOUND, testvehicle1.getDirection());
  }

  @Test
  public void vehicleAcceleration() throws Exception {
    Assert.assertEquals(new Integer(56),
        testvehicle1.vehicleAcceleration(new SpeedFactor
            (40, SpeedFactorType.ACCELERATION)).getCurrentVelocity());
  }

  @Test(expected = InvalidAccelerationException.class)
  public void testInvalidAccelerationException() throws Exception {
    testvehicle2.vehicleAcceleration(new SpeedFactor(new Integer(50),
        SpeedFactorType.ACCELERATION));
  }

  @Test
  public void vehicleDeceleration() throws Exception{
    Assert.assertEquals(new Integer(48),
        testvehicle2.vehicleDeceleration(new SpeedFactor(new Integer(20),
            SpeedFactorType.DECELERATION)).getCurrentVelocity());
  }

  @Test(expected = InvalidDecelerationException.class)
  public void testInvalidDecelerationException() throws Exception {
    testvehicle1.vehicleDeceleration(new SpeedFactor(new Integer(50),
        SpeedFactorType.DECELERATION));
  }

  @Test
  public void vehicleDirectionChange() throws Exception{
    Assert.assertEquals(Direction.SOUTHBOUND,
        testvehicle1.vehicleDirectionChange(Direction.SOUTHBOUND).getDirection());
  }

  @Test(expected = InvalidDirectionException.class)
  public void testInvalidDirectionException() throws Exception {
    testvehicle1.vehicleDirectionChange(Direction.NORTHBOUND);
    testvehicle1.vehicleDirectionChange(Direction.WESTBOUND);
  }


  @Test
  public void equals() {
    Assert.assertTrue(testvehicle1.equals(new Vehicle(color, makeAndModel, licensePlate,
        currentVelocity, vehicleTypes, direction)));

    Assert.assertFalse(testvehicle1.equals(testvehicle2));

    Assert.assertFalse(testvehicle1.equals(color));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(testvehicle1.hashCode(), new Vehicle(color, makeAndModel, licensePlate,
        currentVelocity, vehicleTypes, direction).hashCode());
    Assert.assertNotEquals(testvehicle1.hashCode(), testvehicle2.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("The vehicle is a Red Kawasaki Strider MOTORCYCLE, license plate "
        + "number 1HT-0PI. Registered in Maryland and expires in April 2012. The current "
        + "velocity is 40 and it is going in a NORTHBOUND direction.", testvehicle1.toString());
  }
}