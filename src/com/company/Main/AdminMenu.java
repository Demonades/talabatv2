package com.company.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminMenu {
    Admin admin;
    Scanner input = new Scanner(System.in);

    public AdminMenu(Admin admin){
        this.admin = admin;
        initial();
    }
    public void initial() {
        System.out.println("Welcome to admin menu, " + admin.getName() + "!");
        System.out.println(admin.getName());
        System.out.println("__________________________________");
        System.out.println("What would you like to do?");
        System.out.println("__________________________________");
        System.out.println("[1] Approve restaurant");
        System.out.println("[2] Log out");
        System.out.print("Your choice: ");
        int userChoice = input.nextInt();
        System.out.println("__________________________________");
        switch (userChoice) {
            case 1:
                approveRestaurant();
                break;
            case 2:
                break;
        }
    }
    public void approveRestaurant(){
        ArrayList<RestaurantOwner> restaurantOwners = Admin.getPendingApprovalList();
        int i = 1;
        for(RestaurantOwner restaurantOwner: restaurantOwners)
        {
            Restaurant restaurant = restaurantOwner.getRestaurant();
            System.out.println("[" + i + "]");
            i++;
            System.out.println("Owner name: " + restaurantOwner.name);
            System.out.println("Owner email: " + restaurantOwner.email);
            System.out.println("Restaurant name: " + restaurant.getRestaurant_name());
            System.out.println("Restaurant phone no.: " + restaurant.getPhone());
            System.out.println("Restaurant location: " + restaurant.getLocation().location_name);
            System.out.println("__________________________________");
        }
        System.out.println("__________________________________");
        System.out.print("Choose restaurant to approve: ");
        int userChoice = input.nextInt();
        RestaurantOwner approvedRestaurantOwner = restaurantOwners.get(userChoice-1);
        System.out.println("__________________________________");
        System.out.println("Are you sure you want to approve restaurant owner?");
        System.out.println("[1] YES");
        System.out.println("[2] NO");
        System.out.print("Your choice: ");
        userChoice = input.nextInt();
        switch (userChoice) {
            case 1:
                admin.approveRestaurant(approvedRestaurantOwner);
                System.out.println("Restaurant owner approved!\n\n");
            case 2:
                initial();
                break;
        }
    }
}
