<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login </title>
  <style>
    :root {
      --primary-color: #0074d9;
      --primary-dark: #005bb5;
      --background-color: #f4f4f9;
      --card-bg-color: white;
      --text-color: #333;
      --input-bg: #fff;
      --input-border: #ddd;
      --button-bg: var(--primary-color);
      --button-hover-bg: var(--primary-dark);
      --link-color: var(--primary-color);
      --link-hover-color: var(--primary-dark);
    }

    body {
      font-family: 'Arial', sans-serif;
      background-color: var(--background-color);
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      color: var(--text-color);
    }

    .form-container {
      background: var(--card-bg-color);
      padding: 2rem;
      border-radius: 8px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 400px;
      text-align: center;
    }

    h2 {
      margin-bottom: 1rem;
      color: var(--primary-color);
    }

    label {
      display: block;
      text-align: left;
      margin-top: 1rem;
      font-weight: bold;
    }

    input {
      width: 100%;
      padding: 0.5rem;
      margin-top: 0.5rem;
      border: 1px solid var(--input-border);
      border-radius: 4px;
      background-color: var(--input-bg);
    }

    button {
      margin-top: 1.5rem;
      width: 100%;
      padding: 0.75rem;
      background-color: var(--button-bg);
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 1rem;
    }

    button:hover {
      background-color: var(--button-hover-bg);
    }

    p {
      margin-top: 1rem;
    }

    a {
      color: var(--link-color);
      text-decoration: none;
    }

    a:hover {
      color: var(--link-hover-color);
      text-decoration: underline;
    }

    .theme-toggle {
      position: absolute;
      top: 1rem;
      right: 1rem;
      background-color: var(--primary-color);
      color: white;
      border: none;
      padding: 0.5rem;
      border-radius: 4px;
      cursor: pointer;
    }

    .theme-toggle:hover {
      background-color: var(--primary-dark);
    }
  </style>
</head>
<body>
  <!-- <button class="theme-toggle" id="themeToggle">Toggle Theme</button> -->
  <div class="form-container">
    <h2>Login</h2>
    <form id="loginForm">
      <label for="username">Username</label>
      <input type="text" id="username" name="username" placeholder="Enter your username" required>

      <label for="password">Password</label>
      <input type="password" id="password" name="password" placeholder="Enter your password" required>

      <button type="submit">Login</button>
      <p>Don't have an account? <a href="register.html">Register here</a></p>
    </form>
  </div>

  <script>
    const themeToggleBtn = document.getElementById('themeToggle');
    let darkMode = false;

    themeToggleBtn.addEventListener('click', () => {
      darkMode = !darkMode;
      if (darkMode) {
        document.documentElement.style.setProperty('--primary-color', '#333');
        document.documentElement.style.setProperty('--primary-dark', '#000');
        document.documentElement.style.setProperty('--background-color', '#333');
        document.documentElement.style.setProperty('--card-bg-color', '#444');
        document.documentElement.style.setProperty('--text-color', '#f4f4f9');
        document.documentElement.style.setProperty('--input-bg', '#555');
        document.documentElement.style.setProperty('--input-border', '#666');
        document.documentElement.style.setProperty('--button-bg', '#555');
        document.documentElement.style.setProperty('--button-hover-bg', '#444');
        document.documentElement.style.setProperty('--link-color', '#aaa');
        document.documentElement.style.setProperty('--link-hover-color', '#fff');
      } else {
        document.documentElement.style.setProperty('--primary-color', '#0074d9');
        document.documentElement.style.setProperty('--primary-dark', '#005bb5');
        document.documentElement.style.setProperty('--background-color', '#f4f4f9');
        document.documentElement.style.setProperty('--card-bg-color', 'white');
        document.documentElement.style.setProperty('--text-color', '#333');
        document.documentElement.style.setProperty('--input-bg', '#fff');
        document.documentElement.style.setProperty('--input-border', '#ddd');
        document.documentElement.style.setProperty('--button-bg', '#0074d9');
        document.documentElement.style.setProperty('--button-hover-bg', '#005bb5');
        document.documentElement.style.setProperty('--link-color', '#0074d9');
        document.documentElement.style.setProperty('--link-hover-color', '#005bb5');
      }
    });
  </script>

  <script src="script.js"></script>
</body>
</html>
