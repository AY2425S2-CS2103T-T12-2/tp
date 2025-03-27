package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindByStaffRoleCommand;
import seedu.address.model.person.ProviderRoleContainsKeywordPredicate;

public class FindByStaffRoleCommandParserTest {
    private FindByStaffRoleCommandParser parser = new FindByStaffRoleCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindByStaffRoleCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // leading whitespaces
        FindByStaffRoleCommand expectedFindCommand =
            new FindByStaffRoleCommand(new ProviderRoleContainsKeywordPredicate(Arrays.asList("nurse")));
        assertParseSuccess(parser, " nurse", expectedFindCommand);

        // multiple whitespaces
        assertParseSuccess(parser, " nurse ", expectedFindCommand);
    }
}
