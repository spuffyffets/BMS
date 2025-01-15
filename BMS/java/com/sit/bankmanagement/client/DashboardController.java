//package com.sit.bankmanagement.client;
//
//import java.io.IOException;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//public class DashboardController extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Check if user is logged in by checking session
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("username") == null) {
//            // If no session or username attribute is present, redirect to login page
//            response.sendRedirect("login.jsp");
//        } else {
//            // If logged in, show the dashboard
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
//            dispatcher.forward(request, response);
//        }
//    }
//}
