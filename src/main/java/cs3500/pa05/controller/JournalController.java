package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.BulletJournal;
import cs3500.pa05.model.BulletJournalRecord;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayRecord;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.EventRecord;
import cs3500.pa05.model.FileWriter;
import cs3500.pa05.model.JournalInterface;
import cs3500.pa05.model.JsonUtils;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.TaskRecord;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.WeekRecord;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Represents a controller for a Journal Application.
 */
public class JournalController implements ControllerInterface {
  private Stage stage;
  private Popup popup;
  @FXML
  private Button addEventBtn;
  @FXML
  private Button addTaskBtn;
  @FXML
  private ChoiceBox dayOfWeekChoiceBox;
  @FXML
  private Button saveEventBtn;
  @FXML
  private Button saveTaskBtn;
  @FXML
  private TextField eventNameInput;
  @FXML
  private TextField eventDescriptionInput;
  @FXML
  private TextField eventStartTimeInput;
  @FXML
  private TextField eventDurationInput;
  @FXML
  private VBox sunEvents;
  @FXML
  private VBox monEvents;
  @FXML
  private VBox tuesEvents;
  @FXML
  private VBox wedEvents;
  @FXML
  private VBox thursEvents;
  @FXML
  private VBox friEvents;
  @FXML
  private VBox satEvents;
  @FXML
  private ChoiceBox taskDayOfWeekChoiceBox;
  @FXML
  private ChoiceBox startTimeChoiceBox;
  @FXML
  private VBox sunTasks;
  @FXML
  private VBox monTasks;
  @FXML
  private VBox tuesTasks;
  @FXML
  private VBox wedTasks;
  @FXML
  private VBox thursTasks;
  @FXML
  private VBox friTasks;
  @FXML
  private VBox satTasks;
  @FXML
  private TextField taskNameInput;
  @FXML
  private TextField taskDescriptionInput;
  @FXML
  private CheckBox completeInput;
  @FXML
  private VBox taskQueue;
  @FXML
  private Button saveBtn;
  @FXML
  private Label eventErrorMessage;
  @FXML
  private Label taskErrorMessage;
  @FXML
  private Button openFileBtn;
  @FXML
  private Label openFileErrorMessage;
  @FXML
  private Button saveFilePopupBtn;
  @FXML
  private Label saveFileErrorMessage;
  @FXML
  private TextField pathInput;
  @FXML
  private Button openFilePopupBtn;
  @FXML
  private Button newWeekBtn;
  @FXML
  private ProgressBar sunTaskProgress;
  @FXML
  private ProgressBar monTaskProgress;
  @FXML
  private ProgressBar tuesTaskProgress;
  @FXML
  private ProgressBar wedTaskProgress;
  @FXML
  private ProgressBar thursTaskProgress;
  @FXML
  private ProgressBar friTaskProgress;
  @FXML
  private ProgressBar satTaskProgress;
  @FXML
  private Label totalEventsLabel;
  @FXML
  private Label totalTasksLabel;
  @FXML
  private Label sunTaskRate;
  @FXML
  private Label sunTasksRemaining;
  @FXML
  private Label monTaskRate;
  @FXML
  private Label monTasksRemaining;
  @FXML
  private Label tuesTaskRate;
  @FXML
  private Label tuesTasksRemaining;
  @FXML
  private Label wedTaskRate;
  @FXML
  private Label wedTasksRemaining;
  @FXML
  private Label thursTaskRate;
  @FXML
  private Label thursTasksRemaining;
  @FXML
  private Label friTaskRate;
  @FXML
  private Label friTasksRemaining;
  @FXML
  private Label satTaskRate;
  @FXML
  private Label satTasksRemaining;
  @FXML
  private ProgressBar weekTaskProgress;
  @FXML
  private TextArea notesArea;
  @FXML
  private TextField weekNameField;
  @FXML
  private Button changeMaxEventsTasksBtn;
  @FXML
  private Button setMaxEventsTasksPopupBtn;
  @FXML
  private Button switchViewBtn;
  @FXML
  private TextField maxEventsInput;
  @FXML
  private TextField maxTasksInput;
  @FXML
  private Label maxEventsLabel;
  @FXML
  private Label maxTasksLabel;
  @FXML
  private Label setMaxErrorMessage;
  private JournalInterface journalModel;
  private ObservableList<String> dayOfWeekList = FXCollections.observableArrayList(
      "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
  boolean count = true;
  @FXML
  private ObservableList<String> startDayList = FXCollections.observableArrayList(
      "Sunday", "Monday");
  @FXML
  private ChoiceBox startDayChoiceBox;
  @FXML
  private Button startDayBtn;
  @FXML
  private Button chooseDayBtn;

  private final String password = "password123";


  /**
   * Represents a constructor for a JournalController.
   *
   * @param model The model controller by this JournalController.
   * @param stage The stage to set the scene for the BulletJournal Application.
   */
  public JournalController(JournalInterface model, Stage stage) {
    this.journalModel = model;
    this.stage = stage;
  }

  /**
   * Initializes a BulletJournal application by first opening the privacy lock screen.
   */
  @FXML
  public void run() {
    privacyLock();
  }

  /**
   * Calls methods to sets up action event for different functionality within the program such as
   * creating an event, creating a task, saving a file, opening a file, clearing the journal,
   * changing the max events and tasks, switching the orientation, and changing the start day.
   */
  private void setup() {
    makeEventPopupAction();
    makeTaskPopupAction();
    makeSaveFilePopupAction();
    makeOpenFilePopupAction();
    makeClearJournalAction();
    changeMaxEventsTaskPopupAction();
    switchViewPopupAction();
    makeStartDayPopupAction();
  }

  /**
   * Creates the action event for either doing command+E or ctrl+E/add event button and opening the
   * make event popup.
   */
  private void makeEventPopupAction() {
    KeyCombination kcControlE = new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN);
    KeyCombination kcCommandE = new KeyCodeCombination(KeyCode.E, KeyCombination.SHORTCUT_DOWN);
    Runnable rnEventPopup = () -> makeEventPopup();
    this.stage.getScene().getAccelerators().put(kcControlE, rnEventPopup);
    this.stage.getScene().getAccelerators().put(kcCommandE, rnEventPopup);
    addEventBtn.setOnAction(e -> makeEventPopup());
  }

