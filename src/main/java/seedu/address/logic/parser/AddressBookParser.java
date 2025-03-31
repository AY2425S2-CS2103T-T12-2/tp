package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandType;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ListPatientsCommand;
import seedu.address.logic.commands.ListStaffCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private static final Logger logger = LogsCenter.getLogger(AddressBookParser.class);

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        // Note to developers: Change the log level in config.json to enable lower level (i.e., FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Arguments: " + arguments);
        CommandType commandType = CommandType.fromString(commandWord);

        switch (commandType) {

        case ADD:
            return new AddCommandParser().parse(arguments);

        case ADDPATIENT:
            return new AddPatientCommandParser().parse(arguments);

        case ADDSTAFF:
            return new AddStaffCommandParser().parse(arguments);

        case EDIT:
            return new EditCommandParser().parse(arguments);

        case DELETE:
            return new DeleteCommandParser().parse(arguments);

        case CLEAR:
            return new ClearCommand();

        case FIND:
            return new FindByNameCommandParser().parse(arguments);

        case FINDDEP:
            return new FindByPatientDepartmentCommandParser().parse(arguments);

        case FINDSTAFF:
            return new FindByStaffRoleCommandParser().parse(arguments);

        case LIST:
            return new ListCommand();

        case LISTSTAFF:
            return new ListStaffCommand();

        case LISTPATIENTS:
            return new ListPatientsCommand();

        case EXIT:
            return new ExitCommand();

        case REMARK:
            return new RemarkCommandParser().parse(arguments);

        case HELP:
            return new HelpCommand();

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
