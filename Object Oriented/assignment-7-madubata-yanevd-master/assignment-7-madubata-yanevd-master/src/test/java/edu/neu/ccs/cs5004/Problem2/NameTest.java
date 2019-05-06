package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NameTest {

  private Name test;

  @Before
  public void setUp() throws Exception {
    test = new Name("a", "b");
  }


  @Test
  public void equalsTest() {
    assertTrue(test.equals(new Name("a", "b")));
    assertFalse(test.equals(new Name("a", "B")));
    assertFalse(test.equals(new Name("A", "b")));
    assertFalse(test.equals(null));
    assertTrue(test.equals(test));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), (new Name("a", "b")).hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("a b", test.toString());
  }
}