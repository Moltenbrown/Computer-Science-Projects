package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents the last scene a movie collaborator worked on with its details--
 * the name of the last scene, the duration of the scene in minutes, and the date
 * the scene was filmed as Strings.
 *
 * @author Goch
 */
public class LastScene {
  private String name;
  private String duration;
  private String date;

  /**
   * Creates a new last scene from a name, duration, and date.
   * @param name the name of the last scene.
   * @param duration the duration of the last scene.
   * @param date the date the last scene was filmed.
   */
  public LastScene(String name, String duration, String date){
    this.name = name;
    this.duration = duration;
    this.date = date;
  }

  /**
   * Returns a the name of the scene.
   * @return the scene name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the duration of the last scene.
   * @return the scene duration.
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Returns the date of the last scene.
   * @return the scene date.
   */
  public String getDate() {
    return date;
  }

  /**
   * Evaluates whether an object being compared to a last scene is the same as the
   * last scene.
   * @param o the object being compared to the last scene.
   * @return true if the object is the same as the last scene, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LastScene)) {
      return false;
    }
    LastScene lastScene = (LastScene) o;
    return Objects.equals(name, lastScene.name) &&
        Objects.equals(duration, lastScene.duration) &&
        Objects.equals(date, lastScene.date);
  }

  /**
   * Returns the integer representation of the last scene.
   * @return an integer representing the last scene.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, duration, date);
  }

  /**
   * Returns a string listing all the last scene's information.
   * @return a string about the last string.
   */
  @Override
  public String toString() {
    return "last scene's name is " + name + '.' +
        " It's duration is " + duration +
        " and it took place on " + date +
        '.';
  }
}
