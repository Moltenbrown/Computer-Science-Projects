/**
 * Represents Time with its details --
 *  hours, where hours are between 0 and 23, inclusive
 *  minutes, where minutes are between 0 and 59, inclusive
 *  and seconds, where seconds are between 0 and 59, inclusive
 *
 * @author Goch
 *
 */
public class Time {
  private Integer hours;
  private Integer minutes;
  private Integer seconds;


  /**
   * Creates a new time give the time's hours,
   * minutes, and seconds as integers.
   *
   * @param hours the time's hours
   * @param minutes the time's minutes
   * @param seconds the time's seconds
   */
  public Time(Integer hours, Integer minutes, Integer seconds){
      this.hours = hours;
      this.minutes = minutes;
      this.seconds = seconds;
  }

  /**
   * @return the hours
   */
  public Integer getHours() {
      return hours;
  }

  /**
   * @return the minutes
   */
  public Integer getMinutes() {
      return minutes;
  }

  /**
   * @return the seconds
   */
  public Integer getSeconds() {
      return seconds;
  }
}
