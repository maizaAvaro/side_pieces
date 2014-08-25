<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<jsp:useBean id="bean" class="acme.ShoppingCartBean" scope="session"/>
<jsp:setProperty property="itemID" name="bean"/>
<jsp:setProperty property="quantity" name="bean"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ACME Dangerous Products Inc.</h1>
        <p>Helping to turn your demented schemes into reality</p>
        <div style="width:600px">
              <img src="http://upload.wikimedia.org/wikipedia/en/2/20/Wile_E_Coyote.gif"
                    width="226" height="363" alt="Wile E. Coyote" style="float:right">
              <form method="post" action="addToCart">
                  <table>
                      <tr><th>  Item: </th><th>Quantity</th>

                  <tr><td><select name="itemID">
                      <option value="0">Rocket-powered roller skates, Pair</option>
                      <option value="1">Exploding tennis balls, Case</option>
                      <option value="2">Dehydrated boulder, Set</option>
                      <option value="3">Earthquake pill, bottle of 12</option>
                      <option value="4">Batman outfit, Single</option>
                      <option value="5">Catapult, Set</option>
                  </select>
                      </td>
                 <td> <input type="text" size="4" name="quantity"></td></tr>
                  <tr><td><input type="submit" value="Add to Cart"></td></tr>

                     </table>
              </form>
             
              <h1>Your cart so far:</h1>
              <table border="1">
                  <tr><th style="background-color:lightyellow">Item</th><th style="background-color:lightyellow">Description</th><th style="background-color:lightyellow">Quantity</th></tr>
                    
                    <c:forEach items="${bean.cart}" var="item">
                    
                    <tr><td>${item.itemID}</td><td>${item.description}</td><td>${item.quantity}</td></tr>
                    
                    </c:forEach>
			  </table>
              <p>Wile E. Coyote and the ACME Corporation are creations of cartoonist
                  Chuck Jones. The image is from Wikipedia Commons.</p>
        </div>


    </body>
</html>