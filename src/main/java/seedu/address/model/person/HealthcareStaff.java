package seedu.address.model.person;

import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Healthcare Staff in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class HealthcareStaff extends Person {
    private final ProviderRoleType providerRoleType;

    /**
     * Every field must be present.
     */
    public HealthcareStaff(Name name, ProviderRoleType providerRoleType,
                           Phone phone, Email email, Address address, Set<Tag> tags) {
        super(name, phone, email, address, tags);
        this.providerRoleType = providerRoleType;
    }

    public ProviderRoleType getProviderRoleType() {
        return providerRoleType;
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        // instanceof handles nulls
        if (!(other instanceof HealthcareStaff)) {
            return false;
        }

        HealthcareStaff otherPerson = (HealthcareStaff) other;
        return super.equals(other) && providerRoleType.equals(otherPerson.providerRoleType);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(this.getName(), providerRoleType, this.getPhone(),
            this.getEmail(), this.getAddress(), this.getTags());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("name", this.getName())
            .add("providerRoleType", providerRoleType)
            .add("phone", this.getPhone())
            .add("email", this.getEmail())
            .add("address", this.getAddress())
            .add("tags", this.getTags())
            .toString();
    }
}
