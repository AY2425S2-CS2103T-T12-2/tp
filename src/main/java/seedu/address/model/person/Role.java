package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's role in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidRole(String)}
 */
public class Role {

    /**
     * Enum representing valid roles.
     */
    public enum RoleType {
        PATIENT, STAFF
    }

    public static final String MESSAGE_CONSTRAINTS = "Role should be either 'PATIENT' or 'STAFF' (case insensitive)";

    private final RoleType role;

    /**
     * Constructs a {@code Role}.
     *
     * @param role A valid role.
     */
    public Role(String role) {
        requireNonNull(role);
        checkArgument(isValidRole(role), MESSAGE_CONSTRAINTS);
        this.role = RoleType.valueOf(role.toUpperCase());
    }

    /**
     * Returns true if a given string is a valid role.
     */
    public static boolean isValidRole(String test) {
        if (test == null) {
            return false;
        }
        try {
            RoleType.valueOf(test.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return role.name();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Role)) {
            return false;
        }

        Role otherRole = (Role) other;
        return role == otherRole.role;
    }

    @Override
    public int hashCode() {
        return role.hashCode();
    }
}
