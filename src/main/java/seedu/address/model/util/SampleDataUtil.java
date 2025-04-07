package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Department;
import seedu.address.model.person.Email;
import seedu.address.model.person.HealthcareStaff;
import seedu.address.model.person.Name;
import seedu.address.model.person.NextOfKin;
import seedu.address.model.person.Patient;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.ProviderRole;
import seedu.address.model.person.Remark;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePatients() {
        return new Person[] {
            new Patient(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                        new Address("Blk 30 Geylang Street 29, #06-40"), new Remark(""), "Dr Saajid",
                        new NextOfKin(new Name("Mr Yeoh"), new Phone("NA")),
                        new Department("Pathology")),
            new Patient(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                        new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                        new Remark(""), "Dr Kumar S/O",
                        new NextOfKin(new Name("Mrs Yu"), new Phone("88164715")),
                        new Department("Respiratory Medicine")),
            new HealthcareStaff(new Name("Charlotte Oliveiro"), new ProviderRole("doctor"),
                        new Department("Infectious Diseases @CDC"), new Phone("93210283"),
                        new Email("charlotte_@example.com"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                        new Remark("")),
            new HealthcareStaff(new Name("David Li"), new ProviderRole("nurse"),
                        new Department("Otolaryngology (ENT)"), new Phone("91031282"),
                        new Email("lidavid@example.com"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                        new Remark("")),
            new HealthcareStaff(new Name("Irfan Ibrahim"), new ProviderRole("therapist"),
                        new Department("Cardiology"), new Phone("92492021"),
                        new Email("irfan@example.com"), new Address("Blk 47 Tampines Street 20, #17-35"),
                        new Remark(""))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePatients()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
