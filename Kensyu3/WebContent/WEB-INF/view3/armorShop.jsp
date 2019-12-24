<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.AllyBean"%>
<%@ page import="beans.BattleBean"%>
<%@ page import="beans.EquipmentBean"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	AllyBean main = (AllyBean) session.getAttribute("main");
	BattleBean battle = (BattleBean) session.getAttribute("battleBean");
	// List<EquipmentBean> equipList = (List<EquipmentBean>) session.getAttribute("equipList"); 無くてもEL式は取れる
	// List<EquipmentBean> goodsList = (List<EquipmentBean>) session.getAttribute("goodsList");
%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/playMain.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/backgroundCity.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/armorShop.js"></script>
<title>武具屋</title>
</head>
<body onload="init()">
	<div id="all">

		<div id="mStatus">
			Name:<%=main.getName()%><br>
			HP:<%=main.getHp()%>/<%=main.getMaxHp()%><br>
			MP:<%=main.getMp()%>/<%=main.getMaxMp()%><br>
			Level:<%=main.getLevel()%><br>
			Exp:<%=main.getExperience()%><br>
			Attack:<%=main.getAttack()%><br>
			Int:<%=main.getIntelligence()%><br>
			Defense:<%=main.getDefense()%><br>
			Speed:<%=main.getSpeed()%><br>
			Money:<%=main.getMoney()%><br>
			Equip1:<%= main.getEquipment1Name() %><br>
			Equip2:<%= main.getEquipment2Name() %>
		</div>

<form action="/Kensyu3/PlayServlet2" method="post" name="armorShopForm">
		<div id="equipWindow">
			装備アイテム
				<c:if test="${equipList != null}">
					<table style="border: none">

						<c:forEach items="${equipList}" var="i" varStatus="status">
							<tr>
							<%-- チェックボックスが非活性でも値は取れるように --%>
								<td><input type="hidden" id="${status.index}"
									value="${ i.ing }" name="${'ing' += status.index}"> <input
									type="checkbox" name="equip" onclick="checkLimit()"></td>
								<td><c:out value="${ i.name }" /></td>
								<td><span id="${'sobityu' += status.index}" >装備中</span></td>
							</tr>
						</c:forEach>
						<tr>
							<td><input type="button" value="詳細一覧"
								onclick="showDetails()"></td>
						</tr>

					</table>
				</c:if>
			</div>
		<div id="goodsWindow">
				<table style="border: dotted;">
					<colgroup style="width:150px;"></colgroup>
					<colgroup style="width:80px;"></colgroup>
					<colgroup style="width:80px;"></colgroup>
					<colgroup style="width:80px;"></colgroup>
					<colgroup style="width:80px;"></colgroup>
					<colgroup style="width:80px;"></colgroup>
					<colgroup style="width:100px;"></colgroup>
					<tr>
						<th>名称</th>
						<th>攻撃力</th>
						<th>防御力</th>
						<th>知力</th>
						<th>素早さ</th>
						<th>価格</th>
					</tr>
					<c:forEach items="${goodsList}" var="i" varStatus="status">
						<tr>
							<td><c:out value="${ i.name }" /></td>
							<td style="text-align: right;"><c:out value="${ i.attack }" /></td>
							<td style="text-align: right;"><c:out value="${ i.defense }" /></td>
							<td style="text-align: right;"><c:out
									value="${ i.intelligence }" /></td>
							<td style="text-align: right;"><c:out value="${ i.speed }" /></td>
							<td style="text-align: right;"><c:out value="${ i.price }" /></td>
							<th><input type="submit" value="購入" name="${ 'buy' += status.index }"></th>
						</tr>
					</c:forEach>
				</table>

				<br>
				<input type="submit" value="装備を確定して戻る" name="back">
				<a href="/Kensyu3/Kensyu3Servlet">やめる</a>
		</div>
		<input type="hidden" value="armorShop" name="beforePage">
		</form>

		<%
			if (battle != null && !battle.getBattleLog().equals("")) {
				out.println("<div id=\"msgBuyWindow\">");
				out.println(battle.getBattleLog().toString());
				out.println("<input type=\"button\" value=\"閉じる\" onclick=\"closeLog()\">");
				out.println("</div>");
			}
		%>
	</div>
</body>
</html>