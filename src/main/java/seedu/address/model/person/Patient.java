package seedu.address.model.person;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Patient in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Patient extends Person {
    private final NextOfKin nextOfKin;
    private final String doctorInCharge;
    private final Department department;

    /**
     * Every field must be present and not null.
     */
    public Patient(Name name, Phone phone, Email email, Address address, Remark remark,
               String doctorInCharge, NextOfKin nextOfKin, Department department) {
        super(new Role("PATIENT"), name, phone, email != null ? email : new Email("NA@placeholder.com"),
                address != null ? address : new Address("NA"), remark);
        this.doctorInCharge = doctorInCharge != null ? doctorInCharge : "NA";
        this.nextOfKin = nextOfKin != null ? nextOfKin : new NextOfKin(new Name("NA"), new Phone("000"));
        this.department = department != null ? department : new Department("NA");
    }

    public String getDoctorInCharge() {
        return doctorInCharge;
    }

    public NextOfKin getNextofKin() {
        return nextOfKin;
    }

    public Department getDepartment() {
        return department;
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
        return getName().equals(otherPatient.getName())
                && getPhone().equals(otherPatient.getPhone())
                && getEmail().equals(otherPatient.getEmail())
                && getAddress().equals(otherPatient.getAddress())
                && getDoctorInCharge().equals(otherPatient.getDoctorInCharge())
                && getNextofKin().equals(otherPatient.getNextofKin())
                && getDepartment().equals(otherPatient.getDepartment())
                && getRemark().equals(otherPatient.getRemark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getPhone(), this.getEmail(), this.getAddress(),
                 doctorInCharge, nextOfKin, department, this.getRemark());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("name", this.getName())
            .add("phone", this.getPhone())
            .add("email", this.getEmail())
            .add("address", this.getAddress())
            .add("doctor in charge", doctorInCharge)
            .add("next of kin", nextOfKin) // Display null if no guardian
            .add("department", department)
            .add("remark", this.getRemark())
            .toString();
    }
}
