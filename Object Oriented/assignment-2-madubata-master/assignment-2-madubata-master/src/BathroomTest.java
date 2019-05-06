import static org.junit.Assert.*;

import org.junit.Assert;

public class BathroomTest {
  private Bathroom bathroom;

  @org.junit.Before
  public void setUp() throws Exception {
    this.bathroom = new Bathroom(60,58, 70);
  }

  @org.junit.Test
  public void getCurrentTemp() {
    Assert.assertEquals(60,this.bathroom.getCurrentTemp());
  }

  @org.junit.Test
  public void getLowTempLimit() {
    Assert.assertEquals(58, this.bathroom.getLowTempLimit());
  }

  @org.junit.Test
  public void getHighTempLimit() {
    Assert.assertEquals(70, this.bathroom.getHighTempLimit());
  }
}