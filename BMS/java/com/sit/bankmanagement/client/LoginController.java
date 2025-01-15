//package com.sit.bankmanagement.client;
//
//import java.io.IOException;
//
//import com.sit.bankmanagement.util.DatabaseUtil;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet("/LoginController")
//public class LoginController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        boolean isValidUser = DatabaseUtil.validateUser(username, password);  
//
//        if (isValidUser) {
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            response.sendRedirect("dashboard.jsp"); 
//        } else {
//            request.setAttribute("errorMessage", "Invalid login credentials");
//            request.getRequestDispatcher("login.jsp").forward(request, response);  
//        }
//    }
//}
