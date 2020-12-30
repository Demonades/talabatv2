package com.company.Main;

import java.util.ArrayList;
import java.util.*;

public class Meal {
    private int meal_id;
    private int restaurant_id;
    private final String meal_name;
    private final float meal_price;
    private final String meal_description;

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

    public void insertIntoDB(Restaurant restaurant) {
        //restaurant_id = restaurant.getRestaurant_id();
        restaurant_id = restaurant.getRestaurant_id();
        InsertRecords ir = new InsertRecords();
        ir.insertMeal(restaurant_id, meal_name, meal_price, meal_description);
    }

    public static ArrayList<Meal> getMealList(Restaurant restaurant) {
        SelectRecords sr = new SelectRecords();
        return sr.retrieveMealList(restaurant.getRestaurant_id());
    }
    //INSERT MEAL INTO DATABASE - TO BE WRITTEN
    //RETRIEVE MEAL FROM DATABASE

    public String getMeal_name() {
        return meal_name;
    }

    public float getMeal_price() {
        return meal_price;
    }

    public String getMeal_description() {
        return meal_description;
    }

    public static void displayMealList(Restaurant restaurant) {

        ArrayList<Meal> meals = getMealList(restaurant);
        for (int i = 0; i < meals.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + meals.get(i).meal_name + "  " + meals.get(i).meal_price + "EGP");
            System.out.println(meals.get(i).meal_description);
            System.out.println("__________________________________");
        }
    }

    public static void orderMeal(Restaurant restaurant) {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose meal ID: ");
        int userChoice = input.nextInt();
        Meal meal = Meal.getMealList(restaurant).get(userChoice-1);
        System.out.print("Enter quantity: ");
        int quantity;
        quantity = input.nextInt();
        float price = meal.getMeal_price() * quantity;
        System.out.println("Total: " + price);
        System.out.println("Would you like to checkout?");
        System.out.println("[1] YES");
        System.out.println("[2] NO");
        System.out.println("Your choice: ");
        userChoice = input.nextInt();
        switch (userChoice) {
            case 1:
                System.out.println("Your order will be delivered in 45 minutes!");
                break;
            case 2:
                break;
        }
    }

    public void deleteMeal() {
        DeleteRecords dr = new DeleteRecords();
        dr.deleteMeal(meal_id);
    }

}