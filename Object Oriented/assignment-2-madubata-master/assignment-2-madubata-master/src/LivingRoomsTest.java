import static org.junit.Assert.*;

import org.junit.Assert;

public class LivingRoomsTest {
  private LivingRooms livingRooms;

  @org.junit.Before
  public void setUp() throws Exception {
    this.livingRooms = new LivingRooms(64, 60,72);
  }

  @org.junit.Test
  public void getCurrentTemp() {
    Assert.assertEquals(64, this.livingRooms.getCurrentTemp());
  }

  @org.junit.Test
  public void getLowTempLimit() {
    Assert.assertEquals(60, this.livingRooms.getLowTempLimit());
  }

  @org.junit.Test
  public void getHighTempLimit() {
    Assert.assertEquals(72, this.livingRooms.getHighTempLimit());
  }
}