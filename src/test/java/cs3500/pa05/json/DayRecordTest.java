package cs3500.pa05.json;

import cs3500.pa05.model.DayRecord;
import cs3500.pa05.model.EventRecord;
import cs3500.pa05.model.TaskRecord;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayRecordTest {
  List<EventRecord> events;
  List<TaskRecord> tasks;
  DayRecord dayRecord;

  @BeforeEach
  public void initDayRecord() {
    events = new ArrayList<>();
    events.add(new EventRecord("Office hours", "located at Hurtig", "12:00 pm", "60 minutes"));
    events.add(new EventRecord("Hang out with friends", "", "6:00 pm", "10 minutes"));
    events.add(new EventRecord("Shopping", "Newbury St", "10:00 am", "180 minutes"));

    tasks = new ArrayList<>();
    tasks.add(new TaskRecord("Eat lunch", "IV", true));
    tasks.add(new TaskRecord("Finish PA", "do testing and extra credit", false));
    dayRecord = new DayRecord(events, tasks);
  }

  @Test
  public void testGetEventsForRecord() {
    Assertions.assertEquals(events, dayRecord.events());
  }

  @Test
  public void testGetTasksForRecord() {
    Assertions.assertEquals(tasks, dayRecord.tasks());
  }

}
