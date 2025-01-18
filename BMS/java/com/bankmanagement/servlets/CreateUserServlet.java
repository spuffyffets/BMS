package com.bankmanagement.servlets;

import java.io.IOException;

import com.bankmanagement.services.AdminService;
import com.bankmanagement.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CreateUserController")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String adhar = request.getParameter("adhar");
        String pan = request.getParameter("pan");
        String accountType = request.getParameter("accountType");

//        UserService userService = new UserService();
       AdminService adminService  = new AdminService();

        try {
        	adminService.createUserAccount(name, email, mobile, address, adhar, pan, accountType);
            
            response.sendRedirect("accountCreationSuccess.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("accountCreationError.jsp").forward(request, response);
        }
    }
}
