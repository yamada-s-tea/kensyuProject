<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<title>ページ埋め込みテスト</title>
</head>
<body>
<%@ include file="RegistInfo.jsp" %>
<%@ include file="title.jsp" %>

<br>
<form action="/Kensyu3/Kensyu3Servlet" method="post">
<input type="submit" value="遊ぶ">
<input type="hidden" value="includeTest" name="beforePage">
</form>
<br>
<!-- <form action="/Kensyu3/Kensyu4Servlet" method="post">
<input type="submit" value="学習用ページ">
<input type="hidden" value="includeTest" name="beforePage">
</form> -->
</body>
</html>