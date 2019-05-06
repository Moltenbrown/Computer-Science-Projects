/**
 * Represents a Bathroom with it's details--current temperature,
 *  low temperature limit, where the low temperature limit is 58
 *  and, high temperature limit, where the high temperature limit is 70
 *
 * @author Goch
 */
public class Bathroom {
  private int currentTemp;
  private int lowTempLimit;
  private int highTempLimit;

  /**
   * Creates a new bathroom given the room's current temperature,
   * the low temperature limit and the high temperature limit as ints.
   * @param currentTemp the bathroom's current temperature
   * @param lowTempLimit the bathroom's low temperature limit
   * @param highTempLimit the bathroom's high temperature limit
   */
  public Bathroom(int currentTemp, int lowTempLimit, int highTempLimit){
    this.currentTemp = currentTemp;
    this.lowTempLimit = lowTempLimit;
    this.highTempLimit = highTempLimit;
  }

  /**
   * Returns the current temperature in the bathroom
   * @return the current temperature
   */
  public int getCurrentTemp() {
    return currentTemp;
  }

  /**
   * Returns the low temperature limit for bathroom
   * @return the low temperature limit
   */
  public int getLowTempLimit() {
    return lowTempLimit;
  }

  /**
   * Returns the high temperature limit for bathroom
   * @return highTempLimit
   */
  public int getHighTempLimit() {
    return highTempLimit;
  }
}
