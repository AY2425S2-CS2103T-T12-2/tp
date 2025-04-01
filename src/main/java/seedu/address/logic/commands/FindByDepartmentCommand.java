package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.DepartmentContainsKeywordsPredicate;

/**
 * Finds and lists all patients in address book whose department matches with the keyword.
 * Keyword matching is case-insensitive.
 */
public class FindByDepartmentCommand extends Command {
    public static final CommandType COMMAND_TYPE = CommandType.FINDDEP;

    public static final String MESSAGE_USAGE = COMMAND_TYPE + ": Finds all contacts whose department contain "
        + "the specified keyword (case-insensitive) and displays them as a list with index numbers.\n"
        + "Parameters: KEYWORD\n"
        + "Example: " + COMMAND_TYPE + " Oncology";

    private final DepartmentContainsKeywordsPredicate predicate;

    public FindByDepartmentCommand(DepartmentContainsKeywordsPredicate predicate) {
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

        if (!(other instanceof FindByDepartmentCommand)) {
            return false;
        }

        FindByDepartmentCommand otherFindRoleCommand = (FindByDepartmentCommand) other;
        return predicate.equals(otherFindRoleCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("predicate", predicate)
            .toString();
    }
}
