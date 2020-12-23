package com.company.Main;

public class ValidateLogin {
    public static void validateLogin(String email, String tryPassword) {
        SelectRecords sr = new SelectRecords();
        String hash = sr.retrieveString("hash", "users", "email", email);
        byte[] salt = sr.retrieveByte("salt", "users", "email", email);

        if (PasswordHashing.validatePassword(hash, salt, tryPassword)) {
            System.out.println("Successful login!");
        } else {
            System.out.println("Wrong password, please try again!");
        }
    }
}
