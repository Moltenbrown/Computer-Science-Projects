package edu.neu.ccs.cs5004.lab3.shapes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Point2DTest {
  private Point2D point2D;

  @Before
  public void setUp() throws Exception {
    this.point2D = new Point2D(2, 3);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void distToOrigin() {
    Assert.assertEquals(3.60555128, point2D.distToOrigin(), 0.1);
  }

  @Test
  public void getX() {
    Assert.assertEquals(2, point2D.getX(), 0.1);
  }

  @Test
  public void getY() {
    Assert.assertEquals(3, point2D.getY(), 0.1);
    Assert.assertEquals(3.0, point2D.getY(), 0.1);
  }
}