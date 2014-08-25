<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="bean" class="db.DBHelper" scope="session"/>
<jsp:setProperty property="bandName" name="bean"/>
<jsp:setProperty property="bandId" name="bean"/>
<jsp:setProperty property="albumName" name="bean"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<style type="text/css">

li.color {color:red}

body {background-color: black; color: white}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Bands Project</title>

</head>

<body>
	<h1>My Favorite Bands and their Albums</h1>
	<h3>Enter a new Band</h3>
		<form method="post" action="index.jsp">
			<p>Band Name: <input type="text" name="bandName">
				<input type="submit" value="Add Band"></p>		
		</form>
		<h3>Enter a new Album</h3>
     	<form method="post" action="index.jsp">
     		<p>Band Name: <select name="bandId">
     	<%-- On one iteration of this loop the list of Band objects is obtained, one of these
     	objects is then obtained to have the getId and getBandName methods called on it. A drop-box
     	is then populated with the band Name of the single object at the value corresponding to its
     	band id --%>
     			<c:forEach items="${bean.bandList}" var="band">
     				<option value="${band.id}">${band.bandName}</option>
     			</c:forEach>
     		</select>
     		Album Title: <input type="text" name="albumName">
     					<input type="submit" value="Add Album"></p>
        </form>
			<br>
			<br>
            <ol>
            <%-- On one iteration of this loop the band list is obtained and one of these Band
            objects has the method getBandName called on it to be printed on the page --%>        
        	<c:forEach items="${bean.bandList}" var="band">   
            <li class="color">${band.bandName}
            	<ul>
            	<%-- One one iteration of this loop the album list corresponding to the given
            	Band object is obtained and one album from this list is printed on the page --%>
                    <c:forEach items="${band.albumList}" var="album">
                    	<li class="color">${album}</li>	
                    </c:forEach>
             </ul></li>       
            </c:forEach>
            </ol>
</body>

</html>