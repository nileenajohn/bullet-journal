package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for the Event class.
 */
public class EventTest {
  private Event event;
  private Event event1;

  @BeforeEach
  public void setup() {
    event = new Event("Meeting", "Discuss project details", "10:00 AM", "60");
    event1 = new Event("Lunch", "", "12:30 PM", "45");
  }


  @Test
  public void testGetName() {
    assertEquals("Meeting", event.getName());
  }

  @Test
  public void testGetEventData() {
    assertEquals("Meeting - Discuss project details (10:00 AM | 60 min)", event.getEventData());
    assertEquals("Lunch (12:30 PM | 45 min)", event1.getEventData());
  }

  @Test
  public void testGetDescription() {
    assertEquals("Discuss project details", event.getDescription());
    assertEquals("", event1.getDescription());
  }

  @Test
  public void testGetStartTime() {
    assertEquals("10:00 AM", event.getStartTime());
  }

  @Test
  public void testGetDuration() {
    assertEquals("60", event.getDuration());
  }
}
