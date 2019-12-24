<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ page import="beans.Name" %>
<% Name result = (Name)session.getAttribute("name"); %>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main2.css" type="text/css" >
<title>テスト/名前入力</title>
</head>
<body>

<form action="/Kensyu3/DoRandomServlet" method="post" >
名前：<input type="text" name="name"><br>
<input type="submit" value="占ってみる">
<input type="hidden" value="inputName" name="beforePage">
</form>

</body>
</html>