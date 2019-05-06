import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

  private Individual ugochi = new Individual("Ugochi", "Madubata");
  private Amount currentAccountBalance = new Amount(new Integer(0), new Integer(33));

  private Account ugochiAccount = new Account(ugochi, currentAccountBalance);

  private Amount additionAmount = new Amount(new Integer(5), new Integer(67));

  private Amount subtractionAmount = new Amount(new Integer(0), new Integer(33));


  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getAccountHolder() {
    assertEquals(ugochi, ugochiAccount.getAccountHolder());
  }

  @Test
  public void getCurrentAccountBalance() {
    assertEquals(currentAccountBalance, ugochiAccount.getCurrentAccountBalance());
  }

  @Test
  public void deposit() {
    assertEquals(6,
        ugochiAccount.deposit(additionAmount).getCurrentAccountBalance().getDollars().intValue());
    assertEquals(0,
        ugochiAccount.deposit(additionAmount).getCurrentAccountBalance().getCents().intValue());
    assertEquals(ugochi.getFirstName(),
        ugochiAccount.deposit(additionAmount).getAccountHolder().getFirstName());
  }

  @Test
  public void withdrawal(){
    assertEquals(0,
        ugochiAccount.withdraw(subtractionAmount).getCurrentAccountBalance().getDollars().intValue());
    assertEquals(0,
        ugochiAccount.withdraw(subtractionAmount).getCurrentAccountBalance().getCents().intValue());
    assertEquals(ugochi.getFirstName(),
        ugochiAccount.withdraw(subtractionAmount).getAccountHolder().getFirstName());
  }
}
