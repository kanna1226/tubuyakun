<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやくん</title>
</head>
<body>
	<h1>つぶやくんへようこそ</h1>
	<form action="LoginServlet" method="post">
	<p>ユーザー名:<input type="text" name="name"></p>
	<p>パスワード:<input type="password" name="pass"></p>
	<input type="submit" value="ログイン">
	</form>
	<form action="RegisterAccount" method="get">
        <input type="submit" value="ユーザー登録">
    </form>
</body>
</html>