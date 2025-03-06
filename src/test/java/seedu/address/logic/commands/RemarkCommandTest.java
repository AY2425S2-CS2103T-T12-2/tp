package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.Remark;

class RemarkCommandTest {
    private Model model;

    @BeforeEach
    void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    void execute_addRemark_success() throws Exception {
        Index index = INDEX_FIRST_PERSON;
        Remark remark = new Remark("Likes badminton");
        RemarkCommand remarkCommand = new RemarkCommand(index, remark);

        Person personToEdit = model.getFilteredPersonList().get(index.getZeroBased());
        Person expectedPerson = new Person(personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), remark, personToEdit.getTags());
        CommandResult result = remarkCommand.execute(model);
        assertEquals(String.format(RemarkCommand.MESSAGE_ADD_REMARK_SUCCESS, Messages.format(expectedPerson)),
                result.getFeedbackToUser());
    }

    @Test
    void execute_removeRemark_success() throws Exception {
        Index index = INDEX_FIRST_PERSON;
        Remark emptyRemark = new Remark("");
        RemarkCommand remarkCommand = new RemarkCommand(index, emptyRemark);

        Person personToEdit = model.getFilteredPersonList().get(index.getZeroBased());
        Person expectedPerson = new Person(personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), emptyRemark, personToEdit.getTags());

        CommandResult result = remarkCommand.execute(model);
        assertEquals(String.format(RemarkCommand.MESSAGE_DELETE_REMARK_SUCCESS, Messages.format(expectedPerson)),
                result.getFeedbackToUser());
    }

    @Test
    void execute_invalidIndex_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        Remark remark = new Remark("Invalid Index");
        RemarkCommand remarkCommand = new RemarkCommand(outOfBoundIndex, remark);

        assertThrows(CommandException.class, () -> remarkCommand.execute(model));
    }

    @Test
    void equals() {
        RemarkCommand command1 = new RemarkCommand(INDEX_FIRST_PERSON, new Remark("Likes badminton"));
        RemarkCommand command2 = new RemarkCommand(INDEX_FIRST_PERSON, new Remark("Likes badminton"));
        RemarkCommand command3 = new RemarkCommand(INDEX_SECOND_PERSON, new Remark("Likes football"));

        // Same values -> returns true
        assertEquals(command1, command2);

        // Different index -> returns false
        assertThrows(AssertionError.class, () -> assertEquals(command1, command3));
    }
}
