package seedu.address.model.person;

import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Patient in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Patient extends Person {
    private final String guardian;
    private final String doctorInCharge;
    private final Department department;

    /**
     * Every field must be present and not null.
     */
    public Patient(Name name, Phone phone, Email email, Address address, Set<Tag> tags,
               String doctorInCharge, String guardian, Department department) {
        super(new Role("PATIENT"), name, phone, email != null ? email : new Email("NA@placeholder.com"),
                address != null ? address : new Address("NA"), tags);
        this.doctorInCharge = doctorInCharge != null ? doctorInCharge : "";
        this.guardian = guardian != null ? guardian : "";
        this.department = department != null ? department : new Department("NA");
    }

    public String getDoctorInCharge() {
        return doctorInCharge;
    }

    public String getGuardian() {
        return guardian;
    }

    public Department getDepartment() {
        return department;
    }

    /**
     * Returns true if both patients have the same identity (same name).
     */
    @Override
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson instanceof Patient
                && otherPerson.getName().equals(this.getName());
    }

    /**
     * Returns true if both patients have the same identity and data fields.
     * This defines a stronger notion of equality between two patients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Patient)) {
            return false;
        }

        Patient otherPatient = (Patient) other;
        return super.equals(other)
                && doctorInCharge.equals(otherPatient.doctorInCharge)
                && guardian.equals(otherPatient.guardian)
                && department.equals(otherPatient.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getPhone(), this.getEmail(), this.getAddress(),
                this.getTags(), doctorInCharge, guardian, department);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("name", this.getName())
            .add("phone", this.getPhone())
            .add("email", this.getEmail())
            .add("address", this.getAddress())
            .add("tags", this.getTags())
            .add("doctorInCharge", doctorInCharge)
            .add("guardian", guardian) // Display null if no guardian
            .add("department", department)
            .toString();
    }
}
