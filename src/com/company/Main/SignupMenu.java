package com.company.Main;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SignupMenu {
    public static void initial() throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("__________________________________");
        System.out.println("[1] Sign up as a customer");
        System.out.println("[2] Sign up as a restaurant owner");
        System.out.println("__________________________________");
        System.out.print("Your choice: ");
        int userChoice = input.nextInt();
        switch (userChoice){
            case 1:
                customer();
                break;
            case 2:
                restaurantOwner();
                break;
            default:
                System.out.println("Invalid choice, please try again!");

        }
    }
    public static void customer() throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        String email, name, hash_password;
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter email: ");
        email = input.next();
        System.out.print("Enter password: ");
        hash_password = input.next();

        Customer customer = new Customer(email, name, hash_password);
        customer.insertIntoDB();
        System.out.println("User created successfully!");
        //DISPLAY USER MENU
    }
    public static void restaurantOwner() throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        System.out.println("Restaurant owner credentials");
        System.out.println("__________________________________");
        System.out.print("Enter name: ");
        String name = input.next();
        System.out.print("Enter email: ");
        String email = input.next();
        System.out.print("Enter password: ");
        String hash_password = input.next();
        System.out.println("__________________________________");
        RestaurantOwner owner = new RestaurantOwner(email, name, hash_password);
        System.out.print("Enter restaurant name: ");
        String restaurant_name = input.next();
        System.out.print("Enter phone: ");
        String phone = input.next();
        //CHOOSE LOCATION
        System.out.println("\nLOCATIONS:");
        Location.displayLocationList();
        System.out.println("__________________________________");
        System.out.print("Enter location ID: ");
        int location_id = input.nextInt(); //Pending error handling
        //CHOOSE CATEGORY
        System.out.println("\nCATEGORIES:");
        Category.displayCategoryList();
        System.out.println("__________________________________");
        System.out.print("Enter category ID: ");
        int category_id = input.nextInt(); //Pending error handling
        Register.RestaurantAndOwner(owner, restaurant_name, phone, location_id, category_id);
        System.out.println("\nYour restaurant is now pending admin approval!");
        WelcomeMenu.welcome();
    }
}
