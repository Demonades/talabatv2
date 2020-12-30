package com.company.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminMenu {
    Admin admin;
    Scanner input = new Scanner(System.in);

    public AdminMenu(Admin admin){
        this.admin = admin;

    }
    public void initial(Admin admin) {
        System.out.println("Welcome to admin menu," + admin.getName() + "!");
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
        //ArrayList<RestaurantOwner> restaurantOwners = new ArrayList<>();
        for(RestaurantOwner restaurantOwner: map.keySet())
        {
            Restaurant restaurant = map.get(restaurantOwner);
            System.out.println("[" + i + "]");
            i++;
            restaurantOwners.add(restaurantOwner);

        }
    }
}
