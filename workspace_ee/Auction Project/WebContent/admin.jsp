<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./style.css" />
<title>Cypress Point Charity Auction</title>
</head>
<body>

	<div id="page-wrap">
		<div id="header">
			<div id="header-text">
				<h1>
					<a href="AuctionController">Cypress Point Charity Auction</a>
				</h1>
			</div>
			<div id="header-logo">
				<img src="http://www.montereygolf.com/course-guide/logo/thumb/14937.jpg">
			</div>
		</div>

		<c:forEach items="${catList}" var="category">
		<%-- prints the name of the category along with the form to add an item to this category
		from the list of categories --%>
			<div id="nav">
				<form action="AuctionController" method="post">
					<h3>Add Item to ${category.catName}</h3>
					<table>
						<tr>
							<td class="bold">Item Name:</td>
						</tr>
						<tr>
							<td><input type="text" name="itemName"></td>
						</tr>
						<tr>
							<td class="bold">Item Description:</td>
						</tr>
						<tr>
							<td><textarea rows="10" cols="30" name="itemDescription"></textarea>
							</td>
						</tr>
						<tr>
							<td class="bold">Image URL:</td>
						</tr>
						<tr>
							<td><input type="text" name="imageURL"></td>
							<td><input type="hidden" value="${category.catID}" name="catID"></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Item" style="float: left;"></td>
						</tr>
					</table>
				</form>
			</div>

			<div id="content">
				<h2>${category.catName}</h2>

				<table style="border-spacing: 15px 10px">
				<c:forEach items="${category.itemList}" var="item">
				<%-- prints an item from the list of items in a specified category along with
				its relevant bid information --%>
					<tr>
						<td class="bold"><a href="AuctionController?itemID=${item.itemID}&categoryID=${item.catID}">${item.itemName}</a></td>
						<td class="bold">${item.nameOfHighBidder}</td>
						<td class="bold">${item.emailOfHighBidder}</td>
						<td class="bold"><fmt:formatNumber type="currency" value="${item.highBid}"/></td>
						<td><form action="AuctionController" method="post">
							<input type="hidden" name="itemID" value="${item.itemID}">
							<input type="submit" name="deleteItem" value="Delete">
							</form></td>
					</tr>
				</c:forEach>
				</table>

			</div>

			<hr>
		</c:forEach>

		<div id="footer">
			<a href="AuctionController?logout=true">Logout</a>
		</div>

	</div>
	<%-- end page-wrap --%>

</body>
</html>