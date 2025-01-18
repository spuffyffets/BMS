<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Create User Account - Bank Management System</title>
  <link rel="stylesheet" href="assets/css/createaccount.css">
</head>
<body>
  <header class="header">
    <h1>Bank Management System</h1>
    <nav class="nav">
      <a href="adminDashboard.jsp">Dashboard</a>
     <!--  <a href="userDashboard.jsp">User Dashboard</a> -->
      <a href="usertransactions.html">Transactions</a>
    </nav>
  </header>

  <main class="main-content">
    <section class="section">
      <h2>Create New User Account</h2>
      <form action="CreateUserController" method="post" id="create-user-form">
        <div class="form-group">
          <label for="name">Name:</label>
          <input type="text" id="name" name="name" required>
        </div>

        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" id="email" name="email" required>
        </div>

        <div class="form-group">
          <label for="mobile">Mobile No:</label>
          <input type="text" id="mobile" name="mobile" required>
        </div>

        <div class="form-group">
          <label for="address">Address:</label>
          <input type="text" id="address" name="address" required>
        </div>

        <div class="form-group">
          <label for="adhar">Aadhaar No:</label>
          <input type="text" id="adhar" name="adhar" required>
        </div>

        <div class="form-group">
          <label for="pan">PAN No:</label>
          <input type="text" id="pan" name="pan" required>
        </div>

        <div class="form-group">
          <label for="accountType">Account Type:</label>
          <select id="accountType" name="accountType" required>
            <option value="savings">Savings</option>
            <option value="current">Current</option>
          </select>
        </div>

        <button type="submit" class="btn">Create Account</button>
      </form>
    </section>
  </main>

  <footer class="footer">
    <p>&copy; 2025 Bank Management System. All rights reserved.</p>
  </footer>

  <script src="#"></script>
</body>
</html>
