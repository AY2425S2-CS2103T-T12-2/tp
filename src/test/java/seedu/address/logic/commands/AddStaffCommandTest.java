package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.HealthcareStaff;
import seedu.address.model.person.Person;
import seedu.address.testutil.StaffBuilder;

class AddStaffCommandTest {

    private ModelStub modelStub;
    private HealthcareStaff validStaff;

    @BeforeEach
    void setUp() {
        modelStub = new ModelStub();
        validStaff = new StaffBuilder().withName("John Doe").withPhone("98765432")
                .withEmail("johnd@example.com").withAddress("311, Clementi Ave 2, #02-25")
                .withRole("Doctor").build();
    }

    @Test
    @Disabled("Disabled temporarily")
    void execute_newStaff_success() throws Exception {
        AddStaffCommand addStaffCommand = new AddStaffCommand(validStaff);
        CommandResult result = addStaffCommand.execute(modelStub);

        assertEquals(String.format(AddStaffCommand.MESSAGE_SUCCESS, validStaff), result.getFeedbackToUser());
        assertEquals(1, modelStub.staffAdded.size());
    }

    @Test
    void execute_duplicateStaff_throwsCommandException() {
        modelStub.addStaff(validStaff);
        AddStaffCommand addStaffCommand = new AddStaffCommand(validStaff);

        assertThrows(CommandException.class, () -> addStaffCommand.execute(modelStub),
                AddStaffCommand.MESSAGE_DUPLICATE_PERSON);
    }

    @Test
    void equals_sameObject_returnsTrue() {
        AddStaffCommand addStaffCommand = new AddStaffCommand(validStaff);
        assertEquals(addStaffCommand, addStaffCommand);
    }

    @Test
    void equals_differentObject_returnsFalse() {
        AddStaffCommand addStaffCommand1 = new AddStaffCommand(validStaff);
        HealthcareStaff anotherStaff = new StaffBuilder().withName("Jane Doe").build();
        AddStaffCommand addStaffCommand2 = new AddStaffCommand(anotherStaff);

        assertNotEquals(addStaffCommand1, addStaffCommand2);
    }

    @Test
    void equals_differentCommandType_returnsFalse() {
        AddStaffCommand addStaffCommand = new AddStaffCommand(validStaff);
        Object otherCommand = new Object();

        assertNotEquals(addStaffCommand, otherCommand);
    }

    @Test
    void toString_test() {
        AddStaffCommand addStaffCommand1 = new AddStaffCommand(validStaff);
        AddStaffCommand addStaffCommand2 = new AddStaffCommand(validStaff);

        assertEquals(addStaffCommand1.toString(), addStaffCommand2.toString());
    }

    /**
     * A stub Model implementation for testing AddStaffCommand.
     */
    private static class ModelStub implements Model {
        final ArrayList<HealthcareStaff> staffAdded = new ArrayList<>();

        @Override
        public boolean hasPerson(Person person) {
            return staffAdded.contains(person);
        }

        @Override
        public void addPerson(Person person) {
            if (person instanceof HealthcareStaff) {
                staffAdded.add((HealthcareStaff) person);
            }
        }

        @Override
        public void addStaff(HealthcareStaff staff) {
            staffAdded.add(staff);
        }

        // Unimplemented methods (not needed for AddStaffCommand testing)
        @Override public void setUserPrefs(seedu.address.model.ReadOnlyUserPrefs userPrefs) {}
        @Override public seedu.address.model.ReadOnlyUserPrefs getUserPrefs() {
            return null;
        }
        @Override public seedu.address.commons.core.GuiSettings getGuiSettings() {
            return null;
        }
        @Override public void setGuiSettings(seedu.address.commons.core.GuiSettings guiSettings) {

        }
        @Override public java.nio.file.Path getAddressBookFilePath() {
            return null;
        }
        @Override public void setAddressBookFilePath(java.nio.file.Path addressBookFilePath) {}
        @Override public void setAddressBook(seedu.address.model.ReadOnlyAddressBook addressBook) {}
        @Override public seedu.address.model.ReadOnlyAddressBook getAddressBook() {
            return null;
        }
        @Override public void deletePerson(Person target) {}
        @Override public void addPatient(seedu.address.model.person.Patient patient) {}
        @Override public void setPerson(Person target, Person editedPerson) {}
        @Override public javafx.collections.ObservableList<Person> getFilteredPersonList() {
            return null;
        }
        @Override public void updateFilteredPersonList(java.util.function.Predicate<Person> predicate) {}
    }
}
