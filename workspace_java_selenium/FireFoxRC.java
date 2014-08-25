package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class FireFoxRC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://manheim-shoe-store-test.herokuapp.com/");
		selenium.start();
	}

	@Test
	public void testFireFoxRC() throws Exception {
		selenium.open("/");
		selenium.click("link=January");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
