package edu.neu.ccs.cs5004.assignment3.problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaperTest {
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
    Assert.assertEquals(true, paper.game(rock));
    Assert.assertEquals(false, paper.game(scissor));

  }
  @Test(expected = DrawException.class)
  public void testDrawException() throws Exception {
    paper.game(paper);
  }
}