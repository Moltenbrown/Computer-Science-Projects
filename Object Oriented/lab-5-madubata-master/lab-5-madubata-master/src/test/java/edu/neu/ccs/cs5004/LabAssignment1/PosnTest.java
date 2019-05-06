package edu.neu.ccs.cs5004.LabAssignment1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PosnTest {
  Integer x;
  Integer y;
  Integer q;
  Integer p;
  Posn posn;

  @Before
  public void setUp() throws Exception {
    this.x = new Integer(3);
    this.y = new Integer(10);
    this.q = null;
    this.p = null;
    posn = new Posn(x, y);
  }

  @Test
  public void getX() {
    Assert.assertEquals(new Integer(3), posn.getX());
  }

  @Test
  public void getY() {
    Assert.assertEquals(new Integer(10), posn.getY());
  }

  @Test
  public void equals() {
    Assert.assertEquals(true, x.equals(x));
    Assert.assertEquals(false, x.equals(y));
    Assert.assertEquals(true, posn.equals(posn));
    Assert.assertTrue(posn != null);
    Assert.assertTrue(new Posn(6,7).getClass() ==
    posn.getClass());
    Assert.assertFalse(posn.equals(new Posn(3,5)));
    Assert.assertFalse(posn.equals(new Integer(3)));
    Assert.assertFalse(posn.equals(null));
    Assert.assertFalse(posn.equals(new Posn(null,6)));
    Assert.assertFalse(new Posn(null, null).equals(new Posn(null, 6)));
    Assert.assertFalse(new Posn(null, 7).equals(new Posn(null, 6)));
    Assert.assertFalse(new Posn(null, 7).equals(new Posn(6, null)));
    Assert.assertEquals(null, new Posn(q, p).getY());

    Assert.assertFalse(!this.x.equals(posn.getX()));
    Assert.assertTrue(this.y.equals(posn.getY()));

  }

  @Test
  public void hashCodeTest() {
    Assert.assertTrue(posn.getY().hashCode() != 0);
    Assert.assertEquals(31 * posn.getX().hashCode() + posn.getY().hashCode(),
        posn.hashCode());
    Assert.assertTrue(posn.getX().hashCode() != 0);
    Assert.assertTrue(posn.hashCode() != new Posn(null, null).hashCode());
    Assert.assertTrue(new Posn(q, p).hashCode() == 0);
  }

  @Test
  public void toStringTest(){
    Assert.assertEquals("Posn{x=3, y=10}", posn.toString());
  }
}