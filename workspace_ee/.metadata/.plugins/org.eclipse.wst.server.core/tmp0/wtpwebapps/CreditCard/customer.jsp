<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>E-Z Credit Account Overview</title>
	</head>
	<body>
		<h1><a href="Customer">E-Z Credit, Inc.</a></h1>
		<img src="${customer.imageURL}" alt="Customer Image" style="float: right">
		<h2>${customer.custName}'s Account</h2>
		<h4>Address: ${customer.custAddress}</h4>
		<h4>Credit Limit: <fmt:formatNumber type="currency" value="${customer.creditLimit}"/></h4>
		
		<hr>
		
		<h2>Purchases</h2>
		<c:choose>
			<c:when test="${fn:length(purchaseList)>0}">
				<table border="1">
					<tr>
						<th>Date</th>
						<th>Merchant Name</th>
						<th>Location</th>
						<th>Amount</th>
					</tr>
					<tr>
						<c:forEach items="${purchaseList}" var="purchase">
							<%--print out the customer's data on a single row--%>
							<tr>
								<td>${purchase.date}</td>
								<td>${purchase.merchantName}</td>
								<td>${purchase.merchantCity}, ${purchase.merchantState}</td>
								<td><fmt:formatNumber type="currency" value="${purchase.purchaseAmount}"/></td>
							</tr>
						</c:forEach>				
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<h4>(No purchases have been made on this account)</h4>
			</c:otherwise>
		</c:choose>
		<h3>Unpaid Balance: <fmt:formatNumber type="currency" value="${customer.unpaidBalance}"/></h3>
		
		<hr>
		
		<h2>Add a Purchase</h2>
		<h3 style="color: red">${errorMessage}</h3>
		<form method="post" action="Customer">
			<table>
				<tr>
					<td>Merchant name:</td>
					<td><input type="text" name="merchantName"></td>
				</tr>
				<tr>
					<td>Merchant city:</td>
					<td><input type="text" name="merchantCity"></td>
				</tr>
				<tr>
					<td>Merchant state:</td>
					<td><input type="text" size="2" maxLength="2" name="merchantState"></td>
				</tr>
				<tr>
					<td>Purchase amount:</td>
					<td><input type="text" name="purchaseAmount"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="customerID" value="${customer.id}"></td>
					<td colspan="2"><input type="Submit"
						value="Add New Purchase"></td>
				</tr>
			</table>
		</form>
		
	</body>
</html>