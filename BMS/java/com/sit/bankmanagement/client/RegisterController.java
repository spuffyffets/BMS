//package com.sit.bankmanagement.client;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class RegisterController extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        
//        if (username != null && password != null) {
//            // Add registration logic here (e.g., save to database)
//            response.sendRedirect("login.jsp");  // Redirect to login page after successful registration
//        }
//    }
//}
