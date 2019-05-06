package edu.neu.ccs.cs5004.assignment3.problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FirstOrderStarshipTest {

  Integer fuelLevel;
  Integer destructionLevel;
  FirstOrderShipType firstOrderShipType;
  FirstOrderStarship firstOrderStarship;

  @Before
  public void setUp() throws Exception {
    this.fuelLevel = 50;
    this.destructionLevel = 0;
    this.firstOrderShipType = FirstOrderShipType.StarDestroyer;
    this.firstOrderStarship = new FirstOrderStarship(fuelLevel, destructionLevel,
        firstOrderShipType);
  }

  @Test
  public void getFirstOrderShipType() throws Exception {
    Assert.assertEquals(firstOrderStarship.getFirstOrderShipType(),
        FirstOrderShipType.StarDestroyer);
    Assert.assertEquals(new FirstOrderStarship(fuelLevel, destructionLevel,
        FirstOrderShipType.TIEFighter).getFirstOrderShipType(), FirstOrderShipType.TIEFighter);
  }

  @Test
  public void getAttackRange() throws Exception {
    Assert.assertEquals(firstOrderStarship.getAttackRange(), new AttackRange(0, 50));
    Assert.assertEquals(new FirstOrderStarship(fuelLevel, destructionLevel,
        FirstOrderShipType.TIEFighter).getAttackRange(), new AttackRange(0, 25));
  }

  @Test
  public void updatedFuel() throws Exception {
    Assert.assertEquals(firstOrderStarship.updatedFuel(25, FuelAction.add),
        new FirstOrderStarship(new Integer(75), destructionLevel, firstOrderShipType));
    Assert.assertEquals(firstOrderStarship.updatedFuel(25, FuelAction.substract),
        new FirstOrderStarship(new Integer(25), destructionLevel, firstOrderShipType));
  }

  @Test
  public void updatedDestruction() throws Exception {
    Assert.assertEquals(firstOrderStarship.updatedDestruction(25),
        new FirstOrderStarship(fuelLevel, new Integer(25), firstOrderShipType));
  }

  @Test
  public void equals() throws Exception {
    Assert.assertTrue(firstOrderStarship.equals(new FirstOrderStarship(fuelLevel, destructionLevel,
        firstOrderShipType)));
    Assert.assertFalse(firstOrderStarship.equals(new FirstOrderStarship(fuelLevel, destructionLevel,
        FirstOrderShipType.TIEFighter)));
    Assert.assertFalse(firstOrderStarship.equals(new FirstOrderStarship(new Integer(0),
        destructionLevel, firstOrderShipType)));
    Assert.assertFalse(firstOrderStarship.equals(new FirstOrderStarship(fuelLevel,
        new Integer(80), firstOrderShipType)));
    Assert.assertFalse(firstOrderStarship.equals(fuelLevel));
  }

  @Test
  public void hashCodeTest() throws Exception {
    Assert.assertEquals(firstOrderStarship.hashCode(), new FirstOrderStarship(fuelLevel,
        destructionLevel, firstOrderShipType).hashCode());
    Assert.assertNotEquals(firstOrderStarship.hashCode(), new FirstOrderStarship(fuelLevel,
        destructionLevel, FirstOrderShipType.TIEFighter));
  }

  @Test
  public void toStringTest() throws Exception {
    Assert.assertEquals("FirstOrderStarship{firstOrderShipType=StarDestroyer, "
        + "attackRange=low=0" + ", high=50}AbstractStarship{fuelLevel=50, destructionLevel=0, "
        + "minimumFuelLevel=0, maximumFuelLevel=100, minimumDestructionLevel=0, "
        + "maximumDestructionLevel=100}", firstOrderStarship.toString());
  }
}