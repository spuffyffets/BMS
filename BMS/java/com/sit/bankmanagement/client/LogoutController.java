//package com.sit.bankmanagement.client;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//public class LogoutController extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Invalidate the session to log the user out
//        HttpSession session = request.getSession();
//        session.invalidate();
//
//        // Redirect to login page
//        response.sendRedirect("login.jsp");
//    }
//}
