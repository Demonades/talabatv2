package com.company.Main;

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
    //INSERT MEAL INTO DATABASE - TO BE WRITTEN
    //RETRIEVE MEAL FROM DATABASE
}
