import static org.junit.Assert.*;

public class BicyclistTest {

  private Time start = new Time(23, 12, 13);
  private Time end = new Time(0, 3, 37);

  private Time start2 = new Time(22, 12, 13);
  private Time end2 = new Time(23, 3, 37);

  private Bicyclist John = new Bicyclist("John Smith", "Bazos", start, end);
  private Bicyclist John2 = new Bicyclist("John Smith", "Bazos", start2, end2);

  @org.junit.Before
  public void setUp() throws Exception {
  }

  @org.junit.Test
  public void getName() {
      assertEquals("John Smith", John.getName());
  }

  @org.junit.Test
  public void getTeam() {
      assertEquals("Bazos", John.getTeam());
  }

  @org.junit.Test
  public void getStartTime() {
      assertEquals(start, John.getStartTime());
  }

  @org.junit.Test
  public void getEndTime() {
      assertEquals(end, John.getEndTime());
  }

  @org.junit.Test
  public void getDuration() {
      assertEquals(0, John.getDuration().getHours().intValue());
      assertEquals(51, John.getDuration().getMinutes().intValue());
      assertEquals(24, John.getDuration().getSeconds().intValue());

      assertEquals(0, John2.getDuration().getHours().intValue());
      assertEquals(51, John2.getDuration().getMinutes().intValue());
      assertEquals(24, John2.getDuration().getSeconds().intValue());
  }
}