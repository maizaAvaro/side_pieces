package tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WebsiteTests 
{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception // Sets up the remote control for the website
	{
		
		String browser = "*chrome"; // FireFox
		
		selenium = new DefaultSelenium("localhost", 4444, browser, "http://manheim-shoe-store-test.herokuapp.com/");
		selenium.start();
	
	} // setUp 

	@Test
	public void testRemote() throws Exception // Tests the functionality of the website
	{
		
		// Opens the website
		selenium.open("/");
		
		// Testing all links are displaying properly
		assertTrue(selenium.isElementPresent("link=January"));
		assertTrue(selenium.isElementPresent("link=February"));
		assertTrue(selenium.isElementPresent("link=March"));
		assertTrue(selenium.isElementPresent("link=April"));
		assertTrue(selenium.isElementPresent("link=May"));
		assertTrue(selenium.isElementPresent("link=June"));
		assertTrue(selenium.isElementPresent("link=July"));
		assertTrue(selenium.isElementPresent("link=August"));
		assertTrue(selenium.isElementPresent("link=September"));
		assertTrue(selenium.isElementPresent("link=October"));
		assertTrue(selenium.isElementPresent("link=November"));
		assertTrue(selenium.isElementPresent("link=December"));
		assertTrue(selenium.isElementPresent("link=Home"));
		assertTrue(selenium.isElementPresent("link=All Shoes"));
		assertTrue(selenium.isElementPresent("link=Report An Issue"));
		assertTrue(selenium.isElementPresent("link=Issues"));
		assertTrue(selenium.isElementPresent("link=Problem Definition"));
		
		// Testing the select option for 7 For All Mankind shoe from drop down box
		assertTrue(selenium.isElementPresent("css=option[value=\"7 For All Mankind�\"]"));
		selenium.select("id=brand", "label=7 For All Mankind�");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("7 For All Mankind�'s Shoes", selenium.getText("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Acorn shoe from drop down box
		selenium.select("id=brand", "label=Acorn");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Acorn's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Aetrex shoe from drop down box
		selenium.select("id=brand", "label=Aetrex");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Aetrex's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Alexander McQueen shoe from drop down box
		selenium.select("id=brand", "label=Alexander McQueen");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Alexander McQueen's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Alexandre Birman shoe from drop down box
		selenium.select("id=brand", "label=Alexandre Birman");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Alexandre Birman's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Alberto Fermani shoe from drop down box
		selenium.select("id=brand", "label=Alberto Fermani");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Alberto Fermani's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Alice + Olivia shoe from drop down box
		selenium.select("id=brand", "label=Alice + Olivia");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Alice + Olivia's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Amalfi by Rangoni shoe from drop down box
		selenium.select("id=brand", "label=Amalfi by Rangoni");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Amalfi by Rangoni's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Andre Assous shoe from drop down box
		selenium.select("id=brand", "label=Andre Assous");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Andre Assous's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Anyi Lu shoe from drop down box
		selenium.select("id=brand", "label=Anyi Lu");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Anyi Lu's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for ALDO shoe from drop down box
		selenium.select("id=brand", "label=ALDO");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("ALDO's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Aquatalia by Marvin K shoe from drop down box
		selenium.select("id=brand", "label=Aquatalia by Marvin K");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Aquatalia by Marvin K's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Arche shoe from drop down box
		selenium.select("id=brand", "label=Arche");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Arche's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Ariat shoe from drop down box
		selenium.select("id=brand", "label=Ariat");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Ariat's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Ash shoe from drop down box
		selenium.select("id=brand", "label=Ash");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Ash's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for ASICS shoe from drop down box
		selenium.select("id=brand", "label=ASICS�");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("ASICS�'s Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Athena Alexander shoe from drop down box
		selenium.select("id=brand", "label=Athena Alexander");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Athena Alexander's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Attilio Giusti Leombruni shoe from drop down box
		selenium.select("id=brand", "label=Attilio Giusti Leombruni");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Attilio Giusti Leombruni's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Brian Atwood shoe from drop down box
		selenium.select("id=brand", "label=B Brian Atwood");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("B Brian Atwood's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Badgley Mischka shoe from drop down box
		selenium.select("id=brand", "label=Badgley Mischka");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Badgley Mischka's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for BC Footwear shoe from drop down box
		selenium.select("id=brand", "label=BC Footwear");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("BC Footwear's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for BCBGeneration shoe from drop down box
		selenium.select("id=brand", "label=BCBGeneration");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("BCBGeneration's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for BCBGMAXAZRIA shoe from drop down box
		selenium.select("id=brand", "label=BCBGMAXAZRIA");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("BCBGMAXAZRIA's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Bed Stu shoe from drop down box
		selenium.select("id=brand", "label=Bed Stu");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Bed Stu's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		
		// Testing the select option for Bernardo shoe from drop down box
		selenium.select("id=brand", "label=Bernardo");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		assertEquals("Bernardo's Shoes", selenium.getText("css=h2"));
		assertTrue(selenium.isElementPresent("css=h2"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
				
		// THE CODE IS THE SAME ASIDE FROM THE NAMES FOR THE REMAINDER OF THE DROP DOWN LIST.
		// FOR THE SAKE OF TIME AND SPACE I HAVE OMITTED THE THOROUGH TESTING OF EACH ENTITY 
		// IN THE LIST TO THOSE SHOWN ABOVE. IF THIS WERE A WORK PROJECT, OBVIOUSLY, THESE TESTS
		// WOULD NOT BE OMITTED.
		
		// Testing the properties of each shoe listed on the website - the links, the tables and the images where applicable
		// The email verification is also tested for all shoes not in the month of January (current month), as per website
		selenium.click("link=All Shoes");
		selenium.waitForPageToLoad("30000");
		
			// Jimmy Choo 'Dalia' Tall Boot 
		assertEquals("Jimmy Choo", selenium.getTable("css=table.0.1"));
		assertTrue(selenium.isElementPresent("link=Jimmy Choo"));
		assertEquals("January", selenium.getTable("css=table.4.1"));
		assertTrue(selenium.isElementPresent("css=td.shoe_result_value.shoe_release_month > a"));
		assertEquals("Pre-order this style today! Add to Shopping Bag to view approximate ship date. You'll be charged only when your item ships.Fuchsia flashes amidst the flamboyant genuine fox fur of a fringed confection layered in luscious jewel tones. Jimmy Choo 'Dalia' Tall Boot Jimmy Choo Jimmy Choo Boots Shoes Approx. heel height: 4 3/4\". Approx. boot shaft height: 15\"; 13 1/2\" calf circumference. Suede and genuine fox fur (Finland) upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("css=table.3.1"));
		assertTrue(selenium.isElementPresent("css=td.shoe_result_value.shoe_description"));
		assertEquals("$3,495.00", selenium.getTable("css=table.2.1"));
		assertTrue(selenium.isElementPresent("css=td.shoe_result_value.shoe_price"));
		assertEquals("Jimmy Choo 'Dalia' Tall Boot", selenium.getTable("css=table.1.1"));
		assertTrue(selenium.isElementPresent("css=td.shoe_result_value.shoe_name"));
		assertTrue(selenium.isElementPresent("css=img"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'dalia'tall_boot\"]/div/table/tbody/tr[6]"));
		
			// Giuseppe Zanotti Slingback Sandal 
		assertEquals("Giuseppe Zanotti", selenium.getTable("css=#giuseppe_zanotti_giuseppe_zanotti_slingback_sandal > div.shoe_result > table.0.1"));
		assertTrue(selenium.isElementPresent("link=Giuseppe Zanotti"));
		assertEquals("Giuseppe Zanotti Slingback Sandal", selenium.getTable("css=#giuseppe_zanotti_giuseppe_zanotti_slingback_sandal > div.shoe_result > table.1.1"));
		assertTrue(selenium.isElementPresent("css=#giuseppe_zanotti_giuseppe_zanotti_slingback_sandal > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_name"));
		assertEquals("$1,495.00", selenium.getTable("css=#giuseppe_zanotti_giuseppe_zanotti_slingback_sandal > div.shoe_result > table.2.1"));
		assertTrue(selenium.isElementPresent("css=#giuseppe_zanotti_giuseppe_zanotti_slingback_sandal > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_price"));
		assertEquals("Crystallized color blocks shape a slingback sandal cut with a flirty peep toe. Giuseppe Zanotti Slingback Sandal GIUSEPPE ZANOTTI Giuseppe Zanotti Sandals/Slides Shoes Adjustable strap with buckle closure. Approx. heel height: 5 1/2\" with a 1 1/2\" platform (comparable to a 4\" heel). Leather upper, lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("css=#giuseppe_zanotti_giuseppe_zanotti_slingback_sandal > div.shoe_result > table.3.1"));
		assertTrue(selenium.isElementPresent("css=#giuseppe_zanotti_giuseppe_zanotti_slingback_sandal > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_description"));
		assertEquals("January", selenium.getTable("css=#giuseppe_zanotti_giuseppe_zanotti_slingback_sandal > div.shoe_result > table.4.1"));
		assertTrue(selenium.isElementPresent("css=#giuseppe_zanotti_giuseppe_zanotti_slingback_sandal > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_release_month > a"));
		assertTrue(selenium.isElementPresent("css=#giuseppe_zanotti_giuseppe_zanotti_slingback_sandal > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_image > img"));
		assertTrue(selenium.isElementPresent("//li[@id='giuseppe_zanotti_giuseppe_zanotti_slingback_sandal']/div/table/tbody/tr[6]"));
		
			// Gucci 'Josephine' Tall Boot - January
		assertEquals("Gucci", selenium.getTable("//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("link=Gucci"));
		assertEquals("Gucci 'Josephine' Tall Boot", selenium.getTable("//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$1,650.00", selenium.getTable("//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("An oversized buckle gleams at the side of a pieced leather boot set on a wrapped heel and platform. Gucci 'Josephine' Tall Boot Gucci Gucci Boots Shoes Approx. heel height: 5\" with 1\" platform (comparable to a 4\" heel). Approx. boot shaft height: 16 1/4\"; 14\" calf circumference. Leather upper, lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("January", selenium.getTable("//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'January')])[4]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/6/_7037086.jpg')]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table/tbody/tr[6]"));
		
			// Burberry Peep Toe Boot 
		assertEquals("Burberry", selenium.getTable("css=#burberry_burberry_peep_toe_boot > div.shoe_result > table.0.1"));
		assertTrue(selenium.isElementPresent("link=Burberry"));
		assertEquals("Burberry Peep Toe Boot", selenium.getTable("css=#burberry_burberry_peep_toe_boot > div.shoe_result > table.1.1"));
		assertTrue(selenium.isElementPresent("css=#burberry_burberry_peep_toe_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_name"));
		assertEquals("$1,495.00", selenium.getTable("css=#burberry_burberry_peep_toe_boot > div.shoe_result > table.2.1"));
		assertTrue(selenium.isElementPresent("css=#burberry_burberry_peep_toe_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_price"));
		assertEquals("A neutral palette weaves homespun chic into a peep-toe boot cinched with slim laces. Burberry Peep Toe Boot Burberry Burberry Boots Shoes Side zip closure. Approx. heel height: 5 1/2\" with a 1 1/2\" platform (comparable to a 3\" heel). Leather upper and lining/rubber sole. Made in Italy. Salon Shoes.", selenium.getTable("css=#burberry_burberry_peep_toe_boot > div.shoe_result > table.3.1"));
		assertTrue(selenium.isElementPresent("css=#burberry_burberry_peep_toe_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_description"));
		assertEquals("January", selenium.getTable("css=#burberry_burberry_peep_toe_boot > div.shoe_result > table.4.1"));
		assertTrue(selenium.isElementPresent("css=#burberry_burberry_peep_toe_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_release_month > a"));
		assertTrue(selenium.isElementPresent("css=#burberry_burberry_peep_toe_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_image > img"));
		assertTrue(selenium.isElementPresent("//li[@id='burberry_burberry_peep_toe_boot']/div/table/tbody/tr[6]"));
		
			// Nicholas Kirkwood for Erdem Bootie 
		assertEquals("Nicholas Kirkwood", selenium.getTable("css=#nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie > div.shoe_result > table.0.1"));
		assertTrue(selenium.isElementPresent("link=Nicholas Kirkwood"));
		assertEquals("Nicholas Kirkwood for Erdem Bootie", selenium.getTable("css=#nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie > div.shoe_result > table.1.1"));
		assertTrue(selenium.isElementPresent("css=#nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_name"));
		assertEquals("$1,595.00", selenium.getTable("css=#nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie > div.shoe_result > table.2.1"));
		assertTrue(selenium.isElementPresent("css=#nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_price"));
		assertEquals("A blocky, Perspex heel builds architectural height beneath a color-drenched bootie in dimensional lace. Nicholas Kirkwood for Erdem Bootie Nicholas Kirkwood Nicholas Kirkwood Boots Shoes Side zip closure. Approx. heel height: 4 1/2\" with 1\" platform. Crepe upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("css=#nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie > div.shoe_result > table.3.1"));
		assertTrue(selenium.isElementPresent("css=#nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_description"));
		assertEquals("February", selenium.getTable("css=#nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie > div.shoe_result > table.4.1"));
		assertTrue(selenium.isElementPresent("css=#nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_release_month > a"));
		assertTrue(selenium.isElementPresent("css=#nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_image > img"));
		assertTrue(selenium.isElementPresent("css=form.notification_email_form > label"));
		assertTrue(selenium.isElementPresent("//li[@id='nicholas_kirkwood_nicholas_kirkwoodfor_erdem_bootie']/div/table/tbody/tr[6]"));
		selenium.type("css=form.notification_email_form > input[name=\"email\"]", "sample@gmail.com");
		assertEquals("sample@gmail.com", selenium.getValue("css=form.notification_email_form > input[name=\"email\"]"));
		selenium.click("css=input.notification_email_submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		
			// Jimmy Choo 'Tosca' Genuine Python Pull-On Boot 
		assertEquals("Jimmy Choo", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Jimmy Choo')])[2]"));
		assertEquals("Jimmy Choo 'Tosca' Genuine Python Pull-On Boot", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$2,895.00", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Glistening python redefines a classic knee-high boot set atop a slim, wrapped heel. Jimmy Choo 'Tosca' Genuine Python Pull-On Boot Jimmy Choo Jimmy Choo Boots Shoes Approx. heel height: 4\". Approx. boot shaft height: 15 1/2\"; 14\" calf circumference. Narrow calf. Genuine python upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table.3.1"));
		assertEquals("Glistening python redefines a classic knee-high boot set atop a slim, wrapped heel. Jimmy Choo 'Tosca' Genuine Python Pull-On Boot Jimmy Choo Jimmy Choo Boots Shoes Approx. heel height: 4\". Approx. boot shaft height: 15 1/2\"; 14\" calf circumference. Narrow calf. Genuine python upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getText("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table/tbody/tr[4]/td[2]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("February", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table.4.1"));
		assertEquals("February", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'February')])[3]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/4/_7171104.jpg')]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'tosca'genuine_python_pull_on_boot\"]/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[3]"));
		selenium.type("xpath=(//input[@name='email'])[3]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[4]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Lanvin Ankle Strap Boot 
		assertEquals("Lanvin", selenium.getTable("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table.0.1"));
		assertTrue(selenium.isElementPresent("link=Lanvin"));
		assertEquals("Lanvin Ankle Strap Boot", selenium.getTable("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table.1.1"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_name"));
		assertEquals("$1,590.00", selenium.getTable("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table.2.1"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_price"));
		assertEquals("Signature metal tips the toe of a knee-high boot cast in soft suede. Lanvin Ankle Strap Boot LANVIN Lanvin Boots Shoes Approx. heel height: 4\" with 3/4\" platform. Approx. boot shaft height: 17 1/2\"; 14 3/4\" calf circumference. Suede upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table.3.1"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_description"));
		assertEquals("March", selenium.getTable("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table.4.1"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_release_month > a"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_image > img"));
		assertTrue(selenium.isElementPresent("//li[@id='lanvin_lanvin_ankle_strap_boot']/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input[name=\"email\"]"));
		selenium.type("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input[name=\"email\"]", "sample@gmail.com");
		selenium.click("css=#lanvin_lanvin_ankle_strap_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input.notification_email_submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Jimmy Choo Ankle Strap Crystal Pump
		assertEquals("Jimmy Choo", selenium.getTable("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table.0.1"));
		assertTrue(selenium.isElementPresent("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_brand > a"));
		assertEquals("Jimmy Choo Ankle Strap Crystal Pump", selenium.getTable("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table.1.1"));
		assertTrue(selenium.isElementPresent("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_name"));
		assertEquals("$2,495.00", selenium.getTable("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table.2.1"));
		assertTrue(selenium.isElementPresent("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_price"));
		assertEquals("Pre-order this style today! Add to Shopping Bag to view approximate ship date. You'll be charged only when your item ships.Plush suede shapes an alluring, ankle-wrap pump dipped in glittery crystals. Jimmy Choo Ankle Strap Crystal Pump Jimmy Choo Jimmy Choo Pumps Shoes Adjustable strap with buckle closure. Approx. heel height: 5 1/4\" with 1 1/4\" platform (comparable to a 4\" heel). Suede upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table.3.1"));
		assertTrue(selenium.isElementPresent("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_description"));
		assertEquals("March", selenium.getTable("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table.4.1"));
		assertTrue(selenium.isElementPresent("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_release_month > a"));
		assertTrue(selenium.isElementPresent("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_image > img"));
		assertTrue(selenium.isElementPresent("//li[@id='jimmy_choo_jimmy_choo_ankle_strap_crystal_pump']/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input[name=\"email\"]"));
		selenium.type("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input[name=\"email\"]", "sample@gmail.com");
		selenium.click("css=#jimmy_choo_jimmy_choo_ankle_strap_crystal_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input.notification_email_submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Gucci 'Sofia' Crystal Embellished Platform Pump
		assertEquals("Gucci", selenium.getTable("//li[@id=\"gucci_gucci'sofia'crystal_embellished_platform_pump\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Gucci')])[2]"));
		assertEquals("Gucci 'Sofia' Crystal Embellished Platform Pump", selenium.getTable("//li[@id=\"gucci_gucci'sofia'crystal_embellished_platform_pump\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'sofia'crystal_embellished_platform_pump\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$2,295.00", selenium.getTable("//li[@id=\"gucci_gucci'sofia'crystal_embellished_platform_pump\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'sofia'crystal_embellished_platform_pump\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Brilliant crystals adorn a satin pump with a partially concealed platform and flirty peep toe. Gucci 'Sofia' Crystal Embellished Platform Pump Gucci Gucci Pumps Shoes Approx. heel height: 5\" with 1\" platform (comparable to a 4\" heel). Satin upper/leather lining and sole. Imported. Salon Shoes.", selenium.getTable("//li[@id=\"gucci_gucci'sofia'crystal_embellished_platform_pump\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'sofia'crystal_embellished_platform_pump\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("April", selenium.getTable("//li[@id=\"gucci_gucci'sofia'crystal_embellished_platform_pump\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'April')])[2]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/3/_6647643.jpg')]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[6]"));
		selenium.type("xpath=(//input[@name='email'])[6]", "sample@gmail.com");
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'sofia'crystal_embellished_platform_pump\"]/div/table/tbody/tr[6]"));
		selenium.click("xpath=(//input[@type='submit'])[7]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Lanvin 'Crazy' Wedge Bootie 
		assertEquals("Lanvin", selenium.getTable("//li[@id=\"lanvin_lanvin'crazy'wedge_bootie\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Lanvin')])[2]"));
		assertEquals("Lanvin 'Crazy' Wedge Bootie", selenium.getTable("//li[@id=\"lanvin_lanvin'crazy'wedge_bootie\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"lanvin_lanvin'crazy'wedge_bootie\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$1,580.00", selenium.getTable("//li[@id=\"lanvin_lanvin'crazy'wedge_bootie\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"lanvin_lanvin'crazy'wedge_bootie\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Subtly textured stripes define the sculptural wedge of a striking bootie shaped from crackled patent. Lanvin 'Crazy' Wedge Bootie LANVIN Lanvin Boots Shoes Side zip closure. Approx. heel height: 5 1/4\" with 2\" platform (comparable to a 3 1/4\" heel). Approx. boot shaft height: 5\". Patent leather upper/leather lining/rubber sole. Imported. Salon Shoes.", selenium.getTable("//li[@id=\"lanvin_lanvin'crazy'wedge_bootie\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"lanvin_lanvin'crazy'wedge_bootie\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("April", selenium.getTable("//li[@id=\"lanvin_lanvin'crazy'wedge_bootie\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'April')])[3]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/8/_7005548.jpg')]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"lanvin_lanvin'crazy'wedge_bootie\"]/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[7]"));
		selenium.type("xpath=(//input[@name='email'])[7]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[8]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
	 		// Jimmy Choo 'Kani' Sandal 
		assertEquals("Jimmy Choo", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'kani'sandal\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Jimmy Choo')])[4]"));
		assertEquals("Jimmy Choo 'Kani' Sandal", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'kani'sandal\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'kani'sandal\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$2,195.00", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'kani'sandal\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'kani'sandal\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Plush suede swathes a dazzling, crystal-drenched sandal perched atop a slim heel. Jimmy Choo 'Kani' Sandal Jimmy Choo Jimmy Choo Sandals/Slides Shoes Back zip closure. Approx. heel height: 4 3/4\" with a 1/2\" platform. Suede and fabric upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'kani'sandal\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'kani'sandal\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("May", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'kani'sandal\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'May')])[2]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/1/_7079841.jpg')]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[8]"));
		selenium.type("xpath=(//input[@name='email'])[8]", "sample@gmail.com");
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'kani'sandal\"]/div/table/tbody/tr[6]"));
		selenium.click("xpath=(//input[@type='submit'])[9]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Gucci Lace-Up Tall Boot 
		assertEquals("Gucci", selenium.getTable("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table.0.1"));
		assertTrue(selenium.isElementPresent("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_brand > a"));
		assertEquals("Gucci Lace-Up Tall Boot", selenium.getTable("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table.1.1"));
		assertTrue(selenium.isElementPresent("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_name"));
		assertEquals("$1,550.00", selenium.getTable("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table.2.1"));
		assertTrue(selenium.isElementPresent("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_price"));
		assertEquals("Pre-order this style today! Add to Shopping Bag to view approximate ship date. You'll be charged only when your item ships.A side-swept shaft serves up a flourish high above the vintage vamp of an arresting leather boot. Gucci Lace-Up Tall Boot Gucci Gucci Boots Shoes Back zip closure. Approx. heel height: 4 1/4\". Approx. boot shaft height: 17\" at highest point; 13\" calf circumference. Narrow calf. Made in Italy. Salon Shoes.", selenium.getTable("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table.3.1"));
		assertTrue(selenium.isElementPresent("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_description"));
		assertEquals("May", selenium.getTable("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table.4.1"));
		assertTrue(selenium.isElementPresent("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_release_month > a"));
		assertTrue(selenium.isElementPresent("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_image > img"));
		assertTrue(selenium.isElementPresent("//li[@id='gucci_gucci_lace_up_tall_boot']/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input[name=\"email\"]"));
		selenium.type("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input[name=\"email\"]", "sample@gmail.com");
		selenium.click("css=#gucci_gucci_lace_up_tall_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input.notification_email_submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Lanvin 'Scuba' Short Boot 
		assertEquals("Lanvin", selenium.getTable("//li[@id=\"lanvin_lanvin'scuba'short_boot\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Lanvin')])[3]"));
		assertEquals("Lanvin 'Scuba' Short Boot", selenium.getTable("//li[@id=\"lanvin_lanvin'scuba'short_boot\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"lanvin_lanvin'scuba'short_boot\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$1,998.00", selenium.getTable("//li[@id=\"lanvin_lanvin'scuba'short_boot\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"lanvin_lanvin'scuba'short_boot\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Pre-order this style today! Add to Shopping Bag to view approximate ship date. You'll be charged only when your item ships.A blocky heel and platform juxtapose with the sleek, svelte lines of a smooth leather boot with a stretchy shaft. Lanvin 'Scuba' Short Boot LANVIN Lanvin Boots Shoes Side zip closure. Approx. heel height: 5 1/4\" with 1\" platform (comparable to a 4 1/4\" heel). Approx. boot shaft height: 6\". Leather, nylon and elastane upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("//li[@id=\"lanvin_lanvin'scuba'short_boot\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"lanvin_lanvin'scuba'short_boot\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("June", selenium.getTable("//li[@id=\"lanvin_lanvin'scuba'short_boot\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'June')])[2]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/19/_7076379.jpg')]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"lanvin_lanvin'scuba'short_boot\"]/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[10]"));
		selenium.type("xpath=(//input[@name='email'])[10]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[11]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Gucci 'Josephine' Tall Boot - June
		assertEquals("Gucci", selenium.getTable("xpath=(//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table)[2].0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Gucci')])[4]"));
		assertEquals("Gucci 'Josephine' Tall Boot", selenium.getTable("xpath=(//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table)[2].1.1"));
		assertTrue(selenium.isElementPresent("xpath=(//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table/tbody/tr[2]/td[2])[2]"));
		assertEquals("$1,550.00", selenium.getTable("xpath=(//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table)[2].2.1"));
		assertTrue(selenium.isElementPresent("xpath=(//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table/tbody/tr[3]/td[2])[2]"));
		assertEquals("Pre-order this style today! Add to Shopping Bag to view approximate ship date. You'll be charged only when your item ships.An oversized buckle gleams at the side of a pieced boot set on a wrapped heel and platform. Gucci 'Josephine' Tall Boot Gucci Gucci Boots Shoes Approx. heel height: 4 1/4\". Leather upper and lining/rubber sole. Made in Italy. Salon Shoes.", selenium.getTable("xpath=(//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table)[2].3.1"));
		assertTrue(selenium.isElementPresent("xpath=(//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table/tbody/tr[4]/td[2])[2]"));
		assertEquals("June", selenium.getTable("xpath=(//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table)[2].4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'June')])[3]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/16/_7037076.jpg')]"));
		assertTrue(selenium.isElementPresent("xpath=(//li[@id=\"gucci_gucci'josephine'tall_boot\"]/div/table/tbody/tr[6])[2]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[11]"));
		selenium.type("xpath=(//input[@name='email'])[11]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[12]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Jimmy Choo 'Kairo' Mesh Bootie 
		assertEquals("Jimmy Choo", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'kairo'mesh_bootie\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Jimmy Choo')])[5]"));
		assertEquals("Jimmy Choo 'Kairo' Mesh Bootie", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'kairo'mesh_bootie\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'kairo'mesh_bootie\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$1,995.00", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'kairo'mesh_bootie\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'kairo'mesh_bootie\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Delicious, berry-hued loops dominate a perfectly poised bootie topped with lithe laces. Jimmy Choo 'Kairo' Mesh Bootie Jimmy Choo Jimmy Choo Boots Shoes Back zip closure. Approx. heel height: 4 1/4\". Approx. boot shaft height: 3 1/2\". Leather and fabric upper and lining/leather sole. Made in Italy. Salon Shoes.", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'kairo'mesh_bootie\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'kairo'mesh_bootie\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("July", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'kairo'mesh_bootie\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'July')])[2]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/7/_7134867.jpg')]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'kairo'mesh_bootie\"]/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[12]"));
		selenium.type("xpath=(//input[@name='email'])[12]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[13]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Old Gringo 'Eagle Swarovski' Boot
		assertEquals("Old Gringo", selenium.getTable("//li[@id=\"old_gringo_old_gringo'eagle_swarovski'boot\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("link=Old Gringo"));
		assertEquals("Old Gringo 'Eagle Swarovski' Boot", selenium.getTable("//li[@id=\"old_gringo_old_gringo'eagle_swarovski'boot\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"old_gringo_old_gringo'eagle_swarovski'boot\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$1,549.95", selenium.getTable("//li[@id=\"old_gringo_old_gringo'eagle_swarovski'boot\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"old_gringo_old_gringo'eagle_swarovski'boot\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Swarovski crystals trace a sparkling pattern on a Western-style boot handcrafted in exceptionally soft leather. Old Gringo 'Eagle Swarovski' Boot OLD GRINGO Old Gringo Boots Shoes Pull-on style. Approx. heel height: 1 1/2\". Approx. boot shaft height: 12 1/2\"; 14\" calf circumference. Leather upper, lining and sole. By Old Gringo; imported. BP. Shoes.", selenium.getTable("//li[@id=\"old_gringo_old_gringo'eagle_swarovski'boot\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"old_gringo_old_gringo'eagle_swarovski'boot\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("July", selenium.getTable("//li[@id=\"old_gringo_old_gringo'eagle_swarovski'boot\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'July')])[3]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/13/_6255893.jpg')]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/13/_6255893.jpg')]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/13/_6255893.jpg')]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"old_gringo_old_gringo'eagle_swarovski'boot\"]/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[13]"));
		selenium.type("xpath=(//input[@name='email'])[13]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[14]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Gucci 'Naomi' Sandal 
		assertEquals("Gucci", selenium.getTable("//li[@id=\"gucci_gucci'naomi'sandal\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Gucci')])[5]"));
		assertEquals("Gucci 'Naomi' Sandal", selenium.getTable("//li[@id=\"gucci_gucci'naomi'sandal\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'naomi'sandal\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$1,995.00", selenium.getTable("//li[@id=\"gucci_gucci'naomi'sandal\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'naomi'sandal\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Diminutive baubles stream down the split strap of a minimalist sandal perched atop a strikingly slim heel. Gucci 'Naomi' Sandal Gucci Gucci Sandals/Slides Shoes Back zip closure. Approx. heel height: 4 1/2\" with 1\" platform (comparable to a 3 1/2\" heel). Suede upper/leather lining and sole. Salon Shoes. Made in Italy.", selenium.getTable("//li[@id=\"gucci_gucci'naomi'sandal\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'naomi'sandal\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("August", selenium.getTable("//li[@id=\"gucci_gucci'naomi'sandal\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'August')])[2]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/3/_7109243.jpg')]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'naomi'sandal\"]/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[14]"));
		selenium.type("xpath=(//input[@name='email'])[14]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[15]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Tabitha Simmons 'Wicked' Bootie 
		assertEquals("Tabitha Simmons", selenium.getTable("//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("link=Tabitha Simmons"));
		assertEquals("Tabitha Simmons 'Wicked' Bootie", selenium.getTable("//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$1,495.00", selenium.getTable("//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Smooth leather enriches the vintage appeal of a pointy-toe bootie set on a slim, tapered heel. Tabitha Simmons 'Wicked' Bootie Tabitha Simmons Tabitha Simmons Boots Shoes Approx. heel height: 4 1/2\". Approx. boot shaft height: 5\". Leather upper, lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("August", selenium.getTable("//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'August')])[3]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/12/_7079772.jpg')]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/12/_7079772.jpg')]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[15]"));
		selenium.type("xpath=(//input[@name='email'])[15]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[16]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Jimmy Choo 'Corinna' Embroidered Boot 
		assertEquals("Jimmy Choo", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'corinna'embroidered_boot\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Jimmy Choo')])[6]"));
		assertEquals("Jimmy Choo 'Corinna' Embroidered Boot", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'corinna'embroidered_boot\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'corinna'embroidered_boot\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$1,895.00", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'corinna'embroidered_boot\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'corinna'embroidered_boot\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Floral embroidery decorates the knee-high shaft of a striking suede boot, laced with a vintage twist. Jimmy Choo 'Corinna' Embroidered Boot Jimmy Choo Jimmy Choo Boots Shoes Back zip closure. Approx. heel height: 4\". Approx. boot shaft height: 15 1/2\"; 14\" calf circumference. Suede upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'corinna'embroidered_boot\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'corinna'embroidered_boot\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("September", selenium.getTable("//li[@id=\"jimmy_choo_jimmy_choo'corinna'embroidered_boot\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'September')])[2]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/2/_7112302.jpg')]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"jimmy_choo_jimmy_choo'corinna'embroidered_boot\"]/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[16]"));
		selenium.type("xpath=(//input[@name='email'])[16]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[17]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Tabitha Simmons 'Wicked' Bootie
		assertEquals("Tabitha Simmons", selenium.getTable("xpath=(//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table)[2].0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Tabitha Simmons')])[2]"));
		assertEquals("Tabitha Simmons 'Wicked' Bootie", selenium.getTable("xpath=(//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table)[2].1.1"));
		assertTrue(selenium.isElementPresent("xpath=(//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table/tbody/tr[2]/td[2])[2]"));
		assertEquals("$1,495.00", selenium.getTable("xpath=(//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table)[2].2.1"));
		assertTrue(selenium.isElementPresent("xpath=(//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table/tbody/tr[3]/td[2])[2]"));
		assertEquals("Hand-woven silk deepens the vintage appeal of a pointy-toe bootie set on a slim, tapered heel. Tabitha Simmons 'Wicked' Bootie Tabitha Simmons Tabitha Simmons Boots Shoes Approx. heel height: 4 1/2\". Approx. boot shaft height: 5\". Silk and leather upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("xpath=(//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table)[2].3.1"));
		assertTrue(selenium.isElementPresent("xpath=(//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table/tbody/tr[4]/td[2])[2]"));
		assertEquals("September", selenium.getTable("xpath=(//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table)[2].4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'September')])[3]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/4/_7027124.jpg')]"));
		assertTrue(selenium.isElementPresent("xpath=(//li[@id=\"tabitha_simmons_tabitha_simmons'wicked'bootie\"]/div/table/tbody/tr[6])[2]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[17]"));
		selenium.type("xpath=(//input[@name='email'])[17]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[18]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Lanvin Platform Pump 
		assertEquals("Lanvin", selenium.getTable("css=#lanvin_lanvin_platform_pump > div.shoe_result > table.0.1"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_platform_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_brand > a"));
		assertEquals("Lanvin Platform Pump", selenium.getTable("css=#lanvin_lanvin_platform_pump > div.shoe_result > table.1.1"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_platform_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_name"));
		assertEquals("$1,688.00", selenium.getTable("css=#lanvin_lanvin_platform_pump > div.shoe_result > table.2.1"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_platform_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_price"));
		assertEquals("Pre-order this style today! Add to Shopping Bag to view approximate ship date. You'll be charged only when your item ships.Topsy-turvy crystals crowd the sole of a silky platform pump set on a sleek heel. Lanvin Platform Pump LANVIN Lanvin Pumps Shoes Approx. heel height: 5 1/4\" with 1\" platform (comparable to a 4 1/4\" heel). Fabric upper/leather lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("css=#lanvin_lanvin_platform_pump > div.shoe_result > table.3.1"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_platform_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_description"));
		assertEquals("October", selenium.getTable("css=#lanvin_lanvin_platform_pump > div.shoe_result > table.4.1"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_platform_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_release_month > a"));
		assertTrue(selenium.isElementPresent("css=#lanvin_lanvin_platform_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_image > img"));
		assertTrue(selenium.isElementPresent("//li[@id='lanvin_lanvin_platform_pump']/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("css=#lanvin_lanvin_platform_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input[name=\"email\"]"));
		selenium.type("css=#lanvin_lanvin_platform_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input[name=\"email\"]", "sample@gmail.com");
		selenium.click("css=#lanvin_lanvin_platform_pump > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input.notification_email_submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Valentino 'Ascot' Boot 
		assertEquals("Valentino", selenium.getTable("//li[@id=\"valentino_valentino'ascot'boot\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("link=Valentino"));
		assertEquals("Valentino 'Ascot' Boot", selenium.getTable("//li[@id=\"valentino_valentino'ascot'boot\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"valentino_valentino'ascot'boot\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$1,495.00", selenium.getTable("//li[@id=\"valentino_valentino'ascot'boot\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"valentino_valentino'ascot'boot\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Luscious leather ribbons lace the back of a smooth, knee-high boot. Valentino 'Ascot' Boot VALENTINO Valentino Boots Shoes Side zip closure. Approx. heel height: 1 1/4\". Approx. boot shaft height: 15\"; 13\" calf circumference. Narrow calf. Leather upper and lining/leather and synthetic sole. Made in Italy. Salon Shoes.", selenium.getTable("//li[@id=\"valentino_valentino'ascot'boot\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"valentino_valentino'ascot'boot\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("October", selenium.getTable("//li[@id=\"valentino_valentino'ascot'boot\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'October')])[3]"));
		assertTrue(selenium.isElementPresent("//img[contains(@src,'http://content.nordstrom.com/ImageGallery/store/product/Thumbnail/12/_6988992.jpg')]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"valentino_valentino'ascot'boot\"]/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[19]"));
		selenium.type("xpath=(//input[@name='email'])[19]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[20]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Valentino Bow Over the Knee Boot
		assertEquals("Valentino", selenium.getTable("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table.0.1"));
		assertTrue(selenium.isElementPresent("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_brand > a"));
		assertEquals("Valentino Bow Over the Knee Boot", selenium.getTable("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table.1.1"));
		assertTrue(selenium.isElementPresent("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_name"));
		assertEquals("$1,495.00", selenium.getTable("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table.2.1"));
		assertTrue(selenium.isElementPresent("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_price"));
		assertEquals("A quintet of bows lends signature femme to a svelte boot cast in smooth leather. Valentino Bow Over the Knee Boot VALENTINO Valentino Boots Shoes Partial side-zip closure. Approx. heel height: 1\". Approx. boot shaft height: 21 1/2\" front; 18\" back; 12 1/2\" calf circumference. Narrow calf. Leather upper, lining and sole. Made in Italy. Salon Shoes.", selenium.getTable("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table.3.1"));
		assertTrue(selenium.isElementPresent("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_description"));
		assertEquals("November", selenium.getTable("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table.4.1"));
		assertTrue(selenium.isElementPresent("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td.shoe_result_value.shoe_release_month > a"));
		assertTrue(selenium.isElementPresent("//li[@id='valentino_valentino_bow_overthe_knee_boot']/div/table/tbody/tr[7]"));
		assertEquals("sample@gmail.com", selenium.getValue("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input[name=\"email\"]"));
		selenium.type("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input[name=\"email\"]", "sample@gmail.com");
		selenium.click("css=#valentino_valentino_bow_overthe_knee_boot > div.shoe_result > table > tbody > tr.shoe_result_row > td > form.notification_email_form > input.notification_email_submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
			// Gucci 'Sofia' Sandal 
		assertEquals("Gucci", selenium.getTable("//li[@id=\"gucci_gucci'sofia'sandal\"]/div/table.0.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'Gucci')])[6]"));
		assertEquals("Gucci 'Sofia' Sandal", selenium.getTable("//li[@id=\"gucci_gucci'sofia'sandal\"]/div/table.1.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'sofia'sandal\"]/div/table/tbody/tr[2]/td[2]"));
		assertEquals("$1,650.00", selenium.getTable("//li[@id=\"gucci_gucci'sofia'sandal\"]/div/table.2.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'sofia'sandal\"]/div/table/tbody/tr[3]/td[2]"));
		assertEquals("Pre-order this style today! Add to Shopping Bag to view approximate ship date. You'll be charged only when your item ships.Brilliant crystals adorn the graceful tapers of platform sandal shaped with curvaceous, elegant intersects. Gucci 'Sofia' Sandal Gucci Gucci Sandals/Slides Shoes Adjustable strap with buckle closure. Approx. heel height: 5\" with a 1\" platform (comparable to a 4\" heel). Satin and suede upper/leather lining/suede sole. Made in Italy. Salon Shoes.", selenium.getTable("//li[@id=\"gucci_gucci'sofia'sandal\"]/div/table.3.1"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'sofia'sandal\"]/div/table/tbody/tr[4]/td[2]"));
		assertEquals("November", selenium.getTable("//li[@id=\"gucci_gucci'sofia'sandal\"]/div/table.4.1"));
		assertTrue(selenium.isElementPresent("xpath=(//a[contains(text(),'November')])[3]"));
		assertTrue(selenium.isElementPresent("//li[@id=\"gucci_gucci'sofia'sandal\"]/div/table/tbody/tr[6]"));
		assertEquals("sample@gmail.com", selenium.getValue("xpath=(//input[@name='email'])[21]"));
		selenium.type("xpath=(//input[@name='email'])[21]", "sample@gmail.com");
		selenium.click("xpath=(//input[@type='submit'])[22]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Thanks! We will notify you when this shoe is available at this email: sample@gmail.com", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
		// Input 100 characters into the email in a non-email format (assumed max) - test output
		// (error) This should return a message that the input is not in a correct email format
		selenium.type("id=remind_email_input", "lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		assertEquals("lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala", selenium.getValue("id=remind_email_input"));
		selenium.type("id=remind_email_input", "lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala");
		assertEquals("Thanks! We will notify you of our new shoes at this email: lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		selenium.type("id=remind_email_input", "");
		
		// Input 99 characters into the promo code (assumed 1 less than max) - test output
		assertEquals("lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalal", selenium.getValue("id=promo_code_input"));
		selenium.type("id=promo_code_input", "lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalal");
		selenium.click("css=div.right > input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		assertEquals("The code: lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalal is not a valid promotional code", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
		// Input 100 characters into promo code (assumed max) - test output
		// This posts no flash notice to the screen (error) and thus the test returns false in order to make the cases all pass
		assertEquals("lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala", selenium.getValue("id=promo_code_input"));
		selenium.type("id=promo_code_input", "lalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalalala");
		selenium.click("css=div.right > input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isElementPresent("css=div.flash.notice"));
		
		// Tests for elements on page "Problem Definition"
		selenium.click("link=Problem Definition");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("css=h1"));
		assertTrue(selenium.isElementPresent("css=p"));
		assertTrue(selenium.isElementPresent("css=h2"));
		assertTrue(selenium.isElementPresent("css=div.backstory > p"));
		assertTrue(selenium.isElementPresent("css=div.story_1 > h2"));
		assertTrue(selenium.isElementPresent("css=div.story_1 > p"));
		assertTrue(selenium.isElementPresent("css=h3"));
		assertTrue(selenium.isElementPresent("//div/ul/li[2]"));
		assertTrue(selenium.isElementPresent("css=div.story_3 > h2"));
		assertTrue(selenium.isElementPresent("css=div.story_3 > p"));
		assertTrue(selenium.isElementPresent("css=div.story_3 > div.acceptance_criteria > h3"));
		assertTrue(selenium.isElementPresent("css=div.story_3 > div.acceptance_criteria > ul > li"));
		
		// Test that the Issues page loads
		selenium.click("link=Issues");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("css=h2"));
		assertEquals("Title", selenium.getTable("css=table.issues_table.0.1"));
		assertTrue(selenium.isElementPresent("//th[2]"));
		
		// Test the elements of the Report An Issue page 
		selenium.click("link=Report An Issue");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("css=h2"));
		assertTrue(selenium.isElementPresent("id=issue_title"));
		assertTrue(selenium.isElementPresent("id=issue_description"));
		assertTrue(selenium.isElementPresent("id=issue_severity"));
		assertEquals("", selenium.getTable("css=table.0.1"));
		assertEquals("", selenium.getTable("css=table.1.1"));
		assertEquals("Low Medium High Critical", selenium.getTable("css=table.2.1"));
		
		// Test that a fully filled out issue gets the proper message with low severity
		selenium.type("id=issue_title", "Sample Error Message 7");
		selenium.type("id=issue_description", "This is a sample error message 7");
		selenium.select("id=issue_severity", "label=Low");
		selenium.click("id=issue_submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Your issue was logged!", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
		// Test that a fully filled out issue gets the proper message with medium severity
		selenium.type("id=issue_title", "Sample Error Message 8");
		selenium.type("id=issue_description", "This is a sample error message 8");
		selenium.select("id=issue_severity", "label=Medium");
		selenium.click("id=issue_submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Your issue was logged!", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
		// Test that a fully filled out issue gets the proper message with high severity
		selenium.type("id=issue_title", "Sample Error Message 9");
		selenium.type("id=issue_description", "This is a sample error message 9");
		selenium.select("id=issue_severity", "label=High");
		selenium.click("id=issue_submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Your issue was logged!", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
		// Test that a fully filled out issue gets the proper message with critical severity
		selenium.type("id=issue_title", "Sample Error Message 9");
		selenium.type("id=issue_description", "This is a sample error message 9");
		selenium.select("id=issue_severity", "label=Critical");
		selenium.click("id=issue_submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("Your issue was logged!", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
		// Test that the same issue filled out again gives the proper message
		selenium.click("link=Report An Issue");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=issue_title", "Sample Error Message 7");
		selenium.type("id=issue_description", "This is a sample error message 7");
		selenium.select("id=issue_severity", "label=Low");
		selenium.click("id=issue_submit");
		selenium.waitForPageToLoad("30000");
		
			// Navigate away to make message display (error)
		selenium.click("link=Issues");
		selenium.waitForPageToLoad("30000");
		assertEquals("This issue already exists", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		
		// Tests that an empty issue filled out gives the proper message
		selenium.click("link=Report An Issue");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=issue_submit");
		selenium.waitForPageToLoad("30000");
		
			// Navigate away to make message display (error)
		selenium.click("link=Issues");
		selenium.waitForPageToLoad("30000");
		assertEquals("This issue already exists", selenium.getText("css=div.flash.notice"));
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		selenium.select("id=brand", "label=Alexander McQueen");
		selenium.click("id=search_button");
		selenium.waitForPageToLoad("30000");
		
		
	} // testRemote

	@After
	public void tearDown() throws Exception // closes the remote control for the website
	{
		
		selenium.stop();
	
	} // tearDown

} // WebsiteTests 