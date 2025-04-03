package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalStaff.ALICE;
import static seedu.address.testutil.TypicalStaff.FIONA;
import static seedu.address.testutil.TypicalStaff.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.ProviderRoleContainsKeywordPredicate;

public class FindByStaffRoleCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        ProviderRoleContainsKeywordPredicate firstPredicate =
            new ProviderRoleContainsKeywordPredicate(Collections.singletonList("first"));
        ProviderRoleContainsKeywordPredicate secondPredicate =
            new ProviderRoleContainsKeywordPredicate(Collections.singletonList("second"));

        FindByStaffRoleCommand findFirstCommand = new FindByStaffRoleCommand(firstPredicate);
        FindByStaffRoleCommand findSecondCommand = new FindByStaffRoleCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindByStaffRoleCommand findFirstCommandCopy = new FindByStaffRoleCommand(firstPredicate);
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
        ProviderRoleContainsKeywordPredicate predicate = preparePredicate(" ");
        FindByStaffRoleCommand command = new FindByStaffRoleCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 2);
        ProviderRoleContainsKeywordPredicate predicate = preparePredicate("nurse");
        FindByStaffRoleCommand command = new FindByStaffRoleCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, FIONA), model.getFilteredPersonList());
    }

    @Test
    public void toStringMethod() {
        ProviderRoleContainsKeywordPredicate predicate =
            new ProviderRoleContainsKeywordPredicate(Arrays.asList("keyword"));
        FindByStaffRoleCommand findCommand = new FindByStaffRoleCommand(predicate);
        String expected = FindByStaffRoleCommand.class.getCanonicalName() + "{predicate=" + predicate + "}";
        assertEquals(expected, findCommand.toString());
    }

    /**
     * Parses {@code userInput} into a {@code ProviderRoleContainsKeywordsPredicate}.
     */
    private ProviderRoleContainsKeywordPredicate preparePredicate(String userInput) {
        return new ProviderRoleContainsKeywordPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
