package com.company.Main;

import java.util.ArrayList;

public class Category {
    private int category_id;
    private String category_name;

    public Category(int category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public static ArrayList<Category> getCategoryList(){
        SelectRecords sr = new SelectRecords();
        return sr.retrieveCategoryList();
    }
    //RETRIEVE ARRAY LIST OF ALL RESTAURANT IN A CERTAIN CATEGORY
    public static ArrayList<Restaurant> getCategorizedRestaurants(int category_id){
        SelectRecords sr = new SelectRecords();
        return sr.retrieveCategorizedRestaurantList(category_id);
    }

}
