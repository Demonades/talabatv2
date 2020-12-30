package com.company.Main;

import java.security.NoSuchAlgorithmException;

public class Register{
    public static void RestaurantAndOwner(RestaurantOwner owner, String restaurant_name, String phone, int location_id, int category_id) throws NoSuchAlgorithmException {
        owner.insertIntoDB();

        Restaurant restaurant = new Restaurant(restaurant_name,location_id,phone);
        restaurant.insertIntoDB(owner);

        RestaurantCategory restaurantCategory = new RestaurantCategory(restaurant.getRestaurant_id(), category_id);
        restaurantCategory.insertIntoDB();
    }

}
