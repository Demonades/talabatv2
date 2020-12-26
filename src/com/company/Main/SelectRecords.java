package com.company.Main;

import javax.swing.plaf.nimbus.State;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SelectRecords {
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

    public String retrieveString(String selectedColumnLabel, String tableName, String conditionColumnLabel, String searchKey){
        String sql = "SELECT ? FROM ? WHERE ? = ?";
        sql = sql.replaceFirst("\\?",selectedColumnLabel);
        sql = sql.replaceFirst("\\?",tableName);
        sql = sql.replaceFirst("\\?",conditionColumnLabel);
        String result = "";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,searchKey);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                result = rs.getString(selectedColumnLabel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    public byte[] retrieveByte(String selectedColumnLabel, String tableName, String conditionColumnLabel, String searchKey){
        //SELECT hash FROM USERS where email = "email";
        String sql = "SELECT ? FROM ? WHERE ? = ?";
        sql = sql.replaceFirst("\\?",selectedColumnLabel);
        sql = sql.replaceFirst("\\?",tableName);
        sql = sql.replaceFirst("\\?",conditionColumnLabel);
        //+ selectedColumnLabel + " FROM " + tableName + " WHERE " + conditionColumnLabel + "=\""+ searchKey +"\"";
        byte[] result = new byte[16];
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,searchKey);
            ResultSet rs    = pstmt.executeQuery();
            // loop through the result set
            while (rs.next()) {
                result = rs.getBytes(selectedColumnLabel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    public int retrieveInteger(String selectedColumnLabel, String tableName, String conditionColumnLabel, String searchKey){
        String sql = "SELECT ? FROM ? WHERE ? = ?";
        sql = sql.replaceFirst("\\?",selectedColumnLabel);
        sql = sql.replaceFirst("\\?",tableName);
        sql = sql.replaceFirst("\\?",conditionColumnLabel);
        int result = -1;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,searchKey);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                result = rs.getInt(selectedColumnLabel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Restaurant retrieveRestaurant(String selectedColumnLabel, String tableName, String conditionColumnLabel, String searchKey){
        String sql = "SELECT ? FROM ? WHERE ? = ?";
        sql = sql.replaceFirst("\\?",selectedColumnLabel);
        sql = sql.replaceFirst("\\?",tableName);
        sql = sql.replaceFirst("\\?",conditionColumnLabel);
        int restaurant_id = Integer.parseInt(searchKey);
        String restaurant_name = "";
        int location_id = -1;
        String phone = "";
        int restaurant_owner_id = -1;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,searchKey);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                restaurant_name = rs.getString("restaurant_name");
                location_id = rs.getInt("location_id");
                phone = rs.getString("phone");
                restaurant_owner_id = rs.getInt("restaurant_owner_id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new Restaurant(restaurant_id,restaurant_name,location_id,phone,restaurant_owner_id);
    }
    public ArrayList<Restaurant> retrieveRestaurantListAll(){
        String sql = "SELECT * FROM RESTAURANT WHERE restaurant_owner_id in (SELECT restaurant_owner_id FROM RESTAURANT_OWNER WHERE approved = 1)";
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        int restaurant_id = -1;
        String restaurant_name = "";
        int location_id = -1;
        String phone = "";
        int restaurant_owner_id = -1;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                restaurant_id = rs.getInt("restaurant_id");
                restaurant_name = rs.getString("restaurant_name");
                location_id = rs.getInt("location_id");
                phone = rs.getString("phone");
                restaurant_owner_id = rs.getInt("restaurant_owner_id");
                Restaurant restaurant = new Restaurant(restaurant_id,restaurant_name,location_id,phone,restaurant_owner_id);
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return restaurants;
    }
    public ArrayList<Restaurant> retrieveCategorizedRestaurantList(int category_id){
        String sql = "SELECT * FROM RESTAURANT INNER JOIN RESTAURANT_CATEGORIES ON RESTAURANT.restaurant_id = RESTAURANT_CATEGORIES.restaurant_id WHERE RESTAURANT_CATEGORIES.category_id = ? AND restaurant_owner_id in (SELECT restaurant_owner_id FROM RESTAURANT_OWNER WHERE approved = 1)";
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        int restaurant_id = -1;
        String restaurant_name = "";
        int location_id = -1;
        String phone = "";
        int restaurant_owner_id = -1;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, category_id);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                restaurant_id = rs.getInt("restaurant_id");
                restaurant_name = rs.getString("restaurant_name");
                location_id = rs.getInt("location_id");
                phone = rs.getString("phone");
                restaurant_owner_id = rs.getInt("restaurant_owner_id");
                Restaurant restaurant = new Restaurant(restaurant_id,restaurant_name,location_id,phone,restaurant_owner_id);
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return restaurants;
    }
    public ArrayList<Restaurant> retrieveLocationRestaurantList(int location_id){
        String sql = "SELECT * FROM RESTAURANT WHERE location_id = ? AND restaurant_owner_id in (SELECT restaurant_owner_id FROM RESTAURANT_OWNER WHERE approved = 1)";
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        int restaurant_id = -1;
        String restaurant_name = "";
        String phone = "";
        int restaurant_owner_id = -1;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,location_id);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                restaurant_id = rs.getInt("restaurant_id");
                restaurant_name = rs.getString("restaurant_name");
                phone = rs.getString("phone");
                restaurant_owner_id = rs.getInt("restaurant_owner_id");
                Restaurant restaurant = new Restaurant(restaurant_id,restaurant_name,location_id,phone,restaurant_owner_id);
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return restaurants;
    }
    public ArrayList<Meal> retrieveMealListFromRestaurant(int searchKey){
        String sql = "SELECT * FROM MEALS WHERE restaurant_id = ?";
        ArrayList<Meal> meals = new ArrayList <Meal>();
        int meal_id = -1;
        int restaurant_id = -1;
        String meal_name = "";
        float meal_price = 0.0F;
        String meal_description = "";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,searchKey);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                meal_id = rs.getInt("meal_id");
                restaurant_id = rs.getInt("restaurant_id");
                meal_name = rs.getString("meal_name");
                meal_price = rs.getFloat("meal_price");
                meal_description = rs.getString("meal_description");
                Meal meal = new Meal(meal_id, restaurant_id, meal_name, meal_price, meal_description);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return meals;
    }

    public ArrayList<Location> retrieveLocationList(){
        String sql = "SELECT * FROM LOCATION";
        ArrayList<Location> locations = new ArrayList <Location>();
        int location_id = -1;
        String location_name = "";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                location_id = rs.getInt("location_id");
                location_name = rs.getString("location_name");
                Location location = new Location(location_id, location_name);
                locations.add(location);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return locations;
    }
    public ArrayList<Category> retrieveCategoryList(){
        String sql = "SELECT * FROM CATEGORIES";
        ArrayList<Category> categories = new ArrayList <>();
        int category_id = -1;
        String category_name = "";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                category_id = rs.getInt("category_id");
                category_name = rs.getString("category_name");
                Category category = new Category(category_id, category_name);
                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }
    public HashMap<RestaurantOwner, Restaurant> retrievePendingApprovalRestaurantOwners(){
        //String sql = "SELECT RESTAURANT_OWNER.restaurant_owner_id, RESTAURANT_OWNER.user_id, RESTAURANT_OWNER.approved, USERS.email, USERS.name FROM RESTAURANT_OWNER  INNER JOIN USERS  ON RESTAURANT_OWNER.user_id = USERS.user_id WHERE approved = 0";
        String sql = "SELECT RESTAURANT_OWNER.restaurant_owner_id, RESTAURANT_OWNER.user_id, RESTAURANT_OWNER.approved, USERS.email, USERS.name, RESTAURANT.phone, RESTAURANT.restaurant_name, RESTAURANT.location_id FROM RESTAURANT_OWNER INNER JOIN USERS ON RESTAURANT_OWNER.user_id = USERS.user_id INNER JOIN RESTAURANT ON RESTAURANT.restaurant_owner_id = RESTAURANT_OWNER.restaurant_owner_id WHERE approved = 0";
        //HASH MAP RESTAURANT OWNER AND THEIR RESTAURANT
        HashMap<RestaurantOwner, Restaurant> map = new HashMap<>();
        //RESTAURANT OWNER
        int restaurant_owner_id = -1;
        int user_id = -1;
        int approved = -1;
        String email = "";
        String name = "";
        //RESTAURANT
        String phone = "";
        String restaurant_name = "";
        int location_id = -1;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                email = rs.getString("email");
                name = rs.getString("name");
                restaurant_owner_id = rs.getInt("restaurant_owner_id");
                user_id = rs.getInt("user_id");
                approved = rs.getInt("approved");
                RestaurantOwner restaurantOwner = new RestaurantOwner(email, name, restaurant_owner_id,user_id,approved);
                restaurant_name = rs.getString("restaurant_name");
                location_id = rs.getInt("location_id");
                phone = rs.getString("phone");
                Restaurant restaurant = new Restaurant(restaurant_name, location_id, phone);
                map.put(restaurantOwner, restaurant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return map;
    }
    public ArrayList<Meal> retrieveMealList(int restaurant_id){
        String sql = "SELECT * FROM MEAL WHERE MEAL.restaurant_id = ?";
        ArrayList<Meal> meals = new ArrayList<>();
        int meal_id;
        String meal_name;
        float meal_price;
        String meal_description;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, restaurant_id);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                meal_id = rs.getInt("meal_id");
                meal_name = rs.getString("meal_name");
                meal_price = rs.getFloat("meal_price");
                meal_description = rs.getString("meal_description");
                Meal meal = new Meal(meal_id, restaurant_id, meal_name, meal_price, meal_description);
                meals.add(meal);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return meals;
    }
    public Customer retrieveCustomer(String email){
        String sql = "SELECT * FROM USERS JOIN CUSTOMERS ON USERS.user_id = CUSTOMERS.user_id WHERE email = ?";
        Customer customer = null;
        String name;
        String hash;
        int user_id;
        int customer_id;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                name = rs.getString("name");
                user_id = rs.getInt("user_id");
                customer_id = rs.getInt("customer_id");
                customer = new Customer(email, name, user_id, customer_id);
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }
    public RestaurantOwner retrieveRestaurantOwner(String email){
        String sql = "SELECT * FROM USERS JOIN RESTAURANT_OWNER ON USERS.user_id = RESTAURANT_OWNER.user_id WHERE email = ? AND RESTAURANT_OWNER.approved = 1";
        RestaurantOwner restaurantOwner = null;
        int restaurant_owner_id;
        int user_id;
        int approved;
        String name;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                email = rs.getString("email");
                name = rs.getString("name");
                user_id = rs.getInt("user_id");
                restaurant_owner_id = rs.getInt("restaurant_owner_id");
                approved = rs.getInt("restaurant_owner_id");
                restaurantOwner = new RestaurantOwner(email,name,restaurant_owner_id,user_id,approved);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return restaurantOwner;
    }
    public Admin retrieveAdmin(String email){
        String sql = "SELECT * FROM ADMINS WHERE email = ?";
        int admin_id;
        String name;
        Admin admin = null;
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                name = rs.getString("name");
                admin_id = rs.getInt("admin_id");
                admin = new Admin(admin_id,email,name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return admin;
    }











}
