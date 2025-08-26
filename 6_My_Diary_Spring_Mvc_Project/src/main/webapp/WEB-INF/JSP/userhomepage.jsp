<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User HomePage</title>
<link rel="stylesheet"
	href="<c:url value="/resources/styles/userhomestyle.css"/>"></link>
</head>
<body>
	<div class="header">
		<div class="firstpart">
			<img src="<c:url value="/resources/images/dairyimage.jpg"/>"
				width="70" height="70">
		</div>
		<div class="secondpart">MyDiary Application</div>
	</div>
	<hr>
	<hr>
	<br>
	<h2 align="center">User Home Page</h2>
	<br>
	<br>
	<div class="userhomep1">
		<label class="label">Welcome <span>${user.username}</span>
		</label>
		<div class="userhomep2">
			<a href="./signout" class="button"> Signout </a>
		</div>
		<br /> <br /> <br /> <br />
		<h3 class="heading" align="center">List of Past Diary Entries</h3>
		<br />
		<h3 align="right">
			<a href="./addentry" class="button">Add Entry </a>
		</h3>
		<br>
		<table border="1">
			<tr>
				<th style="font-size: 20px; color: blue; text-align: center">Date</th>
				<th style="font-size: 20px; color: blue; text-align: center"
					colspan="3">Actions</th>
			</tr>
			<c:if test="${entrieslist.size()==0}">
				<tr>
					<td style="font-size: 20px; color: blue; text-align: center"
						colspan="4">User Not Added Any Diary entries till now</td>
				</tr>

			</c:if>

			<c:forEach items="${entrieslist}" var="entry">
				<tr style="font-size: 20px; color: red; text-align: center">
					<td><fmt:formatDate value="${entry.entrydate}"
							pattern="dd/MM/yyy" /></td>
					<td><a href="./viewentry?id=${entry.id}">View</a></td>
					<td><a href="./updateentry?id=${entry.id }">Update</a></td>
					<td><a href="./deleteentry?id=${entry.id }">Delete</a></td>
				</tr>

			</c:forEach>

		</table>


	</div>
</body>
</html>