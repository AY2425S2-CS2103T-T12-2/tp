package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

import static java.util.Objects.requireNonNull;

public class ContentPanel extends UiPart<Region> {

    private static final String FXML = "ContentPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ContentPanel.class);

    @FXML
    private TextArea contentArea;

    public ContentPanel() {
        super(FXML);
    }

    // Method to update the content of the TextArea with the selected person's details
    public void updateContent(Person person) {
        String details = "Name: " + person.getName() + "\n" +
                "Phone: " + person.getPhone() + "\n" +
                "Email: " + person.getEmail() + "\n" +
                "Address: " + person.getAddress();

        contentArea.setText(details);  // Set the TextArea to display the details
        logger.info("Selected Person: " + details);
    }

}
