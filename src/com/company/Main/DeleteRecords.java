package com.company.Main;

import java.sql.*;

public class DeleteRecords {
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
    public void deleteMeal(int meal_id){
        String sql = "DELETE FROM MEAL WHERE meal_id = ?";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, meal_id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
