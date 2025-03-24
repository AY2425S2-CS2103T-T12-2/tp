package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.ProviderRoleContainsKeywordPredicate;

/**
 * Finds and lists all staff in address book whose role matches with the keyword.
 * Keyword matching is case-insensitive.
 */
public class FindByStaffRoleCommand extends Command {

    public static final String COMMAND_WORD = "findstaff";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all staff whose role contain any of "
        + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
        + "Parameters: KEYWORD\n"
        + "Example: " + COMMAND_WORD + " doctor";

    private final ProviderRoleContainsKeywordPredicate predicate;

    public FindByStaffRoleCommand(ProviderRoleContainsKeywordPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
            String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindByStaffRoleCommand)) {
            return false;
        }

        FindByStaffRoleCommand otherFindRoleCommand = (FindByStaffRoleCommand) other;
        return predicate.equals(otherFindRoleCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("predicate", predicate)
            .toString();
    }
}
