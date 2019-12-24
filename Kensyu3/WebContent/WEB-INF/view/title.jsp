<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main2.css" type="text/css" >
<title>テスト/タイトル</title>
</head>
<body>
和色占い

<form action="/Kensyu3/DoRandomServlet" method="get" >
<input type="submit" value="名前入力へ">
<input type="hidden" value="title" name="beforePage">
</form>
</body>
</html>