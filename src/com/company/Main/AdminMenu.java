package com.company.Main;

public class AdminMenu {
    Admin admin;
    public void initial(Admin admin){
        this.admin = admin;
        System.out.println("Welcome to admin menu!");
        System.out.println(admin.getName());
    }
}
