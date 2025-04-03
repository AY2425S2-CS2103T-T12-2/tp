package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {
    // Identity fields
    private final Role role;
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Remark remark;

    // Data fields
    private final Address address;

    /**
     * Every field must be present and not null.
     */
    public Person(Role role, Name name, Phone phone, Email email, Address address, Remark remark) {
        requireAllNonNull(role, name, phone);
        this.role = role;
        this.name = name;
        this.phone = phone;
        this.remark = remark;
        this.email = email != null ? email : new Email("NA@placeholder.com");
        this.address = address != null ? address : new Address("NA");
    }

    public Role getRole() {
        return role;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Remark getRemark() {
        return remark;
    }

    public Address getAddress() {
        return address;
    }


    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName())
                && otherPerson.getPhone().equals(getPhone());
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

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return role.equals(otherPerson.role)
            && name.equals(otherPerson.name)
            && phone.equals(otherPerson.phone)
            && (email == null || otherPerson.email == null || email.equals(otherPerson.email))
            && (address == null || otherPerson.address == null || address.equals(otherPerson.address));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("role", role)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .toString();
    }
}
