package cs3500.pa05.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.EventRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EventRecordTest {
  EventRecord event1 = new EventRecord("Office hours", "located at Hurtig",
      "12:00 pm", "60 minutes");
  EventRecord event2 = new EventRecord("Hang out with friends", "",
      "6:00 pm", "10 minutes");
  EventRecord event3 = new EventRecord("Shopping", "Newbury St",
      "10:00 am", "180 minutes");

  @Test
  public void testGetName() {
    Assertions.assertEquals("Office hours", event1.name());
    Assertions.assertEquals("Hang out with friends", event2.name());
    Assertions.assertEquals("Shopping", event3.name());
  }

  @Test
  public void testGetDescription() {
    Assertions.assertEquals("located at Hurtig", event1.description());
    Assertions.assertEquals("", event2.description());
    Assertions.assertEquals("Newbury St", event3.description());
  }

  @Test
  public void testGetStartTime() {
    Assertions.assertEquals("12:00 pm", event1.startTime());
    Assertions.assertEquals("6:00 pm", event2.startTime());
    Assertions.assertEquals("10:00 am", event3.startTime());
  }

  @Test
  public void testGetDuration() {
    Assertions.assertEquals("60 minutes", event1.duration());
    Assertions.assertEquals("10 minutes", event2.duration());
    Assertions.assertEquals("180 minutes", event3.duration());
  }

}