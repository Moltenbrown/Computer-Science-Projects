package edu.neu.ccs.cs5004.assignment3.problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScissorTest {
  Rock rock;
  Paper paper;
  Scissor scissor;

  @Before
  public void setUp() throws Exception {
    this.rock = new Rock();
    this.paper = new Paper();
    this.scissor = new Scissor();
  }

  @Test
  public void game() throws Exception{
    Assert.assertEquals(false, scissor.game(rock));
    Assert.assertEquals(true, scissor.game(paper));

  }
  @Test(expected = DrawException.class)
  public void testDrawException() throws Exception {
    scissor.game(scissor);
  }
}