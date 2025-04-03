package seedu.address.testutil;

import seedu.address.model.person.Address;
import seedu.address.model.person.Department;
import seedu.address.model.person.Email;
import seedu.address.model.person.HealthcareStaff;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.ProviderRole;
import seedu.address.model.person.Remark;

/**
 * A utility class to help with building Person objects.
 */
public class StaffBuilder {

    public static final String DEFAULT_ROLE = "doctor";
    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_DEPARTMENT = "Emergency";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_REMARK = "";

    private ProviderRole role;
    private Name name;
    private Department department;
    private Phone phone;
    private Email email;
    private Address address;
    private Remark remark;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public StaffBuilder() {
        role = new ProviderRole(DEFAULT_ROLE);
        name = new Name(DEFAULT_NAME);
        department = new Department(DEFAULT_DEPARTMENT);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        remark = new Remark(DEFAULT_REMARK);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public StaffBuilder(HealthcareStaff staffToCopy) {
        role = staffToCopy.getProviderRole();
        name = staffToCopy.getName();
        department = staffToCopy.getDepartment();
        phone = staffToCopy.getPhone();
        email = staffToCopy.getEmail();
        address = staffToCopy.getAddress();
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public StaffBuilder withRole(String role) {
        this.role = new ProviderRole(role);
        return this;
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public StaffBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public StaffBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public StaffBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public StaffBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Department} of the {@code Person} that we are building.
     */
    public StaffBuilder withDepartment(String department) {
        this.department = new Department(department);
        return this;
    }

    public HealthcareStaff build() {
        return new HealthcareStaff(name, role, department, phone, email, address, remark);
    }

}
