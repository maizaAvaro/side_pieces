<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>E-Z Credit Customer List</title>
	</head>
	<body>
		<h1><a href="Customer">E-Z Credit, Inc.</a></h1>
		<h2>Valued Customers</h2>
		<table border="1">
			<tr>
				<th>Customer</th>
				<th>Address</th>
				<th>Unpaid Balance</th>
				<th>Credit Limit</th>
			</tr>
			<tr>
				<c:forEach items="${customerList}" var="customer">
					<%--print out the customer's data on a single row--%>
					<tr>
						<td>${customer.custName}</td>
						<td>${customer.custAddress}</td>
						<td><fmt:formatNumber type="currency" value="${customer.unpaidBalance}"/></td>
						<td><fmt:formatNumber type="currency" value="${customer.creditLimit}"/></td>
						<td>
							<form method="get" action="Customer">
								<input type="hidden" name="customerID" value="${customer.id}">
								<input type="submit" value="View Account">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	
		<hr>
	
		<h2>Enter a new Customer</h2>
		<form method="post" action="Customer">
			<table>
				<tr>
					<td>Customer name:</td>
					<td><input type="text" name="customerName"></td>
				</tr>
				<tr>
					<td>Customer address:</td>
					<td><input type="text" name="customerAddress"></td>
				</tr>
				<tr>
					<td>Credit Limit:</td>
					<td><input type="text" name="creditLimit"></td>
				</tr>
				<tr>
					<td>Image URL:</td>
					<td><input type="text" name="imageURL"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="Submit" value="Create Customer Account">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>