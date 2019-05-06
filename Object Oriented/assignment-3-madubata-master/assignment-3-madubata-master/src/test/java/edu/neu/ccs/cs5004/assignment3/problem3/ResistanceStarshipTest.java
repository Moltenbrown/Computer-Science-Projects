package edu.neu.ccs.cs5004.assignment3.problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResistanceStarshipTest {

  Integer fuelLevel;
  Integer destructionLevel;
  ResistanceShipType resistanceShipType;
  ResistanceStarship resistanceStarship;

  @Before
  public void setUp() throws Exception {
    this.fuelLevel = 50;
    this.destructionLevel = 0;
    this.resistanceShipType = ResistanceShipType.AWingFighter;
    this.resistanceStarship = new ResistanceStarship(fuelLevel, destructionLevel,
        resistanceShipType);
  }

  @Test
  public void getAttackRange() {
    Assert.assertEquals(new AttackRange(0, 30), resistanceStarship.getAttackRange());
  }

  @Test
  public void getResistanceShipType() {
    Assert.assertEquals(resistanceShipType, resistanceStarship.getResistanceShipType());
  }

  @Test(expected = OutOfBoundsException.class)
  public void OutOfBoundsExceptionTest3() throws Exception{
    new ResistanceStarship(110, 105, resistanceShipType);
  }

  @Test
  public void addFuel() throws Exception {
    Assert.assertEquals(new Integer(75), resistanceStarship.addFuel(25));
  }

  @Test(expected = OutOfBoundsException.class)
   public void OutOfBoundsExceptionTest() throws Exception{
         resistanceStarship.addFuel(60);
  }

  @Test
  public void subtractFuel() throws Exception {
    Assert.assertEquals(new Integer(25), resistanceStarship.subtractFuel(25));
  }

  @Test(expected = OutOfBoundsException.class)
  public void OutOfBoundsExceptionTest2() throws Exception{
    resistanceStarship.subtractFuel(55);
  }

  @Test
  public void fuelTracker() throws Exception {
    Assert.assertEquals(new Integer (75),
        resistanceStarship.fuelTracker(25, FuelAction.add));
    Assert.assertEquals(new Integer(25),
        resistanceStarship.fuelTracker(25, FuelAction.substract));
  }

  @Test
  public void updatedFuel() throws Exception {
    Assert.assertEquals(resistanceStarship.updatedFuel(25, FuelAction.add),
        new ResistanceStarship(new Integer(75), destructionLevel,
            resistanceShipType));
    Assert.assertEquals(resistanceStarship.updatedFuel(25, FuelAction.substract),
        new ResistanceStarship(new Integer(25), destructionLevel,
            resistanceShipType));
  }

  @Test
  public void destructionTracker() throws Exception {
    Assert.assertEquals(new Integer(25), resistanceStarship.destructionTracker(25));
  }

  @Test(expected = DeadShipException.class)
  public void DeadShipExceptionTest() throws Exception {
    resistanceStarship.destructionTracker(100);
  }

  @Test
  public void updatedDestructionLevel() throws Exception {
    Assert.assertEquals(resistanceStarship.updatedDestructionLevel(new Integer(25)),
         new ResistanceStarship(fuelLevel, new Integer(25), resistanceShipType));
  }

  @Test
  public void equals() throws Exception {
    Assert.assertTrue(resistanceStarship.equals(new ResistanceStarship(fuelLevel, destructionLevel,
        resistanceShipType)));
    Assert.assertFalse(resistanceStarship.equals(new ResistanceStarship(fuelLevel, destructionLevel,
        ResistanceShipType.XWingFighter)));
    Assert.assertFalse(resistanceStarship.equals(new ResistanceStarship(new Integer(0),
        destructionLevel, resistanceShipType)));
    Assert.assertFalse(resistanceStarship.equals(new ResistanceStarship(fuelLevel,
        new Integer(50), resistanceShipType)));
    Assert.assertFalse(resistanceStarship.equals(fuelLevel));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertEquals(resistanceStarship.hashCode(), new ResistanceStarship(fuelLevel,
        destructionLevel, resistanceShipType).hashCode());
    Assert.assertNotEquals(resistanceStarship.hashCode(),
        new ResistanceStarship(fuelLevel, destructionLevel,
            ResistanceShipType.XWingFighter).hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("ResistanceStarship{resistanceShipType=AWingFighter, "
            + "attackRange=low=0" + ", high=30AbstractStarship{fuelLevel=50, destructionLevel=0, "
            + "minimumFuelLevel=0, maximumFuelLevel=100, minimumDestructionLevel=0, "
            + "maximumDestructionLevel=100}}", resistanceStarship.toString());
  }
}