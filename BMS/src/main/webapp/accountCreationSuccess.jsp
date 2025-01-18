<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #e3f2fd, #81d4fa);
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
            color: #0277bd;
        }
        .message-box {
            background: #ffffff;
            padding: 2em;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 50%;
        }
        h1 {
            color: #0288d1;
        }
        p {
            font-size: 1.2em;
            margin: 1em 0;
        }
        a {
            text-decoration: none;
            color: white;
            background-color: #0288d1;
            padding: 0.8em 1.5em;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #01579b;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="message-box">
            <h1>Account Create Successful!</h1>
            <!-- p>Thank you for registering. Your account has been successfully created.</p>
            <p>You can now log in to access your account.</p> -->
            <a href="adminDashboard.jsp">Go to Dashborad</a>
        </div>
    </div>
</body>
</html>
