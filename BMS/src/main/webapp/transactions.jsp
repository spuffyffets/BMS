<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Transactions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #e3f2fd, #90caf9);
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #1e88e5;
            color: white;
            padding: 1em;
            text-align: center;
        }
        .header a {
            color: white;
            text-decoration: none;
            margin: 0 1em;
        }
        .header a:hover {
            color: #ffc107;
        }
        .container {
            padding: 2em;
        }
        .transactions-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 1em;
        }
        .transactions-table th,
        .transactions-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        .transactions-table th {
            background-color: #0288d1;
            color: white;
        }
        .transactions-table tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .transactions-table tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <header class="header">
        <h1>All Transactions</h1>
        <nav>
            <a href="adminDashboard.jsp">Dashboard</a>
            <a href="logout.jsp">Logout</a>
        </nav>
    </header>

    <div class="container">
        <h2>Transaction Details</h2>
        <table class="transactions-table">
            <thead>
                <tr>
                    <th>Transaction ID</th>
                    <th>Account Number</th>
                    <th>Transaction Type</th>
                    <th>Amount</th>
                    <th>Date & Time</th>
                </tr>
            </thead>
            <tbody>
                <!-- Directly insert transaction data into the table -->
                <%= request.getAttribute("transactionData") %>
            </tbody>
        </table>
    </div>
</body>
</html>
