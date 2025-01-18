package com.bankmanagement.util;

//import java.sql.Connection;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.Statement;
//import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/"; 
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    private static final String CREATE_DB_QUERY = "CREATE DATABASE IF NOT EXISTS BankManagementSystem";
    private static final String USE_DB_QUERY = "USE BankManagementSystem";
    
    
    private static final String CREATE_ADMIN_TABLE = "CREATE TABLE IF NOT EXISTS admins ("
            + "id INT AUTO_INCREMENT PRIMARY KEY, "
            + "name VARCHAR(100), "
            + "email VARCHAR(100) UNIQUE, "
            + "password VARCHAR(100))";

    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS Users ("
            + "id INT AUTO_INCREMENT PRIMARY KEY, "
            + "name VARCHAR(100), "
            + "email VARCHAR(100), "
            + "password VARCHAR(100), "
            + "balance DOUBLE DEFAULT 0.0)";
    
    
    
    
    private static final String CREATE_TRANSACTION_TABLE = "CREATE TABLE IF NOT EXISTS Transactions ("
            + "id INT AUTO_INCREMENT PRIMARY KEY, "
            + "userId INT, "
            + "type VARCHAR(20), "
            + "amount DOUBLE, "
            + "date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
            + "FOREIGN KEY(userId) REFERENCES Users(id))";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new SQLException("Error connecting to the database", e);
        }
    }

    public static void createDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(CREATE_DB_QUERY);
            stmt.executeUpdate(USE_DB_QUERY);
            stmt.executeUpdate(CREATE_ADMIN_TABLE);

            stmt.executeUpdate(CREATE_USER_TABLE);
            stmt.executeUpdate(CREATE_TRANSACTION_TABLE);
            System.out.println("Database and tables created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
