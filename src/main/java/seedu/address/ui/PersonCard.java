package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    private static final Logger logger = LogsCenter.getLogger(PersonCard.class);

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private FlowPane tags;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label remark;

    /**
     * Creates a {@code PersonCard} with the given {@code Person} and index to display.
     * Uses the default FXML if no custom FXML is provided.
     */
    public PersonCard(Person person, int displayedIndex) {
        this(person, displayedIndex, FXML);
    }

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex, String fxml) {
        super(fxml);
        this.person = person;

        // Default Person Details
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        phone.setText(person.getPhone().value);
        address.setText(person.getAddress().value);
        email.setText(person.getEmail().value);

        addIfNotNA(person.getRole().toString());

        logger.info("Person card initialised: " + person);
    }

    protected void addIfNotNA(String label) {
        if (!"NA".equals(label)) {
            Label newLabel = new Label(label.toUpperCase());
            setLabelStyle(newLabel, label);
            tags.getChildren().add(newLabel);
        }
    }

    private void setLabelStyle(Label label, String labelText) {
        switch (labelText.toLowerCase()) {
        case "patient" -> label.getStyleClass().add("role-patient");
        case "staff" -> label.getStyleClass().add("role-staff");
        case "doctor" -> label.getStyleClass().add("providerrole-doctor");
        case "nurse" -> label.getStyleClass().add("providerrole-nurse");
        case "therapist" -> label.getStyleClass().add("providerrole-therapist");
        default -> label.getStyleClass().add("department");
        }
    }
}
