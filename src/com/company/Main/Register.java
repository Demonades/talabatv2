package com.company.Main;

import java.security.NoSuchAlgorithmException;

public class Register{
    public static void RestaurantAndOwner(RestaurantOwner owner, String restaurant_name, String phone, Location location, Category category) throws NoSuchAlgorithmException {
        owner.insertIntoDB();

        Restaurant restaurant = new Restaurant(restaurant_name,location.getLocation_id(),phone);
        restaurant.insertIntoDB(owner);

        RestaurantCategory restaurantCategory = new RestaurantCategory(restaurant.getRestaurant_id(), category.getCategory_id());
        restaurantCategory.insertIntoDB();
    }

}
