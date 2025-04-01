package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;


/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://ay2425s2-cs2103t-t12-2.github.io/tp/UserGuide.html";

    public static final String HELP_MESSAGE = """
        <b>Welcome to A Caring Book!</b><br><br>
        
        <b>PATIENT COMMANDS:</b><br>
        <b>- addpatient:</b> Add a patient contact<br>
          Usage: addpatient n/NAME p/PHONE_NUMBER [e/EMAIL] [a/ADDRESS] [do/DOCTOR] [g/GUARDIAN]
          [dp/DEPARTMENT] [t/TAG]...
          Example: addpatient n/James Ho p/22224444 e/jamesho@example.com a/123 Clementi Rd dr/Dr Mak g/Mrs Ho
          dp/Cardiology t/friend<br><br>
        <b>- findpatient:</b> Search patients by department<br>
          Usage: findpatient KEYWORD<br>
          Example: findpatient surgery<br><br>
        <b>- listpatient:</b> View all patients<br>
          Usage: listpatient<br><br>
          
        <b>STAFF COMMANDS:</b><br>
        <b>- addstaff:</b> Add a staff contact<br>
          Usage: addstaff [r/ROLE] n/NAME p/PHONE_NUMBER [e/EMAIL] [a/ADDRESS] [t/TAG]...
          Example: addstaff r/doctor n/James Ho p/22224444 e/jamesho@example.com a/123 Clementi Rd
          t/colleague<br><br>
        <b>- findstaff:</b> Search staff by role<br>
          Usage: findstaff KEYWORD<br>
          Example: findstaff nurse<br><br>
        <b>- liststaff:</b> View all staff<br>
          Usage: liststaff<br><br>
          
        <b>GENERAL COMMANDS:</b><br>
        <b>- clear:</b> Clear the entire address book<br>
          Usage: clear<br><br>
        <b>- delete:</b> Remove a contact<br>
          Usage: delete INDEX<br>
          Example: delete 3<br><br>
        <b>- edit:</b> Edit an existing contact<br>
          Usage: edit INDEX [r/ROLE] [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [do/DOCTOR] [g/GUARDIAN]
          [dp/DEPARTMENT] [t/TAG]...
          Example: edit 2 n/James Lee e/jameslee@example.com<br><br>
        <b>- exit:</b> Exit the application
          Usage: exit<br><br>
        <b>- find:</b> Search contacts by name<br>
          Usage: find KEYWORD [MORE_KEYWORDS]<br>
          Example: find James Jake<br><br>
        <b>- list:</b> View all contacts<br>
          Usage: list<br><br>
        <b>- remark:</b> Add remark to / Remove remark from existing contact<br>
          - Add
            Usage: remark INDEX rm/REMARK
            Example: remark 1 rm/likes to eat
          - Remove
            Usage: remark INDEX rm/
            
        For detailed instructions, visit:""" + " " + USERGUIDE_URL + "<br>";

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";
    private static final String DARK_THEME = "view/HelpWindow_Dark.css";
    private static final String LIGHT_THEME = "view/HelpWindow_Light.css";

    @FXML
    private Button copyButton;

    @FXML
    private TextFlow helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root, boolean isDarkTheme) {
        super(FXML, root);
        parseAndSetHelpMessage();
        updateStyleSheets(isDarkTheme);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow(boolean isDarkTheme) {
        this(new Stage(), isDarkTheme);
    }

    private void parseAndSetHelpMessage() {
        String[] parts = HELP_MESSAGE.split("<br>");
        for (String part : parts) {
            int lastIndex = 0;
            int boldStart = part.indexOf("<b>");

            while (boldStart != -1) {
                if (boldStart > lastIndex) {
                    // Add plain text before bold
                    Text plainText = new Text(part.substring(lastIndex, boldStart));
                    helpMessage.getChildren().add(plainText);
                }

                int boldEnd = part.indexOf("</b>", boldStart);
                if (boldEnd == -1) {
                    // Malformed bold tag, just add as plain text
                    Text text = new Text(part.substring(lastIndex));
                    helpMessage.getChildren().add(text);
                    break;
                }

                // Add bolded text
                Text boldText = new Text(part.substring(boldStart + 3, boldEnd));
                boldText.setFont(Font.font("System", FontWeight.BOLD, 12));
                helpMessage.getChildren().add(boldText);

                lastIndex = boldEnd + 4;
                boldStart = part.indexOf("<b>", lastIndex);
            }

            // Add any remaining plain text after the last bold section
            if (lastIndex < part.length()) {
                Text remainingText = new Text(part.substring(lastIndex));
                helpMessage.getChildren().add(remainingText);
            }
        }
    }


    /**
     * Shows the help window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
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

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
