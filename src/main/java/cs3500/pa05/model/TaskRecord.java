package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a record representation of a task.
 *
 * @param name the name for the task record.
 * @param description the description for the task record.
 * @param complete whether this task is complete or not.
 */
public record TaskRecord(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("complete") boolean complete
) {
}
