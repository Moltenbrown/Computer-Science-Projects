import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DepositTest {
  private Deposit testDeposit;
  private Amount testAmount;
  private Person name;

  @Before
  public void setUp() throws Exception {
    this.name = new Person("Samuel", "Smith");
    this.testAmount = new Amount(5, 50);
    this.testDeposit = new Deposit(testAmount, name);
  }

  @Test
  public void getDepositAmount() {
    Assert.assertEquals(testAmount, testDeposit.getDepositAmount());
  }

  @Test
  public void getName() {
    Assert.assertEquals(name, testDeposit.getName());
  }
}