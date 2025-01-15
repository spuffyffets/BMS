<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Dashboard - Bank Management System</title>

  <style>
    body {
      font-family: 'Arial', sans-serif;
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      background: linear-gradient(135deg, #e3f2fd, #90caf9);
      color: #333;
    }

    h1, h2, h3 {
      margin: 0;
      padding: 0.5em 0;
      text-align: center;
    }

    .header {
      background: #1e88e5;
      color: white;
      padding: 1em 2em;
      display: flex;
      justify-content: space-between;
      align-items: center;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    .header h1 {
      font-size: 1.8rem;
    }

    .nav {
      display: flex;
      gap: 1.5em;
    }

    .nav a {
      text-decoration: none;
      color: white;
      font-size: 1rem;
      transition: color 0.3s;
    }

    .nav a:hover {
      color: #ffc107;
    }

    .main-content {
      padding: 2em;
    }

    .section {
      margin: 2em auto;
      padding: 2em;
      background: white;
      border-radius: 8px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    .cards-container {
      display: flex;
      gap: 2em;
      justify-content: center;
      flex-wrap: wrap;
    }

    .card {
      background: #ffffff;
      border: 1px solid #eeeeee;
      border-radius: 8px;
      width: 300px;
      padding: 1.5em;
      text-align: center;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      transition: transform 0.3s, box-shadow 0.3s;
    }

    .card h3 {
      font-size: 1.3rem;
      margin-bottom: 0.5em;
    }

    .card p {
      color: #757575;
      margin-bottom: 1em;
    }

    .card button {
      padding: 0.5em 1.5em;
      background: #42a5f5;
      color: white;
      border: none;
      border-radius: 4px;
      font-size: 1rem;
      cursor: pointer;
      transition: background 0.3s;
    }

    .card button:hover {
      background: #1e88e5;
    }

    .card:hover {
      transform: translateY(-10px);
      box-shadow: 0 6px 8px rgba(0, 0, 0, 0.15);
    }

    .form-container {
      margin: 2em auto;
      padding: 2em;
      background: white;
      max-width: 400px;
      border-radius: 8px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    .form-container h2 {
      margin-bottom: 1em;
      text-align: center;
      color: #1e88e5;
    }

    .footer {
      background: #1e88e5;
      color: white;
      text-align: center;
      padding: 1em 0;
      position: fixed;
      bottom: 0;
      width: 100%;
    }
  </style>
</head>
<body>
  <!-- Header Section -->
  <header class="header">
    <h1>Admin Dashboard - Bank Management System</h1>
    <nav class="nav">
      <a href="adminDashboard.jsp">Dashboard</a>
      <a href="adminAccounts.jsp">Accounts</a>
      <a href="adminTransactions.jsp">Transactions</a>
      <a href="logout.jsp">Logout</a>
    </nav>
  </header>

  <!-- Main Content -->
  <main class="main-content">
    <!-- Dashboard Section -->
    <section id="dashboard" class="section">
      <h2>Admin Dashboard</h2>
      <div class="cards-container">
        <!-- All Accounts Card -->
        <div class="card">
          <h3>All Accounts</h3>
          <p>View all account details and balances.</p>
          <button onclick="viewAllAccounts()">View All Accounts</button>
        </div>

        <!-- All Transactions Card -->
        <div class="card">
          <h3>All Transactions</h3>
          <p>View all transactions with time and details.</p>
          <button onclick="viewAllTransactions()">View All Transactions</button>
        </div>

        <!-- Search Account Card -->
        <div class="card">
          <h3>Search Account</h3>
          <p>Find a specific account by account number.</p>
          <button onclick="searchAccount()">Search Account</button>
        </div>
      </div>
    </section>
  </main>

  <script>
    // JavaScript functions for handling actions
    function viewAllAccounts() {
      window.location.href = 'adminAccounts.jsp';  // Navigate to Accounts page
    }

    function viewAllTransactions() {
      window.location.href = 'adminTransactions.jsp';  // Navigate to Transactions page
    }

    function searchAccount() {
      // Trigger search functionality (open modal or navigate)
      window.location.href = 'searchAccount.jsp';  // Navigate to search page
    }
  </script>
</body>
</html>
