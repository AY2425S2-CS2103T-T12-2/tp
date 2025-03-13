package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represent a Department's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDepartment(String)}
 */
public class Department {

    public static final String MESSAGE_CONSTRAINTS =
            "Department should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String departmentName;

    /**
     * Constructs a {@code Department}.
     *
     * @param departmentName A valid department
     */
    public Department(String departmentName) {
        requireNonNull(departmentName);
        checkArgument(isValidDepartment(departmentName), MESSAGE_CONSTRAINTS);
        this.departmentName = departmentName;
    }

    /**
     * Returns true if a given string is a valid Department name
     */
    public static boolean isValidDepartment(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return departmentName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Department)) {
            return false;
        }

        Department otherDepartment = (Department) other;
        return departmentName.equals(otherDepartment.departmentName);
    }

    @Override
    public int hashCode() {
        return departmentName.hashCode();
    }
}
