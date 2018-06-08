package com.deman.jerrett.password_validator;

import java.util.regex.Pattern;

/**
 * A class that contains methods for validating passwords
 */
public class Validator {
    private static String[] commonPasswords = {"password"};
    private static int minLength = 8;

    /**
     * Validates that a password follows a set of rules
     * @param password
     * @return number of rules failed
     */
    public static int validate(String password) {
        int failures = 0;

        if (!isCommon(password))
            failures++;

        if (!isMinChar(password))
            failures++;

        if (!hasSpecialChar(password))
            failures++;

        if (!isUpperAndLowerCase(password))
            failures++;

        if (!hasNum(password)){
            failures++;
        }

        return failures;
    }

    /**
     * Checks if the password is common
     * @param password
     * @return isCommon
     */
    public static boolean isCommon(String password) {
        for (String curr : commonPasswords) {
            if (password.equalsIgnoreCase(curr))
                return false;
        }
        return true;
    }

    /**
     * Checks that the password is the min length
     * @param password
     * @return isMin
     */
    public static boolean isMinChar(String password) {
        return password.length() >= minLength;
    }

    /**
     * Checks that the password as at least one non-alphanumeric char
     * @param password
     * @return hasSpecial
     */
    public static boolean hasSpecialChar(String password) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        return p.matcher(password).find();
    }

    /**
     * Checks that the password has upper and lower case chars
     * @param password
     * @return isUpperAndLower
     */
    public static boolean isUpperAndLowerCase(String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        return hasUppercase && hasLowercase;
    }

    public static boolean hasNum(String password) {
        Pattern p = Pattern.compile("[^a-zA-Z]");
        return p.matcher(password).find();
    }
}
