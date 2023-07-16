package cs3500.pa05.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.model.JsonUtils;
import cs3500.pa05.model.TaskRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Represents test for the JsonUtils class.
 */
public class JsonUtilsTest {

  @Test
  public void testSerializeTaskRecord() {
    // Create a sample Record object to serialize
    TaskRecord taskRecord = new TaskRecord("Task Record", "tasks", true);

    // Serialize the Record object using the JsonUtils class
    JsonNode jsonNode = JsonUtils.serializeRecord(taskRecord);

    assertEquals(true, JsonUtils.serializeRecord(taskRecord) instanceof JsonNode);

    Assertions.assertNotNull(jsonNode);
    Assertions.assertEquals("Task Record", jsonNode.get("name").asText());
    Assertions.assertEquals("tasks", jsonNode.get("description").asText());
    Assertions.assertEquals(true, jsonNode.get("complete").asBoolean());
  }

  @Test
  public void testSerializeRecordIllegalArgument() {
    // Create a sample Record object to serialize
    JsonUtils jsonUtils = new JsonUtils();
    TaskRecord taskRecord = new TaskRecord("Task Record", "tasks", true);
    // Serialize the Record object using the JsonUtils class
    try {
      JsonNode jsonNode = jsonUtils.serializeRecord(taskRecord);

      // Assert that the serialized JsonNode is not null
      Assertions.assertNotNull(jsonNode);
    } catch (IllegalArgumentException e) {
      // Assert that the correct exception message is thrown
      Assertions.assertEquals("Given record cannot be serialized", e.getMessage());
    }
  }
}