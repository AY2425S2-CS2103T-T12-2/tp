package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Healthcare Staff in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class HealthcareStaff extends Person {
    private final ProviderRole providerRole;

    /**
     * Every field must be present.
     */
    public HealthcareStaff(Name name, ProviderRole providerRole,
                           Phone phone, Email email, Address address, Set<Tag> tags) {
        super(new Role("STAFF"), name, phone, email != null ? email : new Email("NA@placeholder.com"),
                address != null ? address : new Address("NA"), tags);
        this.providerRole = providerRole != null ? providerRole : new ProviderRole("NA");
    }

    public ProviderRole getProviderRole() {
        return providerRole;
    }

    /**
     * Returns true if both healthcare staff have the same identity (same name).
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson instanceof HealthcareStaff
            && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof HealthcareStaff)) {
            return false;
        }

        HealthcareStaff otherPerson = (HealthcareStaff) other;
        return super.equals(other) && providerRole.equals(otherPerson.providerRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), providerRole, this.getPhone(),
            this.getEmail(), this.getAddress(), this.getTags());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("name", this.getName())
            .add("providerRoleType", providerRole)
            .add("phone", this.getPhone())
            .add("email", this.getEmail())
            .add("address", this.getAddress())
            .add("tags", this.getTags())
            .toString();
    }
}
