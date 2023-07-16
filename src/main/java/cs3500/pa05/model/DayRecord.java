package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a record representation of a day in a BulletJournalRecord.
 *
 * @param events the events in this Day Record.
 * @param tasks the tasks in this Day Record.
 */
public record DayRecord(
    @JsonProperty("events") List<EventRecord> events,
    @JsonProperty("tasks") List<TaskRecord> tasks) {
}
