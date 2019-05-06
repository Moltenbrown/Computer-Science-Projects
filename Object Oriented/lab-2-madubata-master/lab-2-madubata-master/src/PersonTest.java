import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

  private Person jim;

  @Before
  public void setUp() throws Exception {
    this.jim = new Person("Jim", "McDonald");
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("Jim", this.jim.getFirstName());
  }

  @Test
  public void getLastName() {
    Assert.assertEquals("McDonald", this.jim.getLastName());
  }
}