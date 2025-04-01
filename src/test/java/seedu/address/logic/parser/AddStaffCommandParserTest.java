package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddStaffCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Department;
import seedu.address.model.person.Email;
import seedu.address.model.person.HealthcareStaff;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.ProviderRole;
import seedu.address.model.person.Remark;
import seedu.address.model.tag.Tag;

public class AddStaffCommandParserTest {
    private AddStaffCommandParser parser;

    @BeforeEach
    public void setUp() {
        parser = new AddStaffCommandParser();
    }

    @Test
    @Disabled("Disabled temporarily")
    public void parse_validArgs_returnsAddStaffCommand() throws ParseException {
        // Arrange
        String userInput = "r/doctor n/John Doe dp/Cardiology"
            + " p/12345678 e/johndoe@example.com a/123 Main St t/critical";

        // Create expected HealthcareStaff object
        Name name = new Name("John Doe");
        ProviderRole role = new ProviderRole("doctor");
        Phone phone = new Phone("12345678");
        Department department = new Department("Cardiology");
        Email email = new Email("johndoe@example.com");
        Address address = new Address("123 Main St");
        Remark remark = new Remark("");
        Set<Tag> tags = Set.of(new Tag("critical"));

        HealthcareStaff expectedStaff = new HealthcareStaff(name, role, department,
            phone, email, address, remark, tags);

        // Act
        AddStaffCommand command = parser.parse(userInput);

        // Assert
        assertEquals(new AddStaffCommand(expectedStaff), command);
    }

    @Test
    public void parse_missingArgs_throwsParseException() {
        // Arrange
        String userInput = "r/nurse n/John Doe p/12345678";

        // Act & Assert
        ParseException thrown = assertThrows(ParseException.class, () -> parser.parse(userInput));
        assertEquals(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddStaffCommand.MESSAGE_USAGE), thrown.getMessage());
    }

    @Test
    public void parse_duplicateArgs_throwsParseException() {
        // Arrange
        String userInput = "r/nurse n/John Doe n/John Doe p/12345678 e/johndoe@example.com a/123 Main St";

        // Act & Assert
        ParseException thrown = assertThrows(ParseException.class, () -> parser.parse(userInput));
        assertEquals(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddStaffCommand.MESSAGE_USAGE), thrown.getMessage());
    }

    @Test
    public void parse_missingRequiredPrefix_throwsParseException() {
        // Arrange
        String userInput = "n/John Doe p/12345678 e/johndoe@example.com a/123 Main St";

        // Act & Assert
        ParseException thrown = assertThrows(ParseException.class, () -> parser.parse(userInput));
        assertEquals(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddStaffCommand.MESSAGE_USAGE), thrown.getMessage());
    }

    @Test
    public void parse_invalidRole_throwsParseException() {
        // Arrange
        String userInput = "r/doctor n/John Doe p/12345678 e/johndoe@example.com a/123 Main St";

        // Act & Assert
        ParseException thrown = assertThrows(ParseException.class, () -> parser.parse(userInput));
        assertEquals(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddStaffCommand.MESSAGE_USAGE), thrown.getMessage());
    }

    @Test
    @Disabled("Disabled temporarily")
    public void parse_validArgsWithMultipleTags_returnsAddStaffCommand() throws ParseException {
        // Arran
        String userInput = "r/nurse n/John Doe dp/Cardiology p/12345678 "
            + "e/johndoe@example.com a/123 Main St t/critical t/urgent";

        // Create expected HealthcareStaff object with multiple tags
        Name name = new Name("John Doe");
        ProviderRole role = new ProviderRole("nurse");
        Department department = new Department("Cardiology");
        Phone phone = new Phone("12345678");
        Email email = new Email("johndoe@example.com");
        Address address = new Address("123 Main St");
        Remark remark = new Remark("");
        Set<Tag> tags = Set.of(new Tag("critical"), new Tag("urgent"));

        HealthcareStaff expectedStaff = new HealthcareStaff(name, role, department,
            phone, email, address, remark, tags);

        // Act
        AddStaffCommand command = parser.parse(userInput);

        // Assert
        assertEquals(new AddStaffCommand(expectedStaff), command);
    }

    @Test
    public void parse_missingProviderRole_usesDefaultProviderRole() throws ParseException {
        // Arrange
        String userInput = " n/John Doe dp/Cardio p/12345678 e/johndoe@example.com a/123 Main St t/critical";

        Name name = new Name("John Doe");
        ProviderRole role = new ProviderRole("NA");
        Department department = new Department("Cardio");
        Phone phone = new Phone("12345678");
        Email email = new Email("johndoe@example.com");
        Address address = new Address("123 Main St"); // Expecting default address
        Remark remark = new Remark("serious");
        Set<Tag> tags = Set.of(new Tag("critical"));

        HealthcareStaff expectedStaff = new HealthcareStaff(name, role, department,
            phone, email, address, remark, tags);
        AddStaffCommand expectedCommand = new AddStaffCommand(expectedStaff);

        // Act
        AddStaffCommand actualCommand = parser.parse(userInput);

        // Assert
        assertEquals(expectedCommand, actualCommand);
    }
    @Test
    public void parse_missingAddress_usesDefaultAddress() throws ParseException {
        // Arrange
        String userInput = " r/doctor n/John Doe dp/Cardio p/12345678 e/johndoe@example.com t/critical";

        Name name = new Name("John Doe");
        ProviderRole role = new ProviderRole("doctor");
        Department department = new Department("Cardio");
        Phone phone = new Phone("12345678");
        Email email = new Email("johndoe@example.com");
        Address address = new Address("NA"); // Expecting default address
        Remark remark = new Remark("");
        Set<Tag> tags = Set.of(new Tag("critical"));

        HealthcareStaff expectedStaff = new HealthcareStaff(name, role, department,
            phone, email, address, remark, tags);
        AddStaffCommand expectedCommand = new AddStaffCommand(expectedStaff);

        // Act
        AddStaffCommand actualCommand = parser.parse(userInput);

        // Assert
        assertEquals(expectedCommand, actualCommand);
    }
    @Test
    public void parse_missingEmail_usesDefaultEmail() throws ParseException {
        // Arrange
        String userInput = " r/doctor n/John Doe dp/Emergency p/12345678 a/123 Main St t/critical";

        Name name = new Name("John Doe");
        ProviderRole role = new ProviderRole("doctor");
        Department department = new Department("Emergency");
        Phone phone = new Phone("12345678");
        Email email = new Email("NA@placeholder.com"); // Expecting default email
        Address address = new Address("123 Main St");
        Remark remark = new Remark("serious");
        Set<Tag> tags = Set.of(new Tag("critical"));

        HealthcareStaff expectedStaff = new HealthcareStaff(name, role, department,
            phone, email, address, remark, tags);
        AddStaffCommand expectedCommand = new AddStaffCommand(expectedStaff);

        // Act
        AddStaffCommand actualCommand = parser.parse(userInput);

        // Assert
        assertEquals(expectedCommand, actualCommand);
    }
}
