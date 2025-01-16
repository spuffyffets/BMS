package com.bankmanagement.services;

import com.bankmanagement.models.User;
import com.bankmanagement.util.DatabaseUtil;
import java.sql.*;

public class UserService {

    public User getUserDetails(String username, String password) {
        User user = null;

        try (Connection connection = DatabaseUtil.getConnection()) { 
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int accountId = resultSet.getInt("accountId");
                    String dbUsername = resultSet.getString("username");
                    String dbPassword = resultSet.getString("password");
                    double balance = resultSet.getDouble("balance");
                    String accountType = resultSet.getString("accountType");
                    Timestamp createdAt = resultSet.getTimestamp("createdAt");

                    user = new User(accountId, dbUsername, dbPassword, balance, accountType, createdAt);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return user;  
    }
}
