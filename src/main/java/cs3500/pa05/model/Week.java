package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Week in a BulletJournal.
 */
public class Week {
  private String name;
  private List<Day> days;

  /**
   * Represents a constructor for a new week.
   */
  public Week() {
    this.days = new ArrayList<>();
    // adds 7 days for the week
    for (int i = 0; i < 7; i++) {
      this.days.add(new Day());
    }
  }

  /**
   * Represents a constructor for a week that should be created with the given name and days.
   *
   * @param name the name for this week.
   * @param days The list of days to create this week with.
   */
  public Week(String name, List<Day> days) {
    this.name = name;
    this.days = days;
  }

  /**
   * Sets the name of this week to the given name.
   *
   * @param name the name to set this week's name to.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the name of this week.
   *
   * @return the name of the week
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the days of the week.
   *
   * @return the days of the week.
   */
  public List<Day> getDays() {
    return this.days;
  }

  /**
   * Adds the given event to the given day of the week.
   *
   * @param e the event to add to the week.
   * @param day the day of the week to add the event to.
   */
  public void addEventToWeek(Event e, String day) {
    if (day == "Sunday") {
      this.days.get(0).addEvent(e);
    } else if (day == "Monday") {
      this.days.get(1).addEvent(e);
    } else if (day == "Tuesday") {
      this.days.get(2).addEvent(e);
    } else if (day == "Wednesday") {
      this.days.get(3).addEvent(e);
    } else if (day == "Thursday") {
      this.days.get(4).addEvent(e);
    } else if (day == "Friday") {
      this.days.get(5).addEvent(e);
    } else if (day == "Saturday") {
      this.days.get(6).addEvent(e);
    }
  }

  /**
   * Adds the given task to the week.
   *
   * @param t the task to add to the week.
   * @param day the day to add this task to.
   */
  public void addTaskToWeek(Task t, String day) {
    if (day == "Sunday") {
      this.days.get(0).addTask(t);
    } else if (day == "Monday") {
      this.days.get(1).addTask(t);
    } else if (day == "Tuesday") {
      this.days.get(2).addTask(t);
    } else if (day == "Wednesday") {
      this.days.get(3).addTask(t);
    } else if (day == "Thursday") {
      this.days.get(4).addTask(t);
    } else if (day == "Friday") {
      this.days.get(5).addTask(t);
    } else if (day == "Saturday") {
      this.days.get(6).addTask(t);
    }
  }

  /**
   * Gets the data for each day in the week as a list of strings.
   *
   * @return the data for each day in the week as a list of strings.
   */
  public List<String> getWeekData() {
    List<String> weekData = new ArrayList<>();
    int count = 0;
    List<String> dayNames = new ArrayList<>();
    dayNames.add("Sunday");
    dayNames.add("Monday");
    dayNames.add("Tuesday");
    dayNames.add("Wednesday");
    dayNames.add("Thursday");
    dayNames.add("Friday");
    dayNames.add("Saturday");

    for (Day d : days) {
      weekData.add(dayNames.get(count) + ":");
      for (String s : d.getDayData()) {
        weekData.add(s);
      }
      weekData.add("\n");
      count++;
    }
    return weekData;
  }

  /**
   * Gets the total number of events for this week.
   *
   * @return the total number of events for this week.
   */
  public int getTotalEvents() {
    int totalEvents = 0;
    for (Day d : days) {
      totalEvents += d.getNumTotalEvents();
    }
    return totalEvents;
  }

  /**
   * Gets the total number of tasks for this week.
   *
   * @return the total number of tasks for this week.
   */
  public int getTotalTasks() {
    int totalTasks = 0;
    for (Day d : days) {
      totalTasks += d.getNumTotalTasks();
    }
    return totalTasks;
  }

  /**
   * Gets the task progress for the week.
   *
   * @return the task progress for the week as a double.
   */
  public double getTaskProgress() {
    double totalTasks = 0.0;
    double completedTasks = 0.0;
    for (Day d : days) {
      totalTasks += d.getNumTotalTasks();
      completedTasks += d.getNumCompletedTasks();
    }
    return completedTasks / totalTasks;
  }

  /**
   * Gets the task progress for each day and returns it as a list of doubles.
   *
   * @return the task progress for each day as a list of doubles.
   */
  public List<Double> getDaysTaskProgress() {
    List<Double> daysTaskProgress = new ArrayList<>();
    for (Day d : days) {
      daysTaskProgress.add(d.getTaskProgress());
    }
    return daysTaskProgress;
  }

