<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-5">
     <title>Javascript Assignment -- Form Completion</title>
     <link rel='stylesheet' href='csci4300.css'>

<script type="text/javascript">
  /**
   * Returns true if all form fields have been completed.
   * Otherwise, displays an alert box with an error message
   * for the first uncompleted form field and returns false.
   */
   function formOK()
  {
	   var form = document.forms["submitInfo"];
	   var firstName = form["firstName"].value;
	   var lastName = form["lastName"].value;
	   var phoneNumber = form["phoneNumber"].value;
	   var city = form["city"].value;
	   var zipCode = document.getElementById("zipCode").value;
	   
	   if(firstName && lastName && phoneNumber && city && zipCode != "initial")
		{
			alert("Form has been submitted.");
			return true;
			
		}else
		{
			alert("Form is invalid.");
			return false;
			
		}
  }
</script>
     </head>
<body style="background-color:lightyellow">

<form name="submitInfo" method="post" onSubmit = "return formOK()" action="Echo" >
<div>
<table>
       <tr><th colspan=4>Please tell us who you are (Georgia residents only)
       <tr><td>First name<td><input type='text' size=20 name='firstName' >
           <td>Last name<td><input type='text' size=20 name='lastName'>
       <tr><td>Telephone <td><input type='text' size=15 name='phoneNumber'> <td>&nbsp;<td>&nbsp;
        <tr><td>City<td><input type='text' size=20 name='city'>
            <td>Zip code:<td><select id="zipCode" name="zipCode"><option value="initial">Select</option><option>12345</option><option>99999</option></select>
           
        <tr><td colspan=6 style="text-align:center"><input type='submit' value="Share personal info with our unscrupulous marketing staff">
</table>
<input type='text' size=50 id="status">
</div>
</form>
<p>
      <a href="http://validator.w3.org/check/referer"><img
          src="http://www.w3.org/Icons/valid-html401"
          alt="Valid HTML 4.01!" height="31" width="88"></a>
    </p>
</body>
