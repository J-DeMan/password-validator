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
    }

    /**
     * Checks that non-common passwords pass
     */
    @Test
    public void isNotCommon() {
        String pass = "notCommon";

        boolean result = Validator.isCommon(pass);
        assertTrue(result);
    }

    /**
     * Checks that passwords above 8 chars pass
     */
    @Test
    public void isAboveMinChar() {
        String pass = "above8Chars";

        boolean result = Validator.isMinChar(pass);
        assertTrue(result);
    }

    /**
     * Checks that passwords that are 8 chars pass
     */
    @Test
    public void isMinChar() {
        String pass = "12345678";

        boolean result = Validator.isMinChar(pass);
        assertTrue(result);
    }

    /**
     * Checks that passwords under 8 chars fail
     */
    @Test
    public void underMinChar() {
        String pass = "1234567";

        boolean result = Validator.isMinChar(pass);
        assertFalse(result);
    }

    /**
     * Checks that passwords with no special chars fail
     */
    @Test
    public void noSpecialChar() {
        String pass = "12345678abc";

        boolean result = Validator.hasSpecialChar(pass);
        assertFalse(result);
    }

    /**
     * Checks that passwords with special chars pass
     */
    @Test
    public void specialChar() {
        String pass = "12345678abc%";

        boolean result = Validator.hasSpecialChar(pass);
        assertTrue(result);
    }

    /**
     * Checks that all lower case passwords fail
     */
    @Test
    public void allLower() {
        String pass = "abcdrasdfsd";

        boolean result = Validator.isUpperAndLowerCase(pass);
        assertFalse(result);
    }

    /**
     * Checks that all upper case passwords fail
     */
    @Test
    public void allUpper() {
        String pass = "HJDSKJDSBCKHES";

        boolean result = Validator.isUpperAndLowerCase(pass);
        assertFalse(result);
    }

    /**
     * Checks that passwords with lower and upper case pass
     */
    @Test
    public void upperAndLower() {
        String pass = "HJDSKfDSBCKHES";

        boolean result = Validator.isUpperAndLowerCase(pass);
        assertTrue(result);
    }

    /**
     * Checks that passwords can pass
     */
    @Test
    public void passwordsPass() {
        String pass = "MargaretThatcherIs100&10%Sexy";

        int result = Validator.validate(pass);
        assertEquals(result, 0);
    }

    /**
     * Checks that passwords can fail on one or more rules
     */
    @Test
    public void passwordsFail() {
        String pass = "bad";

        int result = Validator.validate(pass);
        assertNotEquals(result, 0);
    }
}
