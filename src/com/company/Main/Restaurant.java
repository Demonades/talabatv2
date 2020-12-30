package com.company.Main;

import java.util.ArrayList;

public class Restaurant {
    private int restaurant_id;
    private String restaurant_name;
    private int location_id;
    //UNHANDLED IMAGE
    private String phone;
    private int restaurant_owner_id;

    public Restaurant(String restaurant_name, int location_id, String phone) {
        this.restaurant_name = restaurant_name;
        this.location_id = location_id;
        this.phone = phone;
    }
    public Restaurant(int restaurant_id, String restaurant_name, int location_id, String phone, int restaurant_owner_id) {
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
        this.location_id = location_id;
        this.phone = phone;
        this.restaurant_owner_id = restaurant_owner_id;
    }

    public void setRestaurant_owner_id(int restaurant_owner_id) {
        this.restaurant_owner_id = restaurant_owner_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public int getLocation_id() {
        return location_id;
    }

    public String getPhone() {
        return phone;
    }

    public void insertIntoDB(RestaurantOwner restaurantOwner){
        InsertRecords ir = new InsertRecords();
        ir.insertRestaurant(restaurant_name,location_id,phone,restaurantOwner.getRestaurant_owner_id());
        SelectRecords sr = new SelectRecords();
        restaurant_id = sr.retrieveInteger("restaurant_id", "RESTAURANT", "restaurant_name",restaurant_name);
    }

    public static ArrayList<Restaurant> getRestaurantListAll(){
        SelectRecords sr = new SelectRecords();
        return sr.retrieveRestaurantListAll();
    }

    //DISPLAY ALL  RESTAURANTS
    public static void displayRestaurantListAll() {
        ArrayList<Restaurant> all_restaurants = new ArrayList<Restaurant>(100);
        all_restaurants = getRestaurantListAll();
        System.out.println("_________________________");

        for (int i = 0; i < all_restaurants.size(); i++) {

            System.out.println(i+1 + "  "+ all_restaurants.get(i).getRestaurant_name());
        }
        System.out.println("_________________________");
        System.out.println("Press 0 to back to the main menu");

    }
    //RETRIEVE ARRAY LIST OF ALL RESTAURANT IN A CERTAIN CATEGORY
    public static ArrayList<Restaurant> getCategorizedRestaurants(int category_id){
        SelectRecords sr = new SelectRecords();
        return sr.retrieveCategorizedRestaurantList(category_id);
    }


    //DISPLAY ALL  RESTAURANT IN ANY ARRAYLIST
    public static void   displayRestaurants( ArrayList<Restaurant> restaurants  ){
        System.out.println("_____________________");

        for (int j = 0 ; j < restaurants.size() ; j++ )
        {
            System.out.println( j + 1  + "  "+restaurants.get(j).getRestaurant_name() );
        }
        System.out.println("_____________________");
        System.out.println("Press 0 to back to the main menu");

    }

    public static ArrayList<Restaurant> getRestaurantsInLocation(int location_id){
        SelectRecords sr = new SelectRecords();
        return sr.retrieveLocationRestaurantList(location_id);
    }
}