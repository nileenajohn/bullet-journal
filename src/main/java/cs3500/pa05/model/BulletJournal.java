package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a BulletJournal model.
 */
public class BulletJournal implements JournalInterface {
  private Week week;
  private String notes;
  private int maxEvents;
  private int maxTasks;
  private boolean horizontal;
  private boolean startDaySun;

  /**
   * Represents a constructor for a new BulletJournal.
   */
  public BulletJournal() {
    this.week = new Week();
    this.notes = "";
    this.maxEvents = 100;
    this.maxTasks = 100;
    this.horizontal = true; //isHorizontal
    this.startDaySun = true;
  }

  /**
   * Represents a constructor for a new BulletJournal that should be constructed with the given
   * journal data.
   *
   * @param week the Week to construct this journal with
   * @param notes the notes to construct this journal with
   * @param maxEvents the maxEvents to construct this journal with
   * @param maxTasks the maxTasks to construct this journal with
   * @param horizontal whether this journal should be constructed with a horizontal orientation
   * @param startDaySun whether this journal should be constructed with a sunday start day
   */
  public BulletJournal(Week week, String notes, int maxEvents, int maxTasks, boolean horizontal,
                       boolean startDaySun) {
    this.week = week;
    this.notes = notes;
    this.maxEvents = maxEvents;
    this.maxTasks = maxTasks;
    this.horizontal = horizontal;
    this.startDaySun = startDaySun;
  }

  /**
   * Changes the start day of this BulletJournal based on the given boolean.
   *
   * @param isSun whether the start day should start on sunday.
   */
  public void changeStartDay(boolean isSun) {
    this.startDaySun = isSun;
  }

  /**
   * Returns whether this journal's start day is sunday.
   *
   * @return whether this journal's start day is sunday.
   */
  public boolean isStartDaySun() {
    return this.startDaySun;
  }

  /**
   * Returns whether this journal's orientation is horizontal.
   *
   * @return whether this journal's orientation is horizontal.
   */
  public boolean isHorizontal() {
    return this.horizontal;
  }

  /**
   * Sets this journal's orientation according to the given boolean.
   *
   * @param horizontal whether this journal's orientation should be set as horizontal.
   */
  public void setHorizontal(boolean horizontal) {
    this.horizontal = horizontal;
  }

  /**
   * Gets this journal's current highest number of max events on a day.
   *
   * @return this journal's current highest number of max tasks on a day.
   */
  public int currentMaxEvents() {
    return this.week.currentMaxEvents();
  }

  /**
   * Gets this journal's current highest number of max tasks on a day.
   *
   * @return this journal's current highest number of max tasks on a day.
   */
  public int currentMaxTasks() {
    return this.week.currentMaxTasks();
  }

  /**
   * Sets this journal's max event specification.
   *
   * @param maxEvents the value to set this journal's max events to.
   */
  public void setMaxEvents(int maxEvents) {
    this.maxEvents = maxEvents;
  }

  /**
   * Sets this journal's max task specification.
   *
   * @param maxTasks the value to set this journal's max tasks to.
   */
  public void setMaxTasks(int maxTasks) {
    this.maxTasks = maxTasks;
  }

  /**
   * Gets this journal's max event specification.
   *
   * @return this journal's max event specification.
   */
  public int getMaxEvents() {
    return this.maxEvents;
  }

  /**
   * Gets this journal's max task specification.
   *
   * @return this journal's max task specification.
   */
  public int getMaxTasks() {
    return this.maxTasks;
  }

  /**
   * Completes the tasks according to the given task numbers to complete on the given day.
   *
   * @param day the number associated with the day to complete the tasks.
   * @param taskNumbers the number associated with the tasks to complete.
   */
  public void completeTasks(int day, List<Integer> taskNumbers) {
    this.week.completeTasks(day, taskNumbers);
  }

  /**
   * Uncompletes the tasks according to the given task numbers to uncomplete on the given day.
   *
   * @param day the number associated with the day to uncomplete the tasks.
   * @param taskNumbers the number associated with the tasks to uncomplete.
   */
  public void uncompleteTasks(int day, List<Integer> taskNumbers) {
    this.week.uncompleteTasks(day, taskNumbers);
  }

  /**
   * Gets the name of the week.
   *
   * @return the name of the week.
   */
  public String getWeekName() {
    return this.week.getName();
  }

  /**
   * Sets the name of the week.
   *
   * @param name to set the week's name to.
   */
  public void setWeekName(String name) {
    this.week.setName(name);
  }

