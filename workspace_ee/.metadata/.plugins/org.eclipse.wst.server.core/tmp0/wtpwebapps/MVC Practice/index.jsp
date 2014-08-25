<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>MVC Practice</title>
</head>

<body>

<h2>Hello Servlet</h2>

<form method="get" action="Controller">
<p>Enter your name, please:</p>
<input type="text" name="userName">
<input type="submit" value="Go to Hello Servlet">
</form>

<h2>Reverso Page</h2>

<p>You must visit the Hello Servlet and give your name before you go here.</p>

<form method="get" action="Controller">
<p>Enter a string:</p>
<input type="text" name="inputString">
<input type="submit" value="seeReversedString">
</form>

</body>

</html>