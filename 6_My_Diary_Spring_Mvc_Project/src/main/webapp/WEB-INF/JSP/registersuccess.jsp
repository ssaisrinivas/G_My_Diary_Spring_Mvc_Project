<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Successfully</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/style.css"/>"></link>
</head>
<body>
<div class="header"> 
<div class="firstpart">
<img src="<c:url value="/resources/images/dairyimage.jpg"/>" width="70" height="70">
</div>
<div class="secondpart">MyDiary Application</div>

</div>

<hr>
<hr>
<br/>
<div class="bodypart">
<div class="bodypart2">


<br/>
<h1 align="center">Registration Successfully</h1><br>
<h1 align="right">You are Successfully registered with MyDiary </h1><br><br>
<h1 align="center">Please Login into MyDiary Application </h1><br>
<a href="./home" class="button">LOGIN</a>

</div>
<div class="bodypart1">
<img src="<c:url value="/resources/images/registrationsuccessfull.jpg"/>"  width="150" height="150">
</div>
</div>
</body>
</html>