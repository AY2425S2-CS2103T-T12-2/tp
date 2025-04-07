package seedu.address.ui;

import java.awt.Desktop;
import java.net.URI;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;


/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://ay2425s2-cs2103t-t12-2.github.io/tp/UserGuide.html";

    public static final String HELP_MESSAGE = "For detailed instructions, visit: " + USERGUIDE_URL;

    public static final String TUTORIAL_MESSAGE = """
        PATIENT COMMANDS:
        - addpatient (ap): Add a patient contact
          Usage: addpatient n/NAME p/PHONE [e/EMAIL] [a/ADDRESS] [dr/DOCTOR_IN_CHARGE] [nn/NOK_NAME] [np/NOK_PHONE]
           [dp/DEPARTMENT]
          Example: addpatient n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 dr/Dr Mak
           nn/Mrs Hong Doe np/98721322 dp/Conology
        - finddep (fd):Search patients by department
          Usage: finddep KEYWORD
          Example: finddep surgery
        - listpatient (lsp): View all patients
          Usage: listpatient
        STAFF COMMANDS:
        - addstaff (as): Add a staff contact
          Usage: addstaff [r/ROLE] n/NAME p/PHONE [dp/DEPARTMENT] [e/EMAIL] [a/ADDRESS]
          Example: addstaff r/doctor n/Mary Jane dp/General Surgery p/99291267 e/maryJ@example.com a/Spider street,
           block 333, #03-03
        - findstaff (fs): Search staff by role
          Usage: findstaff KEYWORD
          Example: findstaff nurse
        - liststaff (lss): View all staff
          Usage: liststaff
        GENERAL COMMANDS:
        - clear (cls): Clear the entire address book
          Usage: clear
        - delete (del/d): Remove a contact
          Usage: delete INDEX
          Example: delete 3
        - edit (e): Edit an existing contact
          Usage: edit INDEX [r/role] [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [dr/DOCTOR_IN_CHARGE] [nn/NOK_NAME]
           [np/NOK_PHONE] [dp/DEPARTMENT]
          Example: edit 2 n/James Lee e/jameslee@example.com
        - exit (quit): Exit the application
          Usage: exit
        - find (f): Search contacts by name
          Usage: find KEYWORD [MORE_KEYWORDS]
          Example: find James Jake
        - list (ls): View all contacts
          Usage: list
        - remark (re): Add remark to / Remove remark from existing contact
          - Add
            Usage: remark INDEX rm/REMARK
            Example: remark 1 rm/likes to eat
          - Remove
            Usage: remark INDEX rm/
            Example: remark 1 rm/
        - select (s): Select a contact to show full contact information
          Usage: select INDEX
          Example: select 1
        - toggletheme (tt): Toggle between light and dark mode
          Usage: toggletheme
        """;

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";
    private static final String DARK_THEME = "view/HelpWindow_Dark.css";
    private static final String LIGHT_THEME = "view/HelpWindow_Light.css";

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    @FXML
    private TextArea tutorialMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root, boolean isDarkTheme) {
        super(FXML, root);
        setTutorialMessage();
        updateStyleSheets(isDarkTheme);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow(boolean isDarkTheme) {
        this(new Stage(), isDarkTheme);
    }

    private void setTutorialMessage() {
        helpMessage.setText(HELP_MESSAGE);
        tutorialMessage.setText(TUTORIAL_MESSAGE);
        tutorialMessage.setWrapText(true);
    }

    /**
     * Open the URL to the user guide.
     */
    @FXML
    private void openUrl() {
        try {
            Desktop.getDesktop().browse(new URI(USERGUIDE_URL));
        } catch (Exception e) {
            logger.warning("Failed to open URL: " + e.getMessage());
        }
    }

    /**
     * Shows the help window.
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Updates the theme of the HelpWindow based on the provided theme state.
     * This method clears the existing stylesheets and applies the appropriate theme
     * (dark or light) based on the {@code isDarkTheme} parameter.
     *
     * @param isDarkTheme A boolean value representing the desired theme state.
     *                    {@code true} for dark theme, {@code false} for light theme.
     */
    public void updateStyleSheets(boolean isDarkTheme) {
        ObservableList<String> stylesheets = getRoot().getScene().getStylesheets();
        stylesheets.clear();
        if (isDarkTheme) {
            stylesheets.add(DARK_THEME);
        } else {
            stylesheets.add(LIGHT_THEME);
        }
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }
}
