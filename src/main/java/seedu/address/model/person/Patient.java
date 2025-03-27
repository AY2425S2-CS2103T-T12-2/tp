package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

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
    public Patient(Name name, Phone phone, Email email, Address address, Remark remark, Set<Tag> tags,
               String doctorInCharge, String guardian, Department department) {
        super(new Role("PATIENT"), name, phone, email, address, remark, tags);
        requireAllNonNull(doctorInCharge);
        this.doctorInCharge = doctorInCharge;
        this.guardian = guardian;
        this.department = department;
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
        if (this == other) {
            return true;
        }
        if (!(other instanceof Patient)) {
            return false;
        }
        Patient otherPatient = (Patient) other;
        return getName().equals(otherPatient.getName())
                && getPhone().equals(otherPatient.getPhone())
                && getEmail().equals(otherPatient.getEmail())
                && getAddress().equals(otherPatient.getAddress())
                && getTags().equals(otherPatient.getTags())
                && getDoctorInCharge().equals(otherPatient.getDoctorInCharge())
                && getGuardian().equals(otherPatient.getGuardian())
                && getDepartment().equals(otherPatient.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone(), getEmail(), getAddress(), getTags(),
                getDoctorInCharge(), getGuardian(), getDepartment());
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
