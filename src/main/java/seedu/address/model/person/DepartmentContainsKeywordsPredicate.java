package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Patient}'s {@code Department} matches the keyword given.
 */
public class DepartmentContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public DepartmentContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        if (person instanceof Patient) {
            Patient patient = (Patient) person;
            return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(patient.getDepartment().toString(), keyword));
        } else if (person instanceof HealthcareStaff) {
            HealthcareStaff staff = (HealthcareStaff) person;
            return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(staff.getDepartment().toString(), keyword));
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof DepartmentContainsKeywordsPredicate)) {
            return false;
        }

        DepartmentContainsKeywordsPredicate otherNameContainsKeywordsPredicate =
            (DepartmentContainsKeywordsPredicate) other;
        return keywords.equals(otherNameContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
