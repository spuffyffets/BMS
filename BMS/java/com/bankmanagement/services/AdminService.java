package com.bankmanagement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminService {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdb";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public void registerAdmin(String username, String password, String confirmPassword) throws Exception {
		if (!password.equals(confirmPassword)) {
			throw new Exception("Password and Confirm Password do not match.");
		}

		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		String sql = "INSERT INTO admins (username, password) VALUES (?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		preparedStatement.executeUpdate();

		connection.close();
	}

	public boolean loginAdmin(String username, String password) throws Exception {
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		String sql = "SELECT password FROM admins WHERE username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, username);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			String storedPassword = resultSet.getString("password");
			connection.close();
			return storedPassword.equals(password);
		}

		connection.close();
		return false;
	}
     //Admmin ==> User Services 
	public void createUserAccount(String name, String email, String mobile, String address, String adhar, String pan,
			String accountType) throws Exception {
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		String sql = "INSERT INTO users (name, email, mobile, address, adhar, pan, account_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, mobile);
		preparedStatement.setString(4, address);
		preparedStatement.setString(5, adhar);
		preparedStatement.setString(6, pan);
		preparedStatement.setString(7, accountType);

		preparedStatement.executeUpdate();
		connection.close();
	}
	
	
	 //Admmin ==> User Services
    public boolean getUserDetails(String email, String mobile) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String sql = "SELECT * FROM users WHERE email = ? AND mobile = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, mobile);

        ResultSet resultSet = preparedStatement.executeQuery();
        boolean userExists = resultSet.next();
        connection.close();
        return userExists;
    }


}
