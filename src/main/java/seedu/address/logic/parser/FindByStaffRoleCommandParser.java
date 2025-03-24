package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindByStaffRoleCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.ProviderRoleContainsKeywordPredicate;

/**
 * Parses input arguments and creates a new FindByStaffRoleCommand object.
 */
public class FindByStaffRoleCommandParser implements Parser<FindByStaffRoleCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindByStaffRoleCommand
     * and returns a FindByStaffRoleCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindByStaffRoleCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindByStaffRoleCommand.MESSAGE_USAGE));
        }

        String[] roleKeywords = trimmedArgs.split("\\s+");

        return new FindByStaffRoleCommand(new ProviderRoleContainsKeywordPredicate(Arrays.asList(roleKeywords)));
    }
}
