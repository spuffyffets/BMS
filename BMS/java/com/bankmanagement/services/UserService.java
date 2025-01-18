package com.bankmanagement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

//    public void createUserAccount(String name, String email, String mobile, String address, String adhar, String pan,
//                                  String accountType) throws Exception {
//        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//
//        String sql = "INSERT INTO users (name, email, mobile, address, adhar, pan, account_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, name);
//        preparedStatement.setString(2, email);
//        preparedStatement.setString(3, mobile);
//        preparedStatement.setString(4, address);
//        preparedStatement.setString(5, adhar);
//        preparedStatement.setString(6, pan);
//        preparedStatement.setString(7, accountType);
//
//        preparedStatement.executeUpdate();
//        connection.close();
//    }
    
    
    
    
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

    public List<String[]> getAllAccounts() throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String sql = "SELECT id, name, email, mobile, account_type FROM users";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<String[]> accounts = new ArrayList<>();
        while (resultSet.next()) {
            String[] account = new String[5];
            account[0] = resultSet.getString("id");
            account[1] = resultSet.getString("name");
            account[2] = resultSet.getString("email");
            account[3] = resultSet.getString("mobile");
            account[4] = resultSet.getString("account_type");
            accounts.add(account);
        }

        connection.close();
        return accounts;
    }


 
    public String[] getUserById(int id) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String sql = "SELECT name, email, mobile, address, adhar, pan, account_type FROM users WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        String[] user = null;
        if (resultSet.next()) {
            user = new String[7];
            user[0] = resultSet.getString("name");
            user[1] = resultSet.getString("email");
            user[2] = resultSet.getString("mobile");
            user[3] = resultSet.getString("address");
            user[4] = resultSet.getString("adhar");
            user[5] = resultSet.getString("pan");
            user[6] = resultSet.getString("account_type");
        }

        connection.close();
        return user;
    }
}
