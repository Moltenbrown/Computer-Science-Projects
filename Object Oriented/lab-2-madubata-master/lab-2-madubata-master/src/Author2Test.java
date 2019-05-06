import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Author2Test {

  private Author2 jane;

  @Before
  public void setUp() throws Exception {
    this.jane = new Author2("Jane Doe", "j@a.com",
        "222 Main St, Seattle, WA 98980");
  }

  @Test
  public void getName() {
    Assert.assertEquals("Jane Doe", this.jane.getName());

  }

  @Test
  public void getEmail() {
    Assert.assertEquals("j@a.com", this.jane.getEmail());
  }

  @Test
  public void getAddress() {
    Assert.assertEquals("222 Main St, Seattle, WA 98980", this.jane.getAddress());
  }
}