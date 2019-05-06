import static org.junit.Assert.*;

import org.junit.Assert;

public class BedroomTest {
  private Bedroom bedroom;

  @org.junit.Before
  public void setUp() throws Exception {
    this.bedroom = new Bedroom(64, 60, 68);
  }

  @org.junit.Test
  public void getCurrentTemp() {
    Assert.assertEquals(64, this.bedroom.getCurrentTemp());
  }

  @org.junit.Test
  public void getLowTempLimit() {
    Assert.assertEquals(60, this.bedroom.getLowTempLimit());
  }

  @org.junit.Test
  public void getHighTempLimit() {
    Assert.assertEquals(68, this.bedroom.getHighTempLimit());
  }
}