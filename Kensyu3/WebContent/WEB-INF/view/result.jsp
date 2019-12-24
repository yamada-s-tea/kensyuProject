<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="beans.Result" %>
<%@ page import="beans.ColorBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- セッションから結果を取得
	暗めの色の場合は文字を白色にするため、リストをインスタンス化し、
	結果の色と照らし合わせてフラグを管理する
	あまりに強引 -->
<% Result result = (Result)session.getAttribute("result");
 String str = result.getResultColor();
 ColorBean cb = new ColorBean();
 boolean flg = false;
 for(int i=0;i<cb.getDark().size();i++){
	 if(str.equals(cb.getDark().get(i))){
		 flg = true;
	 }
 }
 %>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main2.css" type="text/css" >
<title>テスト/結果</title>
</head>
<body bgcolor=<%= str %>>

<%
 if(flg) {
 out.println("<div id=\"resultMsg\" >");
 out.println(result.getResultMessage());
 out.println("</div>");
 }%>

<%
 if(!flg) {
 out.println("<div id=\"resultMsg2\" >");
 out.println(result.getResultMessage());
 out.println("</div>");
 }%>

<c:if test="${result.resultColor == '#2b2b2b' }" >
この文字見えたらすごーい
</c:if>

<br>
<form action="/Kensyu3/DoRandomServlet" method="get" >
<input type="submit" value="タイトルへ">
<input type="hidden" value="result" name="beforePage">
</form>

<form action="/Kensyu3/DoRandomServlet" method="post" >
<input type="submit" value="もう一回">
<input type="hidden" value="result" name="beforePage">
</form>

</body>
</html>