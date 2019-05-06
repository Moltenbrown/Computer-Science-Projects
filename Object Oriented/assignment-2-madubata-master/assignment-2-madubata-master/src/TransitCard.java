import java.util.Objects;

/**
 * Represents a Transit Card with its details--the card owner as a card owner and the current card
 * balance as a current card balance.
 *
 * @author Goch
 */
public class TransitCard {
  private CardOwner cardOwner;
  private CurrentCardBalance currentCardBalance;

  /**
   * Creates a new transit card from a card owner and from a current card balance
   * @param cardOwner the owner of the transit card
   * @param currentCardBalance the current balance on the transit card
   */
  public TransitCard(CardOwner cardOwner, CurrentCardBalance currentCardBalance){
    this.cardOwner = cardOwner;
    this.currentCardBalance = currentCardBalance;
  }


  /**
   * Returns the owner of the transit card as a card owner
   * @return the owner of the transit card
   */
  public CardOwner getCardOwner() {
    return cardOwner;
  }

  /**
   * Returns the current card balance as a current card balance
   * @return the current card balance
   */
  public CurrentCardBalance getCurrentCardBalance() {
    return currentCardBalance;
  }

  /**
   * Given a new deposit, this method returns an updated transit card if the deposit is under
   * the same name as the transit card owner and the deposit amount is between 5 and 50 dollars and
   * it won't put the current card balance over 99 dollars. Otherwise, the user will get multiple
   * error messages.
   * @param newMoney the deposit the user is trying to apply
   * @return an updated transit card with the card balance updated or error messages if the user put
   * in a problematic deposit.
   */
  public TransitCard depositMoney(Deposit newMoney){
    int newBalanceCents = getCurrentCardBalance().getCurrentCardBalance().getCents() +
        newMoney.getDepositAmount().getCents();

    int newBalanceDollars = getCurrentCardBalance().getCurrentCardBalance().getDollars() +
        newMoney.getDepositAmount().getDollars();

    if(newMoney.getDepositAmount().getDollars() < 5 ||
        newMoney.getDepositAmount().getDollars() > 50){
      System.out.println("You deposit is outside of the required bounds. Please submit and "
          + "alternative amount.");
    }

    else{
      if(newMoney.getName() != this.cardOwner.getName()){
        System.out.println("The name associated with this deposit is not the same as the "
            + "name associated with the transit card. As such, we cannot complete this"
            + "deposit.");
      }

      if(newBalanceCents >= 100){
        newBalanceCents = newBalanceCents - 100;
        newBalanceDollars = newBalanceDollars + 1;
      }

      if(newBalanceDollars > 99){
        System.out.println("Unfortunately, your deposit will cause the balance to go above our"
            + "99 dollar limit. Please choose a smaller deposit amount.");
      }

    }

    return new TransitCard(this.cardOwner,
        new CurrentCardBalance(new Amount(newBalanceDollars, newBalanceCents)));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TransitCard)) {
      return false;
    }
    TransitCard that = (TransitCard) o;
    return Objects.equals(cardOwner, that.cardOwner) &&
        Objects.equals(currentCardBalance, that.currentCardBalance);
  }

  @Override
  public int hashCode() {

    return Objects.hash(cardOwner, currentCardBalance);
  }
}
