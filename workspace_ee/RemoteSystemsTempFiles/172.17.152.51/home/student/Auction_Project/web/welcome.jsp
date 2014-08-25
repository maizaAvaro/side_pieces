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

<c:forEach items="${catList}" var="category">
	<p>${category.catName}</p>						
</c:forEach>

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
<h2 class="center">Welcome to Cypress Point Charity Auction</h2>
	<div class="photo"><img src="http://www.montereygolf.com/course-guide/image/wide/14985.jpg" alt="Cypress Point Golf Club"></div>
<br>
<p>This auction and its proceeds go to benefit the children of Detroit, Michigan.  This third-world
arena desperately needs the help that our limitless checkbooks can provide. Enjoy a round at one of
this country's most impressive courses as a member for the day or pick up some top-of-the-line 
equipment to take your game to the next level. Hell, why not do both.</p>
<br>
<h2>How to begin your bidding:</h2>
<p>Click on any of the links at left to view an item for which you wish to place a bid. Please fill
out the bidder information in the form provided when placing a bid. In order for a bid to be
successful the dollar amount placed must be higher than the current bid displayed for your item
of choice.</p>
</div>

<div id="footer">
<a href="./login.jsp">Admin</a>
</div>

</div><!-- end page-wrap -->

</body>
</html>
