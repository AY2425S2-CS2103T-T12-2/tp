package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListPatientsCommand.
 */
public class ListPatientsCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_unfilteredList_showsOnlyPatients() {
        ListPatientsCommand listPatientsCommand = new ListPatientsCommand();
        expectedModel.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_PATIENTS);

        assertCommandSuccess(listPatientsCommand, model, ListPatientsCommand.MESSAGE_SUCCESS, expectedModel);

        assertTrue(model.getFilteredPersonList().stream().allMatch(Model.PREDICATE_SHOW_ALL_PATIENTS),
                "The filtered list should only contain patients "
                        + "after executing ListPatientsCommand on an unfiltered list.");
    }

    @Test
    public void execute_filteredListContainsOnlyPatients_showsAllPatientsAgain() {
        expectedModel.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_PATIENTS);

        ListPatientsCommand listPatientsCommand = new ListPatientsCommand();
        assertCommandSuccess(listPatientsCommand, model, ListPatientsCommand.MESSAGE_SUCCESS, expectedModel);

        assertTrue(model.getFilteredPersonList().stream().allMatch(Model.PREDICATE_SHOW_ALL_PATIENTS),
                "The filtered list should still contain "
                        + "only patients after executing ListPatientsCommand again.");
    }

    @Test
    public void execute_emptyAddressBook_showsEmptyList() {
        Model emptyModel = new ModelManager(new seedu.address.model.AddressBook(), new UserPrefs());
        Model emptyExpectedModel = new ModelManager(emptyModel.getAddressBook(), new UserPrefs());

        ListPatientsCommand listPatientsCommand = new ListPatientsCommand();
        assertCommandSuccess(listPatientsCommand, emptyModel, ListPatientsCommand.MESSAGE_SUCCESS, emptyExpectedModel);

        assertTrue(emptyModel.getFilteredPersonList().isEmpty(), "The filtered list should be "
                + "empty when there are no patients.");
    }

    @Test
    public void execute_listHasCorrectNumberOfPatients() {
        ListPatientsCommand listPatientsCommand = new ListPatientsCommand();
        expectedModel.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_PATIENTS);

        assertCommandSuccess(listPatientsCommand, model, ListPatientsCommand.MESSAGE_SUCCESS, expectedModel);

        long expectedPatientCount = model.getAddressBook().getPersonList().stream()
                .filter(Model.PREDICATE_SHOW_ALL_PATIENTS).count();

        assertEquals(expectedPatientCount, model.getFilteredPersonList().size(),
                "The number of patients shown should match the number of patients in the address book.");
    }

}
