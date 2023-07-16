package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a record representation of a Bullet Journal.
 *
 * @param week the WeekRecord for this BulletJournal record.
 * @param notes the notes record for this BulletJournal record.
 * @param maxEvents the maxEvents for this BulletJournal record.
 * @param maxTasks the maxTasks for this BulletJournal record.
 * @param horizontal whether the orientation is horizontal for this BulletJournal record.
 * @param startDaySun whether the start day is Sunday for this BulletJournal record.
 */
public record BulletJournalRecord(
    @JsonProperty("week") WeekRecord week,
    @JsonProperty("notes") String notes,
    @JsonProperty("maxEvents") int maxEvents,
    @JsonProperty("maxTasks") int maxTasks,
    @JsonProperty("horizontal") boolean horizontal,
    @JsonProperty("startDaySun") boolean startDaySun) {
}
