package cs3500.pa05.model;

/**
 * Represents an event in a bullet journal.
 */
public class Event {
  private String name;
  private String description;
  private String startTime;
  private String duration;

  /**
   * Represents a constructor for an Event.
   *
   * @param name the name for this event.
   * @param description the description of this event.
   * @param startTime the start time of this event.
   * @param duration the duration of this event.
   */
  public Event(String name, String description, String startTime, String duration) {
    this.name = name;
    this.description = description;
    this.startTime = startTime;
    this.duration = duration;
  }

  /**
   * Gets the data for this event as a string.
   *
   * @return the data for this event as a string.
   */
  public String getEventData() {
    if (this.description.length() > 0) {
      return (this.name + " - " + this.description + " (" + this.startTime + " | "
          + this.duration + " min)");
    } else {
      return (this.name + " (" + this.startTime + " | " + this.duration + " min)");
    }
  }

  /**
   * Gets the name of this event.
   *
   * @return the name of this event.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the description of this event.
   *
   * @return the description of this event.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Gets the start time of this event.
   *
   * @return the start time of this event.
   */
  public String getStartTime() {
    return this.startTime;
  }

  /**
   * Gets the duration of this event.
   *
   * @return the duration of this event.
   */
  public String getDuration() {
    return this.duration;
  }
}
