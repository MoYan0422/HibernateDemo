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
			<h1>登入成功</h1>
			<h2>
				歡迎!<span>${loginMember.memberName}</span>登入
			</h2>



		</div>

	</form>
</body>
</html>