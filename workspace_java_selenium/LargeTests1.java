package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LargeTests1 {
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
  public void testLargeTests1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Problem Definition")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("January")).click();
    driver.findElement(By.linkText("Jimmy Choo")).click();
    driver.findElement(By.linkText("Jimmy Choo")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'February')])[2]")).click();
    driver.findElement(By.cssSelector("form.notification_email_form > input[name=\"email\"]")).clear();
    driver.findElement(By.cssSelector("form.notification_email_form > input[name=\"email\"]")).sendKeys("ntray@uga.edu");
    driver.findElement(By.cssSelector("input.notification_email_submit")).click();
    driver.findElement(By.cssSelector("form.notification_email_form > input[name=\"email\"]")).clear();
    driver.findElement(By.cssSelector("form.notification_email_form > input[name=\"email\"]")).sendKeys("darileemc");
    driver.findElement(By.cssSelector("input.notification_email_submit")).click();
    driver.findElement(By.linkText("Home")).click();
    new Select(driver.findElement(By.id("brand"))).selectByVisibleText("7 For All Mankind®");
    driver.findElement(By.id("search_button")).click();
    driver.findElement(By.id("promo_code_input")).clear();
    driver.findElement(By.id("promo_code_input")).sendKeys("flyingcolors");
    driver.findElement(By.cssSelector("div.right > input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Home")).click();
    new Select(driver.findElement(By.id("brand"))).selectByVisibleText("Acorn");
    driver.findElement(By.id("search_button")).click();
    driver.findElement(By.linkText("Home")).click();
    new Select(driver.findElement(By.id("brand"))).selectByVisibleText("Aetrex");
    driver.findElement(By.id("search_button")).click();
    driver.findElement(By.linkText("Home")).click();
    new Select(driver.findElement(By.id("brand"))).selectByVisibleText("Alexander McQueen");
    driver.findElement(By.id("search_button")).click();
    driver.findElement(By.linkText("Home")).click();
    new Select(driver.findElement(By.id("brand"))).selectByVisibleText("Alexander McQueen");
    driver.findElement(By.id("search_button")).click();
    new Select(driver.findElement(By.id("brand"))).selectByVisibleText("Alexandre Birman");
    driver.findElement(By.id("search_button")).click();
    new Select(driver.findElement(By.id("brand"))).selectByVisibleText("Alberto Fermani");
    driver.findElement(By.id("search_button")).click();
    new Select(driver.findElement(By.id("brand"))).selectByVisibleText("Alice + Olivia");
    driver.findElement(By.id("search_button")).click();
    driver.findElement(By.linkText("Issues")).click();
    driver.findElement(By.linkText("Report An Issue")).click();
    driver.findElement(By.id("issue_title")).clear();
    driver.findElement(By.id("issue_title")).sendKeys("Another Test");
    driver.findElement(By.id("issue_description")).clear();
    driver.findElement(By.id("issue_description")).sendKeys("Here is another test message");
    new Select(driver.findElement(By.id("issue_severity"))).selectByVisibleText("Medium");
    driver.findElement(By.id("issue_submit")).click();
    driver.findElement(By.linkText("March")).click();
    driver.findElement(By.linkText("April")).click();
    driver.findElement(By.linkText("May")).click();
    driver.findElement(By.linkText("June")).click();
    driver.findElement(By.linkText("July")).click();
    driver.findElement(By.linkText("August")).click();
    driver.findElement(By.linkText("September")).click();
    driver.findElement(By.linkText("October")).click();
    driver.findElement(By.linkText("November")).click();
    driver.findElement(By.linkText("December")).click();
    driver.findElement(By.linkText("All Shoes")).click();
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
