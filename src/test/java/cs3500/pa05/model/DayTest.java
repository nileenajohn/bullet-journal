package cs3500.pa05.model;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for the Day class.
 */
public class DayTest {
  private Day day;

  @BeforeEach
  public void setup() {
    day = new Day();
  }


  @Test
  public void testUncompleteTasks() {
    Task task1 = new Task("Task 1", "Homework 1");
    Task task2 = new Task("Task 2", "Homework 2");
    day.addTask(task1);
    day.addTask(task2);

    List<Integer> taskNumbers = new ArrayList<>();
    taskNumbers.add(0); // Index of task1

    day.uncompleteTasks(taskNumbers);

    assertFalse(task1.isComplete());
    assertFalse(task2.isComplete());
  }

  @Test
  public void testCompleteTasks() {
    Task task1 = new Task("Task 1", "Homework 1");
    Task task2 = new Task("Task 2", "Homework 2");
    day.addTask(task1);
    day.addTask(task2);

    List<Integer> taskNumbers = new ArrayList<>();
    taskNumbers.add(0); // Index of task1

    day.completeTasks(taskNumbers);

    assertTrue(task1.isComplete());
    assertFalse(task2.isComplete());
  }

  @Test
  public void testGetTasks_Empty() {
    List<Task> tasks = day.getTasks();

    assertNotNull(tasks);
    assertTrue(tasks.isEmpty());
  }

  @Test
  public void testGetEvents_Empty() {
    List<Event> events = day.getEvents();

    assertNotNull(events);
    assertTrue(events.isEmpty());
  }

  @Test
  public void testGetTaskProgress_NoTasks() {
    double progress = day.getTaskProgress();

    assertEquals(NaN, progress, 0.01);
  }

  @Test
  public void testGetNumTotalTasks_NoTasks() {
    int numTasks = day.getNumTotalTasks();

    assertEquals(0, numTasks);
  }

  @Test
  public void testGetNumTotalEvents_NoEvents() {
    int numEvents = day.getNumTotalEvents();

    assertEquals(0, numEvents);
  }

  @Test
  public void testAddEvent_SingleEvent() {
    Event event = new Event("Event 1", "Meeting 1", "12:00", "2");
    day.addEvent(event);

    List<Event> events = day.getEvents();

    assertEquals(1, events.size());
    assertEquals(event, events.get(0));
  }

  @Test
  public void testDayConstructor_EmptyLists() {
    List<Event> events = new ArrayList<>();
    List<Task> tasks = new ArrayList<>();

    Day day = new Day(events, tasks);

    assertEquals(events, day.getEvents());
    assertEquals(tasks, day.getTasks());
  }

  @Test
  public void testGetDayData_NoEventsOrTasks() {
    List<String> expectedData = new ArrayList<>();
    List<String> dayData = day.getDayData();

    assertEquals(expectedData, dayData);
  }

  @Test
  public void testGetDayData_EventsAndTasks() {
    Event event1 = new Event("Event 1", "Meeting 1", "12:00", "2");
    Event event2 = new Event("Event 2", "Meeting 2", "1:00", "1");
    Task task1 = new Task("Task 1", "Homework 1");
    Task task2 = new Task("Task 2", "Homework 2");
    day.addEvent(event1);
    day.addEvent(event2);
    day.addTask(task1);
    day.addTask(task2);

    List<String> expectedData = new ArrayList<>();
    expectedData.add(event1.getEventData());
    expectedData.add(event2.getEventData());
    expectedData.add(task1.getTaskData());
    expectedData.add(task2.getTaskData());

    List<String> dayData = day.getDayData();

    assertEquals(expectedData, dayData);
  }

  @Test
  public void testGetNumCompletedTasks_AllTasksCompleted() {
    Task task1 = new Task("Task 1", "Homework 1");
    Task task2 = new Task("Task 2", "Homework 2");
    task1.markComplete();
    task2.markComplete();
    Day day = new Day(new ArrayList<>(), Arrays.asList(task1, task2));

    int numCompletedTasks = day.getNumCompletedTasks();

    assertEquals(2, numCompletedTasks);
  }

}