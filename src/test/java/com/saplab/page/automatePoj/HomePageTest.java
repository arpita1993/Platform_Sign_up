package com.saplab.page.automatePoj;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

@Listeners(ExtentITestListenerClassAdapter.class)
public class HomePageTest {

	HomePage homePage;
    
	
	@BeforeMethod
	public void setup() {
		homePage = new HomePage();
	}
	
	@Test
	public void homeUrl()
	{
		String expectedhomeUrl="https://cai.tools.sap/";
		String actualhomeUrl=homePage.driver.getCurrentUrl();
		Assert.assertEquals(actualhomeUrl, expectedhomeUrl);
	}
	
    @Test
	public void testSignUpButton() {
    	homePage.openSignUpPage();
    	
    
    	Assert.assertEquals(homePage.driver.findElement(By.cssSelector(".ids-main__content")).isDisplayed(), true);
	}
	@AfterMethod
	 public void tearDown()
	 {
		homePage.driver.quit();
	 }
}
