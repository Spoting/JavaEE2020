<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <title>THELEI TO PAIDI SITISI</title>
        <link rel="stylesheet" type="text/css" href="CSS/login.css">
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="login">
  <h1>Login to Web App</h1>
  <form method="post" action="">
    <p><input type="text" name="login" value="" placeholder="Email:"></p>
    <p><input type="password" name="password" value="" placeholder="Password:"></p>
    <p class="remember_me">
      <label>
        <input type="checkbox" name="remember_me" id="remember_me">
        Remember me on this computer
      </label>
    </p>
    <p class="submit"><input type="submit" name="commit" value="Login"></p>
  </form>
</div>

<div class="login-help">
  <p>Forgot your password? <a href="#">Click here to reset it</a>.</p>
</div>
</body>
</html>