<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Accounts - Bank Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e3f2fd;
            margin: 0;
            padding: 0;
        }
        .table-container {
            width: 90%;
            margin: 2em auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 2em 0;
            background: white;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        th, td {
            text-align: left;
            padding: 1em;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #1e88e5;
            color: white;
        }
    </style>
</head>
<body> 
    <div class="table-container">
        <h2>All Accounts</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Account Type</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    
                    ArrayList<String[]> accounts = (ArrayList<String[]>) request.getAttribute("accounts");
                    
                    
                    System.out.println("Accounts size in JSP: " + (accounts != null ? accounts.size() : "No accounts"));
                    
                    if (accounts != null && !accounts.isEmpty()) {
                        
                        for (String[] account : accounts) {
                %>
                            <tr>
                                <td><%= account[0] %></td>
                                <td><%= account[1] %></td>
                                <td><%= account[2] %></td>
                                <td><%= account[3] %></td>
                                <td><%= account[4] %></td>
                            </tr>
                <% 
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="5">No accounts found.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
