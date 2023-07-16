package cs3500.pa05.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.BulletJournalRecord;
import cs3500.pa05.model.DayRecord;
import cs3500.pa05.model.EventRecord;
import cs3500.pa05.model.TaskRecord;
import cs3500.pa05.model.WeekRecord;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for the BulletJournalRecord class.
 */
public class BulletJournalRecordTest {
  BulletJournalRecord bulletJournalRecord;
  WeekRecord weekRecord;
  List<DayRecord> days;

  /**
   * Initializes a BulletJournalRecord for tests.
   */
  @BeforeEach
  public void initBulletJournalRecord() {
    List<EventRecord> events = new ArrayList<>();
    events.add(new EventRecord("Office hours", "located at Hurtig",
        "12:00 pm", "60 minutes"));
    events.add(new EventRecord("Hang out with friends", "",
        "6:00 pm", "10 minutes"));
    events.add(new EventRecord("Shopping", "Newbury St",
        "10:00 am", "180 minutes"));

    List<TaskRecord> tasks = new ArrayList<>();
    tasks.add(new TaskRecord("Eat lunch", "IV", true));
    tasks.add(new TaskRecord("Finish PA", "do testing and extra credit",
        false));

    days = new ArrayList<>();
    days.add(new DayRecord(events, tasks));

    weekRecord = new WeekRecord("My Week", days);

    WeekRecord weekRecord = new WeekRecord("My Week", days);
    bulletJournalRecord = new BulletJournalRecord(weekRecord, "here are a few notes, "
        + "clean room", 6, 12, true, false);
  }

  /**
   * Tests that week() returns the BulletJournalRecord's week record.
   */
  @Test
  public void testBulletJournalRecordWeek() {
    Assertions.assertEquals(weekRecord, bulletJournalRecord.week());
  }

  /**
   * Test that notes() returns the BulletJournalRecord's notes.
   */
  @Test
  public void testBulletJournalRecordNotes() {
    Assertions.assertEquals("here are a few notes, clean room",
        bulletJournalRecord.notes());
  }

  @Test
  public void testBulletJournalRecordMaxEvents() {
    Assertions.assertEquals(6, bulletJournalRecord.maxEvents());
  }

  @Test
  public void testBulletJournalRecordMaxTasks() {
    Assertions.assertEquals(12, bulletJournalRecord.maxTasks());
  }

  @Test
  public void testBulletJournalRecordHorizontal() {
    Assertions.assertEquals(true, bulletJournalRecord.horizontal());
  }

  @Test
  public void testBulletJournalRecordStartDay() {
    Assertions.assertEquals(false, bulletJournalRecord.startDaySun());
  }
}
