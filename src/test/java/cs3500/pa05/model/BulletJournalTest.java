package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for the BulletJournal class.
 */
public class BulletJournalTest {
  private BulletJournal bulletJournal;
  private BulletJournal bulletJournal1;

  private String name;
  private List<Day> days;
  private Week week;
  private Day day1;
  private Event event1;

  private Event event2;

  private Event event3;

  private Task task1;
  private Task task2;

  private Task task3;
  private String notes;
  private int maxEvents;
  private int maxTasks;
  private boolean horizontal;
  private boolean startDaySun;

  /**
   * Initializes a BulletJournal for tests.
   */
  @BeforeEach
  public void setUp() {
    this.notes = "bullet journal notes";
    this.maxEvents = 4;
    this.maxTasks = 4;
    this.horizontal = true;
    this.startDaySun = true;
    this.bulletJournal1 = new BulletJournal();

    this.days = new ArrayList<>();
    for (int i = 0; i < 7; i++) {
      days.add(new Day());
    }
    week = new Week(name, days);
    bulletJournal = new BulletJournal(week, notes, maxEvents, maxTasks, horizontal, startDaySun);

    task1 = new Task("Task 1", "do homework", true);
    task2 = new Task("Task 2", "clean room", true);
    task3 = new Task("Task 3", "do laundry", true);
    event1 = new Event("Meeting", "Discuss project details", "11:30 AM", "60");
    event2 = new Event("Interview", "for barista job", "10:00 AM", "60");
    event3 = new Event("Appointment", "for mani-pedi", "3:00 PM", "60");
    day1 = new Day();
  }

  @Test
  public void testGetTaskProgress() {
    Task task1 = new Task("Assignment 1", "CS3500", false);
    Task task2 = new Task("Assignment 2", "CS3501", false);
    task1.markComplete();
    week.addTaskToWeek(task1, "Monday");
    week.addTaskToWeek(task2, "Tuesday");
    assertEquals(0.5, bulletJournal.getTaskProgress(), 0.001);
  }

  @Test
  public void testChangeStartDay() {
    bulletJournal.changeStartDay(false);
    assertFalse(bulletJournal.isStartDaySun());
  }

  @Test
  public void testIsStartDay() {
    assertTrue(bulletJournal.isStartDaySun());
  }


  @Test
  public void testAddEvent() {
    Event event1 = new Event("Interview", "for coffee shop", "10:00 AM", "60");
    bulletJournal.addEvent(event1, "Monday");
    List<Event> mondayEvents = bulletJournal.getMonEvents();
    Assertions.assertEquals(1, mondayEvents.size());
    Assertions.assertEquals(event1, mondayEvents.get(0));
  }

  @Test
  public void testAddTask() {
    Task task = new Task("Complete assignment", "for OOD", false);
    bulletJournal.addTask(task, "Tuesday");
    List<Task> tuesdayTasks = bulletJournal.getTuesTasks();
    Assertions.assertEquals(1, tuesdayTasks.size());
    Assertions.assertEquals(task, tuesdayTasks.get(0));
  }

  @Test
  public void testCompleteTasks() {
    Task task1 = new Task("Task 1", "clean room", false);
    Task task2 = new Task("Task 2", "do laundry", false);
    bulletJournal.addTask(task1, "Wednesday");
    bulletJournal.addTask(task2, "Wednesday");

    List<Integer> taskNumbers = new ArrayList<>();
    taskNumbers.add(0);
    taskNumbers.add(1);
    bulletJournal.completeTasks(3, taskNumbers);

    List<Task> wednesdayTasks = bulletJournal.getWedTasks();
    assertEquals(2, wednesdayTasks.size());
    assertEquals(true, wednesdayTasks.get(0).isComplete());
    assertEquals(true, wednesdayTasks.get(1).isComplete());


  }

  @Test
  public void getWeek() {
    assertEquals(this.week, bulletJournal.getWeek());
  }

