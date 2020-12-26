package com.company.Main;

public class ValidateLogin {
    public static boolean user(String email, String tryPassword) {
        SelectRecords sr = new SelectRecords();
        String hash = sr.retrieveString("hash", "users", "email", email);
        byte[] salt = sr.retrieveByte("salt", "users", "email", email);

        if (PasswordHashing.validatePassword(hash, salt, tryPassword)) {
            return true;
        }
        return false;
    }
    public static boolean admin(String email, String tryPassword) {
        SelectRecords sr = new SelectRecords();
        String hash = sr.retrieveString("hash", "admins", "email", email);
        byte[] salt = sr.retrieveByte("salt", "admins", "email", email);

        if (PasswordHashing.validatePassword(hash, salt, tryPassword)) {
            return true;
        }
        return false;
    }

}
