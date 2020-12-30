package com.company.Main;

import java.util.Scanner;

public class RestaurantOwnerMenu {
    RestaurantOwner restaurantOwner;
    Restaurant restaurant;
    Scanner input = new Scanner(System.in);

    public RestaurantOwnerMenu(RestaurantOwner restaurantOwner) {
        this.restaurantOwner = restaurantOwner;
        restaurant = this.restaurantOwner.getRestaurant();
        initial();
    }

    public void initial() {
        System.out.println("__________________________________");
        System.out.println("Welcome to your restaurant, " + restaurantOwner.name + "!");
        System.out.println("__________________________________");
        System.out.println("What would you like to do?");
        System.out.println("__________________________________");
        System.out.println("[1] Add meal");
        System.out.println("[2] Edit meal");
        System.out.println("[3] Delete meal ");
        System.out.println("[4] Log out ");
        System.out.print("Your choice: ");
        int userChoice = input.nextInt();
        System.out.println("__________________________________");
        switch (userChoice) {
            case 1:
                addMeal();
                break;
            case 2:
                editMeal();
                break;
            case 3:
                deleteMeal();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice, please try again!");
                initial();
                break;
        }
    }

    public void addMeal() {
        Scanner nameInput = new Scanner(System.in);
        System.out.print("Enter meal name: ");
        String mealName = nameInput.nextLine();

        System.out.print("Enter meal price: ");
        Float mealPrice = input.nextFloat();

        Scanner descInput = new Scanner(System.in);
        System.out.print("Enter meal description: ");
        String mealDescription = descInput.nextLine();

        Meal meal = new Meal(mealName, mealPrice, mealDescription);

        System.out.println("__________________________________");
        System.out.println("Are you sure you want to add " + meal.getMeal_name() + "  your menu?");
        System.out.println("[1] YES");
        System.out.println("[2] NO");
        System.out.print("Your choice: ");
        int userChoice = input.nextInt();
        switch (userChoice) {
            case 1:
                meal.insertIntoDB(restaurant);
                System.out.println("Meal added successfully!\n\n");
            case 2:
                initial();
                break;
        }
    }

    public void editMeal() {
        Meal.displayMealList(restaurant);
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.print("Choose meal ID: ");
        int userChoice = input.nextInt();
        Meal meal = Meal.getMealList(restaurant).get(userChoice - 1);

        Scanner nameInput = new Scanner(System.in);
        System.out.println("Leave fields empty if you want them unchanged.");
        System.out.print("Enter new meal name: ");
        String mealName = nameInput.nextLine();
        if (!mealName.isEmpty()) {
            meal.setMeal_name(mealName);
        }

        System.out.print("Enter new meal price (enter 0 to leave unchanged): ");
        Float mealPrice = input.nextFloat();
        if (mealPrice > 1) {
            meal.setMeal_price(mealPrice);
        }

        Scanner descInput = new Scanner(System.in);
        System.out.print("Enter new meal description: ");
        String mealDescription = descInput.nextLine();
        if (!mealDescription.isEmpty()) {
            meal.setMeal_description(mealDescription);
        }

        System.out.println("__________________________________");
        System.out.println("Are you sure you want to update " + meal.getMeal_name() + " in your menu?");
        System.out.println("[1] YES");
        System.out.println("[2] NO");
        System.out.print("Your choice: ");
        userChoice = input.nextInt();
        switch (userChoice) {
            case 1:
                meal.editMeal();
            case 2:
                initial();
                break;
        }

    }

    public void deleteMeal() {
        Meal.displayMealList(restaurant);
        Scanner input = new Scanner(System.in);
        System.out.print("Choose meal ID: ");
        int userChoice = input.nextInt();
        Meal meal = Meal.getMealList(restaurant).get(userChoice - 1);

        System.out.println("__________________________________");
        System.out.println("Are you sure you want to remove " + meal.getMeal_name() + " from your menu?");
        System.out.println("[1] YES");
        System.out.println("[2] NO");
        System.out.print("Your choice: ");
        userChoice = input.nextInt();
        switch (userChoice) {
            case 1:
                meal.deleteMeal();
            case 2:
                initial();
                break;
        }

    }

}

