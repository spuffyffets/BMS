package com.bankmanagement.servlets;

import java.io.IOException;
import com.bankmanagement.models.User;
import com.bankmanagement.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        User user = userService.getUserDetails(email, password);

        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("userDashboard.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
