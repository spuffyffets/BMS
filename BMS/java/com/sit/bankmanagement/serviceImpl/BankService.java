package com.sit.bankmanagement.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BankService {
    protected void logTransaction(Connection connection, long accNo, String description) throws SQLException {
        String query = "INSERT INTO Transactions (account_number, description, transaction_time) VALUES (?, ?, NOW())";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, accNo);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();
        }
    }

    // Define isAccountValid as an abstract method to be implemented by subclasses
    public abstract boolean isAccountValid(long accNo, int pin);
}
	
//protected void logTransaction1(Connection connection, long accNo, String description) throws SQLException {
//    String query = "INSERT INTO Transactions (account_number, description, transaction_time) VALUES (?, ?, NOW())";
//    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//        preparedStatement.setLong(1, accNo);
//        preparedStatement.setString(2, description);
//        preparedStatement.executeUpdate();
//    }
//}
//}
//
