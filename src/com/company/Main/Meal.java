package com.company.Main;

import java.util.ArrayList;
import java.util.*;

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

    public static void dispalayMealList(Restaurant restaurant) {

        ArrayList<Meal> meals = new ArrayList<Meal>(100);
        meals = getMealList(restaurant);
        for(int i = 0 ; i < meals.size() ; i++)
        {
            System.out.println("___________________________");
            System.out.println(i+1 + "  "+meals.get(i).meal_name + "  " +meals.get(i).meal_price   );
            System.out.println(meals.get(i).meal_description);
            System.out.println("___________________________");
        }
    }
    public static void orderMeal(ArrayList<Restaurant> restaurant  ) {
        Scanner input = new Scanner(System.in);
        ArrayList<Meal> restaurant_meals = new ArrayList<Meal>(100);
        while(true) {
            System.out.println("Choose Meal : ");
            int choose_meal = input.nextInt();
            restaurant_meals = Meal.getMealList(restaurant.get(choose_meal - 1));
            System.out.println("Quantity : ");
            int quantity;
            quantity = input.nextInt();
            float price = restaurant_meals.get(choose_meal - 1).getMeal_price() * quantity;
            System.out.println("Total  :  " + price);
            System.out.println("CHECK OUT : (1 - YES   2 - NO  )");
            int i = input.nextInt();
            System.out.println("another order ? (1 - YES   2 - NO  )");
            i = input.nextInt();
            if(i == 2)
            {
                break;
            }


        }
    }
    public void deleteMeal(){
        DeleteRecords dr = new DeleteRecords();
        dr.deleteMeal(meal_id);
    }

}