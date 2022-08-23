<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	<h1>登入頁面</h1>
	<form action="checkLogin" method="post">

		<div class="container">
			<label for="uname"><b>UserName</b></label> <input type="text"
				placeholder="Enter Username" name="uname" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" required>
			<p>${errorMsgMap.LoginError }</p>
			<button type="submit">Login</button>
		</div>

	</form>
</body>
</html>