package com.company.Main;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class WelcomeMenu {
    public static void welcome() throws NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        System.out.println("------WELCOME TO TALABAT!------");
        System.out.println("What would you like to do?");
        System.out.println("[1] Sign up");
        System.out.println("[2] Sign in");
        System.out.println("[3] Exit");
        System.out.println("-------------------------------");
        System.out.print("Your choice: ");
        int userChoice = input.nextInt();
        switch (userChoice){
            case 1:
                SignupMenu.initial();
                break;
            case 2:
                SigninMenu.initial();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice, please try again!");
                break;

        }
    }
}
