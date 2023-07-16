package cs3500.pa05.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.DayRecord;
import cs3500.pa05.model.EventRecord;
import cs3500.pa05.model.TaskRecord;
import cs3500.pa05.model.WeekRecord;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeekRecordTest {
  WeekRecord weekRecord;
  ArrayList<DayRecord> days;

  @BeforeEach
  public void initWeekRecord() {
    List<EventRecord> events = new ArrayList<>();
    events.add(new EventRecord("Office hours", "located at Hurtig", "12:00 pm", "60 minutes"));
    events.add(new EventRecord("Hang out with friends", "", "6:00 pm", "10 minutes"));
    events.add(new EventRecord("Shopping", "Newbury St", "10:00 am", "180 minutes"));

    List<TaskRecord> tasks = new ArrayList<>();
    tasks.add(new TaskRecord("Eat lunch", "IV", true));
    tasks.add(new TaskRecord("Finish PA", "do testing and extra credit", false));

    days = new ArrayList<DayRecord>();
    days.add(new DayRecord(events, tasks));

    weekRecord = new WeekRecord("My Week", days);
  }

  @Test
  public void testGetName() {
    Assertions.assertEquals("My Week", weekRecord.name());
  }

  @Test
  public void testGetDays() {
    Assertions.assertEquals(days, weekRecord.days());
  }
}