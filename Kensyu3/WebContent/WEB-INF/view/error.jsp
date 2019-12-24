<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="beans.Result" %>
<% Result result = (Result)session.getAttribute("result"); %>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/error.css" type="text/css" >
<title>テスト／エラー</title>
</head>

<body>
<%= result.getResultMessage() %>
<br>
<form action="/Kensyu3/DoRandomServlet" method="get" >
<input type="submit" value="タイトル">
<input type="hidden" value="result" name="beforePage">
</form>
</body>
</html>