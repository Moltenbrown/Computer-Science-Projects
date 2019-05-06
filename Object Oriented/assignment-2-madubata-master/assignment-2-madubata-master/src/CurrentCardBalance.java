/**
 * Represents the Current Card Balance of a transit metro card with its details - the current card
 * balance as an Amount.
 *
 * @author Goch
 */
public class CurrentCardBalance {
  private Amount currentCardBalance;

  /**
   * Create a new current card balance from an amount.
   * @param currentCardBalance the amount that represents the current account balance.
   */
  public CurrentCardBalance(Amount currentCardBalance){
    this.currentCardBalance = currentCardBalance;
  }


  /**
   * Returns the current card balance as an amount
   * @return the current card balance
   */
  public Amount getCurrentCardBalance() {
    return currentCardBalance;
  }
}
