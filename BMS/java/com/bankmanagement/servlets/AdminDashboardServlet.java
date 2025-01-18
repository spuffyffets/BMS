package com.bankmanagement.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDashboardServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT id, name, email, mobile, account_type FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<String[]> accounts = new ArrayList<>();

            while (resultSet.next()) {
                String[] account = new String[5];
                account[0] = String.valueOf(resultSet.getInt("id"));
                account[1] = resultSet.getString("name");
                account[2] = resultSet.getString("email");
                account[3] = resultSet.getString("mobile");
                account[4] = resultSet.getString("account_type");
                accounts.add(account);
            }

            connection.close();
            System.out.println("Fetched Accounts: " + accounts.size());

            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("/AllAccount.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Unable to fetch accounts. Please try again later.");
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    }
}
