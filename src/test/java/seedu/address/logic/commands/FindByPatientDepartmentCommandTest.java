package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPatients.ALICE;
import static seedu.address.testutil.TypicalPatients.GEORGE;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.DepartmentContainsKeywordsPredicate;

public class FindByPatientDepartmentCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        DepartmentContainsKeywordsPredicate firstPredicate =
            new DepartmentContainsKeywordsPredicate(Collections.singletonList("first"));
        DepartmentContainsKeywordsPredicate secondPredicate =
            new DepartmentContainsKeywordsPredicate(Collections.singletonList("second"));

        FindByPatientDepartmentCommand findFirstCommand = new FindByPatientDepartmentCommand(firstPredicate);
        FindByPatientDepartmentCommand findSecondCommand = new FindByPatientDepartmentCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindByPatientDepartmentCommand findFirstCommandCopy = new FindByPatientDepartmentCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noPersonFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        DepartmentContainsKeywordsPredicate predicate = preparePredicate(" ");
        FindByPatientDepartmentCommand command = new FindByPatientDepartmentCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 2);
        DepartmentContainsKeywordsPredicate predicate = preparePredicate("general surgery");
        FindByPatientDepartmentCommand command = new FindByPatientDepartmentCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, GEORGE), model.getFilteredPersonList());
    }

    @Test
    public void toStringMethod() {
        DepartmentContainsKeywordsPredicate predicate =
            new DepartmentContainsKeywordsPredicate(Arrays.asList("keyword"));
        FindByPatientDepartmentCommand findCommand = new FindByPatientDepartmentCommand(predicate);
        String expected = FindByPatientDepartmentCommand.class.getCanonicalName() + "{predicate=" + predicate + "}";
        assertEquals(expected, findCommand.toString());
    }

    /**
     * Parses {@code userInput} into a {@code DepartmentContainsKeywordsPredicate}.
     */
    private DepartmentContainsKeywordsPredicate preparePredicate(String userInput) {
        return new DepartmentContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
