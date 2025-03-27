package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Patient;

/**
 * A utility class containing a list of {@code Patient} objects to be used in tests.
 */
public class TypicalPatients {

    public static final Patient ALICE = new PatientBuilder().withName("Alice Pauline")
        .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
        .withPhone("94351253")
        .withDoc("Dr Tan")
        .withDepartment("General Surgery")
        .withTags("friends").build();
    public static final Patient BENSON = new PatientBuilder().withName("Benson Meier")
        .withAddress("311, Clementi Ave 2, #02-25")
        .withEmail("johnd@example.com").withPhone("98765432")
        .withDoc("Dr Sim")
        .withDepartment("Pediatrics")
        .withTags("owesMoney", "friends").build();
    public static final Patient CARL = new PatientBuilder().withName("Carl Kurz")
        .withPhone("95352563")
        .withEmail("heinz@example.com")
        .withAddress("wall street")
        .withNok("Winnie the Pooh")
        .withDoc("Dr Chiu")
        .withDepartment("Pediatrics")
        .build();
    public static final Patient DANIEL = new PatientBuilder().withName("Daniel Meier")
        .withPhone("87652533")
        .withEmail("cornelia@example.com")
        .withAddress("10th street")
        .withDoc("Dr Yap")
        .withDepartment("OBGYN")
        .withTags("friends").build();
    public static final Patient ELLE = new PatientBuilder().withName("Elle Meyer")
        .withPhone("9482224")
        .withEmail("werner@example.com")
        .withAddress("michegan ave")
        .withDoc("Dr Tan")
        .withDepartment("Cardio")
        .build();
    public static final Patient FIONA = new PatientBuilder().withName("Fiona Kunz")
        .withPhone("9482427")
        .withEmail("lydia@example.com")
        .withAddress("little tokyo")
        .withDoc("Dr Chew")
        .withDepartment("Cardio")
        .build();
    public static final Patient GEORGE = new PatientBuilder().withName("George Best")
        .withPhone("9482442")
        .withEmail("anna@example.com")
        .withAddress("4th street")
        .withDoc("Dr Tan")
        .withDepartment("General Surgery")
        .build();

    private TypicalPatients() {}

    /**
     * Returns an {@code AddressBook} with all the typical patients.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Patient patient : getTypicalPatients()) {
            ab.addPerson(patient);
        }
        return ab;
    }

    public static List<Patient> getTypicalPatients() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
