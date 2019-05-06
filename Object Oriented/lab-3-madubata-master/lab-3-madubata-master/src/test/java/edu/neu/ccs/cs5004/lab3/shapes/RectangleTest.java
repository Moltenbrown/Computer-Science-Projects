package edu.neu.ccs.cs5004.lab3.shapes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
  private Rectangle rectangle;
  private double factor;

  @Before
  public void setUp() throws Exception {
    this.rectangle = new Rectangle(2, 3, 5, 10);
    this.factor = 4;
  }

  @Test
  public void area() {
    Assert.assertEquals(50, rectangle.area(), .1);
  }

  @Test
  public void perimeter() {
    Assert.assertEquals(30, rectangle.perimeter(), .1);
  }

  @Test
  public void resize() {
    Assert.assertEquals(new Rectangle(2, 3, 10, 20),
        rectangle.resize(4));
  }

//  @Test
//  public void toString() {
//  }
}