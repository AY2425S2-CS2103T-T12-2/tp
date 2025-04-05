package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEPARTMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DOCTOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOKNAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOKPHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Patient;

/**
 * Adds a person to the address book.
 */
public class AddPatientCommand extends Command {

    public static final CommandType COMMAND_TYPE = CommandType.ADDPATIENT;

    public static final String MESSAGE_USAGE = COMMAND_TYPE + ": Adds a patient to the Caring Book. \n"
            + "Compulsory parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE \n"
            + "Optional parameters: "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + PREFIX_DOCTOR + "DOCTOR "
            + PREFIX_NOKNAME + "NOK NAME "
            + PREFIX_NOKPHONE + "NOK PHONE "
            + PREFIX_DEPARTMENT + "DEPARTMENT \n"
            + "Example 1: "
            + COMMAND_TYPE + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 \n"
            + "Example 2: "
            + COMMAND_TYPE + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_DOCTOR + "Dr Tan Chee Hwa "
            + PREFIX_NOKNAME + "Mr Hao Doe "
            + PREFIX_NOKPHONE + "12345678 "
            + PREFIX_DEPARTMENT + "Gastroenterology ";

    public static final String MESSAGE_SUCCESS = "New patient added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This patient already exists in the address book";

    private final Patient toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddPatientCommand(Patient patient) {
        requireNonNull(patient);
        toAdd = patient;
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
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddPatientCommand)) {
            return false;
        }

        AddPatientCommand otherAddCommand = (AddPatientCommand) other;
        return toAdd.equals(otherAddCommand.toAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", toAdd)
                .toString();
    }
}
