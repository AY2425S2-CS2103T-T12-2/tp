package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

/**
 * Lists all doctors in the address book to the user.
 */
public class ListDoctorsCommand extends Command {
    public static final String COMMAND_WORD = "listdoctors";

    public static final String MESSAGE_SUCCESS = "Listed all doctors.";

    /**
     * Executes the command to filter and display only doctors from the address book.
     *
     * @param model {@code Model} which the command should operate on.
     * @return A {@code CommandResult} indicating the success message.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_DOCTORS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
