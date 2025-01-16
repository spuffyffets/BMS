package com.bankmanagement.servlets;

import java.io.IOException;
import com.bankmanagement.services.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminRegisterController")
public class AdminRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        AdminService adminService = new AdminService();

        try {
            adminService.registerAdmin(username, password, confirmPassword);
            response.sendRedirect("registrationSuccess.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("registrationError.jsp").forward(request, response);
        }
    }
}
