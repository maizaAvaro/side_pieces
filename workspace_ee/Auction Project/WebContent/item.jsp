<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./style.css"/>
<title>Cypress Point Charity Auction</title>
</head>
<body>

<div id="page-wrap">
<div id="header">
	<div id="header-text"><h1><a href="AuctionController">Cypress Point Charity Auction</a></h1></div>
	<div id="header-logo"><img src="http://www.montereygolf.com/course-guide/logo/thumb/14937.jpg"></div>	
</div>

<div id="nav">
<c:forEach items="${catList}" var="category">
<%-- prints a category name from the list of categories --%>
	<h3>${category.catName}</h3>
		<c:forEach items="${category.itemList}" var="item">
		<%-- prints the link to an item via the item name from the list of items for the specified category and item ID --%>
			<ul>
			<li><a href="AuctionController?itemID=${item.itemID}&categoryID=${item.catID}">${item.itemName}</a></li>
			</ul>
		</c:forEach>
	</c:forEach>
</div>

<div id="content">
<h2 class="center">${itemObject.itemName}</h2>
	<div class="photo"><img src="${itemObject.imageURL}" width="400" alt="${itemObject.itemName}"></div>
<br>

<p>${itemObject.itemDescription}</p>
<p><b>Current high bid: </b><fmt:formatNumber type="currency" value="${itemObject.highBid}"/></p>

<form name="input" action="AuctionController" method="post">
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
<td><input type="hidden" name="itemID" value="${itemObject.itemID}"></td>
<td><input type="hidden" name="catID" value="${itemObject.catID}"></td>
<td><input type="submit" value="Submit Bid" style="float:left;"></td>
</tr>
</table>
</form>

<p>${error}</p>

</div>

<div id="footer">
<a href="AuctionController?login=true">Admin</a>
</div>

</div><%-- end page-wrap --%>

</body>
</html>