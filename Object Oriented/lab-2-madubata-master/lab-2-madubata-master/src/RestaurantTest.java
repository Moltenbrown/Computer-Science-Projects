import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RestaurantTest {
  private Restaurant grimms;
  private Menu menu;

  @Before
  public void setUp() throws Exception {
    this.menu = menu = new Menu("Hamburgers, Cheeseburgers",
        "Creamcheese Cupcakes, HoHos", "Coke, Pepsi", "Rum, Beer");
    this.grimms = new Restaurant("Grimm's", "399 Westlake Avenue, Seattle, Wa 98103",
        true, menu);
  }

  @Test
  public void getName() {
    Assert.assertEquals("Grimm's", this.grimms.getName());
  }

  @Test
  public void setName(){
    this.grimms.setName("Sarah");
    Assert.assertEquals("Sarah", this.grimms.getName());
  }

  @Test
  public void getAddress() {
    Assert.assertEquals("399 Westlake Avenue, Seattle, Wa 98103",
        this.grimms.getAddress());
  }

  @Test
  public void setAddress(){
    this.grimms.setAddress("Paris, France");
    Assert.assertEquals("Paris, France", this.grimms.getAddress());
  }

  @Test
  public void isStatus() {
    Assert.assertEquals(true, this.grimms.isStatus());
  }

  @Test
  public void setStatus(){
    this.grimms.setStatus(false);
    Assert.assertEquals(false, this.grimms.isStatus());
  }

  @Test
  public void getMenu(){
    Assert.assertEquals(menu, this.grimms.getMenu());
  }
}