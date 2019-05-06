package edu.neu.ccs.cs5004.lab3.shapes;

import java.util.Objects;

/**
 * This class represents a rectangle.  It defines all the operations mandated by
 * the Shape interface
 */
public class Rectangle extends AbstractShape {
  private double width, height;

  /**
   * Constructs a rectangle object with the given location of its lower-left
   * corner and dimensions
   *
   * @param xAxis      xAxis coordinate of the lower-left corner of this rectangle
   * @param yAxis      yAxis coordinate of the lower-left corner of this rectangle
   * @param width  width of this rectangle
   * @param height height of this rectangle
   */
  public Rectangle(double xAxis, double yAxis, double width, double height) {
    super(new Point2D(xAxis, yAxis));
    this.width = width;
    this.height = height;
  }

  @Override
  public double area() {
    return this.width * this.height;
  }

  @Override
  public double perimeter() {
    return 2 * (this.width + this.height);
  }

  @Override
  public Shape resize(double factor) {
    double sqrtFactor = Math.sqrt(factor);
    return new Rectangle(
        this.reference.getX(),
        this.reference.getY(), sqrtFactor *
        this.width,
        sqrtFactor * this.height);
  }

  public String toString() {
    return String.format("Rectangle: LL corner (%.3f,%.3f) width %.3f height " +
            "%.3f",
        this.reference.getX(), this.reference.getY(), this.width, this
            .height);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Rectangle)) {
      return false;
    }
    Rectangle rectangle = (Rectangle) o;
    return Double.compare(rectangle.width, width) == 0 &&
        Double.compare(rectangle.height, height) == 0;
  }

  @Override
  public int hashCode() {

    return Objects.hash(width, height);
  }
}