  @Test
  public void testGetSunEvents() {
    week.addEventToWeek(event1, "Sunday");
    week.addEventToWeek(event2, "Sunday");
    week.addEventToWeek(event3, "Sunday");
    List<Event> sunEvents = new ArrayList<>();
    sunEvents.add(event1);
    sunEvents.add(event2);
    sunEvents.add(event3);
    List<Event> events = bulletJournal.getSunEvents();
    assertEquals(events.get(0), sunEvents.get(0));
    assertEquals(events.get(1), sunEvents.get(1));
    assertEquals(events.get(2), sunEvents.get(2));
  }

  @Test
  public void testGetMonEvents() {
    week.addEventToWeek(event1, "Monday");
    week.addEventToWeek(event2, "Monday");
    week.addEventToWeek(event3, "Monday");
    List<Event> monEvents = new ArrayList<>();
    monEvents.add(event1);
    monEvents.add(event2);
    monEvents.add(event3);
    List<Event> events = bulletJournal.getMonEvents();
    assertEquals(events.get(0), monEvents.get(0));
    assertEquals(events.get(1), monEvents.get(1));
    assertEquals(events.get(2), monEvents.get(2));
  }

  @Test
  public void testGetTuesEvents() {
    week.addEventToWeek(event1, "Tuesday");
    week.addEventToWeek(event2, "Tuesday");
    week.addEventToWeek(event3, "Tuesday");
    List<Event> tuesEvents = new ArrayList<>();
    tuesEvents.add(event1);
    tuesEvents.add(event2);
    tuesEvents.add(event3);
    List<Event> events = bulletJournal.getTuesEvents();
    assertEquals(events.get(0), tuesEvents.get(0));
    assertEquals(events.get(1), tuesEvents.get(1));
    assertEquals(events.get(2), tuesEvents.get(2));
  }

  @Test
  public void testGetWedEvents() {
    week.addEventToWeek(event1, "Wednesday");
    week.addEventToWeek(event2, "Wednesday");
    week.addEventToWeek(event3, "Wednesday");
    List<Event> wedEvents = new ArrayList<>();
    wedEvents.add(event1);
    wedEvents.add(event2);
    wedEvents.add(event3);
    List<Event> events = bulletJournal.getWedEvents();
    assertEquals(events.get(0), wedEvents.get(0));
    assertEquals(events.get(1), wedEvents.get(1));
    assertEquals(events.get(2), wedEvents.get(2));
  }

  @Test
  public void testGetThursEvents() {
    week.addEventToWeek(event1, "Thursday");
    week.addEventToWeek(event2, "Thursday");
    week.addEventToWeek(event3, "Thursday");
    List<Event> thursEvents = new ArrayList<>();
    thursEvents.add(event1);
    thursEvents.add(event2);
    thursEvents.add(event3);
    List<Event> events = bulletJournal.getThursEvents();
    assertEquals(events.get(0), thursEvents.get(0));
    assertEquals(events.get(1), thursEvents.get(1));
    assertEquals(events.get(2), thursEvents.get(2));
  }

  @Test
  public void testGetFriEvents() {
    week.addEventToWeek(event1, "Friday");
    week.addEventToWeek(event2, "Friday");
    week.addEventToWeek(event3, "Friday");
    List<Event> friEvents = new ArrayList<>();
    friEvents.add(event1);
    friEvents.add(event2);
    friEvents.add(event3);
    List<Event> events = bulletJournal.getFriEvents();
    assertEquals(events.get(0), friEvents.get(0));
    assertEquals(events.get(1), friEvents.get(1));
    assertEquals(events.get(2), friEvents.get(2));
  }

  @Test
  public void testGetSatEvents() {
    week.addEventToWeek(event1, "Saturday");
    week.addEventToWeek(event2, "Saturday");
    week.addEventToWeek(event3, "Saturday");
    List<Event> satEvents = new ArrayList<>();
    satEvents.add(event1);
    satEvents.add(event2);
    satEvents.add(event3);
    List<Event> events = bulletJournal.getSatEvents();
    assertEquals(events.get(0), satEvents.get(0));
    assertEquals(events.get(1), satEvents.get(1));
    assertEquals(events.get(2), satEvents.get(2));
  }

