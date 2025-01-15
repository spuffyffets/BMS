<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Accounts - Bank Management System</title>
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
  <header class="header">
    <h1>Bank Management System</h1>
    <nav class="nav">
      <a href="userDashboard.jsp">Dashboard</a>
      <a href="accounts.html">Accounts</a>
      <a href="transactions.html">Transactions</a>
    </nav>
  </header>

  <main class="main-content">
    <section class="section">
      <h2>Your Accounts</h2>
      <p>Below is the list of your accounts:</p>
      <table id="account-table" class="styled-table">
        <thead>
          <tr>
            <th>Account ID</th>
            <th>Account Type</th>
            <th>Balance</th>
          </tr>
        </thead>
        <tbody>
          <!-- Dynamic content will be loaded here -->
        </tbody>
      </table>
    </section>
  </main>

  <footer class="footer">
    <p>&copy; 2025 Bank Management System. All rights reserved.</p>
  </footer>

  <script src="frontend/api/account.js"></script>
</body>
</html>