  /**
   * Gets this journal's notes.
   *
   * @return the notes of this journal as a string.
   */
  public String getNotes() {
    return this.notes;
  }

  /**
   * Saves the given string as this journal's notes.
   *
   * @param notes the string to save as this journal's notes.
   */
  public void saveNotes(String notes) {
    this.notes = notes;
  }

  /**
   * Adds the given event on the given day of the week.
   *
   * @param e the event to add.
   * @param day the day to add the event on.
   */
  public void addEvent(Event e, String day) {
    this.week.addEventToWeek(e, day);
  }

  /**
   * Adds the given task on the given day of the week.
   *
   * @param t the task to add.
   * @param day the day to add the event on.
   */
  public void addTask(Task t, String day) {
    this.week.addTaskToWeek(t, day);
  }

  /**
   * Gets this journal's week field.
   *
   * @return this journal's week field.
   */
  public Week getWeek() {
    return this.week;
  }

  /**
   * Gets this journal's data as a string.
   *
   * @return this journal's data as a string.
   */
  public List<String> getJournalData() {
    return week.getWeekData();
  }

  /**
   * Gets the total events in this journal.
   *
   * @return the total events in this journal.
   */
  public int getTotalEvents() {
    return this.week.getTotalEvents();
  }

  /**
   * Gets the total tasks in this journal.
   *
   * @return the total tasks in this journal.
   */
  public int getTotalTasks() {
    return this.week.getTotalTasks();
  }

  /**
   * Gets the week's task progress as a double of how many are complete out of total tasks.
   *
   * @return the week's task progress as a double.
   */
  public double getTaskProgress() {
    return this.week.getTaskProgress();
  }

  /**
   * Gets the task progress for each day and returns it as a list of doubles.
   *
   * @return the task progress for each day.
   */
  public List<Double> getDaysTaskProgress() {
    return this.week.getDaysTaskProgress();
  }

  /**
   * Gets sunday's events.
   *
   * @return Sunday's events as a List of events.
   */
  public List<Event> getSunEvents() {
    return this.week.getSunEvents();
  }

  /**
   * Gets sunday's tasks.
   *
   * @return Sunday's tasks as a List of tasks.
   */
  public List<Task> getSunTasks() {
    return this.week.getSunTasks();
  }

  /**
   * Gets Monday's events.
   *
   * @return Monday's events as a List of events.
   */
  public List<Event> getMonEvents() {
    return this.week.getMonEvents();
  }

  /**
   * Gets Monday's tasks.
   *
   * @return Monday's tasks as a List of tasks.
   */
  public List<Task> getMonTasks() {
    return this.week.getMonTasks();
  }

  /**
   * Gets Tuesday's events.
   *
   * @return Tuesday's events as a List of events.
   */
  public List<Event> getTuesEvents() {
    return this.week.getTuesEvents();
  }

  /**
   * Gets Tuesday's tasks.
   *
   * @return Tuesday's tasks as a List of tasks.
   */
  public List<Task> getTuesTasks() {
    return this.week.getTuesTasks();
  }

  /**
   * Gets Wednesday's events.
   *
   * @return Wednesday's events as a List of events.
   */
  public List<Event> getWedEvents() {
    return this.week.getWedEvents();
  }

  /**
   * Gets Wednesday's tasks.
   *
   * @return Wednesday's tasks as a List of tasks.
   */
  public List<Task> getWedTasks() {
    return this.week.getWedTasks();
  }

  /**
   * Gets Thursday's events.
   *
   * @return Thursday's events as a List of events.
   */
  public List<Event> getThursEvents() {
    return this.week.getThursEvents();
  }

  /**
   * Gets Thursday's tasks.
   *
   * @return Thursday's tasks as a List of tasks.
   */
  public List<Task> getThursTasks() {
    return this.week.getThursTasks();
  }

  /**
   * Gets Friday's events.
   *
   * @return Friday's events as a List of events.
   */
  public List<Event> getFriEvents() {
    return this.week.getFriEvents();
  }

  /**
   * Gets Friday's tasks.
   *
   * @return Friday's tasks as a List of events.
   */
  public List<Task> getFriTasks() {
    return this.week.getFriTasks();
  }

  /**
   * Gets Saturday's events.
   *
   * @return Saturday's events as a List of events.
   */
  public List<Event> getSatEvents() {
    return this.week.getSatEvents();
  }

  /**
   * Gets Saturday's tasks.
   *
   * @return Saturday's tasks as a List of tasks.
   */
  public List<Task> getSatTasks() {
    return this.week.getSatTasks();
  }
}
