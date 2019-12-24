<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<title>キャラ作成</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/playMain.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/backgroundCity.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/inputData.js"></script>
</head>
<body>
	<div id="all">

		<div id="inputWindow">
			<form action="/Kensyu3/Kensyu3Servlet" method="post" name="inDataForm">
				キャラクターネーム：<input type="text" size="8" name="name" onchange="startBtnDis()">
				※6文字まで<br>
				<div id="attack" style="margin-top: 15px;">
					<span style="font-weight: bold">攻撃方法は...</span><br>
					物理<input type="radio" value="1" name="attack" onchange="startBtnDis()" checked>
					魔法<input type="radio" value="2" name="attack" onchange="startBtnDis()">
				</div>
				<div id="way" style="margin-top: 5px;">
					<span style="font-weight: bold">敵の攻撃に対して...</span><br>
					防御<input type="radio" value="1" name="way" onchange="startBtnDis()" checked>
					躱す<input type="radio" value="2" name="way" onchange="startBtnDis()">
				</div>
				<input type="submit" value="Start" name="startBtn" disabled style="margin-top: 15px;">
				<input type="hidden" value="inputData" name="beforePage">
			</form>
			<br>
			<a href="/Kensyu3/Kensyu3Servlet">やめる</a>
		</div>

	</div>
</body>
</html>