package edu.neu.ccs.cs5004.Problem3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PolynomialTest {
  Polynomial polynomial;

  @Before
  public void setUp() throws Exception {
    this.polynomial = new Polynomial();
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(polynomial.isEmpty());
  }

  @Test
  public void addTerm() {
    Polynomial test1 = polynomial.addTerm(new Integer(2), new Integer(3));
    Assert.assertEquals(test1.coefficient, new Integer(2));
    Assert.assertEquals(test1.power, new Integer(3));
    Polynomial test2 = test1.addTerm(new Integer(5), new Integer(8));
    Assert.assertEquals(test2.coefficient, new Integer(5));
    Assert.assertEquals(test2.power, new Integer(8));

    Polynomial test3 = polynomial.addTerm(0, 5);
    Assert.assertEquals(polynomial, test3);
  }

  @Test
  public void removeTerm() {
    Polynomial test1 = polynomial.addTerm(new Integer(2), new Integer(3));
    Polynomial test2 = test1.addTerm(new Integer(5), new Integer(8));
    Polynomial test3 = test2.removeTerm(8);
    Assert.assertEquals(test3, test1);
    Assert.assertNotEquals(test3, test2);
  }

  @Test
  public void getDegree() {
    Polynomial test1 = polynomial.addTerm(new Integer(2), new Integer(3));
    Polynomial test2 = test1.addTerm(new Integer(5), new Integer(8));
    Polynomial test3 = test2.addTerm(new Integer(4), new Integer(5));
    Assert.assertEquals(new Integer(8), test3.getDegree());
    Assert.assertEquals(new Integer(8), test2.getDegree());
    Assert.assertEquals(new Integer(3), test1.getDegree());
  }

  @Test
  public void getCoefficient() {
    Polynomial test1 = polynomial.addTerm(new Integer(2), new Integer(3));
    Polynomial test2 = test1.addTerm(new Integer(5), new Integer(8));
    Polynomial test3 = test2.addTerm(new Integer(4), new Integer(5));
    Assert.assertEquals(new Integer(2), test3.getCoefficient(3));
    Assert.assertEquals(new Integer(5), test3.getCoefficient(8));
    Assert.assertEquals(new Integer(4), test3.getCoefficient(5));
  }

  @Test
  public void isSame() {
    Polynomial test1 = polynomial.addTerm(new Integer(2), new Integer(3));
    Polynomial test2 = test1.addTerm(new Integer(5), new Integer(8));
    Polynomial test3 = test2.addTerm(new Integer(4), new Integer(5));
    Polynomial test4 = test3.addTerm(new Integer(4), new Integer(2));
    Assert.assertTrue(polynomial.isSame(new Polynomial()));
    Assert.assertTrue(test1.isSame(new Polynomial().
        addTerm(new Integer(2), new Integer(3))));
    Assert.assertFalse(test3.isSame(test1));
    Assert.assertFalse(test3.isSame(test4));
  }

  @Test
  public void evaluate() {
    Polynomial test1 = polynomial.addTerm(new Integer(2), new Integer(3));
    Polynomial test2 = test1.addTerm(new Integer(5), new Integer(8));
    Polynomial test3 = test2.addTerm(new Integer(4), new Integer(5));
    Assert.assertEquals(1424, test3.evaluate(2), .001);

  }

  @Test
  public void add() {
    Polynomial test1 = polynomial.addTerm(new Integer(2), new Integer(3));
    Polynomial test2 = test1.addTerm(new Integer(5), new Integer(8));
    Polynomial test3 = test2.addTerm(new Integer(4), new Integer(5));
    Polynomial test4 = polynomial.addTerm(new Integer(2), new Integer(3));
    Polynomial test5 = test4.addTerm(new Integer(5), new Integer(8));
    Polynomial test6 = test5.addTerm(new Integer(4), new Integer(5));
    Polynomial test7 = polynomial.addTerm(new Integer(4), new Integer(3));
    Polynomial test8 = test7.addTerm(new Integer(10), new Integer(8));
    Polynomial test9 = test8.addTerm(new Integer(8), new Integer (5));
    Polynomial test10 = polynomial.addTerm(new Integer(2), new Integer(2));

    Assert.assertEquals(test9, test3.add(test6));
    Assert.assertEquals(test3.addTerm(new Integer(2), new Integer(2)),
        test3.add(test10));
    Assert.assertEquals(test3, test3.add(polynomial));
  }

  @Test
  public void multiply() {
    Polynomial test1 = polynomial.addTerm(new Integer(2), new Integer(3));
    Polynomial test2 = test1.addTerm(new Integer(5), new Integer(8));
    Assert.assertEquals(new Polynomial(),
        test2.multiply(new Polynomial()));
    Assert.assertEquals(new Polynomial().addTerm(new Integer(4), new Integer(6)),
        test1.multiply(test1));
    Polynomial test3 = new Polynomial().addTerm(10, 11).addTerm(4, 6);
    Assert.assertEquals(test3, test1.multiply(test2));
  }
}