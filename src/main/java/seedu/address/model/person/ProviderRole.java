package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Healthcare Staff's role in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidProviderRole(String)}
 */
public class ProviderRole {

    /**
     * Represents the different roles of the healthcare providers.
     */
    public enum ProviderRoleType {
        DOCTOR,
        NURSE,
        THERAPIST,

        NA,
    }

    public static final String MESSAGE_CONSTRAINTS = "Healthcare Staff's Role"
        + " should be either 'DOCTOR', 'NURSE' or 'THERAPIST' (case insensitive)";

    private final ProviderRoleType providerRoleType;

    /**
     * Constructs a {@code ProviderRole}.
     *
     * @param providerRole A valid provider role.
     */
    public ProviderRole(String providerRole) {
        requireNonNull(providerRole);
        checkArgument(isValidProviderRole(providerRole), MESSAGE_CONSTRAINTS);
        this.providerRoleType = ProviderRoleType.valueOf(providerRole.toUpperCase());
    }

    /**
     * Returns true if a given string is a valid provider role.
     */
    public static boolean isValidProviderRole(String test) {
        if (test == null) {
            return false;
        }
        try {
            ProviderRoleType.valueOf(test.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return providerRoleType.name();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ProviderRole)) {
            return false;
        }

        ProviderRole otherProviderRole = (ProviderRole) other;
        return providerRoleType == otherProviderRole.providerRoleType;
    }

    @Override
    public int hashCode() {
        return providerRoleType.hashCode();
    }
}