  @Test
  public void testGetSunTasks() {
    week.addTaskToWeek(task1, "Sunday");
    week.addTaskToWeek(task2, "Sunday");
    week.addTaskToWeek(task3, "Sunday");
    List<Task> sunTasks = new ArrayList<>();
    sunTasks.add(task1);
    sunTasks.add(task2);
    sunTasks.add(task3);
    List<Task> tasks = bulletJournal.getSunTasks();
    assertEquals(tasks.get(0), sunTasks.get(0));
    assertEquals(tasks.get(1), sunTasks.get(1));
    assertEquals(tasks.get(2), sunTasks.get(2));
  }

  @Test
  public void testGetMonTasks() {
    week.addTaskToWeek(task1, "Monday");
    week.addTaskToWeek(task2, "Monday");
    week.addTaskToWeek(task3, "Monday");
    List<Task> monTasks = new ArrayList<>();
    monTasks.add(task1);
    monTasks.add(task2);
    monTasks.add(task3);
    List<Task> tasks = bulletJournal.getMonTasks();
    assertEquals(tasks.get(0), monTasks.get(0));
    assertEquals(tasks.get(1), monTasks.get(1));
    assertEquals(tasks.get(2), monTasks.get(2));
  }

  @Test
  public void testGetTuesTasks() {
    week.addTaskToWeek(task1, "Tuesday");
    week.addTaskToWeek(task2, "Tuesday");
    week.addTaskToWeek(task3, "Tuesday");
    List<Task> tuesTasks = new ArrayList<>();
    tuesTasks.add(task1);
    tuesTasks.add(task2);
    tuesTasks.add(task3);
    List<Task> tasks = bulletJournal.getTuesTasks();
    assertEquals(tasks.get(0), tuesTasks.get(0));
    assertEquals(tasks.get(1), tuesTasks.get(1));
    assertEquals(tasks.get(2), tuesTasks.get(2));
  }

  @Test
  public void testGetWedTasks() {
    week.addTaskToWeek(task1, "Wednesday");
    week.addTaskToWeek(task2, "Wednesday");
    week.addTaskToWeek(task3, "Wednesday");
    List<Task> wedTasks = new ArrayList<>();
    wedTasks.add(task1);
    wedTasks.add(task2);
    wedTasks.add(task3);
    List<Task> tasks = bulletJournal.getWedTasks();
    assertEquals(tasks.get(0), wedTasks.get(0));
    assertEquals(tasks.get(1), wedTasks.get(1));
    assertEquals(tasks.get(2), wedTasks.get(2));
  }

  @Test
  public void testGetThursTasks() {
    week.addTaskToWeek(task1, "Thursday");
    week.addTaskToWeek(task2, "Thursday");
    week.addTaskToWeek(task3, "Thursday");
    List<Task> thursTasks = new ArrayList<>();
    thursTasks.add(task1);
    thursTasks.add(task2);
    thursTasks.add(task3);
    List<Task> tasks = bulletJournal.getThursTasks();
    assertEquals(tasks.get(0), thursTasks.get(0));
    assertEquals(tasks.get(1), thursTasks.get(1));
    assertEquals(tasks.get(2), thursTasks.get(2));
  }

  @Test
  public void testGetFriTasks() {
    week.addTaskToWeek(task1, "Friday");
    week.addTaskToWeek(task2, "Friday");
    week.addTaskToWeek(task3, "Friday");
    List<Task> friTasks = new ArrayList<>();
    friTasks.add(task1);
    friTasks.add(task2);
    friTasks.add(task3);
    List<Task> tasks = bulletJournal.getFriTasks();
    assertEquals(tasks.get(0), friTasks.get(0));
    assertEquals(tasks.get(1), friTasks.get(1));
    assertEquals(tasks.get(2), friTasks.get(2));
  }

