package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindByPatientDepartmentCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.DepartmentContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindByPatientDepartmentCommand object.
 */
public class FindByPatientDepartmentCommandParser implements Parser<FindByPatientDepartmentCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindByPatientDepartmentCommand
     * and returns a FindByPatientDepartmentCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindByPatientDepartmentCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindByPatientDepartmentCommand.MESSAGE_USAGE));
        }

        String[] departmentKeywords = trimmedArgs.split("\\s+");

        DepartmentContainsKeywordsPredicate predicate =
            new DepartmentContainsKeywordsPredicate(Arrays.asList(departmentKeywords));

        return new FindByPatientDepartmentCommand(predicate);
    }
}
