package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() > 32 || password.length() < 8) {
            throw new IllegalArgumentException(("Password should be length [8, 32]"));
        }
        for (String forbidden : FORBIDDEN) {
            if (password.toLowerCase().contains(forbidden)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        for (char symbol : password.toCharArray()) {
            if (isUpperCase(symbol)) {
                hasUpCase = true;
                continue;
            }
            if (isLowerCase(symbol)) {
                hasLowCase = true;
                continue;
            }
            if (isDigit(symbol)) {
                hasDigit = true;
                continue;
            }
            if (!isLetterOrDigit(symbol)) {
                hasSpecial = true;
            }
        }
        if (!hasUpCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!hasLowCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!hasDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(("Password should contain at least one special symbol"));
        }
        return password;

    }

}
