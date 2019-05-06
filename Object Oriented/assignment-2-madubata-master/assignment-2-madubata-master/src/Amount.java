/**
 * Represents an Amount with it's details--dollars, where the value is greater or equal to 0, and
 * cents, where the value is greater or equal to 0 and less than or equal to 99. Both dollars and
 * cents are integers
 *
 * @author Goch
 */
public class Amount {
  private int dollars;
  private int cents;

  /**
   * Create a new Amount from two integers, the dollars and cents
   * @param dollars the dollars of the current card balance
   * @param cents the cents of the current card balance
   */
  public Amount(int dollars, int cents){
    this.dollars = dollars;
    this.cents = cents;
  }


  /**
   * Returns the dollars in the amount
   * @return the dollars as an integer
   */
  public int getDollars() {
    return dollars;
  }

  /**
   * Returns the cents in an amount
   * @return the cents as an integer
   */
  public int getCents() {
    return cents;
  }
}
