package com.sit.bankmanagement.util;

import java.sql.*;

public class DatabaseUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/BankDB";
        String user = "root";
        String password = "root"; 
        return DriverManager.getConnection(url, user, password);
    }

	public static boolean validateUser(String username, String password) {
		return false;
	}
}
