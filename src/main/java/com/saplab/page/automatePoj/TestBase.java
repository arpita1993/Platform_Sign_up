package com.saplab.page.automatePoj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public Properties prop;

	public WebDriver driver;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Code\\Selenium\\automatePoj\\src\\main\\resources\\config.properties");
			prop.load(fis);
			String browserName = prop.getProperty("browser");
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Arpita\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equals("FireFox")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Arpita\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
