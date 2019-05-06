/**
 * Represents a Living Room with it's details-- current temperature,
 *  low temperature limit, where the low temperature limit is 60
 *  and, high temperature limit, where the high temperature limit is 72
 *
 * @author Goch
 */
public class LivingRooms {
  private int currentTemp;
  private int lowTempLimit;
  private int highTempLimit;

  /**
   * Creates a new living room given the room's current temperature,
   * the low temperature limit and the high temperature limit as ints.
   * @param currentTemp the living rooms' current temperature
   * @param lowTempLimit the living rooms' low temperature limit
   * @param highTempLimit the living rooms' high temperature limit
   */
  public LivingRooms(int currentTemp, int lowTempLimit, int highTempLimit){
    this.currentTemp = currentTemp;
    this.lowTempLimit = lowTempLimit;
    this.highTempLimit = highTempLimit;
  }

  /**
   * Returns the current temperature in the living room
   * @return the current temperature
   */
  public int getCurrentTemp() {
    return currentTemp;
  }

  /**
   * Returns the low temperature limit for the living room
   * @return the low temperature limit
   */
  public int getLowTempLimit() {
    return lowTempLimit;
  }

  /**
   * Returns the high temperature limit for the bedroom
   * @return the high temperature limit
   */
  public int getHighTempLimit() {
    return highTempLimit;
  }
}
