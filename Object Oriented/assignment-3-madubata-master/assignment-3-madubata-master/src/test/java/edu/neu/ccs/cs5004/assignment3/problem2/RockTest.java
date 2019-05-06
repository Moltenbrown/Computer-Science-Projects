package edu.neu.ccs.cs5004.assignment3.problem2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RockTest {
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
    Assert.assertEquals(false, rock.game(paper));
    Assert.assertEquals(true, rock.game(scissor));

  }
  @Test(expected = DrawException.class)
  public void testDrawException() throws Exception{
    rock.game(rock);
  }
}