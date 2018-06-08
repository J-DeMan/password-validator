package com.deman.jerrett.password_validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorUnitTest {
    /**
     * Checks that common passwords fail
     */
    @Test
    public void isCommon() {
        boolean result = Validator.isNotCommon("password");
        assertFalse(result);
    }

    /**
     * Checks that non-common passwords pass
     */
    @Test
    public void isNotCommon() {
        boolean result = Validator.isNotCommon("notCommon");
        assertTrue(result);
    }

    /**
     * Checks that passwords above 8 chars pass
     */
    @Test
    public void isAboveMinChar() {
        boolean result = Validator.isMinChar("above8Chars");
        assertTrue(result);
    }

    /**
     * Checks that passwords that are 8 chars pass
     */
    @Test
    public void isMinChar() {
        boolean result = Validator.isMinChar("12345678");
        assertTrue(result);
    }

    /**
     * Checks that passwords under 8 chars fail
     */
    @Test
    public void underMinChar() {
        boolean result = Validator.isMinChar("1234567");
        assertFalse(result);
    }
}
