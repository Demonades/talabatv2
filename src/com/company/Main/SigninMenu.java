package com.company.Main;

import java.util.Scanner;

public class SigninMenu {
    public static void initial() {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("[1] Sign in as a customer");
        System.out.println("[2] Sign in as a restaurant owner");
        System.out.println("[3] Sign in as an admin");

        System.out.print("Your choice: ");
        int userChoice = input.nextInt();
        switch (userChoice) {
            case 1:
                customer();
                break;
            case 2:
                restaurantOwner();
                break;
            case 3:
                admin();
                break;
            default:
                System.out.println("Invalid choice, please try again!");

        }
    }
    public static void customer(){
        System.out.println("__________________________________");
        System.out.println("         CUSTOMER SIGN IN         ");
        System.out.println("__________________________________");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = input.next();
        System.out.print("Enter your password: ");
        String trypassword = input.next();
        Customer customer = Customer.login(email, trypassword);
        if (customer == null){
            System.out.println("Invalid email or password, please try again!");
        }
        else {
            CustomerMenu menu = new CustomerMenu(customer);
        }

    }
    public static void restaurantOwner(){
        System.out.println("__________________________________");
        System.out.println("     RESTAURANT OWNER SIGN IN     ");
        System.out.println("__________________________________");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = input.next();
        System.out.print("Enter your password: ");
        String trypassword = input.next();

        RestaurantOwner restaurantOwner = RestaurantOwner.login(email, trypassword);
        if (restaurantOwner == null){
            System.out.println("Invalid email or password, please try again!"); //PENDING: INFORM THE USER IF THEIR RESTAURANT IS PENDING APPROVAL
        }
        else {
            RestaurantOwnerMenu menu = new RestaurantOwnerMenu(restaurantOwner);
        }

    }
    public static void admin(){
        System.out.println("__________________________________");
        System.out.println("           ADMIN SIGN IN          ");
        System.out.println("__________________________________");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = input.next();
        System.out.print("Enter your password: ");
        String trypassword = input.next();
        Admin admin = Admin.login(email, trypassword);
        if (admin == null){
            System.out.println("Invalid email or password, please try again!");
        }
        else {
            AdminMenu menu = new AdminMenu(admin);
        }

    }

}
