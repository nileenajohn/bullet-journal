package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for the Week class.
 */
public class WeekTest {
  private Week week;
  private Task task1;
  private Task task2;
  private Task task3;
  private Event event1;
  private Event event2;
  private Event event3;
  private Day day1;
  private String name;
  private List<Day> days;

  /**
   * Initializes a Week for tests.
   */
  @BeforeEach
  public void setUp() {
    this.days = new ArrayList<>();
    // adds 7 days for the week
    for (int i = 0; i < 7; i++) {
      this.days.add(new Day());
    }
    week = new Week(name, days);
    task1 = new Task("Task 1", "do homework", true);
    task2 = new Task("Task 2", "clean room", true);
    task3 = new Task("Task 3", "do laundry", true);
    event1 = new Event("Meeting", "Discuss project details", "11:30 AM", "60");
    event2 = new Event("Interview", "for barista job", "10:00 AM", "60");
    event3 = new Event("Appointment", "for mani-pedi", "3:00 PM", "60");
    day1 = new Day();
  }

  @Test
  public void testSetName() {
    week.setName("Test Week");
    assertEquals("Test Week", week.getName());
  }

  @Test
  public void testGetName() {
    week.setName("Test Week");
    String weekN = week.getName();
    assertEquals("Test Week", weekN);
  }

  @Test
  public void testGetDays() {
    List<Day> days = week.getDays();
    assertEquals(7, days.size());
  }

  @Test
  public void testAddEventToWeek() {
    Event event = new Event("Meeting", "for "
        + "spanish project", "10:00 AM", "60 mins");
    week.addEventToWeek(event, "Monday");
    List<Event> mondayEvents = week.getMonEvents();
    assertEquals(1, mondayEvents.size());
    assertEquals(event, mondayEvents.get(0));
  }



  @Test
  public void testAddTaskToWeek() {
    Task task = new Task("Assignment", "CS3500", true);
    week.addTaskToWeek(task, "Tuesday");
    List<Task> tuesdayTasks = week.getTuesTasks();
    assertEquals(1, tuesdayTasks.size());
    assertEquals(task, tuesdayTasks.get(0));
  }

  @Test
  public void testGetWeekData() {
    Event event1 = new Event("Hair Appointment", "for a trim", "10:00 AM",
        "40");
    Event event2 = new Event("Nail Appointment", "acrylic manicure",
        "3:00 PM", "50");
    week.addEventToWeek(event1, "Monday");
    week.addEventToWeek(event2, "Tuesday");
    assertEquals("Sunday:", week.getWeekData().get(0));
    assertEquals("\n", week.getWeekData().get(1));
    assertEquals("Monday:", week.getWeekData().get(2));
    assertEquals("Hair Appointment - for a trim (10:00 AM | 40 min)",
        week.getWeekData().get(3));
    assertEquals("\n", week.getWeekData().get(4));
    assertEquals("Tuesday:", week.getWeekData().get(5));
    assertEquals("Nail Appointment - acrylic manicure (3:00 PM | 50 min)",
        week.getWeekData().get(6));
    assertEquals("\n", week.getWeekData().get(7));
    assertEquals("Wednesday:", week.getWeekData().get(8));
    assertEquals("\n", week.getWeekData().get(9));
    assertEquals("Thursday:", week.getWeekData().get(10));
    assertEquals("\n", week.getWeekData().get(11));
    assertEquals("Friday:", week.getWeekData().get(12));
    assertEquals("\n", week.getWeekData().get(13));
    assertEquals("Saturday:", week.getWeekData().get(14));
    assertEquals("\n", week.getWeekData().get(15));

    List<String> expectedData = Arrays.asList(
        "Sunday:",
        "\n",
        "Monday:",
        "Hair Appointment - for a trim (10:00 AM | 40 min)",
        "\n",
        "Tuesday:",
        "Nail Appointment - acrylic manicure (3:00 PM | 50 min)",
        "\n",
        "Wednesday:",
        "\n",
        "Thursday:",
        "\n",
        "Friday:",
        "\n",
        "Saturday:",
        "\n"
    );
    assertEquals(expectedData, week.getWeekData());
  }

