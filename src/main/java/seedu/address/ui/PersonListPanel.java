package seedu.address.ui;

import java.util.function.Consumer;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.HealthcareStaff;
import seedu.address.model.person.Patient;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private ListView<Person> personListView;

    private Consumer<Person> personSelectionListener;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonListPanel(ObservableList<Person> personList) {
        super(FXML);
        personListView.setItems(personList);
        personListView.setCellFactory(listView -> new PersonListViewCell());

        // Add listener to monitor selection changes
        personListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Notify the listener (MainWindow) when a person is selected
            if (personSelectionListener != null) {
                personSelectionListener.accept(newValue);
            }
            // Handle the selection, e.g., by updating the UI or performing an action
            logger.info("Selected Person: " + newValue);
        });
    }

    // Set the listener to be called when a person is selected
    public void setPersonSelectionListener(Consumer<Person> listener) {
        this.personSelectionListener = listener;
    }

    public void setSelectedPerson(Person personToSelect) {
        if (personToSelect == null) {
            personListView.getSelectionModel().clearSelection();
        }

        // Get the index of the person you want to select
        int indexToSelect = personListView.getItems().indexOf(personToSelect);
        if (indexToSelect >= 0) {
            personListView.getSelectionModel().select(indexToSelect);
            personListView.scrollTo(indexToSelect);
        }
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                if (person instanceof Patient) {
                    setGraphic(new PatientCard((Patient) person, getIndex() + 1).getRoot());
                } else if (person instanceof HealthcareStaff) {
                    setGraphic(new StaffCard((HealthcareStaff) person, getIndex() + 1).getRoot());
                } else {
                    setGraphic(new PersonCard(person, getIndex() + 1).getRoot());
                }
            }
        }
    }

}
