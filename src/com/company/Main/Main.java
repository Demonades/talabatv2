package com.company.Main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {


        //ADDING A CUSTOMER
        //Customer user1 = new Customer("perry@test.com","perry","abc123");
        //user1.insertIntoDB();

        //ADDING A RESTAURANT OWNER AND A RESTAURANT
        //RestaurantOwner owner = new RestaurantOwner("kebda@test.com","bta3kebda","kebda");
        //Location location = new Location(1, "NASR CITY"); // TEMP HOLDERS
        //Category category = new Category(2, "Breakfast"); // TEMP HOLDERS
        //Register.RestaurantAndOwner(owner, "El fala7", "0102333", location, category);

        //CREATE AND ADD A MEAL
        //Meal meal = new Meal("Pizza shar2y",40F,"Akeed pizza agmad menha");
        //meal.insertIntoDB(restaurant);

        //VERIFY EMAIL AND PASSWORD TO LOGIN, RETURNS BOOLEAN
        //ValidateLogin.validateLogin("perry@test.com","abc123");

        //GET AN ARRAY LIST OF ALL RESTAURANTS
        //Restaurant.getRestaurantListAll();

        //GET AN ARRAY LIST OF ALL LOCATIONS
        //Location.getLocationList();


        //Admin.getPendingApprovalList();

        //Category.getCategoryList();

        //Category.getCategorizedRestaurants(1);
        //SelectRecords sr = new SelectRecords();
        //Restaurant restaurant = sr.retrieveRestaurant("*","RESTAURANT", "restaurant_id", "4");


        //ArrayList<Meal> al = Meal.getMealList(restaurant);
        //for(Meal meal: al){
        //    System.out.println(meal.getMeal_name());
        //}
        //UpdateRecords.updateAdmin(1, 2);
        //ArrayList<Restaurant> rs = Restaurant.getRestaurantsInLocation(1);
        //for(Restaurant r: rs){
        //    System.out.println(r.getRestaurant_name());
        //}

        //Customer c1= new Customer("user1@test.com","user1", "user1");
        //Customer c2= new Customer("user2@test.com","user2", "user2");
        //c1.insertIntoDB();
        //c2.insertIntoDB();
        RestaurantOwner c = RestaurantOwner.login("ro@test.com","fool");
        Restaurant r = c.getRestaurant();
        //System.out.println(r.getRestaurant_name());
        //System.out.println(r.getPhone());
        //System.out.println("Hello!");
        //System.out.println(c.getName());
        //Admin admin = new Admin("admin1@admin.com", "admin1", "admin1");
        //admin.insertIntoDB();
        //Admin a = Admin.login("admin1@admin.com", "admin1");
        //System.out.println(a.getName());
        //System.out.println("Hello!");
        //DeleteRecords dr = new DeleteRecords();
        //dr.deleteMeal(1);
    }
}