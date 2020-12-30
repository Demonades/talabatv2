package com.company.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMenu {
    Customer customer;
    Scanner input = new Scanner(System.in);

    public CustomerMenu(Customer customer) {
        this.customer = customer;
        initial();
    }

    public void initial() {
        System.out.println("__________________________________");
        System.out.println("Welcome to main menu, " + customer.name + "!");
        System.out.println("__________________________________");
        System.out.println("What would you like to do?");
        System.out.println("[1] Categories");
        System.out.println("[2] All restaurants");
        System.out.println("[3] Search");
        System.out.println("[4] Log out");
        System.out.println("__________________________________");
        System.out.print("Your choice: ");
        int userChoice = input.nextInt();
        switch (userChoice) {
            case 1:
                viewCategories();
                break;
            case 2:
                viewAllRestaurants();
                break;
            case 3:
                searchRestaurants();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice, please try again!");
                initial();
                break;
        }
    }

    public void viewCategories() {
        System.out.println("__________________________________");
        System.out.println("            CATEGORIES            ");
        System.out.println("__________________________________");
        Category.displayCategoryList();
        System.out.print("Select a category ID: ");
        int userChoice = input.nextInt();
        //PENDING ERROR HANDLING
        viewCategorizedRestaurants(Category.getCategoryList().get(userChoice - 1));
    }

    public void viewCategorizedRestaurants(Category category) {
        System.out.println("__________________________________");
        System.out.println(category.getCategory_name().toUpperCase()+" RESTAURANTS");
        System.out.println("__________________________________");
        ArrayList<Restaurant> restaurants = Restaurant.getCategorizedRestaurants(category.getCategory_id());
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + restaurants.get(i).getRestaurant_name());
        }
        System.out.println("__________________________________");
        System.out.print("Select a restaurant ID: ");
        int userChoice = input.nextInt();
        viewRestaurant(restaurants.get(userChoice - 1));
    }

    public void viewAllRestaurants() {
        System.out.println("\n__________________________________");
        System.out.println("          ALL RESTAURANTS         ");
        System.out.println("__________________________________");

        ArrayList<Restaurant> restaurants = Restaurant.getRestaurantListAll();
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + restaurants.get(i).getRestaurant_name());
        }
        System.out.print("Select a restaurant ID: ");
        int userChoice = input.nextInt();
        viewRestaurant(restaurants.get(userChoice - 1));
    }

    public void viewRestaurant(Restaurant restaurant) {
        System.out.println("\n__________________________________");
        System.out.println("Welcome to " + restaurant.getRestaurant_name());
        System.out.println("__________________________________");
        Meal.displayMealList(restaurant);

        System.out.println("What would you like to do?");
        System.out.println("[1] Make an order");
        System.out.println("[0] Go back to main menu");
        System.out.print("Your choice: ");
        int userChoice = input.nextInt();
        switch (userChoice) {
            case 0 -> initial();
            case 1 -> {
                Meal.orderMeal(restaurant);
                initial();
            }
        }

        //System.out.println("What would you like to do?");
        //System.out.println("[1] Make another order");
        //System.out.println("[0] Go back to main menu");
        //userChoice = input.nextInt();
        //switch (userChoice) {
        //case 1:
        //        viewRestaurant(restaurant);
        //        break;
        //    case 2:
        //        initial();
        //}
    }

    public void searchRestaurants() {
        System.out.println("\n__________________________________");
        System.out.println("              SEARCH              ");
        System.out.println("__________________________________");
        System.out.println("What would you like to do?");
        System.out.println("[1] Search by location");
        System.out.println("[2] Search by restaurant name");
        System.out.println("[0] Go back to main menu\n");
        System.out.print("Your choice: ");

        int userChoice = input.nextInt();

        switch (userChoice) {
            case 0:
                initial();
                break;
            case 1:
                viewLocations();
                break;
            case 2:
                searchRestaurantName();
                break;
        }
    }

    public void viewLocations() {
        System.out.println("\n__________________________________");
        System.out.println("             LOCATIONS            ");
        System.out.println("__________________________________");

        Location.displayLocationList();
        System.out.print("Select a location ID: ");
        int userChoice = input.nextInt();
        //PENDING ERROR HANDLING
        viewRestaurantsByLocation(Location.getLocationList().get(userChoice - 1));
    }

    public void viewRestaurantsByLocation(Location location) {
        System.out.println("__________________________________");
        System.out.println("    RESTAURANTS IN " + location.getLocation_name());
        System.out.println("__________________________________");
        ArrayList<Restaurant> restaurants = Restaurant.getRestaurantsInLocation(location.getLocation_id());
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + restaurants.get(i).getRestaurant_name());
        }
        System.out.println("[0] Go back to main menu\n");
        System.out.print("Select a restaurant ID: ");
        int userChoice = input.nextInt();
        if (userChoice == 0) {
            initial();
        } else {
            viewRestaurant(restaurants.get(userChoice - 1));
        }
    }

    public void searchRestaurantName() {
        System.out.println("__________________________________");
        System.out.println("     SEARCH RESTAURANT BY NAME    ");
        System.out.println("__________________________________");
        String restaurantName;
        ArrayList<Restaurant> restaurants = Restaurant.getRestaurantListAll();
        System.out.print("Enter restaurant name: ");
        restaurantName = input.next();
        Restaurant foundRestaurant = null;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getRestaurant_name().equals(restaurantName)) {
                foundRestaurant = restaurant;
            }
        }
        if(foundRestaurant != null){
            viewRestaurant(foundRestaurant);
        }
        else{
            System.out.println("No restaurant found with that name!");
            System.out.println("__________________________________");
            System.out.println("What would you like to do?");
            System.out.println("[1] Search for another restaurant");
            System.out.println("[0] Go back to main menu");
            System.out.print("Your choice: ");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 0:
                    initial();
                    break;
                case 1:
                    searchRestaurants();
                    break;
            }
        }
    }
}
