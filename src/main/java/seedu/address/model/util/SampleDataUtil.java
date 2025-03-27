package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Department;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Patient;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Patient[] getSamplePatients() {
        return new Patient[] {
            new Patient(new Name("Alex Yeoh"), new Phone("87438807"),
                    new Email("alexyeoh@example.com"), new Address("Blk 30 Geylang Street 29, #06-40"),
                new Remark(""), getTagSet("friends"), "Dummy Doctor", "Dummy Guradian",
                    new Department("dummy department")),
            new Patient(new Name("Bernice Yu"), new Phone("99272758"),
                    new Email("berniceyu@example.com"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                new Remark(""), getTagSet("colleagues", "friends"), "Dummy Doctor", "Dummy Guradian",
                    new Department("dummy department")),
            new Patient(new Name("Charlotte Oliveiro"), new Phone("93210283"),
                    new Email("charlotte@example.com"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                new Remark(""), getTagSet("neighbours"), "Dummy Doctor", "Dummy Guradian",
                    new Department("dummy department")),
            new Patient(new Name("David Li"), new Phone("91031282"),
                    new Email("lidavid@example.com"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                new Remark(""), getTagSet("family"), "Dummy Doctor", "Dummy Guradian",
                    new Department("dummy department")),
            new Patient(new Name("Irfan Ibrahim"), new Phone("92492021"),
                    new Email("irfan@example.com"), new Address("Blk 47 Tampines Street 20, #17-35"),
                new Remark(""), getTagSet("classmates"), "Dummy Doctor", "Dummy Guradian",
                    new Department("dummy department")),
            new Patient(new Name("Roy Balakrishnan"), new Phone("92624417"),
                    new Email("royb@example.com"), new Address("Blk 45 Aljunied Street 85, #11-31"),
                new Remark(""), getTagSet("colleagues"), "Dummy Doctor", "Dummy Guradian",
                    new Department("dummy department"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Patient samplePerson : getSamplePatients()) {
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