  @Test
  public void testGetTotalEvents() {
    Event event1 = new Event("Interview", "for barista job", "10:00 AM", "60 mins");
    Event event2 = new Event("Dinner", "for father's day", "9:00 PM", "60 mins");
    week.addEventToWeek(event1, "Monday");
    week.addEventToWeek(event2, "Tuesday");
    assertEquals(2, week.getTotalEvents());
  }

  @Test
  public void testGetTotalTasks() {
    Task task1 = new Task("Assignment 1", "CS3500", false);
    Task task2 = new Task("Assignment 2", "CS3501", true);
    week.addTaskToWeek(task1, "Monday");
    week.addTaskToWeek(task2, "Tuesday");
    assertEquals(2, week.getTotalTasks());
  }

  @Test
  public void testGetTaskProgress() {
    Task task1 = new Task("Assignment 1", "CS3500", false);
    Task task2 = new Task("Assignment 2", "CS3501", false);
    task1.markComplete();
    week.addTaskToWeek(task1, "Monday");
    week.addTaskToWeek(task2, "Tuesday");
    assertEquals(0.5, week.getTaskProgress(), 0.001);
  }

  @Test
  public void testGetDaysTaskProgress() {
    Task completeT = new Task("Complete Task", "", true);
    Task uncompleteT = new Task("Uncomplete Task", "", false);

    week.addTaskToWeek(completeT, "Sunday");
    week.addTaskToWeek(completeT, "Sunday");
    week.addTaskToWeek(uncompleteT, "Sunday");
    week.addTaskToWeek(completeT, "Monday");
    week.addTaskToWeek(uncompleteT, "Monday");
    week.addTaskToWeek(uncompleteT, "Tuesday");
    week.addTaskToWeek(uncompleteT, "Wednesday");
    week.addTaskToWeek(uncompleteT, "Wednesday");
    week.addTaskToWeek(uncompleteT, "Thursday");
    week.addTaskToWeek(uncompleteT, "Thursday");
    week.addTaskToWeek(completeT, "Thursday");
    week.addTaskToWeek(completeT, "Friday");
    week.addTaskToWeek(completeT, "Friday");
    week.addTaskToWeek(completeT, "Friday");
    week.addTaskToWeek(completeT, "Saturday");
    week.addTaskToWeek(uncompleteT, "Saturday");
    week.addTaskToWeek(completeT, "Saturday");
    week.addTaskToWeek(completeT, "Saturday");
    week.addTaskToWeek(completeT, "Saturday");
    List<Double> progress = week.getDaysTaskProgress();

    assertEquals(0.666, progress.get(0), 0.001);
    assertEquals(.5, progress.get(1), 0.001);
    assertEquals(0, progress.get(2), 0.001);
    assertEquals(0.0, progress.get(3), 0.001);
    assertEquals(.333, progress.get(4), 0.001);
    assertEquals(1, progress.get(5), 0.001);
    assertEquals(.8, progress.get(6), 0.001);
  }

  @Test
  public void testCurrentMaxEvents() {
    List<Day> days = new ArrayList<>();
    days.add(new Day());  // Sunday
    days.add(new Day());  // Monday
    days.add(new Day());  // Tuesday
    days.add(new Day());  // Wednesday
    days.add(new Day());  // Thursday
    days.add(new Day());  // Friday
    days.add(new Day());  // Saturday

    Week week = new Week("Week 1", days);


    week.addEventToWeek(new Event("Meeting", "Team meeting", "10:00 AM",
        "60"), "Monday");
    week.addEventToWeek(new Event("Lunch", "Lunch break", "12:00 PM",
        "45"), "Wednesday");
    week.addEventToWeek(new Event("Presentation", "Client presentation",
        "2:00 PM", "90"), "Friday");

    int expectedMaxEvents = 1;  // The maximum number of events is 1 (on Friday)
    int actualMaxEvents = week.currentMaxEvents();
    assertEquals(expectedMaxEvents, actualMaxEvents);
  }

