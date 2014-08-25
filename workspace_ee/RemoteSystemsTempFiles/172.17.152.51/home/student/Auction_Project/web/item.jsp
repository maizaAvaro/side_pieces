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

<div id="nav">
<h3>Rounds of Golf</h3>
<ul>
<li><a href="./item.jsp">Cypress Point Golf Club</a></li>
<li><a href="">Pebble Beach Golf Club</a></li>
<li><a href="">Spanish Bay Golf Club</a></li>
</ul>
<h3>Golf Clubs</h3>
<ul>
<li><a href="">TaylorMade Irons</a></li>
<li><a href="">TaylorMade Driver</a></li>
<li><a href="">Mizuno Irons</a></li>
<li><a href="">Mizuno Driver</a></li>
<li><a href="">Titleist Irons</a></li>
<li><a href="">Titleist Driver</a></li>
</ul>
</div>

<div id="content">
<h2 class="center">Item Name</h2>
	<div class="photo"><img src="http://www.montereygolf.com/course-guide/image/wide/14985.jpg" alt="Cypress Point Golf Club"></div>
<br>

<p><b>Description:</b> The specific item description goes here.</p>
<p><b>Current high bid:</b> highBid</p>

<form name="input" action="" method="get">
<table border="0">
<tr>
<td class="bold">Bid Amount:</td> 
<td><input type="text" name="highBid"></td>
</tr>
<tr>
<td class="bold">Bidder Name:</td>
<td><input type="text" name="bidderName"></td>
</tr>
<tr>
<td class="bold">Bidder Email:</td>
<td><input type="text" name="bidderEmail"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Submit Bid" style="float:right;"></td>
</tr>
</table>
</form>

</div>

<div id="footer">
<a href="./login.jsp">Admin</a>
</div>

</div><!-- end page-wrap -->

</body>
</html>