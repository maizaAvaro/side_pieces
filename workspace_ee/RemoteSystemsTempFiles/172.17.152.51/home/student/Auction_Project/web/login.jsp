<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./style.css"/>
<title>Cypress Point Charity Auction</title>
</head>
<body>

<div id="page-wrap">
<div id="header">
	<div id="header-text"><h1><a href="./welcome.jsp">Cypress Point Charity Auction</a></h1></div>
	<div id="header-logo"><img src="http://www.montereygolf.com/course-guide/logo/thumb/14937.jpg"></div>	
</div>

<div id="content">
<h2>Administration Login</h2>
<br>

<form name="input" action="./admin.jsp" method="post">
<table border="0">
<tr>
<td class="bold">User Name:</td> 
<td><input type="text" name="userName"></td>
</tr>
<tr>
<td class="bold">Password:</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="login" style="float:right;"></td>
</table>
</form>

</div>

<div id="footer">
<a href="./login.jsp">Admin</a>
</div>

</div><!-- end page-wrap -->

</body>
</html>