package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Patient;

/**
 * An UI component that displays information of a {@code Patient}.
 */
public class PatientCard extends UiPart<Region> {

    private static final String FXML = "PatientListCard.fxml"; // Update to the correct FXML file for patient cards

    public final Patient patient;

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

    /**
     * Creates a {@code PatientCard} with the given {@code Person} to display.
     */
    public PatientCard(Patient patient, int displayedIndex) {
        super(FXML);
        this.patient = patient;

        // Default Person Details
        id.setText(displayedIndex + ". ");
        name.setText(patient.getName().fullName);
        phone.setText(patient.getPhone().value);
        address.setText(patient.getAddress().value);
        email.setText(patient.getEmail().value);

        // Extra Patient Details
        tags.getChildren().add(new Label(patient.getRole().toString()));

        // Add label only if it's not "NA"
        addIfNotNA(patient.getDepartment().toString());
    }

    private void addIfNotNA(String label) {
        if (!"NA".equals(label)) {
            tags.getChildren().add(new Label(label.toUpperCase()));
        }
    }
}
