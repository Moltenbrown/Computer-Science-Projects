/**
 * Represents a Bicyclist with their details
 * --name, team, start time, and end time
 *
 * @author Goch
 *
 */

public class Bicyclist {
  private String name;
  private String team;
  private Time startTime;
  private Time endTime;

  /**
   * Creates a new bicyclist given the
   * bicyclist's name and team as strings, and
   * their start time and end time as Times.
   *
   * @param name
   * @param team
   * @param startTime
   * @param endTime
   */
  public Bicyclist(String name, String team, Time startTime, Time endTime){
      this.name = name;
      this.team = team;
      this.startTime = startTime;
      this.endTime = endTime;
  }

  /**
   * @return the name
   */
  public String getName() {
      return name;
  }

  /**
   * @return the team
   */
  public String getTeam() {
      return team;
  }

  /**
   * @return the start time
   */
  public Time getStartTime() {
      return startTime;
  }

  /**
   * @return the end time
   */
  public Time getEndTime() {
      return endTime;
  }

/**
 *
 * @return the duration of time that passed
 * between the start time and the end time.
 */
  public Time getDuration() {
      Time endTime = getEndTime();
      Time startTime = getStartTime();

      Integer endHours = endTime.getHours();
      Integer endMinutes = endTime.getMinutes();
      Integer endSeconds = endTime.getSeconds();

      Integer startHours = startTime.getHours();
      Integer startMinutes = startTime.getMinutes();
      Integer startSeconds = startTime.getSeconds();

      Integer finalHours = new Integer(endHours.intValue() - startHours.intValue());
      Integer finalMinutes = new Integer (endMinutes.intValue() - startMinutes.intValue());
      Integer finalSeconds = new Integer(endSeconds.intValue() - startSeconds.intValue());

      if(finalSeconds.intValue() < 0) {
          finalMinutes = new Integer(finalMinutes.intValue() - 1);
          finalSeconds = new Integer(finalSeconds.intValue() + 60);
      }

      if(finalMinutes.intValue() < 0) {
          finalHours = new Integer(finalHours.intValue() - 1);
          finalMinutes = new Integer(finalMinutes.intValue() + 60);
      }

      if(finalHours.intValue() < 0) {
          finalHours = new Integer(23 - startHours.intValue() + endHours.intValue());
      }

      return new Time(finalHours, finalMinutes, finalSeconds);
  }
}
