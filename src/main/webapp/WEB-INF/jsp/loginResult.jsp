<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Login" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Login loginUser = (Login)session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやくん</title>
</head>
<body>
	<h1>つぶやくんログイン</h1>
	<c:choose>
		<c:when test="${not empty loginUser}">
			<p>ログインに成功しました</p>
			<p>ようこそ<c:out value="${loginUser.userId}" />さん</p>
			<a href="Main">つぶやき投稿･閲覧へ</a>
		</c:when>
		<c:otherwise>
			<p>ログインに失敗しました</p>
			<a href="index.jsp">TOPへ</a>
		</c:otherwise>
	</c:choose>
</body>
</html>