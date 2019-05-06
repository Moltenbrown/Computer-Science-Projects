package edu.neu.ccs.cs5004.Problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonEmptyUPPairTest {
  Empty empty;
  NonEmptyUPPair nonEmptyUPPair;
  String username;
  String password;
  String username1;
  String password1;
  NonEmptyUPPair nonEmptyUPPair1;

  @Before
  public void setUp() throws Exception {
    this.empty = new Empty();
    this.username = "Madubata";
    this.username1 = "Francis";
    this.password = "Albatross";
    this.password1 = "Hammersmith";
    this.nonEmptyUPPair = new NonEmptyUPPair(username, password);
    this.nonEmptyUPPair1 = new NonEmptyUPPair(username1, password1);
  }

  @Test
  public void getUsername() {
    Assert.assertEquals(username, nonEmptyUPPair.getUsername());
    Assert.assertNull(empty.getUsername());
  }

  @Test
  public void createEmpty() {
    Assert.assertEquals(empty, empty.createEmpty());
    Assert.assertEquals(empty, nonEmptyUPPair1.createEmpty());
  }

  @Test
  public void isEmpty() throws Exception{
    Assert.assertTrue(empty.isEmpty());
    Assert.assertFalse(nonEmptyUPPair.isEmpty());
  }

  @Test
  public void add() throws Exception {
    Assert.assertEquals(new NonEmptyUPPair(username1, password1), empty.add(username1, password1));
  }

  @Test(expected = PairAlreadyInitializedException.class)
  public void PairAlreadyInitializedExceptionTest() throws Exception{
    nonEmptyUPPair.add(username1, password1);
  }

  @Test
  public void replace() throws Exception {
    Assert.assertEquals(nonEmptyUPPair1, nonEmptyUPPair.replace(username1, password1));
  }

  @Test(expected = PairEmptyException.class)
  public void PairEmptyExceptionTest() throws Exception{
    empty.replace(username1, password1);
  }

  @Test
  public void delete() throws Exception {
    Assert.assertTrue(empty.delete(username).isEmpty());
    Assert.assertTrue(nonEmptyUPPair.delete(username).isEmpty());
  }

  @Test(expected = InvalidUsernameException.class)
  public void InvalidUsernameExceptionTest() throws Exception{
    nonEmptyUPPair1.delete(username);
  }

  @Test
  public void equals() {
    Assert.assertEquals(nonEmptyUPPair, new NonEmptyUPPair(username, password));
    Assert.assertFalse(nonEmptyUPPair.equals(nonEmptyUPPair1));
    Assert.assertFalse(nonEmptyUPPair.equals(username));
  }

  @Test
  public void hashCodeTest() {
    Assert.assertEquals(nonEmptyUPPair.hashCode(), new NonEmptyUPPair(username, password).hashCode());
    Assert.assertNotEquals(nonEmptyUPPair.hashCode(), nonEmptyUPPair1.hashCode());
  }

  @Test
  public void toStringTest() {
    Assert.assertEquals("AbstractUPPair{username='Madubata', password='Albatross'}",
        nonEmptyUPPair.toString());
  }

  @Test
  public void getPassword() throws Exception {
    Assert.assertEquals(password, nonEmptyUPPair.getPassword(username));
  }

  @Test(expected = Exception.class)
  public void ExceptionTest() throws Exception{
    nonEmptyUPPair1.getPassword(username);
    empty.getPassword(username);
  }
}