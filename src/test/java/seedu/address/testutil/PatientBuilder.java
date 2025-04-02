package seedu.address.testutil;

import seedu.address.model.person.Address;
import seedu.address.model.person.Department;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.NextOfKin;
import seedu.address.model.person.Patient;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.person.Role;

/**
 * A utility class to help with building Person objects.
 */
public class PatientBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_REMARK = "";
    public static final String DEFAULT_DOCTOR = "Dr Lee";
    public static final String DEFAULT_NOKNAME = "Mrs Bee Bee";
    public static final String DEFAULT_NOKPHONE = "85355255";
    public static final String DEFAULT_DEPARTMENT = "Chronology";

    private Role role;
    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Remark remark;
    private Department department;
    private String doctor;
    private NextOfKin nok;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PatientBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        remark = new Remark(DEFAULT_REMARK);
        department = new Department(DEFAULT_DEPARTMENT);
        doctor = DEFAULT_DOCTOR;
        nok = new NextOfKin(new Name(DEFAULT_NOKNAME), new Phone(DEFAULT_NOKPHONE));
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PatientBuilder(Patient patientToCopy) {
        role = patientToCopy.getRole();
        name = patientToCopy.getName();
        phone = patientToCopy.getPhone();
        email = patientToCopy.getEmail();
        address = patientToCopy.getAddress();
        remark = patientToCopy.getRemark();
        department = patientToCopy.getDepartment();
        doctor = patientToCopy.getDoctorInCharge();
        nok = patientToCopy.getNextofKin();
    }


    /**
     * Sets the {@code Name} of the {@code Patient} that we are building.
     */
    public PatientBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }


    /**
     * Sets the {@code Address} of the {@code Patient} that we are building.
     */
    public PatientBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Patient} that we are building.
     */
    public PatientBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Patient} that we are building.
     */
    public PatientBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Doctor} of the {@code Patient} that we are building.
     */
    public PatientBuilder withDoc(String doctor) {
        this.doctor = doctor;
        return this;
    }

    /**
     * Sets the {@code NOK} of the {@code Patient} that we are building.
     */
    public PatientBuilder withNok(String nokName, String nokPhone) {
        this.nok = new NextOfKin(new Name(nokName), new Phone(nokPhone));
        return this;
    }

    /**
     * Sets the {@code Department} of the {@code Patient} that we are building.
     */
    public PatientBuilder withDepartment(String department) {
        this.department = new Department(department);
        return this;
    }


    public Patient build() {
        return new Patient(name, phone, email, address, remark, doctor, nok, department);
    }

}
