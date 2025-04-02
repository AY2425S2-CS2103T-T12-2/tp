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
    private FlowPane role;
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
    private Label nokName;
    @FXML
    private Label nokPhone;

    /**
     * Creates a {@code PatientCard} with the given {@code Person} to display.
     */
    public PatientCard(Patient patient, int displayedIndex) {
        super(FXML);
        this.patient = patient;
        id.setText(displayedIndex + ". ");
        name.setText(patient.getName().fullName);
        phone.setText(patient.getPhone().value);
        address.setText(patient.getAddress().value);
        email.setText(patient.getEmail().value);
        doctor.setText(patient.getDoctorInCharge());
        department.setText(patient.getDepartment().toString());
        role.getChildren().add(new Label(patient.getRole().toString()));
        nokName.setText(patient.getNextofKin().getName().toString());
        nokPhone.setText(patient.getNextofKin().getPhone().toString());

    }
}
