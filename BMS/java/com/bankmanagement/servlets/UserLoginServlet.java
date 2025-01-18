package com.bankmanagement.servlets;

import java.io.IOException;

import com.bankmanagement.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserLoginController")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserService();

        try {
            boolean userValid = userService.getUserDetails(username, password);
            if (userValid) {
                response.sendRedirect("userDashboard.jsp");  
            } else {
                request.setAttribute("errorMessage", "Invalid credentials");
                request.getRequestDispatcher("userLogin.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred during login");
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
        }
    }
}
