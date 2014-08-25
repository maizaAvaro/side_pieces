package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AssertTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://manheim-shoe-store-test.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAssertTests() throws Exception {
    driver.get(baseUrl + "/");
    assertTrue(isElementPresent(By.linkText("January")));
    assertTrue(isElementPresent(By.linkText("January")));
    try {
      assertTrue(isElementPresent(By.linkText("January")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.linkText("February")));
    try {
      assertTrue(isElementPresent(By.linkText("February")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("option[value=\"7 For All Mankind®\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("option[value=\"Acorn\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("option[value=\"Aetrex\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.cssSelector("option[value=\"Alexander McQueen\"]")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.cssSelector("option[value=\"7 For All Mankind®\"]")));
    assertTrue(isElementPresent(By.linkText("Problem Definition")));
    try {
      assertTrue(isElementPresent(By.linkText("Problem Definition")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("flyingcolors", driver.findElement(By.id("promo_code_input")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.id("promo_code_input")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("promo_code_input")).clear();
    driver.findElement(By.id("promo_code_input")).sendKeys("flyingcolors");
    try {
      assertEquals("", driver.findElement(By.cssSelector("div.right > input[type=\"submit\"]")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("div.right > input[type=\"submit\"]")).click();
    assertTrue(isElementPresent(By.cssSelector("div.flash.notice")));
    try {
      assertTrue(isElementPresent(By.linkText("Report An Issue")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertTrue(isElementPresent(By.linkText("Issues")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("Issues")).click();
    driver.findElement(By.linkText("Report An Issue")).click();
    driver.findElement(By.id("issue_submit")).click();
    driver.findElement(By.linkText("Report An Issue")).click();
    assertTrue(isElementPresent(By.cssSelector("div.flash.notice")));
    try {
      assertTrue(isElementPresent(By.cssSelector("div.flash.notice")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("issue_title")).clear();
    driver.findElement(By.id("issue_title")).sendKeys("asdl;fkj");
    driver.findElement(By.id("issue_description")).clear();
    driver.findElement(By.id("issue_description")).sendKeys("a;sdflkj;");
    driver.findElement(By.id("issue_submit")).click();
    assertTrue(isElementPresent(By.cssSelector("div.flash.notice")));
    try {
      assertTrue(isElementPresent(By.cssSelector("div.flash.notice")));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
