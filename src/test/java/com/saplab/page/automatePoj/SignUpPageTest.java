package com.saplab.page.automatePoj;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.eclipse.jetty.io.ManagedSelector.SelectorUpdate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

@Listeners(ExtentITestListenerClassAdapter.class)
public class SignUpPageTest {
	
	
	
	SignUpPage page;
	
    
	@BeforeMethod
	public void setup()
	{
		HomePage homePage = new HomePage();
		page=homePage.openSignUpPage();
	}
	
	@Test
	public void testSuccessfullRegistration()
	{
		page.fillUpSignUpPageFields("arpita", "mohanty", "abcd@gmail.com", "933@arpi", "933@arpi");
		WebDriverWait wait  =  new WebDriverWait(page.driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ids-heading-1")));
		
		String expected="Thank you for registering with SAP Conversational AI";
		String actual=page.driver.findElement(By.cssSelector(".ids-heading-1")).getText();
		assertEquals(page.driver.findElement(By.cssSelector(".ids-heading-1")).isDisplayed(), true);
		assertEquals(actual, expected);
	}
	
	@Test
    public void testInavlidErrorFullRegistration()
    {
		
		page.fillUpSignUpPageFields("", "", "", "", "");
		WebDriverWait wait  =  new WebDriverWait(page.driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ids-heading-1")));
		assertEquals(page.driver.findElement(By.cssSelector(".ids-heading-1")).isDisplayed(), true);
    }
	
	@Test
	public void testPasswordMismatch()
	{
		page.fillUpSignUpPageFields("arpita", "mohanty", "abcd@gmail.com", "1234@sapi", "sat@1236");
		assertEquals(page.driver.findElement(By.cssSelector(".ids-heading-1")).isDisplayed(), true);
		String actual=page.driver.findElement(By.id("passwordConfirm.errors")).getText();
		String expected="Must match the password";
		assertEquals(actual, expected);
		
	}
	
	
	
	@AfterMethod
	 public void closeDriver()
	 {
		page.driver.quit();
	 }
	
	
	
}
