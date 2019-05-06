import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardOwnerTest {
  private Person samuel;
  private CardOwner cardOwner;

  @Before
  public void setUp() throws Exception {
    this.samuel = new Person("Samuel", "Smith");
    this.cardOwner = new CardOwner(samuel, "555 Deerborn Ln", "something@aol.com");

  }

  @Test
  public void getName() {
    Assert.assertEquals(samuel, cardOwner.getName());
  }

  @Test
  public void getAddress() {
    Assert.assertEquals("555 Deerborn Ln", cardOwner.getAddress());
  }

  @Test
  public void getEmail() {
    Assert.assertEquals("something@aol.com", cardOwner.getEmail());
  }
}