package cs3500.pa05.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.TaskRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskRecordTest {

  TaskRecord taskRecord1;
  TaskRecord taskRecord2;

  @BeforeEach
  public void initTaskRecord() {
    taskRecord1 = new TaskRecord("Eat lunch", "IV", true);
    taskRecord2 = new TaskRecord("Finish PA", "do testing and extra credit", false);
  }

  @Test
  public void testGetName() {
    Assertions.assertEquals("Eat lunch", taskRecord1.name());
    Assertions.assertEquals("Finish PA", taskRecord2.name());
  }

  @Test
  public void testGetDescription() {
    Assertions.assertEquals("IV", taskRecord1.description());
    Assertions.assertEquals("do testing and extra credit", taskRecord2.description());
  }

  @Test
  public void testGetComplete() {
    Assertions.assertEquals(true, taskRecord1.complete());
    Assertions.assertEquals(false, taskRecord2.complete());
  }

}