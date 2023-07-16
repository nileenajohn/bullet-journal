package cs3500.pa05.model;

/**
 * Represents a task in a BulletJournal.
 */
public class Task {
  private String name;
  private String description;
  private boolean complete;

  /**
   * Represents a constructor for a task.
   *
   * @param name the name of this task.
   * @param description the description of this task.
   */
  public Task(String name, String description) {
    this.name = name;
    this.description = description;
    this.complete = false;
  }

  /**
   * Represents a constructor for a task.
   *
   * @param name the name of this task.
   * @param description the description of this task.
   * @param complete whether this task is complete.
   */
  public Task(String name, String description, boolean complete) {
    this.name = name;
    this.description = description;
    this.complete = complete;
  }

  /**
   * Returns whether this task is complete.
   *
   * @return whether this task is complete.
   */
  public boolean isComplete() {
    return this.complete;
  }

  /**
   * Marks this task as complete.
   */
  public void markComplete() {
    this.complete = true;
  }

  /**
   * Marks this task as uncomplete.
   */
  public void markUncomplete() {
    this.complete = false;
  }

  /**
   * Gets the data of this task as a string.
   *
   * @return the data of this task as a string.
   */
  public String getTaskData() {
    if (this.description.length() > 0) {
      return (this.name + " - " + this.description);
    } else {
      return (this.name);
    }
  }

  /**
   * Gets the name of this task.
   *
   * @return the name of this task.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the description of this task.
   *
   * @return the description of this task.
   */
  public String getDescription() {
    return this.description;
  }
}
