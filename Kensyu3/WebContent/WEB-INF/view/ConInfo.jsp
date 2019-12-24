<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.ConInfoBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% ConInfoBean bean = (ConInfoBean)session.getAttribute("CIBean"); %>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css" type="text/css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/conInfo.css" type="text/css" >
<title>登録情報確認</title>
</head>
<body>
<div id="whole">
登録情報<br>

<table>
<tr>
<th>氏名</th>
<td><%= bean.getName() %></td>
</tr>

<tr>
<th>年齢</th>
<td><%= bean.getAge() %></td>
</tr>

<tr>
<th>性別</th>
<td>
<%
 if(bean.getSex() == "男") {
 out.println("<div id=\"male\" >");
 out.println(bean.getSex());
 out.println("</div>");
 }%>
<%
 if(bean.getSex() == "女") {
 out.println("<div id=\"female\" >");
 out.println(bean.getSex());
 out.println("</div>");
 }%>
</td>
</tr>

<tr>
<th>住所</th>
<td><%= bean.getAdress() %></td>
</tr>

<tr>
<th>備考</th>
<td><%= bean.getBiko() %></td>
</tr>
</table>

<a href="/Kensyu3/Kensyu2Servlet?action=戻る">戻る</a>

</div>
</body>
</html>