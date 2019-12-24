<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.AllyBean"%>
<%@ page import="beans.BattleBean"%>
<%@ page import="beans.PlaceMap"%>
<%@ page import="java.util.Map"%>
<%
	AllyBean main = (AllyBean) session.getAttribute("main");
	BattleBean battle = (BattleBean) session.getAttribute("battleBean");
	PlaceMap place = new PlaceMap();
%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/playMain.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/backgroundCity.css" type="text/css">
<title>行先</title>
</head>
<body>
	<div id="all">

		<div id="mStatus">
			Name:<%= main.getName() %><br>
			HP:<%= main.getHp() %>/<%= main.getMaxHp() %><br>
			MP:<%= main.getMp() %>/<%= main.getMaxMp() %><br>
			Level:<%= main.getLevel() %><br>
			Exp:<%= main.getExperience() %><br>
			Attack:<%= main.getAttack() %>(+<%= main.getAttack() - main.getOrgAttack() %>)<br>
			Int:<%= main.getIntelligence() %>(+<%= main.getIntelligence() - main.getOrgIntelligence() %>)<br>
			Defense:<%= main.getDefense() %>(+<%= main.getDefense() - main.getOrgDefense() %>)<br>
			Speed:<%= main.getSpeed() %>(+<%= main.getSpeed() - main.getOrgSpeed() %>)<br>
			Money:<%= main.getMoney() %><br>
			Equip1:<%= main.getEquipment1Name() %><br>
			Equip2:<%= main.getEquipment2Name() %>
		</div>

		<div id="choosePlaceLogWindow">
			行先を選んでください
			<form action="/Kensyu3/PlayServlet" method="post" name="choosePlaceForm">
				<select name="place">
					<%
						for (Map.Entry<String,String> pl : place.getPlaceMap().entrySet()) {
							out.print("<option value=\"" + pl.getKey() + "\">");
							out.print(pl.getValue());
							out.println("</option>");
						}
					%>
				</select> <input type="submit" value="移動" name="move">
				<input type="hidden" value="choosePlace" name="beforePage">
			</form>
			<a href="/Kensyu3/Kensyu3Servlet">やめる</a>
		</div>

		<%
			if (battle != null && !battle.getBattleLog().equals("")) {
				out.println("<div id=\"msgWindow\">");
				out.println(battle.getBattleLog().toString());
				out.println("</div>");
			}
		%>
	</div>
</body>
</html>