  /**
   * Gets Sunday's events.
   *
   * @return Sunday's events.
   */
  public List<Event> getSunEvents() {
    return this.days.get(0).getEvents();
  }

  /**
   * Gets Sunday's tasks.
   *
   * @return Sunday's tasks.
   */
  public List<Task> getSunTasks() {
    return this.days.get(0).getTasks();
  }

  /**
   * Gets Monday's events.
   *
   * @return Monday's events.
   */
  public List<Event> getMonEvents() {
    return this.days.get(1).getEvents();
  }

  /**
   * Gets Monday's tasks.
   *
   * @return Monday's tasks.
   */
  public List<Task> getMonTasks() {
    return this.days.get(1).getTasks();
  }

  /**
   * Gets Tuesday's events.
   *
   * @return Tuesday's events.
   */
  public List<Event> getTuesEvents() {
    return this.days.get(2).getEvents();
  }

  /**
   * Gets Tuesday's tasks.
   *
   * @return Tuesday's tasks.
   */
  public List<Task> getTuesTasks() {
    return this.days.get(2).getTasks();
  }

  /**
   * Gets Wednesday's events.
   *
   * @return Wednesday's events.
   */
  public List<Event> getWedEvents() {
    return this.days.get(3).getEvents();
  }

  /**
   * Gets Wednesday's tasks.
   *
   * @return Wednesday's tasks.
   */
  public List<Task> getWedTasks() {
    return this.days.get(3).getTasks();
  }

  /**
   * Gets Thursday's events.
   *
   * @return Thursday's events.
   */
  public List<Event> getThursEvents() {
    return this.days.get(4).getEvents();
  }

  /**
   * Gets Thursday's tasks.
   *
   * @return Thursday's tasks.
   */
  public List<Task> getThursTasks() {
    return this.days.get(4).getTasks();
  }

  /**
   * Gets Friday's events.
   *
   * @return Friday's events.
   */
  public List<Event> getFriEvents() {
    return this.days.get(5).getEvents();
  }

  /**
   * Gets Friday's tasks.
   *
   * @return Friday's tasks.
   */
  public List<Task> getFriTasks() {
    return this.days.get(5).getTasks();
  }

  /**
   * Gets Saturday's events.
   *
   * @return Saturday's events.
   */
  public List<Event> getSatEvents() {
    return this.days.get(6).getEvents();
  }

  /**
   * Gets Saturday's tasks.
   *
   * @return Saturday's tasks.
   */
  public List<Task> getSatTasks() {
    return this.days.get(6).getTasks();
  }

  /**
   * Completes the tasks associated with the given numbers on the given day.
   *
   * @param day the day to complete the tasks
   * @param taskNumbers the tasks to complete
   */
  public void completeTasks(int day, List<Integer> taskNumbers) {
    this.days.get(day).completeTasks(taskNumbers);
  }

  /**
   * Uncompletes the tasks associated with the given numbers on the given day.
   *
   * @param day the day to uncomplete the tasks
   * @param taskNumbers the tasks to uncomplete
   */
  public void uncompleteTasks(int day, List<Integer> taskNumbers) {
    this.days.get(day).uncompleteTasks(taskNumbers);
  }

  /**
   * Gets the most amount of events on a day of this week.
   *
   * @return the most amount of events on a day of this week.
   */
  public int currentMaxEvents() {
    return Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(this.days.get(0)
                        .getNumTotalEvents(),
        this.days.get(1).getNumTotalEvents()), this.days.get(2).getNumTotalEvents()),
        this.days.get(3).getNumTotalEvents()), this.days.get(4).getNumTotalEvents()),
        this.days.get(5).getNumTotalEvents()), this.days.get(6).getNumTotalEvents());
  }

  /**
   * Gets the most amount of tasks on a day of this week.
   *
   * @return the most amount of tasks on a day of this week.
   */
  public int currentMaxTasks() {
    return Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(this.days.get(0)
                    .getNumTotalTasks(),
        this.days.get(1).getNumTotalTasks()), this.days.get(2).getNumTotalTasks()),
        this.days.get(3).getNumTotalTasks()), this.days.get(4).getNumTotalTasks()),
        this.days.get(5).getNumTotalTasks()), this.days.get(6).getNumTotalTasks());
  }
}
