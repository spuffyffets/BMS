
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bank Management System</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background: linear-gradient(to right, #c1e1fc, #b2dffc);
}

.container {
	display: flex;
	align-items: center;
	justify-content: space-between;
	max-width: 1200px;
	background-color: #ffffff;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	overflow: hidden;
}

.illustration {
	flex: 1;
	padding: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	background: #f0f8ff;
}

.illustration img {
	max-width: 100%;
	height: auto;
}

.content {
	flex: 1;
	padding: 40px;
	text-align: center;
	color: #333333;
}

.content h1 {
	font-size: 2rem;
	margin-bottom: 20px;
	color: #4b4ca5;
}

.content p {
	margin-bottom: 20px;
	font-size: 1rem;
	line-height: 1.5;
	color: #555555;
}

.buttons {
	display: flex;
	flex-direction: column;
	align-items: center;
	gap: 10px;
}

.buttons a {
	text-decoration: none;
	padding: 10px 20px;
	border-radius: 5px;
	font-size: 1rem;
	font-weight: bold;
	transition: 0.3s;
}

.buttons a.login {
	background: linear-gradient(to right, #4ca1af, #c4e0e5);
	color: #ffffff;
}

.buttons a.guest {
	border: 2px solid #4ca1af;
	color: #4ca1af;
	background: transparent;
}

.buttons a:hover {
	transform: translateY(-3px);
	opacity: 0.8;
}

.signup {
	margin-top: 20px;
}

.signup a {
	color: #4b4ca5;
	text-decoration: none;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="container">
		<div class="illustration">
			<img src="bank-illustration.png" alt="Bank Illustration">
		</div>
		<div class="content">
			<h1>Welcome to Bank Management System</h1>
			<p>Streamline banking operations, manage customer accounts,
				perform secure transactions, and track financial data seamlessly.</p>
			<div class="buttons">
				<a href="2main.jsp" class="login">LOGIN</a> <a href="#"
					class="guest">LOGIN AS GUEST</a>
			</div>
			<div class="signup">
				<p>
					Don't have an account? <a href="adminRegister.jsp">Sign up</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>