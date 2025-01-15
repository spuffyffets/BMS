 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Panel</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .panel {
            background: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #0074d9;
        }
        .button-container {
            margin-top: 1.5rem;
        }
        .button-container a {
            text-decoration: none;
            margin: 0 10px;
            padding: 0.75rem 1.5rem;
            background-color: #0074d9;
            color: white;
            border-radius: 4px;
            font-size: 1rem;
        }
        .button-container a:hover {
            background-color: #005bb5;
        }
    </style>
</head>
<body>
    <div class="panel">
        <h1>Bank Management System</h1>
        <p>Please choose your login type:</p>
        <div class="button-container">
            <a href="adminLogin.jsp">Admin Login</a>
            <a href="userLogin.jsp">User Login</a>
        </div>
    </div>
</body>
</html>
	 
	 
	 