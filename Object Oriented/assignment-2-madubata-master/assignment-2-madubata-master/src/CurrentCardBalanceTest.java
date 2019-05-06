import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurrentCardBalanceTest {
  private CurrentCardBalance cardBalance;
  private Amount testAmount;

  @Before
  public void setUp() throws Exception {
    this.testAmount = new Amount(12, 50);
    this.cardBalance = new CurrentCardBalance(testAmount);
  }

  @Test
  public void getCurrentCardBalance() {
    Assert.assertEquals(testAmount, cardBalance.getCurrentCardBalance());
  }
}