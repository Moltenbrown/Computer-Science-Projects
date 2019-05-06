package edu.neu.ccs.cs5004.lab3.shapes;

/**
 * This class represents a 2D point. This point is denoted in Cartesian
 * coordinates as (x,y).
 */
public class Point2D {
  private double xAxis;
  private double yAxis;

  /**
   * Construct a 2d point with the given coordinates
   *
   * @param xAxis the x-coordinate of this point
   * @param yAxis the y-coordinate of this point
   */
  public Point2D(double xAxis, double yAxis) {
    this.xAxis = xAxis;
    this.yAxis = yAxis;
  }

  /**
   * Compute and return the Euclidean distance of this point to the origin
   *
   * @return the euclidean distance
   */

  public double distToOrigin() {
    return Math.sqrt(xAxis * xAxis + yAxis * yAxis);
  }

  /**
   * Return the x-coordinate of this point
   *
   * @return x-coordinate of this point
   */
  public double getX() {
    return xAxis;
  }

  /**
   * Return the y-coordinate of this point
   *
   * @return y-coordinate of this point
   */
  public double getY() {
    return yAxis;
  }
}