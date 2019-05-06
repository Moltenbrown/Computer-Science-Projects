/**
 * Represents a Deposit to a Transit Card with it's details--the amount of the deposit as an Amount
 * between 5 dollars and 0 cents and 50 dollars and 0 cents and the name of the card owner as a
 * Person
 *
 * @author Goch
 */
public class Deposit {
  private Amount depositAmount;
  private Person name;

  /**
   * Create a new deposit from an amount and a card owner.
   * @param depositAmount the amount of the deposit
   * @param name the owner of the card the deposit is being applied to.
   */
  public Deposit(Amount depositAmount, Person name){
    this.depositAmount = depositAmount;
    this.name = name;
  }


  /**
   * Returns the how much the deposit is as an amount
   * @return the deposit amount
   */
  public Amount getDepositAmount() {
    return depositAmount;
  }

  /**
   * Returns the owner of the card the deposit is being applied to
   * @return the name of the card owner
   */
  public Person getName() {
    return name;
  }
}
