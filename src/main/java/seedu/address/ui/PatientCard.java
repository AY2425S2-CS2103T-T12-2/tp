package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Patient;

/**
 * An UI component that displays information of a {@code Patient}.
 */
public class PatientCard extends UiPart<Region> {

    private static final String FXML = "PatientCard.fxml"; // Update to the correct FXML file for patient cards

    public final Patient patient;

    @FXML
    private HBox cardPane;
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
    private Label doctor;
    @FXML
    private Label department;
    @FXML
    private Label nok;

    /**
     * Creates a {@code PatientCard} with the given {@code Person} to display.
     */
    public PatientCard(Patient patient, int displayedIndex) {
        super(FXML);
        this.patient = patient;
        id.setText(displayedIndex + ". ");
        name.setText(patient.getName().fullName);
        phone.setText("HP: " + patient.getPhone().value);
        address.setText("Address: " + patient.getAddress().value);
        email.setText("Email: " + patient.getEmail().value);
        doctor.setText("Doctor: " + patient.getDoctorInCharge());
        department.setText("Department: " + patient.getDepartment().toString());
        nok.setText("NOK: " + patient.getGuardian());
    }
}
