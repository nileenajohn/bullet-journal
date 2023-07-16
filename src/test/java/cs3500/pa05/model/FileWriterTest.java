package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Represents test for the FileWriter class.
 */
public class FileWriterTest {

  @Test
  public void testWriteToFile() throws Exception {
    File tempFile = File.createTempFile("test", ".txt");
    String filePath = tempFile.getAbsolutePath();
    String contents = "This is a test content.";
    FileWriter fileWriter = new FileWriter();
    fileWriter.writeToFile(tempFile, contents);
    String fileContent = Files.readString(Path.of(filePath + ".bujo"));
    Assertions.assertEquals(contents, fileContent);
  }

  @Test
  public void testWriteToFile_RuntimeException() {
    File invalidFile = new File("/path/does/not/exist/test.txt");
    String contents = "This is a test content.";
    FileWriter fileWriter = new FileWriter();
    Assertions.assertThrows(RuntimeException.class, () -> fileWriter.writeToFile(invalidFile,
        contents));
  }
}