  @Test
  public void testCurrentMaxTasks() {
    List<Day> days = new ArrayList<>();
    days.add(new Day());  // Sunday
    days.add(new Day());  // Monday
    days.add(new Day());  // Tuesday
    days.add(new Day());  // Wednesday
    days.add(new Day());  // Thursday
    days.add(new Day());  // Friday
    days.add(new Day());  // Saturday

    Week week = new Week("Week 1", days);


    week.addTaskToWeek(new Task("Homework", "Complete math assignment", true), "Sunday");
    week.addTaskToWeek(new Task("Project", "Work on project proposal", false), "Monday");
    week.addTaskToWeek(new Task("Study", "Review for exam", true), "Wednesday");

    int expectedMaxTasks = 1;  // The maximum number of tasks is 1 (on Monday)
    int actualMaxTasks = week.currentMaxTasks();
    assertEquals(expectedMaxTasks, actualMaxTasks);
  }

  @Test
  public void testCompleteTasks() {
    // Create tasks
    Task task1 = new Task("Task 1", "clean room", true);
    Task task2 = new Task("Task 2", "do laundry", false);
    Task task3 = new Task("Task 3", "do homework", true);

    // Add tasks to the week
    week.addTaskToWeek(task1, "Sunday");
    week.addTaskToWeek(task2, "Sunday");
    week.addTaskToWeek(task3, "Sunday");

    System.out.println(week.getSunTasks());

    // Complete tasks
    List<Integer> taskNumbers = Arrays.asList(1, 2);
    week.completeTasks(0, taskNumbers);

    // Check task completion
    List<Task> tasks = week.getSunTasks();
    assertEquals(true, tasks.get(0).isComplete());
    assertEquals(true, tasks.get(1).isComplete());
    assertEquals(true, tasks.get(2).isComplete());
  }

  @Test
  public void testUncompleteTasks() {
    // Create tasks
    Task task1 = new Task("Task 1", "do homework", true);
    Task task2 = new Task("Task 2", "clean room", true);
    Task task3 = new Task("Task 3", "do laundry", true);

    // Add tasks to the week
    week.addTaskToWeek(task1, "Sunday");
    week.addTaskToWeek(task2, "Sunday");
    week.addTaskToWeek(task3, "Sunday");

    // Uncomplete tasks
    List<Integer> taskNumbers = Arrays.asList(0, 2);
    week.uncompleteTasks(0, taskNumbers);

    // Check task completion
    List<Task> tasks = week.getSunTasks();
    assertEquals(false, task1.isComplete());
    assertEquals(true, task2.isComplete());
    assertEquals(false, task3.isComplete());
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
    List<Event> events = week.getSunEvents();
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
    List<Event> events = week.getMonEvents();
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
    List<Event> events = week.getTuesEvents();
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
    List<Event> events = week.getWedEvents();
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
    List<Event> events = week.getThursEvents();
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
    List<Event> events = week.getFriEvents();
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
    List<Event> events = week.getSatEvents();
    assertEquals(events.get(0), satEvents.get(0));
    assertEquals(events.get(1), satEvents.get(1));
    assertEquals(events.get(2), satEvents.get(2));
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
    List<Task> tasks = week.getMonTasks();
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
    List<Task> tasks = week.getTuesTasks();
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
    List<Task> tasks = week.getWedTasks();
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
    List<Task> tasks = week.getThursTasks();
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
    List<Task> tasks = week.getFriTasks();
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
    List<Task> tasks = week.getSatTasks();
    assertEquals(tasks.get(0), satTasks.get(0));
    assertEquals(tasks.get(1), satTasks.get(1));
    assertEquals(tasks.get(2), satTasks.get(2));
  }

}


