package com.bankmanagement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public List<String[]> getAllTransactions() throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String sql = "SELECT transaction_id, account_number, transaction_type, amount, transaction_date FROM transactions";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<String[]> transactions = new ArrayList<>();
        while (resultSet.next()) {
            String[] transaction = new String[5];
            transaction[0] = resultSet.getString("transaction_id");
            transaction[1] = resultSet.getString("account_number");
            transaction[2] = resultSet.getString("transaction_type");
            transaction[3] = resultSet.getString("amount");
            transaction[4] = resultSet.getString("transaction_date");
            transactions.add(transaction);
        }

        connection.close();
        return transactions;
    }
}
