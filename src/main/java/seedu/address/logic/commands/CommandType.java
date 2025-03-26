package seedu.address.logic.commands;

/**
 *  Represents the command type.
 */
public enum CommandType {
    ADD,
    ADDPATIENT,
    ADDSTAFF,
    LIST,
    LISTPATIENTS,
    LISTSTAFF,
    FIND,
    FINDPATIENT,
    FINDSTAFF,
    EDIT,
    CLEAR,
    DELETE,
    HELP,
    EXIT,
    UNKNOWN;

    /**
     * Returns the CommandType from the given string.
     *
     * @param value The string value to convert to CommandType.
     * @return The CommandType from the given string.
     */
    public static CommandType fromString(String value) {
        return switch (value.toLowerCase()) {
        case "add", "a" -> ADD;
        case "addpatient", "ap" -> ADDPATIENT;
        case "addstaff", "as" -> ADDSTAFF;
        case "list", "ls" -> LIST;
        case "listpatient", "lsp" -> LISTPATIENTS;
        case "liststaff", "lss" -> LISTSTAFF;
        case "find", "f" -> FIND;
        case "findpatient", "fp" -> FINDPATIENT;
        case "findstaff", "fs" -> FINDSTAFF;
        case "edit", "e" -> EDIT;
        case "clear", "cls" -> CLEAR;
        case "delete", "del", "d" -> DELETE;
        case "help", "h" -> HELP;
        case "exit", "quit" -> EXIT;
        default -> UNKNOWN;
        };
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
