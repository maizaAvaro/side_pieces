<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
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
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>UGA Course Picker</title>
	</head>
	<body>
		<div class="wrap">
		<h1>Course Picker</h1>
		
		<p>Choose a requirement to see a list of courses that satisfy that requirement</p>
		<div class="searchform">
		<form method="get" action="Controller">
				<table>
					
					<tr>
						<td>Requirement:</td>
						<td>
							<select name="requirementID">
							<c:forEach items="${requirementList}" var="requirement">
								<!-- print out the requirement as an option -->
								<option value="${requirement.requirementID}">${requirement.requirementName}</option>
							</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="Submit" name="searchForCourses" value="Search"></td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		<hr>
		
		<p>Results of your previous search (${requirement.requirementName}):</p>
		<table class="searchresults">
			<tr class="heading">
				<th>Course Prefix</th>
				<th>Course Number</th>
				<th>Course Name</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th width="100%"> </th>
			</tr>
			<c:forEach items="${courseList}" var="course">
				<!-- print out information about the course and its meetings -->
				<tr class="course">
					<td>${course.prefix}</td>
					<td>${course.courseNum}</td>
					<td>${course.courseTitle}</td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
					<td> </td>
				</tr>
					<c:forEach items="${course.sections}" var="section">
						<!-- print out information about the course and its meetings on a new row-->
						<tr class="section">
							<td> </td>
							<td>${section.callNum}</td>
							<td> </td>
							<td> </td>
							<td> </td>
							<td> </td>
							<td>
								<form method="post" action=Controller>
									<input type="hidden" name="rID" value="${requirement.requirementID}">
									<input type="hidden" name="courseName" value="${course.courseTitle}">
									<input type="hidden" name="callNo" value="${section.callNum}">
									<input type="submit" name="addCourse" value="Add Class">
								</form>
							</td>
						</tr>
						<c:forEach items="${section.meetings}" var="meeting">
							<!-- print out information about the meeting -->
							<tr class="meeting">
								<td> </td>
								<td> </td>
								<td>${meeting.beginTime}-${meeting.endingTime} ${meeting.day}</td>
								<td>${meeting.instructor}</td>
								<td>${meeting.building}</td>
								<td>${meeting.room}</td>
								<td> </td>
								<td> </td>
							</tr>
						</c:forEach>
					</c:forEach>
			</c:forEach>
		</table>
		
		<hr>
		
		<a href="Controller?page=schedule">View your schedule</a>
		</div>
	</body>
</html>
