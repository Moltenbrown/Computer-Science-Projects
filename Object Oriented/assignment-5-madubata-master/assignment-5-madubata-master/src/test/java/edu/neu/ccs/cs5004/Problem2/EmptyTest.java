package edu.neu.ccs.cs5004.Problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmptyTest {
  Empty empty;
  String username;
  String password;
  NonEmptyUPPair nonEmptyUPPair;

  @Before
  public void setUp() throws Exception {
    this.empty = new Empty();
    this.username = "Madubata";
    this.password = "Albatross";
    this.nonEmptyUPPair = new NonEmptyUPPair(username, password);
  }

  @Test
  public void getUsername() {
    Assert.assertNull(empty.getUsername());
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(empty.hashCode(), new Empty().hashCode());
    Assert.assertNotEquals(empty.hashCode(), nonEmptyUPPair.hashCode());
  }

  @Test
  public void equals() {
    Assert.assertTrue(empty.equals(new Empty()));
    Assert.assertFalse(empty.equals(new NonEmptyUPPair(username, null)));
    Assert.assertFalse(empty.equals(new NonEmptyUPPair(null, password)));
    Assert.assertFalse(empty.equals(nonEmptyUPPair));
    Assert.assertFalse(empty.equals(username));
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("AbstractUPPair{username='null', password='null'}",
        empty.toString());
  }

  @Test
  public void createEmpty() {
    Assert.assertEquals(new Empty(), empty.createEmpty());
  }

  @Test
  public void add() throws Exception {
    Assert.assertEquals(nonEmptyUPPair, empty.add(username, password));
  }

  @Test(expected = PairEmptyException.class)
  public void PairEmptyExceptionTest() throws Exception{
    empty.replace(username, password);
    empty.getPassword(username);
  }

  @Test
  public void delete() throws Exception {
    Assert.assertEquals(new Empty(), empty.delete(username));
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(empty.isEmpty());
  }
}