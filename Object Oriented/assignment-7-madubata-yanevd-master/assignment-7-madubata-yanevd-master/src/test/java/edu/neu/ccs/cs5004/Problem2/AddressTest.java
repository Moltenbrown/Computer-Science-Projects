package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressTest {

  private Address test;

  @Before
  public void setUp() throws Exception {
    test = new Address("a", "b");
  }

  @Test
  public void getCountry() {
    Assert.assertEquals("b", test.getCountry());
  }

  @Test
  public void equalsTest() {
    assertTrue(test.equals(test));
    assertTrue(test.equals(new Address("a", "b")));
    assertFalse(test.equals(null));
    assertFalse(test.equals(new Address("ab", "b")));
    assertFalse(test.equals(new Address("a", "bb")));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(test.hashCode(), (new Address("a", "b")).hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("a, b", test.toString());
  }
}