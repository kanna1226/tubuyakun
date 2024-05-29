<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやくん</title>
</head>
<body>
	<h1>ユーザー登録</h1>
	<p>下記のユーザーを登録します</p>
	<table border="1">
	<tr>
		<th>ユーザーID</th>
		<th>メールアドレス</th>
		<th>名前</th>
	</tr>
	<tr>
	<th><c:out value="${registerAccount.userId}" /></th>
	<th><c:out value="${registerAccount.mail}" /></th>
	<th><c:out value="${registerAccount.name}" /></th>
	</tr>
	</table>
	
	<a href="RegisterAccount">戻る</a>
	<a href="RegisterAccount?action=done">登録</a>
</body>
</html>