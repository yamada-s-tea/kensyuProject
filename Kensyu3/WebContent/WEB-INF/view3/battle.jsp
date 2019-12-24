<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.AllyBean" import="beans.EnemyBean"
	import="beans.BattleBean"%>
<%
	AllyBean main = (AllyBean) session.getAttribute("main");
	EnemyBean enemy = (EnemyBean) session.getAttribute("enemy");
	BattleBean battle = (BattleBean) session.getAttribute("battleBean");
%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/playMain.css" type="text/css" >
</head>
<body>

	<div id="mStatusB">
		Name:<%=main.getName()%><br>
		HP:<%=main.getHp()%>/<%=main.getMaxHp()%><br>
		MP:<%=main.getMp()%>/<%=main.getMaxMp()%><br>
		Level:<%=main.getLevel()%><br>
		Exp:<%=main.getExperience()%><br>
		Attack:<%=main.getAttack()%><br>
		Int:<%=main.getIntelligence()%><br>
		Defense:<%=main.getDefense()%><br>
		Speed:<%=main.getSpeed()%><br>
	</div>

	<div id="eStatus">
		Name:<%=enemy.getName()%><br>
		HP:<%=enemy.getHp()%>/<%=enemy.getMaxHp()%><br>
	</div>

	<div id="msgWindow">
		<%
			if (battle == null || battle.getBattleLog().equals("")) {
				out.println(enemy.getName() + "があらわれた");
			} else {
				out.println(battle.getBattleLog().toString());
			}
		%>
		<div id="commandWindow">
			<form action="/Kensyu3/PlayServlet" method="post" name="commandForm">
				<input type="submit" value="たたかう" name="command"> <input
					type="submit" value="にげる" name="command"> <input
					type="hidden" value="battle" name="beforePage">
			</form>
		</div>

	</div>

</body>
</html>