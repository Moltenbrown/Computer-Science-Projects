import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransitCardTest {
  private TransitCard transitCardTest;
  private CardOwner cardOwner;
  private Deposit depositTest;
  private Deposit depositTest2;
  private Deposit depositTest3;
  private Deposit depositTest4;
  private Amount amount1;
  private Amount amount2;
  private Amount amount3;
  private Amount amount4;
  private Person sam;
  private Person jay;
  private CurrentCardBalance currentCardBalance;
  private Amount startingAmount;

  @Before
  public void setUp() throws Exception {
    this.sam = new Person("Samuel", "Smith");
    this.jay = new Person("Jay", "Smith");
    this.startingAmount = new Amount(12, 50);
    this.currentCardBalance = new CurrentCardBalance(startingAmount);
    this.cardOwner = new CardOwner(sam, "555 Deerborn Avenue", "something@aol.com");
    this.transitCardTest = new TransitCard(cardOwner, currentCardBalance);
    this.amount1 = new Amount(5, 0);
    this.amount2 = new Amount(100, 0);
    this.amount3 = new Amount(87, 50);
    this.amount4 = new Amount(50, 0);
    this.depositTest = new Deposit(amount1, jay);
    this.depositTest2 = new Deposit(amount2, sam);
    this.depositTest3 = new Deposit(amount3, sam);
    this.depositTest4 = new Deposit(amount4, sam);
  }

  @Test
  public void getCardOwner() {
    Assert.assertEquals(new CardOwner(new Person("Samuel", "Smith"),
        "555 Deerborn Avenue", "something@aol.com"), transitCardTest.getCardOwner());
  }

  @Test
  public void getCurrentCardBalance() {
    Assert.assertEquals(new CurrentCardBalance(new Amount(12, 50)),
        transitCardTest.getCurrentCardBalance());
  }

  @Test
  public void depositMoney() {
    Assert.assertEquals("The name associated with this deposit is not the same as the "
        + "name associated with the transit card. As such, we cannot complete this"
        + "deposit.", transitCardTest.depositMoney(depositTest));

    Assert.assertEquals("You deposit is outside of the required bounds. Please submit and "
        + "alternative amount.", transitCardTest.depositMoney(depositTest2));

    Assert.assertEquals("Unfortunately, your deposit will cause the balance to go above our"
        + "99 dollar limit. Please choose a smaller deposit amount.",
        transitCardTest.depositMoney(depositTest3));

    Assert.assertEquals(new TransitCard(new CardOwner(new Person("Samuel", "Smith"),
        "555 Deerborn Avenue", "something@aol.com"),
        new CurrentCardBalance(new Amount(62, 50))),
        transitCardTest.depositMoney(depositTest4));
  }
}