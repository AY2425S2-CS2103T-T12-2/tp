package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEPARTMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROLE;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.HealthcareStaff;

/**
 * Adds a person to the address book.
 */
public class AddStaffCommand extends Command {

    public static final CommandType COMMAND_TYPE = CommandType.ADDSTAFF;

    public static final String MESSAGE_USAGE = COMMAND_TYPE + ": Adds a staff to the Caring Book. \n"
            + "Compulsory parameters: "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_NAME + "NAME \n"
            + "Optinal parameters: "
            + PREFIX_ROLE + "ROLE "
            + PREFIX_DEPARTMENT + "DEPARTMENT "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + "Example 1: "
            + COMMAND_TYPE + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 \n"
            + "Example 2: " + COMMAND_TYPE + " "
            + PREFIX_ROLE + "doctor "
            + PREFIX_NAME + "John Doe "
            + PREFIX_DEPARTMENT + "Internal Medicine "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 ";

    public static final String MESSAGE_SUCCESS = "New staff added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This staff already exists in the address book";

    private final HealthcareStaff toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddStaffCommand(HealthcareStaff healthcareStaff) {
        requireNonNull(healthcareStaff);
        toAdd = healthcareStaff;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPerson(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addPerson(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddStaffCommand)) {
            return false;
        }
        AddStaffCommand otherCommand = (AddStaffCommand) other;
        return toAdd.equals(otherCommand.toAdd);
    }

    @Override
    public int hashCode() {
        return toAdd.hashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", toAdd)
                .toString();
    }
}