  /**
   * Creates the action event for either doing command+T or ctrl+T/clicking the make task button
   * and opening the make task popup.
   */
  private void makeTaskPopupAction() {
    KeyCombination kcControlT = new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN);
    KeyCombination kcCommandT = new KeyCodeCombination(KeyCode.T, KeyCombination.SHORTCUT_DOWN);
    Runnable rnTaskPopup = () -> makeTaskPopup();
    this.stage.getScene().getAccelerators().put(kcControlT, rnTaskPopup);
    this.stage.getScene().getAccelerators().put(kcCommandT, rnTaskPopup);
    addTaskBtn.setOnAction(e -> makeTaskPopup());
  }

  /**
   * Creates the action event for either doing command+S or ctrl+S/clicking the save file button
   * and opening the save file popup.
   */
  private void makeSaveFilePopupAction() {
    KeyCombination kcControlS = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
    KeyCombination kcCommandS = new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN);
    Runnable rnSaveFilePopup = () -> makeSaveFilePopup();
    this.stage.getScene().getAccelerators().put(kcControlS, rnSaveFilePopup);
    this.stage.getScene().getAccelerators().put(kcCommandS, rnSaveFilePopup);
    saveBtn.setOnAction(e -> makeSaveFilePopup());
  }

  /**
   * Creates the action event for either doing command+O or ctrl+O/clicking the open file button
   * and opening the open file popup.
   */
  private void makeOpenFilePopupAction() {
    KeyCombination kcControlO = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
    KeyCombination kcCommandO = new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN);
    Runnable rnOpenFilePopup = () -> makeOpenFilePopup();
    this.stage.getScene().getAccelerators().put(kcControlO, rnOpenFilePopup);
    this.stage.getScene().getAccelerators().put(kcCommandO, rnOpenFilePopup);
    openFileBtn.setOnAction(e -> makeOpenFilePopup());
  }

  /**
   * Creates the action event for either doing command+N or ctrl+N or clicking the new week button
   * and clearing the journal.
   */
  private void makeClearJournalAction() {
    KeyCombination kcControlN = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
    KeyCombination kcCommandN = new KeyCodeCombination(KeyCode.N, KeyCombination.SHORTCUT_DOWN);
    Runnable rnNewWeek = () -> clearJournal();
    this.stage.getScene().getAccelerators().put(kcControlN, rnNewWeek);
    this.stage.getScene().getAccelerators().put(kcCommandN, rnNewWeek);
    newWeekBtn.setOnAction(e -> clearJournal());
  }

  /**
   * Creates the action event for either doing command+M or ctrl+M/clicking the change max button
   * and changing the max events/tasks.
   */
  private void changeMaxEventsTaskPopupAction() {
    KeyCombination kcControlM = new KeyCodeCombination(KeyCode.M, KeyCombination.CONTROL_DOWN);
    KeyCombination kcCommandM = new KeyCodeCombination(KeyCode.M, KeyCombination.SHORTCUT_DOWN);
    Runnable rnChangeMax = () -> makeChangeMaxEventsTasksPopup();
    this.stage.getScene().getAccelerators().put(kcControlM, rnChangeMax);
    this.stage.getScene().getAccelerators().put(kcCommandM, rnChangeMax);
    changeMaxEventsTasksBtn.setOnAction(e -> makeChangeMaxEventsTasksPopup());
  }

  /**
   * Creates the action event for clicking the switch view button and switching the orientation of
   * the journal.
   */
  private void switchViewPopupAction() {
    switchViewBtn.setOnAction(e -> switchView());
  }

  /**
   * Creates the action event for either doing command+D or ctrl+D or clicking the change start day
   * button and switching the start day of the journal.
   */
  private void makeStartDayPopupAction() {
    KeyCombination kcControlD = new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN);
    KeyCombination kcCommandD = new KeyCodeCombination(KeyCode.D, KeyCombination.SHORTCUT_DOWN);
    Runnable rnChangeStartDay = () -> makeStartDayPopup();
    this.stage.getScene().getAccelerators().put(kcControlD, rnChangeStartDay);
    this.stage.getScene().getAccelerators().put(kcCommandD, rnChangeStartDay);

    startDayBtn.setOnAction(e -> makeStartDayPopup());
  }

  /**
   * Creates the popup for changing the start day of the week.
   */
  @FXML
  private void makeStartDayPopup() {
    this.popup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(
        "startDayPopup.fxml"));
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    popup.getContent().add((Node) s.getRoot());
    startDayChoiceBox.setItems(startDayList);
    Button b = new Button("X");
    b.setOnAction(e -> popup.hide());
    popup.getContent().add(b);

    this.popup.show(this.stage);
    chooseDayBtn.setOnAction(e -> switchDays());
  }

  /**
   * Changes the journal's display so the start day of the week is Monday.
   */
  private void makeWeekStartMon() {
    FXMLLoader loader;
    if (this.journalModel.isHorizontal()) {
      loader = new FXMLLoader(getClass().getClassLoader().getResource(
          "monJournal.fxml"));
    } else {
      loader = new FXMLLoader(getClass().getClassLoader().getResource(
          "monJournalVertical.fxml"));
    }
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    this.stage.setScene(s);
    setup();
    displayJournal();
  }

  /**
   * Changes the journal's display so the start day of the week is Sunday.
   */
  private void makeWeekStartSun() {
    FXMLLoader loader;
    if (this.journalModel.isHorizontal()) {
      loader = new FXMLLoader(getClass().getClassLoader().getResource(
          "journal.fxml"));
    } else {
      loader = new FXMLLoader(getClass().getClassLoader().getResource(
          "journalVertical.fxml"));
    }
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    this.stage.setScene(s);
    setup();
    displayJournal();
  }

  /**
   * Changes the start day value of the journal based on the user's input in the choice box.
   */
  @FXML
  private void switchDays() {
    if (startDayChoiceBox.getValue().equals("Monday")) {
      this.journalModel.changeStartDay(false);
      makeWeekStartMon();
    } else if (startDayChoiceBox.getValue().equals("Sunday")) {
      this.journalModel.changeStartDay(true);
      makeWeekStartSun();
    }
  }

  /**
   * Creates the popup for adding an event to the journal.
   */
  @FXML
  private void makeEventPopup() {
    this.popup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(
        "addEventPopup.fxml"));
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    popup.getContent().add((Node) s.getRoot());
    dayOfWeekChoiceBox.setItems(dayOfWeekList);
    startTimeChoiceBox.setItems(FXCollections.observableArrayList("am", "pm"));
    Button b = new Button("X");
    b.setOnAction(e -> popup.hide());
    popup.getContent().add(b);

    this.popup.show(this.stage);
    saveEventBtn.setOnAction(e -> addEventToList());
  }

  /**
   * Switches the journal's orientation based on this journal model's current orientation.
   */
  private void switchView() {
    if (this.journalModel.isHorizontal()) {
      switchViewToVertical();
    } else {
      switchViewToHorizontal();
    }
  }

  /**
   * Switches the journal's display orientation and the orientation field of the journal model to
   * vertical.
   */
  private void switchViewToVertical() {
    FXMLLoader loader;
    if (this.journalModel.isStartDaySun()) {
      loader = new FXMLLoader(getClass().getClassLoader().getResource(
          "journalVertical.fxml"));
    } else {
      loader = new FXMLLoader(getClass().getClassLoader().getResource(
          "monJournalVertical.fxml"));
    }
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    this.stage.setScene(s);
    this.journalModel.setHorizontal(false);
    displayJournal();
    setup();
  }

  /**
   * Switches the journal's display orientation and the orientation field of the journal model to
   * horizontal.
   */
  private void switchViewToHorizontal() {
    FXMLLoader loader;
    if (this.journalModel.isStartDaySun()) {
      loader = new FXMLLoader(getClass().getClassLoader().getResource(
          "journal.fxml"));
    } else {
      loader = new FXMLLoader(getClass().getClassLoader().getResource(
          "monJournal.fxml"));
    }
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    this.stage.setScene(s);
    this.journalModel.setHorizontal(true);
    displayJournal();
    setup();
  }

  /**
   * Creates the popup for opening a file.
   */
  @FXML
  private void makeOpenFilePopup() {
    this.popup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(
        "openFilePopup.fxml"));
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    popup.getContent().add((Node) s.getRoot());
    Button b = new Button("X");
    b.setOnAction(e -> popup.hide());
    popup.getContent().add(b);
    this.popup.show(this.stage);
    openFilePopupBtn.setOnAction(e -> {
      try {
        openFile(Paths.get(pathInput.getText() + ".bujo"));
      } catch (IOException ex) {
        openFileErrorMessage.setText("File cannot be opened");
      }
    });
  }

  /**
   * Creates the popup for saving a file.
   */
  @FXML
  private void makeSaveFilePopup() {
    this.popup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(
        "saveFilePopup.fxml"));
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    popup.getContent().add((Node) s.getRoot());
    Button b = new Button("X");
    b.setOnAction(e -> popup.hide());
    popup.getContent().add(b);
    this.popup.show(this.stage);
    saveFilePopupBtn.setOnAction(e -> saveInfoToFile(Paths.get(pathInput.getText())));
  }

  /**
   * Creates the popup for creating a task.
   */
  @FXML
  private void makeTaskPopup() {
    this.popup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(
        "addTaskPopup.fxml"));
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    popup.getContent().add((Node) s.getRoot());
    taskDayOfWeekChoiceBox.setItems(dayOfWeekList);
    Button b = new Button("X");
    b.setOnAction(e -> popup.hide());
    popup.getContent().add(b);

    this.popup.show(this.stage);
    saveTaskBtn.setOnAction(e -> addTaskToList());
  }

  /**
   * Creates the popup for changing the max events and tasks for the journal.
   */
  @FXML
  private void makeChangeMaxEventsTasksPopup() {
    this.popup = new Popup();
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(
        "changeMaxEventsTasksPopup.fxml"));
    loader.setController(this);
    Scene s = null;
    try {
      s = loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    popup.getContent().add((Node) s.getRoot());
    Button b = new Button("X");
    b.setOnAction(e -> popup.hide());
    popup.getContent().add(b);
    this.popup.show(this.stage);
    setMaxEventsTasksPopupBtn.setOnAction(e -> getMaxEventsTaskInput());
  }

  /**
   * Sets the max events and max tasks of the journal model to the user's input in the max events &
   * tasks popup.
   */
  private void getMaxEventsTaskInput() {
    try {
      if (Integer.parseInt(maxEventsInput.getText()) >= this.journalModel.currentMaxEvents()
          && Integer.parseInt(maxTasksInput.getText()) >= this.journalModel.currentMaxTasks()) {
        this.journalModel.setMaxEvents(Integer.parseInt(maxEventsInput.getText()));
        this.journalModel.setMaxTasks(Integer.parseInt(maxTasksInput.getText()));
        this.updateMaxEventsTasks();
        setMaxErrorMessage.setText("");
      } else {
        setMaxErrorMessage.setText("Your existing commitments exceed these specifications.");
      }
    } catch (NumberFormatException ex) {
      setMaxErrorMessage.setText("Input must be a number");
    }
  }

  /**
   * Responsible for adding an event when the user clicks the save event button.
   */
  @FXML
  private void addEventToList() {
    if (eventNameInput.getText().length() == 0
        || dayOfWeekChoiceBox.getValue() == null || startTimeChoiceBox.getValue() == null
        || eventStartTimeInput.getText().contains(":") == false) {
      eventErrorMessage.setText("Event cannot be added due to invalid inputs.");
    } else {
      try {
        eventErrorMessage.setText("");
        Integer.parseInt(eventDurationInput.getText());
        int startTimeHour = Integer.parseInt(eventStartTimeInput.getText().substring(0,
            eventStartTimeInput.getText().indexOf(":")));
        int startTimeMinutes = Integer.parseInt(eventStartTimeInput.getText().substring(
            eventStartTimeInput.getText().indexOf(":") + 1,
            eventStartTimeInput.getText().length()));

        if (startTimeHour < 1 || startTimeHour > 12 || startTimeMinutes < 0
            || startTimeMinutes >= 60) {
          eventErrorMessage.setText("Event cannot be added due to invalid inputs.");
        } else {
          String day = (String) dayOfWeekChoiceBox.getValue();
          Event event = new Event(eventNameInput.getText(), eventDescriptionInput.getText(),
              eventStartTimeInput.getText() + " "
                  + startTimeChoiceBox.getValue().toString(), eventDurationInput.getText());

          Label l = new Label(event.getEventData());
          l.setWrapText(true);
          if (dayOfWeekChoiceBox.getValue().equals("Sunday")) {
            if (journalModel.getSunEvents().size() >= journalModel.getMaxEvents()) {
              eventErrorMessage.setText("Events on this day exceed max events.");
            } else {
              journalModel.addEvent(event, day);
              sunEvents.getChildren().add(l);
            }
          } else if (dayOfWeekChoiceBox.getValue().equals("Monday")) {
            if (journalModel.getMonEvents().size() >= journalModel.getMaxEvents()) {
              eventErrorMessage.setText("Events on this day exceed max events.");
            } else {
              journalModel.addEvent(event, day);
              monEvents.getChildren().add(l);
            }
          } else if (dayOfWeekChoiceBox.getValue().equals("Tuesday")) {
            if (journalModel.getTuesEvents().size() >= journalModel.getMaxEvents()) {
              eventErrorMessage.setText("Events on this day exceed max events.");
            } else {
              journalModel.addEvent(event, day);
              tuesEvents.getChildren().add(l);
            }
          } else if (dayOfWeekChoiceBox.getValue().equals("Wednesday")) {
            if (journalModel.getWedEvents().size() >= journalModel.getMaxEvents()) {
              eventErrorMessage.setText("Events on this day exceed max events.");
            } else {
              journalModel.addEvent(event, day);
              wedEvents.getChildren().add(l);
            }
          } else if (dayOfWeekChoiceBox.getValue().equals("Thursday")) {
            if (journalModel.getThursEvents().size() >= journalModel.getMaxEvents()) {
              eventErrorMessage.setText("Events on this day exceed max events.");
            } else {
              journalModel.addEvent(event, day);
              thursEvents.getChildren().add(l);
            }
          } else if (dayOfWeekChoiceBox.getValue().equals("Friday")) {
            if (journalModel.getFriEvents().size() >= journalModel.getMaxEvents()) {
              eventErrorMessage.setText("Events on this day exceed max events.");
            } else {
              journalModel.addEvent(event, day);
              friEvents.getChildren().add(l);
            }
          } else if (dayOfWeekChoiceBox.getValue().equals("Saturday")) {
            if (journalModel.getSatEvents().size() >= journalModel.getMaxEvents()) {
              eventErrorMessage.setText("Events on this day exceed max events.");
            } else {
              journalModel.addEvent(event, day);
              satEvents.getChildren().add(l);
            }
          }
        }
      } catch (NumberFormatException e) {
        eventErrorMessage.setText("Event cannot be added due to invalid inputs.");
      }
    }
  }

  /**
   * Responsible for adding an event when the user clicks the save task button.
   */
  @FXML
  private void addTaskToList() {
    String day = (String) taskDayOfWeekChoiceBox.getValue();
    Task task = new Task(taskNameInput.getText(), taskDescriptionInput.getText());

    CheckBox dayCb = new CheckBox();
    dayCb.setOnAction(e -> updateProgress());
    CheckBox taskQueueCb = new CheckBox();
    dayCb.setText(task.getTaskData());
    taskQueueCb.setText(task.getTaskData());
    dayCb.setWrapText(true);
    taskQueueCb.setWrapText(true);
    if (taskDayOfWeekChoiceBox.getValue().equals("Sunday")) {
      if (journalModel.getSunTasks().size() >= journalModel.getMaxTasks()) {
        taskErrorMessage.setText("Tasks on this day exceed max tasks.");
      } else {
        journalModel.addTask(task, day);
        sunTasks.getChildren().add(dayCb);
        updateSundayTasksCompletion();
        taskQueue.getChildren().add(taskQueueCb);
        taskErrorMessage.setText("");
      }
    } else if (taskDayOfWeekChoiceBox.getValue().equals("Monday")) {
      if (journalModel.getMonTasks().size() >= journalModel.getMaxTasks()) {
        taskErrorMessage.setText("Tasks on this day exceed max tasks.");
      } else {
        journalModel.addTask(task, day);
        monTasks.getChildren().add(dayCb);
        updateMondayTasksCompletion();
        taskQueue.getChildren().add(taskQueueCb);
        taskErrorMessage.setText("");
      }
    } else if (taskDayOfWeekChoiceBox.getValue().equals("Tuesday")) {
      if (journalModel.getTuesTasks().size() >= journalModel.getMaxTasks()) {
        taskErrorMessage.setText("Tasks on this day exceed max tasks.");
      } else {
        journalModel.addTask(task, day);
        tuesTasks.getChildren().add(dayCb);
        updateTuesdayTasksCompletion();
        taskQueue.getChildren().add(taskQueueCb);
        taskErrorMessage.setText("");
      }
    } else if (taskDayOfWeekChoiceBox.getValue().equals("Wednesday")) {
      if (journalModel.getWedTasks().size() >= journalModel.getMaxTasks()) {
        taskErrorMessage.setText("Tasks on this day exceed max tasks.");
      } else {
        journalModel.addTask(task, day);
        wedTasks.getChildren().add(dayCb);
        updateWednesdayTasksCompletion();
        taskQueue.getChildren().add(taskQueueCb);
        taskErrorMessage.setText("");
      }
    } else if (taskDayOfWeekChoiceBox.getValue().equals("Thursday")) {
      if (journalModel.getThursTasks().size() >= journalModel.getMaxTasks()) {
        taskErrorMessage.setText("Tasks on this day exceed max tasks.");
      } else {
        journalModel.addTask(task, day);
        thursTasks.getChildren().add(dayCb);
        updateThursdayTasksCompletion();
        taskQueue.getChildren().add(taskQueueCb);
        taskErrorMessage.setText("");
      }
    } else if (taskDayOfWeekChoiceBox.getValue().equals("Friday")) {
      if (journalModel.getFriTasks().size() >= journalModel.getMaxTasks()) {
        taskErrorMessage.setText("Tasks on this day exceed max tasks.");
      } else {
        journalModel.addTask(task, day);
        friTasks.getChildren().add(dayCb);
        updateFridayTasksCompletion();
        taskQueue.getChildren().add(taskQueueCb);
        taskErrorMessage.setText("");
      }
    } else if (taskDayOfWeekChoiceBox.getValue().equals("Saturday")) {
      if (journalModel.getSatTasks().size() >= journalModel.getMaxTasks()) {
        taskErrorMessage.setText("Tasks on this day exceed max tasks.");
      } else {
        journalModel.addTask(task, day);
        satTasks.getChildren().add(dayCb);
        updateSaturdayTasksCompletion();
        taskQueue.getChildren().add(taskQueueCb);
        taskErrorMessage.setText("");
      }
    }
    updateStats();
  }

  /**
   * Responsible for saving all the information associated with a journal to the given path.
   *
   * @param path the path to save the journal information to
   */
  @FXML
  private void saveInfoToFile(Path path) {
    this.saveWeekName(weekNameField.getText());
    this.saveNotes(notesArea.getText());
    BulletJournalRecord record = convertJournalToRecord(this.journalModel);
    JsonNode node = JsonUtils.serializeRecord(record);
    node.toString();

    File fileOutput = path.toFile();
    FileWriter wf = new FileWriter();
    wf.writeToFile(fileOutput, node.toString());
  }

  /**
   * Responsible for displaying a new journal based on the journal information in the file at the
   * given path.
   *
   * @param path the path to the file of journal information.
   * @throws IOException when the file cannot be read
   */
  private void openFile(Path path) throws IOException {
    String jsonContent = "";
    clearJournal();
    jsonContent = new String(Files.readAllBytes(path));
    ObjectMapper objectMapper = new ObjectMapper();
    BulletJournalRecord record = objectMapper.readValue(jsonContent, BulletJournalRecord.class);
    this.journalModel = convertRecordToJournal(record);
    this.switchView();
    this.switchView();
    if (this.journalModel.isStartDaySun()) {
      makeWeekStartSun();
    } else {
      makeWeekStartMon();
    }
  }

  /**
   * Converts a BulletJournalRecord into a BulletJournal
   *
   * @param record the BulletJournalRecord to be converted
   * @return the given BulletJournalRecord as a BulletJournal
   */
  private BulletJournal convertRecordToJournal(BulletJournalRecord record) {
    List<Day> days = new ArrayList<>();
    for (DayRecord d : record.week().days()) {
      List<Event> events = new ArrayList<>();
      for (EventRecord e : d.events()) {
        events.add(new Event(e.name(), e.description(), e.startTime(), e.duration()));
      }
      List<Task> tasks = new ArrayList<>();
      for (TaskRecord t : d.tasks()) {
        tasks.add(new Task(t.name(), t.description(), t.complete()));
      }
      days.add(new Day(events, tasks));
    }
    Week week = new Week(record.week().name(), days);
    return new BulletJournal(week, record.notes(), record.maxEvents(), record.maxTasks(),
        record.horizontal(),
        record.startDaySun());
  }

  /**
   * Converts a BulletJournal into a BulletJournalRecord
   *
   * @param journal the BulletJournal to be converted
   * @return the given BulletJournal as a BulletJournalRecord
   */
  private BulletJournalRecord convertJournalToRecord(JournalInterface journal) {
    List<DayRecord> days = new ArrayList<>();

    for (Day d : journal.getWeek().getDays()) {
      List<EventRecord> events = new ArrayList<>();
      for (Event e : d.getEvents()) {
        events.add(new EventRecord(e.getName(), e.getDescription(), e.getStartTime(),
            e.getDuration()));
      }
      List<TaskRecord> tasks = new ArrayList<>();
      for (Task t : d.getTasks()) {
        tasks.add(new TaskRecord(t.getName(), t.getDescription(), t.isComplete()));
      }
      days.add(new DayRecord(events, tasks));
    }

    WeekRecord week = new WeekRecord(journal.getWeekName(), days);
    return new BulletJournalRecord(week, journal.getNotes(), journal.getMaxEvents(),
        journal.getMaxTasks(), journal.isHorizontal(), journal.isStartDaySun());
  }

  /**
   * Changes the display of the journal by updating the name of the week, the events in each day,
   * the tasks in each day, the notes area, the progress bar for each day, and the set max events
   * and tasks for the week.
   */
  private void displayJournal() {
    updateWeekName();
    updateEvents();
    updateTasks();
    updateNotes();
    updateProgress();
    updateMaxEventsTasks();
  }

  /**
   * Updates the max events and max tasks label to the max events and max tasks specified for this
   * journal model.
   */
  private void updateMaxEventsTasks() {
    maxEventsLabel.setText(String.valueOf(this.journalModel.getMaxEvents()));
    maxTasksLabel.setText(String.valueOf(this.journalModel.getMaxTasks()));
  }

  /**
   * Clears the journal by clearing all events and tasks in the week, clearing tasks in the task
   * queue, clearing notes, clearing the week name, updating the max events and tasks, and switching
   * the view back to default.
   */
  private void clearJournal() {
    this.journalModel = new BulletJournal();
    clearWeek();
    clearTaskQueue();
    clearNotes();
    clearWeekName();
    updateMaxEventsTasks();
    switchView();
    switchView();
  }

  /**
   * Clears all the events and tasks for the week for each day.
   */
  private void clearWeek() {
    sunEvents.getChildren().clear();
    monEvents.getChildren().clear();
    tuesEvents.getChildren().clear();
    wedEvents.getChildren().clear();
    thursEvents.getChildren().clear();
    friEvents.getChildren().clear();
    satEvents.getChildren().clear();

    sunTasks.getChildren().clear();
    monTasks.getChildren().clear();
    tuesTasks.getChildren().clear();
    wedTasks.getChildren().clear();
    thursTasks.getChildren().clear();
    friTasks.getChildren().clear();
    satTasks.getChildren().clear();
  }

  /**
   * Removes the tasks in the task queue.
   */
  private void clearTaskQueue() {
    taskQueue.getChildren().clear();
  }

  /**
   * Clears the notes area.
   */
  private void clearNotes() {
    notesArea.clear();
  }

  /**
   * Saves the given notes to the journal model's notes area.
   *
   * @param notes the notes to be saved to the journal model
   */
  private void saveNotes(String notes) {
    this.journalModel.saveNotes(notes);
  }

  /**
   * Clears the week name text field of the journal display.
   */
  private void clearWeekName() {
    this.weekNameField.clear();
  }

  /**
   * Saves the given name to the journal model's week name.
   *
   * @param name the name to set the journal models' week name to.
   */
  private void saveWeekName(String name) {
    this.journalModel.setWeekName(name);
  }

  /**
   * Updates the week name area to the journal model's week name.
   */
  private void updateWeekName() {
    this.weekNameField.setText(this.journalModel.getWeekName());
  }

  /**
   * Updates the task progress on the journal display by updating the task completion for the task
   * queue and the progress bars for each day and the journal's overall task progression bar.
   */
  private void updateProgress() {
    this.updateTaskCompletion();
    this.updateStats();
    this.updateTasks();
  }

  /**
   * Updates the journal's display with each day's completed tasks by checking the completion of
   * each task for each day.
   */
  private void updateTaskCompletion() {
    updateSundayTasksCompletion();
    updateMondayTasksCompletion();
    updateTuesdayTasksCompletion();
    updateWednesdayTasksCompletion();
    updateThursdayTasksCompletion();
    updateFridayTasksCompletion();
    updateSaturdayTasksCompletion();
  }

  /**
   * Updates the journal's display with Sunday's completed tasks by checking the completion of
   * each task for Sunday. Updates the progress bar for Sunday's tasks.
   */
  private void updateSundayTasksCompletion() {
    List<Integer> sunCompletedTasks = new ArrayList<>();
    List<Integer> sunUncompletedTasks = new ArrayList<>();

    int count = 0;
    for (Node n : sunTasks.getChildren()) {
      if (((CheckBox) n).isSelected()) {
        sunCompletedTasks.add(count);
      } else {
        sunUncompletedTasks.add(count);
      }
      count++;
    }
    this.journalModel.completeTasks(0, sunCompletedTasks);
    this.journalModel.uncompleteTasks(0, sunUncompletedTasks);

    int countCompletedTasks = 0;
    for (Task t : journalModel.getSunTasks()) {
      if (t.isComplete()) {
        countCompletedTasks++;
      }
    }
    int countTotalTasks = journalModel.getSunTasks().size();
    sunTaskProgress.setProgress(Double.valueOf(countCompletedTasks)
        / Double.valueOf(countTotalTasks));
    sunTaskRate.setText(countCompletedTasks + " Tasks Completed out of " + countTotalTasks
        + " Total Tasks");
    sunTasksRemaining.setText(countTotalTasks - countCompletedTasks + " Tasks Remaining");
  }

  /**
   * Updates the journal's display with Monday's completed tasks by checking the completion of
   * each task for Monday. Updates the progress bar for Monday's tasks.
   */
  private void updateMondayTasksCompletion() {
    List<Integer> monCompletedTasks = new ArrayList<>();
    List<Integer> monUncompletedTasks = new ArrayList<>();

    int count = 0;
    for (Node n : monTasks.getChildren()) {
      if (((CheckBox) n).isSelected()) {
        monCompletedTasks.add(count);
      } else {
        monUncompletedTasks.add(count);
      }
      count++;
    }
    this.journalModel.completeTasks(1, monCompletedTasks);
    this.journalModel.uncompleteTasks(1, monUncompletedTasks);

    int countCompletedTasks = 0;
    for (Task t : journalModel.getMonTasks()) {
      if (t.isComplete()) {
        countCompletedTasks++;
      }
    }
    int countTotalTasks = journalModel.getMonTasks().size();
    monTaskProgress.setProgress(Double.valueOf(countCompletedTasks)
        / Double.valueOf(countTotalTasks));
    monTaskRate.setText(countCompletedTasks + " Tasks Completed out of " + countTotalTasks
        + " Total Tasks");
    monTasksRemaining.setText(countTotalTasks - countCompletedTasks + " Tasks Remaining");
  }

  /**
   * Updates the journal's display with Tuesday's completed tasks by checking the completion of
   * each task for Tuesday. Updates the progress bar for Tuesday's tasks.
   */
  private void updateTuesdayTasksCompletion() {
    List<Integer> tuesCompletedTasks = new ArrayList<>();
    List<Integer> tuesUncompletedTasks = new ArrayList<>();

    int count = 0;
    for (Node n : tuesTasks.getChildren()) {
      if (((CheckBox) n).isSelected()) {
        tuesCompletedTasks.add(count);
      } else {
        tuesUncompletedTasks.add(count);
      }
      count++;
    }
    this.journalModel.completeTasks(2, tuesCompletedTasks);
    this.journalModel.uncompleteTasks(2, tuesUncompletedTasks);

    int countCompletedTasks = 0;
    for (Task t : journalModel.getTuesTasks()) {
      if (t.isComplete()) {
        countCompletedTasks++;
      }
    }
    int countTotalTasks = journalModel.getTuesTasks().size();
    tuesTaskProgress.setProgress(Double.valueOf(countCompletedTasks)
        / Double.valueOf(countTotalTasks));
    tuesTaskRate.setText(countCompletedTasks + " Tasks Completed out of " + countTotalTasks
        + " Total Tasks");
    tuesTasksRemaining.setText(countTotalTasks - countCompletedTasks + " Tasks Remaining");
  }

  /**
   * Updates the journal's display with Wednesday's completed tasks by checking the completion of
   * each task for Wednesday. Updates the progress bar for Wednesday's tasks.
   */
  private void updateWednesdayTasksCompletion() {
    List<Integer> wedCompletedTasks = new ArrayList<>();
    List<Integer> wedUncompletedTasks = new ArrayList<>();

    int count = 0;
    for (Node n : wedTasks.getChildren()) {
      if (((CheckBox) n).isSelected()) {
        wedCompletedTasks.add(count);
      } else {
        wedUncompletedTasks.add(count);
      }
      count++;
    }
    this.journalModel.completeTasks(3, wedCompletedTasks);
    this.journalModel.uncompleteTasks(3, wedUncompletedTasks);

    int countCompletedTasks = 0;
    for (Task t : journalModel.getWedTasks()) {
      if (t.isComplete()) {
        countCompletedTasks++;
      }
    }
    int countTotalTasks = journalModel.getWedTasks().size();
    wedTaskProgress.setProgress(Double.valueOf(countCompletedTasks)
        / Double.valueOf(countTotalTasks));
    wedTaskRate.setText(countCompletedTasks + " Tasks Completed out of " + countTotalTasks
        + " Total Tasks");
    wedTasksRemaining.setText(countTotalTasks - countCompletedTasks + " Tasks Remaining");
  }

  /**
   * Updates the journal's display with Thursday's completed tasks by checking the completion of
   * each task for Thursday. Updates the progress bar for Thursday's tasks.
   */
  private void updateThursdayTasksCompletion() {
    List<Integer> thursCompletedTasks = new ArrayList<>();
    List<Integer> thursUncompletedTasks = new ArrayList<>();

    int count = 0;
    for (Node n : thursTasks.getChildren()) {
      if (((CheckBox) n).isSelected()) {
        thursCompletedTasks.add(count);
      } else {
        thursUncompletedTasks.add(count);
      }
      count++;
    }
    this.journalModel.completeTasks(4, thursCompletedTasks);
    this.journalModel.uncompleteTasks(4, thursUncompletedTasks);

    int countCompletedTasks = 0;
    for (Task t : journalModel.getThursTasks()) {
      if (t.isComplete()) {
        countCompletedTasks++;
      }
    }
    int countTotalTasks = journalModel.getThursTasks().size();
    thursTaskProgress.setProgress(Double.valueOf(countCompletedTasks)
        / Double.valueOf(countTotalTasks));
    thursTaskRate.setText(countCompletedTasks + " Tasks Completed out of " + countTotalTasks
        + " Total Tasks");
    thursTasksRemaining.setText(countTotalTasks - countCompletedTasks + " Tasks Remaining");
  }

  /**
   * Updates the journal's display with Friday's completed tasks by checking the completion of
   * each task for Friday. Updates the progress bar for Friday's tasks.
   */
  private void updateFridayTasksCompletion() {
    List<Integer> friCompletedTasks = new ArrayList<>();
    List<Integer> friUncompletedTasks = new ArrayList<>();

    int count = 0;
    for (Node n : friTasks.getChildren()) {
      if (((CheckBox) n).isSelected()) {
        friCompletedTasks.add(count);
      } else {
        friUncompletedTasks.add(count);
      }
      count++;
    }
    this.journalModel.completeTasks(5, friCompletedTasks);
    this.journalModel.uncompleteTasks(5, friUncompletedTasks);

    int countCompletedTasks = 0;
    for (Task t : journalModel.getFriTasks()) {
      if (t.isComplete()) {
        countCompletedTasks++;
      }
    }
    int countTotalTasks = journalModel.getFriTasks().size();
    friTaskProgress.setProgress(Double.valueOf(countCompletedTasks)
        / Double.valueOf(countTotalTasks));
    friTaskRate.setText(countCompletedTasks + " Tasks Completed out of " + countTotalTasks
        + " Total Tasks");
    friTasksRemaining.setText(countTotalTasks - countCompletedTasks + " Tasks Remaining");
  }

  /**
   * Updates the journal's display with Saturday's completed tasks by checking the completion of
   * each task for Saturday. Updates the progress bar for Saturday's tasks.
   */
  private void updateSaturdayTasksCompletion() {
    List<Integer> satCompletedTasks = new ArrayList<>();
    List<Integer> satUncompletedTasks = new ArrayList<>();

    int count = 0;
    for (Node n : satTasks.getChildren()) {
      if (((CheckBox) n).isSelected()) {
        satCompletedTasks.add(count);
      } else {
        satUncompletedTasks.add(count);
      }
      count++;
    }
    this.journalModel.completeTasks(6, satCompletedTasks);
    this.journalModel.uncompleteTasks(6, satUncompletedTasks);

    int countCompletedTasks = 0;
    for (Task t : journalModel.getSatTasks()) {
      if (t.isComplete()) {
        countCompletedTasks++;
      }
    }
    int countTotalTasks = journalModel.getSatTasks().size();
    satTaskProgress.setProgress(Double.valueOf(countCompletedTasks)
        / Double.valueOf(countTotalTasks));
    satTaskRate.setText(countCompletedTasks + " Tasks Completed out of " + countTotalTasks
        + " Total Tasks");
    satTasksRemaining.setText(countTotalTasks - countCompletedTasks + " Tasks Remaining");
  }

  /**
   * Updates the statistics box for the journal display by updating the total events and total
   * tasks and the task progress for the whole week.
   */
  private void updateStats() {
    this.totalEventsLabel.setText(Integer.toString(this.journalModel.getTotalEvents()));
    this.totalTasksLabel.setText(Integer.toString(this.journalModel.getTotalTasks()));
    this.weekTaskProgress.setProgress(this.journalModel.getTaskProgress());
  }

  /**
   * Updates the journal's display with each day's events based on the events in the journal model.
   */
  private void updateEvents() {
    for (Event e : journalModel.getSunEvents()) {
      Label l = new Label(e.getEventData());
      l.setWrapText(true);
      sunEvents.getChildren().add(l);
    }
    for (Event e : journalModel.getMonEvents()) {
      Label l = new Label(e.getEventData());
      l.setWrapText(true);
      monEvents.getChildren().add(l);
    }
    for (Event e : journalModel.getTuesEvents()) {
      Label l = new Label(e.getEventData());
      l.setWrapText(true);
      tuesEvents.getChildren().add(l);
    }
    for (Event e : journalModel.getWedEvents()) {
      Label l = new Label(e.getEventData());
      l.setWrapText(true);
      wedEvents.getChildren().add(l);
    }
    for (Event e : journalModel.getThursEvents()) {
      Label l = new Label(e.getEventData());
      l.setWrapText(true);
      thursEvents.getChildren().add(l);
    }
    for (Event e : journalModel.getFriEvents()) {
      Label l = new Label(e.getEventData());
      l.setWrapText(true);
      friEvents.getChildren().add(l);
    }
    for (Event e : journalModel.getSatEvents()) {
      Label l = new Label(e.getEventData());
      l.setWrapText(true);
      satEvents.getChildren().add(l);
    }
  }

  /**
   * Updates the journal's display with each day's tasks based on the tasks in the journal model.
   */
  private void updateTasks() {
    clearDayTasks();

    for (Task t : journalModel.getSunTasks()) {
      updateSunTasks(createDayCb(t), createTaskCb(t));
    }
    for (Task t : journalModel.getMonTasks()) {
      updateMonTasks(createDayCb(t), createTaskCb(t));
    }
    for (Task t : journalModel.getTuesTasks()) {
      updateTuesTasks(createDayCb(t), createTaskCb(t));
    }
    for (Task t : journalModel.getWedTasks()) {
      updateWedTasks(createDayCb(t), createTaskCb(t));
    }
    for (Task t : journalModel.getThursTasks()) {
      updateThursTasks(createDayCb(t), createTaskCb(t));
    }
    for (Task t : journalModel.getFriTasks()) {
      updateFriTasks(createDayCb(t), createTaskCb(t));
    }
    for (Task t : journalModel.getSatTasks()) {
      updateSatTasks(createDayCb(t), createTaskCb(t));
    }
  }

  /**
   * Clears the task for each day's box.
   */
  private void clearDayTasks() {
    sunTasks.getChildren().clear();
    monTasks.getChildren().clear();
    tuesTasks.getChildren().clear();
    wedTasks.getChildren().clear();
    thursTasks.getChildren().clear();
    friTasks.getChildren().clear();
    satTasks.getChildren().clear();
    taskQueue.getChildren().clear();
  }

  /**
   * Create a checkbox for a task to be placed in the day's box.
   *
   * @param t the Task to create a checkbox for
   * @return the checkbox for the given task
   */
  private CheckBox createDayCb(Task t) {
    CheckBox dayCb = new CheckBox();
    dayCb.setOnAction(e -> updateProgress());
    dayCb.setText(t.getTaskData());
    dayCb.setWrapText(true);
    dayCb.setSelected(t.isComplete());
    return dayCb;
  }

  /**
   * Create a checkbox for a task to be placed in the task queue.
   *
   * @param t the Task to create a checkbox for
   * @return the checkbox for the given task
   */
  private CheckBox createTaskCb(Task t) {
    CheckBox taskQueueCb = new CheckBox();
    taskQueueCb.setOnAction(e -> updateProgress());
    taskQueueCb.setText(t.getTaskData());
    taskQueueCb.setWrapText(true);
    taskQueueCb.setSelected(t.isComplete());
    return taskQueueCb;
  }

  /**
   * Updates the tasks in Sunday's box and in the task queue by adding the given checkboxes.
   *
   * @param dayCb the CheckBox to add to Sunday's box.
   * @param taskQueueCb the CheckBox to add to the task queue.
   */
  private void updateSunTasks(CheckBox dayCb, CheckBox taskQueueCb) {
    sunTasks.getChildren().add(dayCb);
    taskQueue.getChildren().add(taskQueueCb);
  }

  /**
   * Updates the tasks in Monday's box and in the task queue by adding the given checkboxes.
   *
   * @param dayCb the CheckBox to add to Monday's box.
   * @param taskQueueCb the CheckBox to add to the task queue.
   */
  private void updateMonTasks(CheckBox dayCb, CheckBox taskQueueCb) {
    monTasks.getChildren().add(dayCb);
    taskQueue.getChildren().add(taskQueueCb);
  }

  /**
   * Updates the tasks in Tuesday's box and in the task queue by adding the given checkboxes.
   *
   * @param dayCb the CheckBox to add to Tuesday's box.
   * @param taskQueueCb the CheckBox to add to the task queue.
   */
  private void updateTuesTasks(CheckBox dayCb, CheckBox taskQueueCb) {
    tuesTasks.getChildren().add(dayCb);
    taskQueue.getChildren().add(taskQueueCb);
  }

  /**
   * Updates the tasks in Wednesday's box and in the task queue by adding the given checkboxes.
   *
   * @param dayCb the CheckBox to add to Wednesday's box.
   * @param taskQueueCb the CheckBox to add to the task queue.
   */
  private void updateWedTasks(CheckBox dayCb, CheckBox taskQueueCb) {
    wedTasks.getChildren().add(dayCb);
    taskQueue.getChildren().add(taskQueueCb);
  }

  /**
   * Updates the tasks in Thursday's box and in the task queue by adding the given checkboxes.
   *
   * @param dayCb the CheckBox to add to Thursday's box.
   * @param taskQueueCb the CheckBox to add to the task queue.
   */
  private void updateThursTasks(CheckBox dayCb, CheckBox taskQueueCb) {
    thursTasks.getChildren().add(dayCb);
    taskQueue.getChildren().add(taskQueueCb);
  }

  /**
   * Updates the tasks in Friday's box and in the task queue by adding the given checkboxes.
   *
   * @param dayCb the CheckBox to add to Friday's box.
   * @param taskQueueCb the CheckBox to add to the task queue.
   */
  private void updateFriTasks(CheckBox dayCb, CheckBox taskQueueCb) {
    friTasks.getChildren().add(dayCb);
    taskQueue.getChildren().add(taskQueueCb);
  }

  /**
   * Updates the tasks in Saturday's box and in the task queue by adding the given checkboxes.
   *
   * @param dayCb the CheckBox to add to Saturday's box.
   * @param taskQueueCb the CheckBox to add to the task queue.
   */
  private void updateSatTasks(CheckBox dayCb, CheckBox taskQueueCb) {
    satTasks.getChildren().add(dayCb);
    taskQueue.getChildren().add(taskQueueCb);
  }

  /**
   * Updates the notes area with the notes associated with this journal model.
   */
  private void updateNotes() {
    notesArea.setText(this.journalModel.getNotes());
  }

  /**
   * Creates the privacy lock before displaying the journal.
   */
  public void privacyLock() {
    // Create the login screen
    PasswordField passwordField = new PasswordField();
    Button loginButton = new Button("Login");

    GridPane loginPane = new GridPane();
    loginPane.setPadding(new Insets(10));
    loginPane.setHgap(10);
    loginPane.setVgap(10);
    loginPane.add(new Label("Password:"), 0, 0);
    loginPane.add(passwordField, 1, 0);
    loginPane.add(loginButton, 1, 1);

    Scene loginScene = new Scene(loginPane, 300, 200);

    this.stage.setScene(loginScene);
    this.stage.setTitle("Bullet Journal App");
    this.stage.show();

    // Handle login button click
    loginButton.setOnAction(event -> {
      String enteredPassword = passwordField.getText();
      if (authenticate(enteredPassword)) {
        // Set the journal view as the primary stage scene if authentication is successful
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getClassLoader().getResource(
            "journal.fxml"));
        loader.setController(this);
        Scene s = null;
        try {
          s = loader.load();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
        this.stage.setScene(s);
        displayJournal();
        setup();
      } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Authentication Error");
        alert.setHeaderText("Invalid password");
        alert.setContentText("Please enter the correct password.");
        alert.showAndWait();
      }
      // Clear the password field after each login attempt
      passwordField.clear();
    });
  }

  /**
   * Authenticates the user tring to access the journal by checking the entered password.
   *
   * @param enteredPassword the user's entered password to be authenticated.
   * @return whether the entered password is correct.
   */
  private boolean authenticate(String enteredPassword) {
    return enteredPassword.equals(password);
  }
}
