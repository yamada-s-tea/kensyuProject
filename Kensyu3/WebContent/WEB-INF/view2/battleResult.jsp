<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="beans.BattleBean" %>
<% BattleBean battle = (BattleBean)session.getAttribute("battleBean");%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/playMain.css" type="text/css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/<%= battle.getPlace() %>.css" type="text/css">
<title>戦闘結果</title>
</head>
<body>
<div id="all">

<div id="resultWindow">
<h1>戦闘終了</h1>
</div>
<div id="msgWindow">
<%= battle.getBattleLog().toString() %>
<form action="/Kensyu3/PlayServlet" method="post">
<input type="submit" value="次へ">
<input type="hidden" value="battleResult" name="beforePage">
</form>
</div>

</div>
</body>
</html>