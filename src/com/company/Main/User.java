package com.company.Main;

import java.security.NoSuchAlgorithmException;

public abstract class User {
    protected int user_id;
    protected String email;
    protected String name;
    protected String hash = "";
    protected byte[] salt;

    public User(){

    }

    public User(String email, String name, String hash) throws NoSuchAlgorithmException {
        this.email = email;
        this.name = name;
        //GENERATE SALT FOR USER
        salt = PasswordHashing.generateSalt();
        //HASH PASSWORD IMMEDIATELY USING SALT AND SHA-1
        this.hash = PasswordHashing.generateHash(hash,salt);
    }

    public abstract void insertIntoDB();
}
