package com.saplab.page.automatePoj;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

	@FindBy(xpath= "//a[@title='login']")
	WebElement loginButton;
	
	@FindBy(xpath= "//div[@class='btn--content'  and text()='Sign up']")
	WebElement signUpButton;
	
	
	public HomePage() {
		driver.get(prop.getProperty("homeUrl"));
		PageFactory.initElements(driver, this);
		dismissCookieBar();
	}
	

	private void dismissCookieBar() {
		driver.findElement(By.cssSelector(".CookieBanner.px2")).findElement(By.cssSelector(".btn--content")).click();
	}


	public SignUpPage openSignUpPage() {
		signUpButton.click();
		return new SignUpPage(driver);
	}

	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Arpita\\Downloads\\chromedriver_win32\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();
		driver.get("https://cai.tools.sap");
		driver.findElement(By.cssSelector(".CookieBanner.px2")).findElement(By.cssSelector(".btn--content")).click();
		driver.findElement(By.className("btn--content")).click();
		WebDriverWait wait  =  new WebDriverWait(driver, Duration.ofSeconds(7));
//		Thread.sleep(5000);
//		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.xpath("//div[@class='ids_container']"),By.tagName("iframe")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ids-main__content")));
		/*driver.findElement(By.name("firstName")).sendKeys("arpita");
		driver.findElement(By.name("lastName")).sendKeys("Mohanty");
		driver.findElement(By.id("mail")).sendKeys("mohanty.arpita.933@gmail.com");
		driver.findElement(By.id("newPasswordInput")).sendKeys("933@arpi");
		driver.findElement(By.id("retypeNewPasswordInput")).sendKeys("933@arpi");
		driver.findElement(By.id("pdAccept")).click();
		driver.findElement(By.id("touAccept")).click();*/
//		driver.findElement(By.id("sapStoreRegisterFormSubmit")).click();
		

		/*driver.quit();*/
	/*	System.exit(1);*/

	}
	
}
