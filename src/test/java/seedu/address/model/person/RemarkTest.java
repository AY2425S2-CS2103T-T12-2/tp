package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class RemarkTest {
    @Test
    void constructor_validRemark_success() {
        Remark remark = new Remark("This is a test remark");
        assertEquals("This is a test remark", remark.value);
    }

    @Test
    void toString_validRemark_returnsCorrectString() {
        Remark remark = new Remark("Test remark");
        assertEquals("Test remark", remark.toString());
    }


    @Test
    void equals_differentObjectsDifferentValue_returnsFalse() {
        Remark remark1 = new Remark("First remark");
        Remark remark2 = new Remark("Second remark");
        assertNotEquals(remark1, remark2);
    }

    @Test
    void hashCode_sameValue_sameHashCode() {
        Remark remark1 = new Remark("Hashcode test");
        Remark remark2 = new Remark("Hashcode test");
        assertEquals(remark1.hashCode(), remark2.hashCode());
    }

    @Test
    void hashCode_differentValue_differentHashCode() {
        Remark remark1 = new Remark("Hashcode one");
        Remark remark2 = new Remark("Hashcode two");
        assertNotEquals(remark1.hashCode(), remark2.hashCode());
    }
}
