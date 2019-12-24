<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="beans.BattleBean" %>
<% BattleBean battle = (BattleBean)session.getAttribute("battleBean");%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/error.css" type="text/css" >
<title>戦闘結果</title>
</head>
<body>
<h1 style="color:red;">Game Over</h1>
<%= battle.getBattleLog().toString() %>
<br>
<form action="/Kensyu3/Kensyu3Servlet" method="get">
<input type="submit" value="メニューへもどる">
<!-- <input type="hidden" value="gameOver" name="beforePage"> -->
</form>
</body>
</html>