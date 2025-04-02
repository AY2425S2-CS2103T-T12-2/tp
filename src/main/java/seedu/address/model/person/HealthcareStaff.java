package seedu.address.model.person;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Healthcare Staff in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class HealthcareStaff extends Person {
    private final ProviderRole providerRole;
    private final Department department;

    /**
     * Every field must be present.
     */
    public HealthcareStaff(Name name, ProviderRole providerRole,
                           Department department,
                           Phone phone, Email email, Address address, Remark remark) {
        super(new Role("STAFF"), name, phone, email != null ? email : new Email("NA@placeholder.com"),
                address != null ? address : new Address("NA"), remark);
        this.department = department != null ? department : new Department("NA");
        this.providerRole = providerRole != null ? providerRole : new ProviderRole("NA");
    }

    public ProviderRole getProviderRole() {
        return providerRole;
    }

    public Department getDepartment() {
        return department;
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
        if (this == other) {
            return true;
        }
        if (!(other instanceof HealthcareStaff)) {
            return false;
        }
        HealthcareStaff otherStaff = (HealthcareStaff) other;
        return getName().equals(otherStaff.getName())
                && providerRole.equals(otherStaff.providerRole)
                && department.equals(otherStaff.department)
                && getPhone().equals(otherStaff.getPhone())
                && getEmail().equals(otherStaff.getEmail())
                && getAddress().equals(otherStaff.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), providerRole, department, getEmail(), getAddress());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("name", this.getName())
            .add("department", department)
            .add("providerRoleType", providerRole)
            .add("phone", this.getPhone())
            .add("email", this.getEmail())
            .add("address", this.getAddress())
            .toString();
    }
}
