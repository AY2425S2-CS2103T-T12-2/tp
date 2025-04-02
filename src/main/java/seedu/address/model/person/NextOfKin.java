package seedu.address.model.person;

import java.util.Objects;

/**
 * Represents a Person's next of kin (emergency contact) in the address book.
 * Guarantees: immutable fields.
 */
public class NextOfKin {
    private final Name name;
    private final Phone phone;

    /**
     * Constructs a {@code NextOfKin}.
     *
     * @param name  The name of the next of kin. Must not be null.
     * @param phone The phone number of the next of kin. Must not be null.
     */
    public NextOfKin(Name name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    /**
     * Returns the name of the next of kin.
     *
     * @return The name as a {@code Name} object.
     */
    public Name getName() {
        return name;
    }

    /**
     * Returns the phone number of the next of kin.
     *
     * @return The phone number as a {@code Phone} object.
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * Checks if this next of kin is logically equal to another object.
     *
     * @param other The object to compare with. May be null.
     * @return True if {@code other} is the same NextOfKin or has matching name and phone fields.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof NextOfKin)) {
            return false;
        }
        NextOfKin otherKin = (NextOfKin) other;
        return otherKin.getName().equals(getName())
                && otherKin.getPhone().equals(getPhone());
    }

    /**
     * Generates a hash code for this next of kin based on name and phone fields.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone());
    }

    /**
     * Returns a string representation of the next of kin in the format: "Name Phone".
     *
     * @return A string combining the name and phone number.
     */
    @Override
    public String toString() {
        return name + " " + phone;
    }
}