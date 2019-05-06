import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

  private Person samuel;

  @Before
  public void setUp() throws Exception {
    this.samuel = new Person("Samuel", "Smith");
  }

  @Test
  public void getFirstName() {
    Assert.assertEquals("Samuel", samuel.getFirstName());
  }

  @Test
  public void getLastName() {
    Assert.assertEquals("Smith", samuel.getLastName());
  }
}