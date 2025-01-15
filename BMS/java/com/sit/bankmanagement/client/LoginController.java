package com.sit.bankmanagement.client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "root");

            if ("admin".equals(role)) {
                String query = "SELECT * FROM users WHERE username = ? AND role = 'admin'";
                stmt = connection.prepareStatement(query);
                stmt.setString(1, username);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    if (rs.getString("password").equals(password)) {
                        response.sendRedirect("adminDashboard.jsp");
                    } else {
                        response.sendRedirect("error.jsp");
                    }
                } else {
                    request.setAttribute("message", "Admin not found. Please register first.");
                    request.getRequestDispatcher("error.jsp").forward(request, response);  // Forward to error.jsp with a message
                }
            }
            else if ("user".equals(role)) {
                String query = "SELECT * FROM users WHERE username = ? AND role = 'user'";
                stmt = connection.prepareStatement(query);
                stmt.setString(1, username);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    
                    if (rs.getString("password").equals(password)) {
                        
                        response.sendRedirect("userDashboard.jsp");
                    } else {
                       
                        response.sendRedirect("error.jsp");
                    }
                } else {
                    
                    request.setAttribute("message", "User not found. Please register first.");
                    request.getRequestDispatcher("error.jsp").forward(request, response);  
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
