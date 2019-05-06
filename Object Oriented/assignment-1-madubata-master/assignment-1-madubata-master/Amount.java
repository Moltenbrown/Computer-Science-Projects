/**
 * Represents the amount with its details --
 *  dollars, where dollars are greater or equal to 0
 *  and cents, where cents are greater or equal to 0 and less than or equal to 99
 *
 * @author Goch
 *
 */
public class Amount {
  private Integer dollars;
  private Integer cents;

  /**
   * Creates a new amount given the dollar portion of the amount and the cents portions of the
   * amount as integers.
   *
   * @param dollars
   * @param cents
   */
  public Amount(Integer dollars, Integer cents){
      this.dollars = dollars;
      this.cents = cents;
  }


  /**
   * @return the dollars
   */
  public Integer getDollars() {
      return dollars;
  }

  /**
   * @return the cents1
   */
  public Integer getCents() {
      return cents;
  }
}
