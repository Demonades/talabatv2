package com.company.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class InsertRecords {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:users.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void insertUser(String email, String name, String hash, byte[] salt) {
        //ir.insertUser(email, name, hash_password,salt,location);
        String sql = "INSERT INTO USERS(email, name, hash, salt) VALUES(?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, name);
            pstmt.setString(3, hash);
            pstmt.setBytes(4, salt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insertCustomer(int user_id) {
        //ir.insertUser(email, name, hash_password,salt,location);
        String sql = "INSERT INTO CUSTOMERS(user_id) VALUES(?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insertRestaurantOwner(int user_id, int approved) {
        //ir.insertUser(email, name, hash_password,salt,location);
        String sql = "INSERT INTO RESTAURANT_OWNER(user_id,approved) VALUES(?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            pstmt.setInt(2,approved);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //ir.insertRestaurant(restaurant_id,restaurant_name,location,phone,restaurant_owner_id);
    public void insertRestaurant(String restaurant_name, int location_id, String phone, int restaurant_owner_id) {
        //ir.insertUser(email, name, hash_password,salt,location);
        String sql = "INSERT INTO RESTAURANT(restaurant_name,location_id,phone,restaurant_owner_id) VALUES(?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, restaurant_name);
            pstmt.setInt(2, location_id);
            pstmt.setString(3, phone);
            pstmt.setInt(4, restaurant_owner_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insertMeal(int restaurant_id, String meal_name, float meal_price, String meal_description) {
        //ir.insertUser(email, name, hash_password,salt,location);
        String sql = "INSERT INTO MEAL(restaurant_id, meal_name, meal_price, meal_description) VALUES(?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, restaurant_id);
            pstmt.setString(2, meal_name);
            pstmt.setFloat(3, meal_price);
            pstmt.setString(4, meal_description);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insertRestaurantCategory(int restaurant_id, int category_id) {
        String sql = "INSERT INTO RESTAURANT_CATEGORIES(restaurant_id, category_id) VALUES(?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, restaurant_id);
            pstmt.setInt(2, category_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }





}