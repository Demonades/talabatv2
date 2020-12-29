package com.company.Main;

import java.util.ArrayList;

public class Meal {
    private int meal_id;
    private int restaurant_id;
    private String meal_name;
    private float meal_price;
    private String meal_description;

    public Meal(String meal_name, float meal_price, String meal_description) {
        this.meal_name = meal_name;
        this.meal_price = meal_price;
        this.meal_description = meal_description;
    }

    public Meal(int meal_id, int restaurant_id, String meal_name, float meal_price, String meal_description) {
        this.meal_id = meal_id;
        this.restaurant_id = restaurant_id;
        this.meal_name = meal_name;
        this.meal_price = meal_price;
        this.meal_description = meal_description;
    }

    public void insertIntoDB(Restaurant restaurant){
        //restaurant_id = restaurant.getRestaurant_id();
        restaurant_id = restaurant.getRestaurant_id();
        InsertRecords ir = new InsertRecords();
        ir.insertMeal(restaurant_id, meal_name, meal_price, meal_description);
    }

    public static ArrayList<Meal> getMealList(Restaurant restaurant){
        SelectRecords sr = new SelectRecords();
        return sr.retrieveMealList(restaurant.getRestaurant_id());
    }

    public void deleteMeal(){
        DeleteRecords dr = new DeleteRecords();
        dr.deleteMeal(meal_id);
    }

    public String getMeal_name() {
        return meal_name;
    }

    public float getMeal_price() {
        return meal_price;
    }

    public String getMeal_description() {
        return meal_description;
    }
}
