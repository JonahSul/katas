/*
 * Password Validation Kata
 * 
 * Problem Description:
 * Given a password in clear text, validate that it matches a secure password object which has been hashed and salted.
 * 
 * Examples:
 * - Input: "password123"
 *   Expected Output: true
 * - Input: "wrongpassword"
 *   Expected Output: false
 * 
 * 
 */
package com.katas;

public class Password {
    private String hashedPassword;

    public Password(String passwordString) {
        if (!passwordString.isEmpty()) {
            this.hashedPassword = hashPassword(passwordString);
        } else {
            throw new IllegalArgumentException("Password cannot be empty");
        }
    }

    private String hashPassword(String password) {
        // Simple hash for demonstration; replace with secure hashing in production
        return Integer.toHexString(password.hashCode());
    }

    public boolean validate(String input) {
        return hashedPassword.equals(hashPassword(input));
    }
}
