package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents a Movie Collaborator with its details--the collaborator's name as a person and
 * the last scene they were in as a last scene.
 *
 * @author Goch
 */
public abstract class AbstractMovieCollaborator {
  protected Person name;
  protected LastScene lastScene;

  /**
   * Creates a new movie collaborator from a name and a last scene.
   * @param name the name of the movie collaborator.
   * @param lastScene the last scene the movie collaborator worked on.
   */
  public AbstractMovieCollaborator(Person name, LastScene lastScene){
    this.name = name;
    this.lastScene = lastScene;
  }

  /**
   * Returns the movie collaborator's name.
   * @return the movie collaborator's name.
   */
  public Person getName() {
    return name;
  }

  /**
   * Returns the last scene the movie collaborator was in.
   * @return the last scene the movie collaborator was in.
   */
  public LastScene getLastScene() {
    return lastScene;
  }

  /**
   * Represents whether an object is the same as the movie collaborator.
   * @param o the object being compared to the movie collaborator.
   * @return true is the object is the same as the movie collaborator and
   * false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractMovieCollaborator)) {
      return false;
    }
    AbstractMovieCollaborator that = (AbstractMovieCollaborator) o;
    return Objects.equals(name, that.name) &&
        Objects.equals(lastScene, that.lastScene);
  }

  /**
   * Return an integer hashcode representation of the movie collaborator.
   * @return an integer hashcode representation of the movie collaborator.
   */
  @Override
  public int hashCode() {

    return Objects.hash(name, lastScene);
  }

  /**
   * Returns a string describing the movie collaborator.
   * @return a string describing the movie collaborator.
   */
  @Override
  public String toString() {
    return  name +"'s " + lastScene;
  }
}
