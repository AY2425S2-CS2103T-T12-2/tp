package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEPARTMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DOCTOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOKNAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOKPHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROLE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_ROLE, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
                        PREFIX_DOCTOR, PREFIX_NOKNAME, PREFIX_NOKPHONE, PREFIX_DEPARTMENT);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE), pe);
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_ROLE, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
                PREFIX_DOCTOR, PREFIX_NOKNAME, PREFIX_NOKPHONE, PREFIX_DEPARTMENT);

        EditPersonDescriptor editPersonDescriptor = new EditPersonDescriptor();

        if (argMultimap.getValue(PREFIX_ROLE).isPresent()) {
            editPersonDescriptor.setProviderRole(ParserUtil.parseRoleType(argMultimap.getValue(PREFIX_ROLE).get()));
        }
        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            editPersonDescriptor.setName(ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()));
        }
        if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
            editPersonDescriptor.setPhone(ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()));
        }
        if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
            editPersonDescriptor.setEmail(ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()));
        }
        if (argMultimap.getValue(PREFIX_ADDRESS).isPresent()) {
            editPersonDescriptor.setAddress(ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get()));
        }
        if (argMultimap.getValue(PREFIX_DOCTOR).isPresent()) {
            editPersonDescriptor.setDocInCharge(ParserUtil.parseDoctor(argMultimap.getValue(PREFIX_DOCTOR).get()));
        }
        if (argMultimap.getValue(PREFIX_NOKNAME).isPresent() || argMultimap.getValue(PREFIX_NOKPHONE).isPresent()) {
            Name updatedNokName = editPersonDescriptor.getNokName().orElse(null);
            Phone updatedNokPhone = editPersonDescriptor.getNokPhone().orElse(null);

            if (argMultimap.getValue(PREFIX_NOKNAME).isPresent()) {
                updatedNokName = ParserUtil.parseName(argMultimap.getValue(PREFIX_NOKNAME).get());
                editPersonDescriptor.setNokName(updatedNokName);
            }

            if (argMultimap.getValue(PREFIX_NOKPHONE).isPresent()) {
                updatedNokPhone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_NOKPHONE).get());
                editPersonDescriptor.setNokPhone(updatedNokPhone);
            }
        }

        if (argMultimap.getValue(PREFIX_DEPARTMENT).isPresent()) {
            editPersonDescriptor.setDepartment(ParserUtil.parseDepartment(argMultimap.getValue(PREFIX_DEPARTMENT)
                    .get()));
        }

        if (!editPersonDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
        }

        return new EditCommand(index, editPersonDescriptor);
    }
}
