package edu.neu.ccs.cs5004.Problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MakeAndModelTest {
  String make1;
  String make2;
  String model1;
  String model2;
  MakeAndModel one;
  MakeAndModel two;
  int hashCodeTest;

  @Before
  public void setUp() {
    this.make1 = "Suburu";
    this.make2 = "Chevrolet";
    this.model1 = "Forrestor";
    this.model2 = "Mustang";
    this.one = new MakeAndModel(this.make1, this.model1);
    this.two = new MakeAndModel(this.make2, this.model2);
    this.hashCodeTest = one.hashCode();
  }

  @Test
  public void getMake() {
    Assert.assertEquals("Suburu", one.getMake());
  }

  @Test
  public void getModel() {
    Assert.assertEquals("Forrestor", one.getModel());
  }

  @Test
  public void equals() {
    Assert.assertTrue(one.equals(new MakeAndModel(make1, model1)));
    Assert.assertFalse(one.equals(two));
    Assert.assertFalse(one.equals(make1));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(one.hashCode(), new MakeAndModel(make1, model1).hashCode());
    Assert.assertFalse(hashCodeTest == make1.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("This vehicle is a Suburu Forrestor.", one.toString());
  }

}