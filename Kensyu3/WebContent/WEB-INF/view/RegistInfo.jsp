<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="beans.Adress1" %>
<% Adress1 adressMap = new Adress1(); %>

<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css" type="text/css"  media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/registInfo.css" type="text/css"  media="all">
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/registInfo.js"></script>
<title>情報登録</title>
</head>
<body onload="init()">
<div id="whole">
<form action="/Kensyu3/Kensyu2Servlet" method="post" name="registInfo">

<div id="name1">
氏：<input type="text" name="name1" onchange="registDisabled()" />
</div>

<div id="name2">
名：<input type="text" name="name2" onchange="registDisabled()" />
</div>

<div id="age">
年齢：<input type="text" name="age"  size="5" onchange="registDisabled()" placeholder="半角数字"/>
</div>

<div id="sex">
性別：男<input type="radio"  name="sex" value=1 onchange="registDisabled()" />
女<input type="radio"  name="sex" value=2 onchange="registDisabled()" />
</div>

<div id="adress">
住所：<select name="adress1" onchange="registDisabled()"  style="margin-top:5px; height:95%;" >
<% for(int i=1;i<=adressMap.getAdress().size();i++){
	out.print("<option value=\"" + i + "\">");
	out.print(adressMap.getAdress(i));
	out.println("</option>");
	}%>
</select>
<input type="text" name="adress2" onchange="registDisabled()" />
</div>

<div id="biko">
備考：<input type="text" name=biko onchange="registDisabled()" />
</div>

<div id="ageError">
年齢は半角数字で正しく入力してください。
</div>

<div id="registBtn">
<input type=submit value="登録" name="registBtn" />
</div>
</form>

</div>
</body>
</html>