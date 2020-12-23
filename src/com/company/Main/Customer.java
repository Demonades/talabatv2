package com.company.Main;

import java.security.NoSuchAlgorithmException;

public class Customer extends User{
    private int customer_id;
    private int user_id;

    public Customer(String email, String name, String hash_password) throws NoSuchAlgorithmException {
        super(email, name, hash_password);
    }

    @Override
    public void insertIntoDB(){
        InsertRecords ir = new InsertRecords();
        SelectRecords sr = new SelectRecords();
        ir.insertUser(email, name, hash, salt);
        user_id = sr.retrieveInteger("user_id","USERS","email",email);
        ir.insertCustomer(user_id);
    }
}
