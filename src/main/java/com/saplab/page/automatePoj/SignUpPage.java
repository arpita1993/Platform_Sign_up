package com.saplab.page.automatePoj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	
	
	@FindBy(name = "firstName")
	WebElement firstNameText;
	@FindBy(name="lastName")
	WebElement lastNameText;
	@FindBy(id="mail")
	WebElement EmailId;
	@FindBy(id="newPasswordInput")
	WebElement newPassword;
	@FindBy(id="retypeNewPasswordInput")
	WebElement retypePasswordText;
	@FindBy(id="pdAccept")
	WebElement checkBox1;
	@FindBy(id="touAccept")
	WebElement checkBox2;
	@FindBy(id="sapStoreRegisterFormSubmit")
	WebElement registerBtn;
	
	
	WebDriver driver;
	
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ids-main__content")));
//		driver.switchTo().frame(1);
		PageFactory.initElements(driver, this);
	}
	
	public void fillFirstNameFieldWithValues(String firstName) {
		firstNameText.sendKeys(firstName);
	}
	
	public void fillLastNameWithValue(String lastName)
	{
		lastNameText.sendKeys(lastName);
	}
	
	public void enterMailId(String mail)
	{
		EmailId.sendKeys(mail);
	}    
	public void passWord(String newPasswordInput)
	{
		newPassword.sendKeys(newPasswordInput);
	}
	
	public void retypePassword(String retypeNewPasswordInput)
	{
		retypePasswordText.sendKeys(retypeNewPasswordInput);
	}
	public void chekBoxForTerms1()
	{
		checkBox1.click();
	}
	
	public void chekBoxForTerms2()
	{
		checkBox2.click();
	}
	public void clickOnRegisterButton( )
	{
		registerBtn.click();
	}
	
	public void fillUpSignUpPageFields(String firstNameText,String lastNameText,
			String EmailId,String newPassword,String retypePasswordText)
	{
		fillFirstNameFieldWithValues(firstNameText);
		fillLastNameWithValue(lastNameText);
		enterMailId(EmailId);
		passWord(newPassword);
		retypePassword(retypePasswordText);
		chekBoxForTerms1();
		chekBoxForTerms2();
		clickOnRegisterButton();
	}

	public WebElement getFirstNameText() {
		return firstNameText;
	}

	public WebElement getLastNameText() {
		return lastNameText;
	}

	public WebElement getEmailId() {
		return EmailId;
	}

	public WebElement getNewPassword() {
		return newPassword;
	}

	public WebElement getRetypePasswordText() {
		return retypePasswordText;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}
	
}
