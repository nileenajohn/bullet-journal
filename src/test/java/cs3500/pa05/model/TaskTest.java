package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for the Task class.
 */
public class TaskTest {

  private Task task;
  private Task task1;

  private Task task2;

  @BeforeEach
  public void setup() {
    task = new Task("Homework", "Complete math assignment", false);
    task1 = new Task("Homework", "", true);
  }


  @Test
  public void testIsComplete() {
    assertFalse(task.isComplete());
    assertTrue(task1.isComplete());
  }

  @Test
  public void testNoBooleanTaskConstructor() {
    task2 = new Task("Homework", "Science assignment");
    assertEquals("Homework", task2.getName());
  }

  @Test
  public void testMarkComplete() {
    task.markComplete();
    assertTrue(task.isComplete());
  }

  @Test
  public void testMarkUncomplete() {
    task.markComplete();
    task1.markUncomplete();
    assertTrue(task.isComplete());
    assertFalse(task1.isComplete());
  }


  @Test
  public void testGetTaskData() {
    assertEquals("Homework", task1.getTaskData());
    assertEquals("Homework - Complete math assignment", task.getTaskData());
  }

  @Test
  public void testGetName() {
    assertEquals("Homework", task.getName());
  }

  @Test
  public void testGetDescription() {

    assertEquals("Complete math assignment", task.getDescription());
    assertEquals("", task1.getDescription());
  }
}