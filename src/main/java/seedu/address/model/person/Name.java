package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String MESSAGE_CONSTRAINTS =
            "Name must be 1 to 66 characters long, contain at least one letter (A-Z, a-z), "
                    + "start and end with an alphanumeric character (A-Z, a-z, 0-9), "
                    + "and may contain spaces and the following special characters in between: , ( ) / . @ - '";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX =
            "^(?=[\\p{Alnum} ,()./@\\-']{1,66}$)(?=.*[A-Za-z])[\\p{Alnum}](?:[\\p{Alnum} ,()./@\\-']{0,64}[\\p{Alnum}])?$";

    public final String fullName;

    /**
     * Constructs a {@code Name}.
     *
     * @param name A valid name.
     */
    public Name(String name) {
        requireNonNull(name);
        checkArgument(isValidName(name), MESSAGE_CONSTRAINTS);
        fullName = name;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidName(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Name)) {
            return false;
        }

        Name otherName = (Name) other;
        String otherFullName = otherName.fullName.replaceAll("\\s+", "").toLowerCase();
        String thisFullName = fullName.replaceAll("\\s+", "").toLowerCase();
        return otherFullName.equals(thisFullName);
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
