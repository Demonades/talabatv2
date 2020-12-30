package com.company.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class UpdateRecords {

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

    public void updateMeal(String meal_name, float meal_price, String meal_description, int meal_id) {
        //UPDATE table_name
        //SET column1 = value1, column2 = value2, ...
        //WHERE condition;
        String sql = "UPDATE MEAL SET meal_name = ?, meal_price = ?, meal_description = ? WHERE meal_id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, meal_name);
            pstmt.setFloat(2, meal_price);
            pstmt.setString(3, meal_description);
            pstmt.setInt(4, meal_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAdmin(int approved, int restaurant_owner_id) {
        //UPDATE table_name
        //SET column1 = value1, column2 = value2, ...
        //WHERE condition;
        String sql = "UPDATE RESTAURANT_OWNER SET approved = ? WHERE restaurant_owner_id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, approved);
            pstmt.setInt(2, restaurant_owner_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}