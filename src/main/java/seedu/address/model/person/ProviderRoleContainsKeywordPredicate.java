package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Staff}'s {@code Role} matches the keyword given.
 */
public class ProviderRoleContainsKeywordPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public ProviderRoleContainsKeywordPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        if (!(person instanceof HealthcareStaff)) {
            return false;
        }
        HealthcareStaff staff = (HealthcareStaff) person;
        return keywords.stream()
            .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(staff.getProviderRole().toString(), keyword));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ProviderRoleContainsKeywordPredicate)) {
            return false;
        }

        ProviderRoleContainsKeywordPredicate otherNameContainsKeywordsPredicate =
            (ProviderRoleContainsKeywordPredicate) other;
        return keywords.equals(otherNameContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
