package com.saplab.page.automatePoj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
	public Properties prop;

	public WebDriver driver;
	
	public DesiredCapabilities capabilities=null;

	public TestBase() {
		try {
			capabilities =  new DesiredCapabilities("chrome", "84.0.4147.89", Platform.LINUX);
			ChromeOptions tp = new ChromeOptions();
			tp.addArguments("--disable-dev-shm-usage");
			capabilities.setCapability(ChromeOptions.CAPABILITY, tp);
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Code\\Selenium\\automatePoj\\src\\main\\resources\\config.properties");
			prop.load(fis);
			String browserName = prop.getProperty("browser");
		/*	if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Arpita\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equals("FireFox")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Arpita\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new FirefoxDriver();
			}*/
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			driver.manage().window().maximize();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
