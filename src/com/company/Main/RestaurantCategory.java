package com.company.Main;

public class RestaurantCategory {
    int restaurant_id;
    int category_id;

    public RestaurantCategory(int restaurant_id, int category_id) {
        this.restaurant_id = restaurant_id;
        this.category_id = category_id;
    }

    public void insertIntoDB(){
        InsertRecords ir = new InsertRecords();
        ir.insertRestaurantCategory(restaurant_id, category_id);
    }
}
