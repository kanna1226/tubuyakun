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
	<h1>どこつぶメイン</h1>
	<p>
	<c:out value="${loginUser.userId}"></c:out>さん、ログイン中
	<a href="Logout">ログアウト</a>
	</p>
	<p><a href="Main">更新</a></p>
	<form action="Main" method="post">
	<input type="text" name="text">
	<input type="submit" value="つぶやく">
	</form>
	<c:if test="${not empty errorMsg}">
		<p><c:out value="${errorMsg}" /></p>
	</c:if>
	<c:forEach var="mutter" items="${mutterList}">
		<p><c:out value="${mutter.userId}" />:
			<c:out value="${mutter.text}" /> - 
			<c:out value="${mutter.date}" /></p>
	</c:forEach>
</body>
</html>