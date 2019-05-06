import static org.junit.Assert.*;

import org.junit.Assert;

public class AuthorTest {

  private Author jane;
  private Person janeDoe;
  private Email jemail;

  @org.junit.Before
  public void setUp() throws Exception {
    this.janeDoe = new Person("Jane", "Doe");
    this.jemail = new Email("j", "@a.com");
    this.jane = new Author(janeDoe, jemail,
        "222 Main St, Seattle, WA 98980");
  }

  @org.junit.Test
  public void getName() {
    Assert.assertEquals(janeDoe, this.jane.getName());
  }

  @org.junit.Test
  public void getEmail() {
    Assert.assertEquals(jemail, this.jane.getEmail());
  }

  @org.junit.Test
  public void getAddress() {
    Assert.assertEquals("222 Main St, Seattle, WA 98980", this.jane.getAddress());
  }
}