package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirefoxTests 
{

  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  
  public void setUp() throws Exception 
  {
  
	driver = new FirefoxDriver();
    baseUrl = "http://manheim-shoe-store-test.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  
  } // setUp

  
  public void testFirefox() throws Exception 
  {
    
	  // Open the webpage
	  driver.get(baseUrl + "/");
	  
	  /*
	  
	  // Get to the issues page
	  driver.findElement(By.linkText("Issues")).click();
	  
	  // Submit an issue with all fields selected and Low severity
	  driver.findElement(By.linkText("Report An Issue")).click();
	  driver.findElement(By.id("issue_title")).clear();
	  driver.findElement(By.id("issue_title")).sendKeys("Automated Test 1");
	  driver.findElement(By.id("issue_description")).clear();
	  driver.findElement(By.id("issue_description")).sendKeys("This is a test message 1");
	  new Select(driver.findElement(By.id("issue_severity"))).selectByVisibleText("Low");
	  driver.findElement(By.id("issue_submit")).click();
	  
	  // Submit an issue with all fields selected and Medium severity
	  driver.findElement(By.linkText("Report An Issue")).click();
	  driver.findElement(By.id("issue_title")).clear();
	  driver.findElement(By.id("issue_title")).sendKeys("Automated Test 2");
	  driver.findElement(By.id("issue_description")).clear();
	  driver.findElement(By.id("issue_description")).sendKeys("This is a test message 2");
	  new Select(driver.findElement(By.id("issue_severity"))).selectByVisibleText("Medium");
	  driver.findElement(By.id("issue_submit")).click();
	  
	  // Submit an issue with all fields selected and High severity
	  driver.findElement(By.linkText("Report An Issue")).click();
	  driver.findElement(By.id("issue_title")).clear();
	  driver.findElement(By.id("issue_title")).sendKeys("Automated Test 3");
	  driver.findElement(By.id("issue_description")).clear();
	  driver.findElement(By.id("issue_description")).sendKeys("This is a test message 3");
	  new Select(driver.findElement(By.id("issue_severity"))).selectByVisibleText("High");
	  driver.findElement(By.id("issue_submit")).click();
	  
	  // Submit an issue with all fields selected and Critical severity
	  driver.findElement(By.linkText("Report An Issue")).click();
	  driver.findElement(By.id("issue_title")).clear();
	  driver.findElement(By.id("issue_title")).sendKeys("Automated Test 4");
	  driver.findElement(By.id("issue_description")).clear();
	  driver.findElement(By.id("issue_description")).sendKeys("This is a test message 4");
	  new Select(driver.findElement(By.id("issue_severity"))).selectByVisibleText("Critical");
	  driver.findElement(By.id("issue_submit")).click();
	  
	  // Submit an issue with no title but with a description
	  driver.findElement(By.linkText("Report An Issue")).click();
	  driver.findElement(By.id("issue_title")).clear();
	  driver.findElement(By.id("issue_title")).sendKeys("");
	  driver.findElement(By.id("issue_description")).clear();
	  driver.findElement(By.id("issue_description")).sendKeys("This is the next test message");
	  new Select(driver.findElement(By.id("issue_severity"))).selectByVisibleText("Low");
	  driver.findElement(By.id("issue_submit")).click();
	  
	  // Submit an issue with a title but no description
	  driver.findElement(By.linkText("Report An Issue")).click();
	  driver.findElement(By.id("issue_title")).clear();
	  driver.findElement(By.id("issue_title")).sendKeys("Next Automated Message");
	  driver.findElement(By.id("issue_description")).clear();
	  driver.findElement(By.id("issue_description")).sendKeys("");
	  new Select(driver.findElement(By.id("issue_severity"))).selectByVisibleText("Low");
	  driver.findElement(By.id("issue_submit")).click();
	  
	  */
	  
	  // Navigate to the Problem Definition page
	  driver.findElement(By.linkText("Problem Definition")).click();
	  
	  // Navigate back to the Home page
	  driver.findElement(By.linkText("Home")).click();
	  
	  String URL = driver.getPageSource();
	  System.out.println("Page Source:  " + URL);
	  
	  /*
	  
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
	  new Select(driver.findElement(By.id("brand"))).selectByVisibleText("7 For All Mankind�");
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
	  
	  */
	  
  } // testFireFox

  
  public void tearDown() throws Exception 
  {
  
	driver.quit();
    String verificationErrorString = verificationErrors.toString();
    
    if (!"".equals(verificationErrorString)) 
    {
    
    	fail(verificationErrorString);
    
    } // if
  
  } // tearDown
  
  private boolean isElementPresent(By by) 
  {
  
	  try 
	  {
      
		  driver.findElement(by);
		  return true;
      
	  }catch (NoSuchElementException e) 
	  {
	
		  return false;
	  
	  } // try-catch
  
  } // isElementPresent

  private boolean isAlertPresent() 
  {
    
	  try 
	  {
		  
		  driver.switchTo().alert();
		  return true;
    
	  }catch (NoAlertPresentException e) 
	  {
		  
		  return false;
    
	  } // try-catch
  
  } // isAlertPresent

  private String closeAlertAndGetItsText() 
  {
    
	  try 
	  {
		  
		  Alert alert = driver.switchTo().alert();
		  String alertText = alert.getText();
		  
		  if (acceptNextAlert) 
		  {
			
			  alert.accept();
      
		  }else 
		  {
        
			  alert.dismiss();
      
		  } // if-else
      
		  return alertText;
    
	  }finally 
	  {
      
		  acceptNextAlert = true;
    
	  } // try-catch
  
  } // closeAlertAndGetItsText

} // FireFoxTests
