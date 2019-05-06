import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MenuTest {

  private Menu menu;

  @Before
  public void setUp() throws Exception {
    this.menu = new Menu("Hamburgers, Cheeseburgers",
        "Creamcheese Cupcakes, HoHos", "Coke, Pepsi", "Rum, Beer");
  }

  @Test
  public void getMeals() {
    Assert.assertEquals("Hamburgers, Cheeseburgers",
        this.menu.getMeals());
  }

  @Test
  public void setMeals() {
    this.menu.setMeals("Ham");
    Assert.assertEquals("Ham", this.menu.getMeals());
  }

  @Test
  public void getDesserts() {
    Assert.assertEquals("Creamcheese Cupcakes, HoHos",
        this.menu.getDesserts());
  }

  @Test
  public void setDesserts() {
    this.menu.setDesserts("Cake");
    Assert.assertEquals("Cake", this.menu.getDesserts());
  }

  @Test
  public void getBeverages() {
    Assert.assertEquals("Coke, Pepsi", this.menu.getBeverages());
  }

  @Test
  public void setBeverages() {
    this.menu.setBeverages("A&W");
    Assert.assertEquals("A&W", this.menu.getBeverages());
  }

  @Test
  public void getDrinks() {
    Assert.assertEquals("Rum, Beer", this.menu.getDrinks());
  }

  @Test
  public void setDrinks() {
    this.menu.setDrinks("Vodka");
    Assert.assertEquals("Vodka", this.menu.getDrinks());
  }
}