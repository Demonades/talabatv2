package com.company.Main;

import java.security.NoSuchAlgorithmException;

public class Customer extends User{
    private int customer_id;
    private int user_id;

    public Customer(String email, String name, String hash) throws NoSuchAlgorithmException {
        super(email, name, hash);
    }

    public Customer(String email, String name, int user_id, int customer_id) throws NoSuchAlgorithmException {
        this.email = email;
        this.name = name;
        this.user_id = user_id;
        this.customer_id = customer_id;

    }

    public void insertIntoDB(){
        InsertRecords ir = new InsertRecords();
        SelectRecords sr = new SelectRecords();
        ir.insertUser(email, name, hash, salt);
        user_id = sr.retrieveInteger("user_id","USERS","email",email);
        ir.insertCustomer(user_id);
    }


    public static Customer login(String email, String password){
        SelectRecords sr = new SelectRecords();
        if(ValidateLogin.user(email,password)){
            return sr.retrieveCustomer(email);
        }
        return null;
    }


}
