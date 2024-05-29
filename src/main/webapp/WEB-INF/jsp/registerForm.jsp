<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやくん</title>
</head>
<body>
	<h1>ユーザー登録</h1>
	<form action="RegisterAccount" method="post">
		<p>ログインID:<input type="text" name="userId"></p>
		<p>パスワード:<input type="password" name="pass"></p>
		<p>メールアドレス:<input type="text" name="mail"></p>
		<p>名前:<input type="text" name="name"></p>
		<input type="submit" value="登録">
	</form>
</body>
</html>