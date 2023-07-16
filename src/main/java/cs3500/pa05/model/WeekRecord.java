package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a record representation of a week.
 *
 * @param name the name for this week record.
 * @param days the days in this week record.
 */
public record WeekRecord(
    @JsonProperty("name") String name,
    @JsonProperty("days") List<DayRecord> days) {
}
