package com.company.Main;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class Admin {
    private int admin_id;
    private String email;
    private String name;
    private String hash;
    private byte[] salt;

    public Admin(int admin_id, String email, String name) {
        this.admin_id = admin_id;
        this.email = email;
        this.name = name;
    }

    public static ArrayList<RestaurantOwner> getPendingApprovalList(){
        SelectRecords sr = new SelectRecords();
        return sr.retrievePendingApprovalRestaurantOwners();

    }
    public void approveRestaurant(RestaurantOwner restaurantOwner){
        UpdateRecords ur = new UpdateRecords();
        ur.updateAdmin(1, restaurantOwner.getRestaurant_owner_id());
    }

    public static Admin login(String email, String password){
        SelectRecords sr = new SelectRecords();
        if(ValidateLogin.admin(email,password)){
            return sr.retrieveAdmin(email);
        }
        return null;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
