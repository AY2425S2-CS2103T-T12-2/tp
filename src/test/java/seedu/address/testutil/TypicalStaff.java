package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.HealthcareStaff;

/**
 * A utility class containing a list of {@code Staff} objects to be used in tests.
 */
public class TypicalStaff {
    public static final HealthcareStaff ALICE = new StaffBuilder().withName("Alice Pauline")
        .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
        .withPhone("94351253")
        .withRole("nurse").build();
    public static final HealthcareStaff BENSON = new StaffBuilder().withName("Benson Meier")
        .withAddress("311, Clementi Ave 2, #02-25")
        .withEmail("johnd@example.com").withPhone("98765432")
        .withRole("doctor").build();
    public static final HealthcareStaff CARL = new StaffBuilder().withName("Carl Kurz")
        .withPhone("95352563")
        .withEmail("heinz@example.com")
        .withAddress("wall street")
        .withRole("therapist")
        .build();
    public static final HealthcareStaff DANIEL = new StaffBuilder().withName("Daniel Meier")
        .withPhone("87652533")
        .withEmail("cornelia@example.com")
        .withAddress("10th street")
        .withRole("doctor").build();
    public static final HealthcareStaff ELLE = new StaffBuilder().withName("Elle Meyer")
        .withPhone("94482224")
        .withEmail("werner@example.com")
        .withAddress("michegan ave")
        .withRole("doctor")
        .build();
    public static final HealthcareStaff FIONA = new StaffBuilder().withName("Fiona Kunz")
        .withPhone("94482427")
        .withEmail("lydia@example.com")
        .withAddress("little tokyo")
        .withRole("nurse")
        .build();
    public static final HealthcareStaff GEORGE = new StaffBuilder().withName("George Best")
        .withPhone("94842442")
        .withEmail("anna@example.com")
        .withAddress("4th street")
        .withRole("doctor")
        .build();

    private TypicalStaff() {}

    /**
     * Returns an {@code AddressBook} with all the typical staff.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (HealthcareStaff staff : getTypicalStaff()) {
            ab.addPerson(staff);
        }
        return ab;
    }

    public static List<HealthcareStaff> getTypicalStaff() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
