//package com.bankmanagement.servlets;
//
//import com.bankmanagement.services.TransactionService;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.List;
//
//public class TransactionServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        TransactionService transactionService = new TransactionService();
//
//        try {
//            List<String[]> transactions = transactionService.getAllTransactions();
//            request.setAttribute("transactions", transactions);
//
//            request.getRequestDispatcher("/transactions.jsp").forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            request.setAttribute("errorMessage", "Unable to fetch transactions.");
//            request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
//        }
//    }
//}

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

public class TransactionServlet extends HttpServlet {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bankdb";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "SELECT transaction_id, account_number, transaction_type, amount, transaction_date FROM transactions";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			StringBuilder transactionData = new StringBuilder();

			while (resultSet.next()) {
				transactionData.append("<tr>");
				transactionData.append("<td>").append(resultSet.getString("transaction_id")).append("</td>");
				transactionData.append("<td>").append(resultSet.getString("account_number")).append("</td>");
				transactionData.append("<td>").append(resultSet.getString("transaction_type")).append("</td>");
				transactionData.append("<td>").append(resultSet.getString("amount")).append("</td>");
				transactionData.append("<td>").append(resultSet.getString("transaction_date")).append("</td>");
				transactionData.append("</tr>");
			}

			if (transactionData.length() == 0) {
				transactionData.append("<tr><td colspan='5'>No transactions found.</td></tr>");
			}

			request.setAttribute("transactionData", transactionData.toString());

			request.getRequestDispatcher("/transactions.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Unable to fetch transactions.");
			request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
		}
	}
}
