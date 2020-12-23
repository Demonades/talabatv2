package com.company.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Admin {
    private int admin_id;

    public static HashMap<RestaurantOwner, Restaurant> getPendingApprovalList(){
        SelectRecords sr = new SelectRecords();
        return sr.retrievePendingApprovalRestaurantOwners();
        //for(RestaurantOwner owner: map.keySet()){
            //System.out.println("Owner name: " + owner.name);
            //System.out.println("Restaurant name: " + map.get(owner).getRestaurant_name());
        //}
    }
}
