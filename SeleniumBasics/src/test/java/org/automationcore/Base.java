package org.automationcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	public WebDriver driver;

	public void initializeBrowser(String browser) {
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Invalid Browser");
		}
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void setBrowser() {
		initializeBrowser("Chrome");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
