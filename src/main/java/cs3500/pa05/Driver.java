package cs3500.pa05;

import cs3500.pa05.controller.ControllerInterface;
import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.model.JournalInterface;
import cs3500.pa05.view.GuiViewInterface;
import cs3500.pa05.view.JournalGuiView;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Represents a simple interactive application with a GUI.
 */
public class Driver extends Application {
  /**
   * Starts the GUI for a simple interactive application.
   *
   * @param stage the JavaFX stage to add elements to
   */
  @Override
  public void start(Stage stage) {
    // instantiate a simple welcome GUI view
    JournalInterface model = new BulletJournal();
    ControllerInterface journalController = new JournalController(model, stage);

    GuiViewInterface jgv = new JournalGuiView(journalController);

    try {
      // load and place the view's scene onto the stage
      stage.setScene(jgv.load());
      stage.setTitle("Bullet Journal");
      journalController.run();
      // render the stage
      stage.show();
    } catch (IllegalStateException e) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Runs a GUI application.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) throws IOException {
    launch();
  }
}