  @Test
  public void testGetSatTasks() {
    week.addTaskToWeek(task1, "Saturday");
    week.addTaskToWeek(task2, "Saturday");
    week.addTaskToWeek(task3, "Saturday");
    List<Task> satTasks = new ArrayList<>();
    satTasks.add(task1);
    satTasks.add(task2);
    satTasks.add(task3);
    List<Task> tasks = bulletJournal.getSatTasks();
    assertEquals(tasks.get(0), satTasks.get(0));
    assertEquals(tasks.get(1), satTasks.get(1));
    assertEquals(tasks.get(2), satTasks.get(2));
  }

  @Test
  public void testUncompleteTasks() {
    Task task1 = new Task("Task 1", "clean room", true);
    Task task2 = new Task("Task 2", "do laundry", true);
    bulletJournal.addTask(task1, "Wednesday");
    bulletJournal.addTask(task2, "Wednesday");

    List<Integer> taskNumbers = new ArrayList<>();
    taskNumbers.add(0);
    taskNumbers.add(1);
    bulletJournal.uncompleteTasks(3, taskNumbers);

    List<Task> wednesdayTasks = bulletJournal.getWedTasks();
    assertEquals(2, wednesdayTasks.size());
    assertEquals(false, wednesdayTasks.get(0).isComplete());
    assertEquals(false, wednesdayTasks.get(1).isComplete());
  }

  @Test
  public void testIsHorizontal() {
    bulletJournal.setHorizontal(true);
    assertTrue(bulletJournal.isHorizontal());
  }

  @Test
  public void testSetHorizontal() {
    bulletJournal.setHorizontal(false);
    boolean isHor = bulletJournal.isHorizontal();
    assertFalse(isHor);
  }

  @Test
  public void testCurrentMaxEvents() {
    int currentMaxEvents = bulletJournal.currentMaxEvents();
    Assertions.assertEquals(0, currentMaxEvents);
  }

  @Test
  public void testCurrentMaxTasks() {
    int currentMaxTasks = bulletJournal.currentMaxTasks();
    Assertions.assertEquals(0, currentMaxTasks);
  }

  @Test
  public void testSetMaxEvents() {
    bulletJournal.setMaxEvents(50);
    Assertions.assertEquals(50, bulletJournal.getMaxEvents());
  }

  @Test
  public void testSetMaxTasks() {
    bulletJournal.setMaxTasks(75);
    Assertions.assertEquals(75, bulletJournal.getMaxTasks());
  }

  @Test
  public void testGetWeekName() {
    bulletJournal.setWeekName("Week");
    String weekName = bulletJournal.getWeekName();
    Assertions.assertEquals("Week", weekName);
  }



  @Test
  public void testSetWeekName() {
    bulletJournal.setWeekName("My Week");
    String weekName = bulletJournal.getWeekName();
    Assertions.assertEquals("My Week", weekName);
  }

  @Test
  public void testGetNotes() {
    String notes = bulletJournal.getNotes();
    Assertions.assertEquals("bullet journal notes", notes);
  }

  @Test
  public void testSaveNotes() {
    bulletJournal.saveNotes("Important notes");
    String notes = bulletJournal.getNotes();
    Assertions.assertEquals("Important notes", notes);
  }

  @Test
  public void testGetTotalEvents() {
    Event event1 = new Event("8 am class", "for fundies", "8:00 AM", "60");
    Event event2 = new Event("movie", "called The Notebook",
        "9:00 PM", "60");
    bulletJournal.addEvent(event1, "Monday");
    bulletJournal.addEvent(event2, "Tuesday");

    int totalEvents = bulletJournal.getTotalEvents();
    Assertions.assertEquals(2, totalEvents);
  }

  @Test
  public void testGetTotalTasks() {
    Task task1 = new Task("Task 1", "get groceries", false);
    Task task2 = new Task("Task 2", "", true);
    bulletJournal.addTask(task1, "Monday");
    bulletJournal.addTask(task2, "Tuesday");

    int totalTasks = bulletJournal.getTotalTasks();
    Assertions.assertEquals(2, totalTasks);
  }

}
