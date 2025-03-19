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
 * Contains integration tests (interaction with the Model) and unit tests for ListStaffCommand.
 */
public class ListStaffCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_unfilteredList_showsOnlyStaff() {
        ListStaffCommand listStaffCommand = new ListStaffCommand();
        expectedModel.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_STAFF);

        assertCommandSuccess(listStaffCommand, model, ListStaffCommand.MESSAGE_SUCCESS, expectedModel);

        assertTrue(model.getFilteredPersonList().stream().allMatch(Model.PREDICATE_SHOW_ALL_STAFF),
                "The filtered list should only contain staff "
                        + "after executing ListStaffCommand on an unfiltered list.");
    }

    @Test
    public void execute_listIsFiltered_showsAllStaff() {
        expectedModel.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_STAFF);

        assertCommandSuccess(new ListStaffCommand(), model, ListStaffCommand.MESSAGE_SUCCESS, expectedModel);

        assertTrue(model.getFilteredPersonList().stream().allMatch(Model.PREDICATE_SHOW_ALL_STAFF),
                "The filtered list should contain only staff members after executing ListStaffCommand.");
    }

    @Test
    public void execute_emptyAddressBook_showsEmptyList() {
        Model emptyModel = new ModelManager(new seedu.address.model.AddressBook(), new UserPrefs());
        Model emptyExpectedModel = new ModelManager(emptyModel.getAddressBook(), new UserPrefs());

        ListStaffCommand listStaffCommand = new ListStaffCommand();
        assertCommandSuccess(listStaffCommand, emptyModel, ListStaffCommand.MESSAGE_SUCCESS, emptyExpectedModel);

        assertTrue(emptyModel.getFilteredPersonList().isEmpty(),
                "The filtered list should be empty when there are no staff.");
    }

    @Test
    public void execute_listHasCorrectNumberOfStaff() {
        ListStaffCommand listStaffCommand = new ListStaffCommand();
        expectedModel.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_STAFF);

        assertCommandSuccess(listStaffCommand, model, ListStaffCommand.MESSAGE_SUCCESS, expectedModel);

        long expectedStaffCount = model.getAddressBook().getPersonList().stream()
                .filter(Model.PREDICATE_SHOW_ALL_STAFF).count();

        assertEquals(expectedStaffCount, model.getFilteredPersonList().size(),
                "The number of staff shown should match the number of staff in the address book.");
    }
}
