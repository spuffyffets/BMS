package com.sit.bankmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/BankDB";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Database connected successfully!");
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database!");
			e.printStackTrace();
		}
		return connection;
	}
}
