package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindByPatientDepartmentCommand;
import seedu.address.model.person.DepartmentContainsKeywordsPredicate;

public class FindByPatientDepartmentCommandParserTest {
    private FindByPatientDepartmentCommandParser parser = new FindByPatientDepartmentCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindByPatientDepartmentCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // leading whitespaces
        FindByPatientDepartmentCommand expectedFindCommand =
            new FindByPatientDepartmentCommand(new DepartmentContainsKeywordsPredicate(Arrays.asList("cardio")));
        assertParseSuccess(parser, " cardio", expectedFindCommand);

        // multiple whitespaces
        assertParseSuccess(parser, " cardio ", expectedFindCommand);
    }
}
