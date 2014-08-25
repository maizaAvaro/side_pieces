package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class Remote {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://manheim-shoe-store-test.herokuapp.com/");
		selenium.start();
	}

	@Test
	public void testRemote() throws Exception {
		selenium.open("/");
		selenium.click("link=Report An Issue");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=issue_title", "sample");
		selenium.type("id=issue_description", "samplesample");
		selenium.click("id=issue_submit");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("css=div.flash.notice"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
