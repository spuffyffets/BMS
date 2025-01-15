package com.sit.bankmanagement.client;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminRegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Basic validation (ensure passwords match)
        if (!password.equals(confirmPassword)) {
            response.sendRedirect("register.jsp?error=Passwords do not match");
            return;
        }

        // Assume a method that checks if the admin already exists in the database
        boolean adminExists = checkIfAdminExists(username);

        if (adminExists) {
            response.sendRedirect("register.jsp?error=Admin already exists");
        } else {
            // Insert the new admin into the database
            boolean registrationSuccessful = registerAdmin(username, password);

            if (registrationSuccessful) {
                response.sendRedirect("login.jsp?message=Registration successful. Please log in.");
            } else {
                response.sendRedirect("register.jsp?error=Registration failed");
            }
        }
    }

    // Mock method to check if an admin exists (should interact with DB)
    private boolean checkIfAdminExists(String username) {
        // Database logic to check if admin exists
        return false;  // For now, assume the admin doesn't exist
    }

    // Mock method to register admin (should interact with DB)
    private boolean registerAdmin(String username, String password) {
        // Database logic to insert new admin record
        return true;  // Assume registration is successful for now
    }
}
