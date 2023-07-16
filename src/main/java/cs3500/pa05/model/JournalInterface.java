package cs3500.pa05.model;

import java.util.List;

/**
 * Represents an interface for a BulletJournal model.
 */
public interface JournalInterface {
  void addEvent(Event e, String day);

  void addTask(Task t, String day);

  List<String> getJournalData();

  double getTaskProgress();

  void changeStartDay(boolean isSun);

  boolean isStartDaySun();

  List<Double> getDaysTaskProgress();

  void setWeekName(String name);

  Week getWeek();

  void saveNotes(String notes);

  void completeTasks(int day, List<Integer> taskNumbers);

  void uncompleteTasks(int day, List<Integer> taskNumbers);

  int getTotalEvents();

  int getTotalTasks();

  String getNotes();

  String getWeekName();

  List<Event> getSunEvents();

  List<Task> getSunTasks();

  List<Event> getMonEvents();

  List<Task> getMonTasks();

  List<Event> getTuesEvents();

  List<Task> getTuesTasks();

  List<Event> getWedEvents();

  List<Task> getWedTasks();

  List<Event> getThursEvents();

  List<Task> getThursTasks();

  List<Event> getFriEvents();

  List<Task> getFriTasks();

  List<Event> getSatEvents();

  List<Task> getSatTasks();

  int currentMaxEvents();

  int currentMaxTasks();

  boolean isHorizontal();

  void setHorizontal(boolean horizontal);

  void setMaxEvents(int maxEvents);

  void setMaxTasks(int maxTasks);

  int getMaxEvents();

  int getMaxTasks();
}
