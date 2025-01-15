<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Bank Management System</title>

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

.form-container label {
  display: block;
  font-size: 0.9rem;
  margin-bottom: 0.5em;
  color: #555;
}

.form-container input {
  width: 100%;
  padding: 0.7em;
  margin-bottom: 1em;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 1rem;
}

.form-container input:focus {
  border-color: #42a5f5;
  outline: none;
}

.form-container button {
  width: 100%;
  padding: 0.7em;
  background: #1e88e5;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  cursor: pointer;
  transition: background 0.3s;
}

.form-container button:hover {
  background: #0d47a1;
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
  
  <!-- <link rel="stylesheet" href="frontend\css\styles.css"> -->
</head>
<body>
  <!-- Header Section -->
  <header class="header">
    <h1>Bank Management System</h1>
    <nav class="nav">
      <a href="index.html">Dashboard</a>
      <a href="account.html">Accounts</a>
      <a href="transactions.html">Transactions</a>
    </nav>
    
  </header>

  <!-- Main Content -->
  <main class="main-content">
    <!-- Dashboard Section -->
    <section id="dashboard" class="section">
      <h2>Dashboard</h2>
      <div class="cards-container">
        <!-- Account Summary Card -->
        <div class="card">
          <h3>Account Summary</h3>
          <p>Check your account balance and details.</p>
          <button onclick="fetchAccounts()">View Accounts</button>
        </div>

        <!-- Transactions Card -->
        <div class="card">
          <h3>Recent Transactions</h3>
          <p>View and manage your recent transactions.</p>
          <button onclick="viewTransactions()">View Transactions</button>
        </div>

        <!-- Quick Actions Card -->
        <div class="card">
          <h3>Quick Actions</h3>
          <p>Transfer money, pay bills, and more.</p>
          <button onclick="">Quick Actions</button>
        </div>
      </div>
    </section>
  </main>

  <!-- Footer -->
  <!-- <footer class="footer">
     <p>&copy; 2025 Bank Management System. All rights reserved.</p> 
  </footer> -->

  <script src="script.js"></script>
</body>
</html>
