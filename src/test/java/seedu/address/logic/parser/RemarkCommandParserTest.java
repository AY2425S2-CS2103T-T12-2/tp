package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Remark;

class RemarkCommandParserTest {
    private final RemarkCommandParser parser = new RemarkCommandParser();

    @Test
    void parse_validArgs_returnsRemarkCommand() throws Exception {
        RemarkCommand expectedCommand = new RemarkCommand(Index.fromOneBased(1), new Remark("Likes badminton"));
        assertEquals(expectedCommand, parser.parse("1 r/Likes badminton"));
    }

    @Test
    void parse_missingIndex_throwsParseException() {
        assertThrows(ParseException.class, () -> parser.parse("r/Likes badminton"));
    }

    @Test
    void parse_invalidIndex_throwsParseException() {
        assertThrows(ParseException.class, () -> parser.parse("a r/Likes badminton"));
    }

    @Test
    void parse_emptyRemark_returnsRemarkCommand() throws Exception {
        RemarkCommand expectedCommand = new RemarkCommand(Index.fromOneBased(1), new Remark(""));
        assertEquals(expectedCommand, parser.parse("1 r/"));
    }
}
