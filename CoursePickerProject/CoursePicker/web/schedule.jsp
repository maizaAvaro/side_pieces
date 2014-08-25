

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Your Schedule</title>
		<script type="text/javascript" src="jQuery.js"> </script>
		<script type="text/javascript" src="scheduleViewer.js">	</script>

		<style>

			body {

				font-family: 'Trebuchet MS Regular', sans-serif;

				background-color: #666E71;

			}

			

			.wrap {

				border: solid 4px #021C24;

				background-color: #F8EFE6;

				color: black;
				
				margin: 40px;

			}

			.wrap canvas {
			margin: 40px;
			}

			.wrap a {
			margin: 15px 0px 40px 20px;
			font-weight: bold;
			font-size: 20px;
			color: #9D7144; 
			text-decoration: none;
			line-height: 100px;
			}
			

			h1 {

			font-family: Helvetica;

			font-size: 32px;

			text-align: right;

			padding: 10px;

			background-color: #9D7144;

			margin-bottom: 30px;

			letter-spacing: 3px;

			}

			
			.searchform {
				margin: 0px 40px 15px 40px;
			}

			.searchresults {

				border-spacing: 0px;
				width: 100%;

			}

			.searchresults tr td:first-child {
				padding-left: 30px;
			}
			
			.searchresults tr th {
				padding: 10px;
				border-left: solid black 1px;
			}

			.searchresults tr.course {
				background-color: #BCC7CB;
			}
			
			.searchresults tr.section {
				font-weight: bold;
			}

			p {

				font-size: 16px;

				padding: 10px;

				margin-bottom: 15px;

			}

			

			td {

				padding: 10px;

				font-size: 16px;

			}

			

			tr {

				margin: 0px;

				padding: 0px;

			}

			

			th {

				font-weight: bold;

				font-size: 22px;

				background-color: #B5ACA2;

				color: #021C24;

				margin: 0px;

				padding: px;

			}

		</style>
		
	</head>
	<body onload='init(${courseList})'>
		<div class="wrap chart">
		<h1>Your Schedule</h1>
		<div>
			<canvas id="scheduleCanvas" width="800" height="600"></canvas>
		</div>
		<a href="Controller?page=picker">Go to course picker</a>
		</div>
	</body>
</html>
