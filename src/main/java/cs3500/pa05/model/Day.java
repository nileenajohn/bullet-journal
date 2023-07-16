package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a day in a week in a bullet journal.
 */
public class Day {
  private List<Event> events;
  private List<Task> tasks;

  /**
   * Represents a constructor for a new day.
   */
  public Day() {
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  /**
   * Represents a constructor for a day to be created with the given information.
   *
   * @param events the events to create the day with.
   * @param tasks the tasks to create the day with.
   */
  public Day(List<Event> events, List<Task> tasks) {
    this.events = events;
    this.tasks = tasks;
  }

  /**
   * Adds the given event to this day's events.
   *
   * @param e The event to add.
   */
  public void addEvent(Event e) {
    this.events.add(e);
  }

  /**
   * Adds the given task to this day's tasks.
   *
   * @param t The task to add.
   */
  public void addTask(Task t) {
    this.tasks.add(t);
  }

  /**
   * Gets the data for each day as a list of strings.
   *
   * @return the data for each day as a list of strings.
   */
  public List<String> getDayData() {
    List<String> dayData = new ArrayList<>();
    for (int i = 0; i < events.size(); i++) {
      dayData.add(events.get(i).getEventData());
    }
    for (int i = 0; i < tasks.size(); i++) {
      dayData.add(tasks.get(i).getTaskData());
    }
    return dayData;
  }

  /**
   * Gets the number of total tasks.
   *
   * @return the number of total tasks.
   */
  public int getNumTotalTasks() {
    return this.tasks.size();
  }

  /**
   * Gets the number of total events.
   *
   * @return the number of total events.
   */
  public int getNumTotalEvents() {
    return this.events.size();
  }

  /**
   * Gets the number of completed tasks.
   *
   * @return the number of completed tasks.
   */
  public int getNumCompletedTasks() {
    int count = 0;
    for (Task t : tasks) {
      if (t.isComplete()) {
        count++;
      }
    }
    return count;
  }

  /**
   * Gets the task progress by getting the number of completed tasks out of total tasks.
   *
   * @return the task progress.
   */
  public double getTaskProgress() {
    return Double.valueOf(this.getNumCompletedTasks()) / Double.valueOf(this.getNumTotalTasks());
  }

  /**
   * Gets all of this journal's events.
   *
   * @return this journal's events.
   */
  public List<Event> getEvents() {
    return this.events;
  }

  /**
   * Gets all of this journal's tasks.
   *
   * @return this journal's tasks.
   */
  public List<Task> getTasks() {
    return this.tasks;
  }

  /**
   * Completes the tasks associated with the given task numbers.
   *
   * @param taskNumbers the numbers associated with the tasks to complete.
   */
  public void completeTasks(List<Integer> taskNumbers) {
    for (int i : taskNumbers) {
      this.tasks.get(i).markComplete();
    }
  }

  /**
   * Uncompletes the tasks associated with the given task numbers.
   *
   * @param taskNumbers the numbers associated with the tasks to uncomplete.
   */
  public void uncompleteTasks(List<Integer> taskNumbers) {
    for (int i : taskNumbers) {
      this.tasks.get(i).markUncomplete();
    }
  }
}
