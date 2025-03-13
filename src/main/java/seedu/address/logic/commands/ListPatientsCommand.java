package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

/**
 * Lists all patients in the address book to the user.
 */
public class ListPatientsCommand extends Command {
    public static final String COMMAND_WORD = "listpatients";

    public static final String MESSAGE_SUCCESS = "Listed all patients.";

    /**
     * Executes the command to filter and display only patients from the address book.
     *
     * @param model {@code Model} which the command should operate on.
     * @return A {@code CommandResult} indicating the success message.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_PATIENTS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
