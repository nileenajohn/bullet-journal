package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a record representation of an Event.
 *
 * @param name the name of this event record.
 * @param description the description for this event record.
 * @param startTime the start time for this event record.
 * @param duration the duration for this event record.
 */
public record EventRecord(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("startTime") String startTime,
    @JsonProperty("duration") String duration) {
}
