<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./style.css"/>
<title>Cypress Point Charity Auction</title>
</head>
<body>

<div id="page-wrap">
<div id="header">
	<div id="header-text"><h1><a href="AuctionController">Cypress Point Charity Auction</a></h1></div>
	<div id="header-logo"><img src="http://www.montereygolf.com/course-guide/logo/thumb/14937.jpg"></div>	
</div>

<div id="nav">
<c:forEach items="${catList}" var="category">
<%-- prints a category name from the category list --%>
	<h3>${category.catName}</h3>
		<c:forEach items="${category.itemList}" var="item">
		<%-- prints the link to an item via the item name from a list of items for the specified category and item id --%>
			<ul>
			<li><a href="AuctionController?itemID=${item.itemID}&categoryID=${item.catID}">${item.itemName}</a></li>
			</ul>
		</c:forEach>
	</c:forEach>
</div>

<div id="content">
<h2 class="center">Welcome to Cypress Point Charity Auction</h2>
	<div class="photo"><img src="http://img1.findthebest.com/sites/default/files/356/media/images/Cypress_Point_Club_in_Pebble_Beach_California.jpg" width="640" height="480" alt="Cypress Point Golf Club"></div>
<br>
<p>This auction and its proceeds go to benefit the children of Detroit, Michigan.  This third-world
arena desperately needs the help that our limitless checkbooks can provide. Enjoy a round at one of
this country's most impressive courses as a member for the day or pick up some top-of-the-line 
equipment to take your game to the next level. Hell, why not do both.</p>
<br>
<h2>How to begin your bidding:</h2>
<p>Click on any of the links at left to view an item for which you wish to place a bid. Please fill
out the bidder information in the form provided when placing a bid. In order for a bid to be
successful the dollar amount placed must be higher than the current bid displayed for your item
of choice.</p>
<h3>Sources:</h3>
<p>The login information for the admin page is: user name = ntray  password = marley1</p>
<p>The font license for the font used in the header on all pages is located in the fonts folder of the web folder on my VM</p>
<p>The color palette used for this project is Frog Prince. All styling is accomplished via my style.css sheet located in the web folder on my VM</p>
<p><b>Cypress Point logo:</b><br>
http://www.montereygolf.com/course-guide/logo/thumb/14937.jpg</p>
<p><b>Cypress Point welcome page photo:</b><br>
http://img1.findthebest.com/sites/default/files/356/media/images/<br>Cypress_Point_Club_in_Pebble_Beach_California.jpg</p>
<p><b>Cypress Point item page photo:</b><br>
http://mw2.google.com/mw-panoramio/photos/medium/2357078.jpg</p>
<p><b>Pebble Beach item page photo:</b><br>
http://www.andavotravel.com/blog/wp-content/uploads/2011/06/pebblebeach.jpg</p>
<p><b>Spanish Bay item page photo:</b><br>
http://blog.forelinksters.com/wp-content/uploads/2010/02/spanish.jpg</p>
<p><b>TaylorMade irons item page photo:</b><br>
http://uncrate.com/p/2012/10/taylormade-rocketbladez-xl.jpg</p>
<p><b>TaylorMade driver item page photo:</b><br>
http://thesandtrap.com/b/imgs/clubs/taylormade_r11_driver_hero.jpg</p>
<p><b>Mizuno irons item page photo:</b><br>
http://www.maplehillgc.com/images/MizMP69Iron.png</p>
<p><b>Mizuno driver item page photo:</b><br>
http://golf-monthly.media.ipcdigital.co.uk/11136/000002a80/a353/Mizuno-MP630-FT.jpg</p>
<p><b>Titleist irons item page photo:</b><br>
http://www.footjoy.com/community/cfs-file.ashx/__key/CommunityServer.Discussions.Components.Files/22/<br>6862.mb_5F00_back_5F00_2009_5F00_full.jpg</p>
<p><b>Titleist driver item page photo:</b><br>
http://1.bp.blogspot.com/_hGuTx-bvyk0/SO5wxK2cjnI/AAAAAAAABas/NAdEZjPpRFc/s400/Titleist-909-Driver_299.jpg</p>
</div>

<div id="footer">
<a href="AuctionController?login=true">Admin</a>
</div>

</div><%-- end page-wrap --%>

</body>
</html>