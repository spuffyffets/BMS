<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Bank Management System</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
    <header>
        <div class="header-content">
            <h1>Welcome, ${username}</h1>
            <a href="logout" class="btn">Logout</a>
        </div>
    </header>
    <main>
        <section class="dashboard">
            <h2>Your Dashboard</h2>
            <ul>
                <li><a href="account-details.jsp">View Account Details</a></li>
                <li><a href="transfer.jsp">Transfer Funds</a></li>
                <li><a href="transaction-history.jsp">Transaction History</a></li>
            </ul>
        </section>
    </main>
</body>
</html>
