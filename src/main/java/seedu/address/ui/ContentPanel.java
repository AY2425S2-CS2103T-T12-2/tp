package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.HealthcareStaff;
import seedu.address.model.person.Patient;
import seedu.address.model.person.Person;

/**
 * A UI component that displays the details of a selected person.
 */
public class ContentPanel extends UiPart<Region> {

    private static final String FXML = "ContentPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ContentPanel.class);

    @FXML
    private TextArea contentArea;

    public ContentPanel() {
        super(FXML);
    }

    /**
     * Update the contentArea to reflect {@code person} details
     *
     * @param person
     */
    public void updateContent(Person person) {
        requireNonNull(person);
        StringBuilder details = new StringBuilder();
        details.append("Role: " + person.getRole() + "\n")
                .append("Name: " + person.getName() + "\n")
                .append("Phone: " + person.getPhone() + "\n")
                .append("Email: " + person.getEmail() + "\n")
                .append("Address: " + person.getAddress() + "\n");

        if (person instanceof Patient patient) {
            details.append("Doctor in charge: " + patient.getDoctorInCharge() + "\n")
                    .append("Department: " + patient.getDepartment() + "\n")
                    .append("Next of Kin: " + patient.getNextofKin() + "\n");
        }

        if (person instanceof HealthcareStaff healthcareStaff) {
            details.append("Department: " + healthcareStaff.getDepartment() + "\n");
        }

        details.append("Remark: " + person.getRemark());

        contentArea.setText(details.toString()); // Set the TextArea to display the details
        logger.info("Selected Person: " + details);
    }

}
