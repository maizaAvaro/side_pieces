
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:useBean class="csci4300.Student" id="student" scope="session"/>

<jsp:setProperty name="student" property="studentName" value="Nathan Ray"/>
<jsp:setProperty name="student" property="description" value="I am a Senior at the University of Georgia with aspirations in financial software development. I love the puzzle that coding provides and spend most of my time with my nose in a book."/>
<jsp:setProperty name="student" property="imageURL" value=""/>
<jsp:setProperty name="student" property="activityStatement" value=""/>
<jsp:setProperty name="student" property="newActivity"/>   

<html>

<head>

<style type="text/css">

#activityBox {border-style:solid; border-width:thick; border-color:red; font-family:Arial,Sans-serif}
p.textStyling {font-weight:bold; font-style:italic}
#boldTextAndCenter {font-weight:bold; text-align:center}
p.spacing {width:45%}
td.textCenter {text-align:center}
#boldText {font-weight:bold}

table.center {margin-left:auto; margin-right:auto}

body {background-image:url('bigWave.jpg'); background-size:100%}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Student Profile</title>

</head>

<body>

<h1>Student Profile</h1>

<div><img src="Nathan_Ray.JPG" style="float:right" width="300" height="350" alt="Student Photo"></div>

<p class="textStyling">Student Name:</p> 
<p class="spacing"><jsp:getProperty name="student" property="studentName"/></p>
<p class="textStyling">Student Description:</p> 
<p class="spacing"><jsp:getProperty name="student" property="description"/></p>
<p class="textStyling">Student Activities:</p> 
<p class="spacing"><jsp:getProperty name="student" property="activityStatement"/></p>

<h3 id="boldTextAndCenter">Enter a new student activity:</h3>

<form name="activityForm" method="get" action="index.jsp">

<table class="center" id="activityBox" width="35%" border="0" cellspacing="0" cellpadding="0">

<tr><td>&nbsp;</td></tr>
<tr><td class="textCenter">Activity: <input type="text" name="newActivity"></td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td class="textCenter"><input type="submit" value="Submit Activity"></td></tr>
<tr><td>&nbsp;</td></tr>

</table>

</form>

<p id="boldText">Background Image: wallpapers.free-review.net</p>

</body>

</html>