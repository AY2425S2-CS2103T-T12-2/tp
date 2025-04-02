package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.person.HealthcareStaff;
import seedu.address.model.person.Patient;
import seedu.address.model.person.Person;
import seedu.address.testutil.PatientBuilder;

class AddPatientCommandTest {

    private ModelStub modelStub;
    private Patient validPatient;

    @BeforeEach
    void setUp() {
        modelStub = new ModelStub();
        validPatient = new PatientBuilder().withName("John Doe").withPhone("98765432")
                .withEmail("johnd@example.com").withAddress("311, Clementi Ave 2, #02-25")
                .withDoc("Dr Tan Chee Hwa").withNok("Mr Hao Doe")
                .withDepartment("Gastroenterology").withTags("elder").build();
    }

    @Test
    @Disabled("Disabled temporarily")
    void execute_newPatient_success() throws Exception {
        AddPatientCommand addPatientCommand = new AddPatientCommand(validPatient);
        CommandResult result = addPatientCommand.execute(modelStub);

        assertEquals(String.format(AddPatientCommand.MESSAGE_SUCCESS, validPatient), result.getFeedbackToUser());
        assertEquals(1, modelStub.patientsAdded.size());
    }

    @Test
    void execute_duplicatePatient_throwsCommandException() {
        modelStub.addPatient(validPatient);
        AddPatientCommand addPatientCommand = new AddPatientCommand(validPatient);

        assertThrows(CommandException.class, () -> addPatientCommand.execute(modelStub),
                AddPatientCommand.MESSAGE_DUPLICATE_PERSON);
    }

    @Test
    void equals_sameObject_returnsTrue() {
        AddPatientCommand addPatientCommand = new AddPatientCommand(validPatient);
        assertEquals(addPatientCommand, addPatientCommand);
    }

    @Test
    void equals_differentObject_returnsFalse() {
        AddPatientCommand addPatientCommand1 = new AddPatientCommand(validPatient);
        Patient anotherPatient = new PatientBuilder().withName("Jane Doe").build();
        AddPatientCommand addPatientCommand2 = new AddPatientCommand(anotherPatient);

        assertEquals(false, addPatientCommand1.equals(addPatientCommand2));
    }

    private class ModelStub implements Model {
        final ArrayList<Patient> patientsAdded = new ArrayList<>();

        @Override
        public boolean hasPerson(Person person) {
            return patientsAdded.contains(person);
        }

        @Override
        public void addPerson(Person person) {
            if (person instanceof Patient) {
                patientsAdded.add((Patient) person);
            }
        }

        @Override
        public void addPatient(Patient patient) {
            patientsAdded.add(patient);
        }

        // Unimplemented methods (not needed for AddPatientCommand testing)
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new UnsupportedOperationException();
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Person getSelectedPerson() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook addressBook) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deletePerson(Person target) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void selectPerson(Person target) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addStaff(HealthcareStaff healthcareStaff) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setSelectedPerson(Person person) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            return FXCollections.observableArrayList();
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new UnsupportedOperationException();
        }
    }
}
