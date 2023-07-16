package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * Represents an interface for a GUIView.
 */
public interface GuiViewInterface {
  /**
   * Loads a scene.
   *
   * @return the layout
   */
  Scene load() throws IllegalStateException;
}
