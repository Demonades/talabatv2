package com.company.Main;

import java.security.NoSuchAlgorithmException;

public class RestaurantOwner extends User{
    private int restaurant_owner_id;
    private int user_id;
    private int approved;
    //FOR RESTAURANT OWNER CREATION
    public RestaurantOwner(String email, String name, String hash_password) throws NoSuchAlgorithmException {
        super(email, name, hash_password);
        approved = 0; //FALSE
    }
    //FOR RESTAURANT OWNER SELECTION AND ITERATION FROM DATABASE
    public RestaurantOwner(String email, String name, int restaurant_owner_id, int user_id, int approved) {
        this.email = email;
        this.name = name;
        this.restaurant_owner_id = restaurant_owner_id;
        this.user_id = user_id;
        this.approved = approved;
    }

    public int getRestaurant_owner_id() {
        return restaurant_owner_id;
    }

    @Override
    public void insertIntoDB() {
        InsertRecords ir = new InsertRecords();
        SelectRecords sr = new SelectRecords();
        ir.insertUser(email, name, hash, salt);
        user_id = sr.retrieveInteger("user_id","USERS","email",email);
        ir.insertRestaurantOwner(user_id,approved);
        restaurant_owner_id = sr.retrieveInteger("restaurant_owner_id","RESTAURANT_OWNER",
                "user_id", String.valueOf(user_id));
    }
    //GET RESTAURANT BY CATEGORIES
}
