/**
 * Represents a Menu with its details --
 * meals, desserts, beverages, and drinks.
 *
 * @author Goch
 *
 */
public class Menu {
  private String meals;
  private String desserts;
  private String beverages;
  private String drinks;

  /**
   * Creates a new menu given the menu's meals,
   * desserts, beverages, and drinks as strings.
   *
   * @param meals
   * @param desserts
   * @param beverages
   * @param drinks
   */
  public Menu(String meals, String desserts, String beverages, String drinks){
    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this.drinks = drinks;
  }


  /**
   * Returns the menu's meals
   * @return the meals
   */
  public String getMeals() {
    return meals;
  }

  /**
   * Sets the menu's meals
   * @param meals
   */
  public void setMeals(String meals) {
    this.meals = meals;
  }

  /**
   * Returns the menu's desserts
   * @return the desserts
   */
  public String getDesserts() {
    return desserts;
  }

  /**
   * Sets the menu's desserts
   * @param desserts
   */
  public void setDesserts(String desserts) {
    this.desserts = desserts;
  }

  /**
   * Returns the menu's beverages
   * @return the beverages
   */
  public String getBeverages() {
    return beverages;
  }

  /**
   * Sets the menu's beverages
   * @param beverages
   */
  public void setBeverages(String beverages) {
    this.beverages = beverages;
  }

  /**
   * Returns the menu's drinks
   * @return the drinks
   */
  public String getDrinks() {
    return drinks;
  }

  /**
   * Sets the menu's drinks
   * @param drinks
   */
  public void setDrinks(String drinks) {
    this.drinks = drinks;
  }
}
