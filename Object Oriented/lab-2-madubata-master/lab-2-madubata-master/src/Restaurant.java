/**
 * Represents a Restaurant with its details--name, address and status
 * where true represents open and false represents closed.
 *
 * @author Goch
 */
public class Restaurant {
  private String name;
  private String address;
  private boolean status;
  private Menu menu;

  /**
   * Creates a new restaurant given the restaurant's name, it's address,
   * and it's status as a boolean
   * @param name
   * @param address
   * @param status
   */
  public Restaurant(String name, String address, boolean status, Menu menu){
    this.name = name;
    this.address = address;
    this.status = status;
    this.menu = menu;
  }


  /**
   * Returns the name of the restaurant
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the restaurant
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the address of the restaurant
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets the address of the restaurant
   * @param address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Returns the status of the restaurant
   * @return the status
   */
  public boolean isStatus() {
    return status;
  }

  /**
   * Sets the status of the restaurant
   * @param status
   */
  public void setStatus(boolean status) {
    this.status = status;
  }

  /**
   * Returns the menu of the restaurant
   * @return the menu
   */
  public Menu getMenu() {
    return menu;
  }
}
