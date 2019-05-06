import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AmountTest {
  private Amount testAmount;

  @Before
  public void setUp() throws Exception {
    this.testAmount = new Amount(12,50);
  }

  @Test
  public void getDollars() {
    Assert.assertEquals(12, testAmount.getDollars());
  }

  @Test
  public void getCents() {
    Assert.assertEquals(50, testAmount.getCents());
  }
}