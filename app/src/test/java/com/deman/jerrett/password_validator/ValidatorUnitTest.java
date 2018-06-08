package com.deman.jerrett.password_validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorUnitTest {
    /**
     * Checks that common passwords fail
     */
    @Test
    public void isCommon() {
        String pass = "password";

        boolean result = Validator.isCommon(pass);
        assertFalse(result);

        int ruleFalures = Validator.validate(pass);
        assertNotEquals(ruleFalures, 0);
    }

    /**
     * Checks that non-common passwords pass
     */
    @Test
    public void isNotCommon() {
        String pass = "notCommon";

        boolean result = Validator.isCommon(pass);
        assertTrue(result);

        int ruleFalures = Validator.validate(pass);
        assertEquals(ruleFalures, 0);
    }

    /**
     * Checks that passwords above 8 chars pass
     */
    @Test
    public void isAboveMinChar() {
        String pass = "above8Chars";

        boolean result = Validator.isMinChar(pass);
        assertTrue(result);

        int ruleFalures = Validator.validate(pass);
        assertEquals(ruleFalures, 0);
    }

    /**
     * Checks that passwords that are 8 chars pass
     */
    @Test
    public void isMinChar() {
        String pass = "12345678";

        boolean result = Validator.isMinChar(pass);
        assertTrue(result);

        int ruleFalures = Validator.validate(pass);
        assertEquals(ruleFalures, 0);
    }

    /**
     * Checks that passwords under 8 chars fail
     */
    @Test
    public void underMinChar() {
        String pass = "1234567";

        boolean result = Validator.isMinChar(pass);
        assertFalse(result);

        int ruleFalures = Validator.validate(pass);
        assertNotEquals(ruleFalures, 0);
    }
}
