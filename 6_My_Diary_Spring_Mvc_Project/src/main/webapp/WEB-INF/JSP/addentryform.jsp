<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/style.css"/>"></link>
</head>
<body>
<div class="header"> 
<div class="firstpart">
<img src="<c:url value="/resources/images/dairyimage.jpg"/>" width="70" height="70">
</div>
<div class="secondpart">MyDiary Application
<label style="font-size:25px ;color:blue; text-align:right" class="label">Welcome ${user.username} </label>
<a href="./signout"> <button type="submit" class="button">Signout</button>  </a>

</div>

</div>

<hr>
<hr>
<br/>
<div class="bodypart">
<div class="bodypart2">

<h1 align="center"><br/>Add Entry</h1>
<br/>
<form action="./saveentry" method="POST">

<label class="label">Entry Date     </label> <input type="date" name="entrydate" class="formcontrol" ><br/><br/>

<label class="label">Entry Description </label> <textarea rows="10" cols="30" name="description" class="formcontrol" ></textarea><br/><br/>

<input type="hidden" name="userid" value="${user.id }">

<button type="submit" class="button">Save Entry</button><br/><br/>


</form>
</div>
<div class="bodypart1">
<img src="<c:url value="/resources/images/dairyimage.mainjpg.jpg"/>"  width="200" height="200">
</div>
</div>
</body>
</html>