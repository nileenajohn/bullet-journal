package cs3500.pa05.view;

import cs3500.pa05.controller.ControllerInterface;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Represents a Journal GUI view.
 */
public class JournalGuiView implements GuiViewInterface {
  FXMLLoader loader;
  @FXML
  private TextField eventNameInput;
  @FXML
  private TextField eventDescriptionInput;
  @FXML
  private VBox sunEvents;

  /**
   * Represents a constructor for a GUIView.
   *
   * @param controller the controller of the loader of this view.
   */
  public JournalGuiView(ControllerInterface controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("journal.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads a scene.
   *
   * @return the layout
   */
  @Override
  public Scene load() {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
