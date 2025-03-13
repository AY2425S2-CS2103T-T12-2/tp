package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    public void constructor_validRole_success() {
        assertDoesNotThrow(() -> new Role("PATIENT"));
        assertDoesNotThrow(() -> new Role("STAFF"));
        assertDoesNotThrow(() -> new Role("patient")); // Case insensitive
        assertDoesNotThrow(() -> new Role("staff"));
    }

    @Test
    public void constructor_invalidRole_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Role("DOCTOR"));
        assertThrows(IllegalArgumentException.class, () -> new Role(""));
        assertThrows(IllegalArgumentException.class, () -> new Role("123"));
        assertThrows(IllegalArgumentException.class, () -> new Role("staff123"));
    }

    @Test
    public void isValidRole_validInputs_returnTrue() {
        assertTrue(Role.isValidRole("PATIENT"));
        assertTrue(Role.isValidRole("STAFF"));
        assertTrue(Role.isValidRole("patient"));
        assertTrue(Role.isValidRole("staff"));
    }

    @Test
    public void isValidRole_invalidInputs_returnFalse() {
        assertFalse(Role.isValidRole("DOCTOR"));
        assertFalse(Role.isValidRole(""));
        assertFalse(Role.isValidRole("123"));
        assertFalse(Role.isValidRole("staff123"));
        assertFalse(Role.isValidRole(null));
    }

    @Test
    public void toString_validRole_returnsCorrectString() {
        assertEquals("PATIENT", new Role("patient").toString());
        assertEquals("STAFF", new Role("STAFF").toString());
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        Role role = new Role("PATIENT");
        assertTrue(role.equals(role));
    }

    @Test
    public void equals_differentObjectSameValue_returnsTrue() {
        assertTrue(new Role("PATIENT").equals(new Role("patient")));
        assertTrue(new Role("STAFF").equals(new Role("staff")));
    }

    @Test
    public void equals_differentRole_returnsFalse() {
        assertFalse(new Role("PATIENT").equals(new Role("STAFF")));
    }

    @Test
    public void equals_differentType_returnsFalse() {
        assertFalse(new Role("PATIENT").equals("patient"));
        assertFalse(new Role("STAFF").equals(null));
    }

    @Test
    public void hashCode_sameRoleSameHash() {
        assertEquals(new Role("PATIENT").hashCode(), new Role("patient").hashCode());
        assertEquals(new Role("STAFF").hashCode(), new Role("staff").hashCode());
    }

    @Test
    public void hashCode_differentRolesDifferentHash() {
        assertNotEquals(new Role("PATIENT").hashCode(), new Role("STAFF").hashCode());
    }
}