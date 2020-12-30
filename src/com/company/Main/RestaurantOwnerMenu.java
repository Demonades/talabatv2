package com.company.Main;

public class RestaurantOwnerMenu {
    RestaurantOwner restaurantOwner;
    Restaurant restaurant;

    public void initial(RestaurantOwner restaurantOwner){
        this.restaurantOwner = restaurantOwner;
        restaurant = this.restaurantOwner.getRestaurant();
        System.out.println("Welcome to restaurant owner menu!");
        System.out.println(restaurantOwner.name);
        System.out.println(restaurant.getRestaurant_name());
    }
}
