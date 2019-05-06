package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

/**
 * Represents an Actor, which extends Abstract Talent, with its details--the current projects
 * the Actor is currently working on as a string and the type of actor the actor is, either lead
 * actor or supporting role actor, as an actor type.
 */
public class Actor extends AbstractTalent {
  private String currentProjects;
  private ActorType actorType;

  /**
   * Creates a actor from a name, last scene, willingness to perform stunts, current projects, and
   * actor type.
   * @param name the name of the actor.
   * @param lastScene the last scene the actor worked on.
   * @param willingnessToPerformStunts the actor's willingess to do different stunts.
   * @param currentProjects the current project or movie the actor is working on.
   * @param actorType the type of actor the actor is.
   */
  public Actor(Person name, LastScene lastScene, WillingnessToPerformStunts willingnessToPerformStunts,
      String currentProjects, ActorType actorType){
    super(name, lastScene, willingnessToPerformStunts);
    this.currentProjects = currentProjects;
    this.actorType = actorType;
  }

  /**
   * Returns the current projects the actor is working on.
   * @return the actor's current project.
   */
  public String getCurrentProjects() {
    return currentProjects;
  }

  /**
   * Returns the type of actor the actor is.
   * @return the actor's actor type.
   */
  public ActorType getActorType() {
    return actorType;
  }

  /**
   * Evaluates whether the object being compared is the same as the actor.
   * @param o the object being compared to the actor.
   * @return true if the object is the same as the actor, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Actor)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Actor actor = (Actor) o;
    return Objects.equals(currentProjects, actor.currentProjects) &&
        actorType == actor.actorType;
  }

  /**
   * Returns the integer hashcode representation for the actor.
   * @return the integer hashcode representation for the actor.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), currentProjects, actorType);
  }

  /**
   * Returns a string describing the actor, including their name, their last scene,
   * what stunts they are willing to work with, the current project they're working on,
   * and the type of actor they are..
   * @return a string describing the actor.
   */
  @Override
  public String toString() {
    return super.toString() + " Their current project is " + currentProjects +
        " and they are a " + actorType +
        '.';
  }
}
