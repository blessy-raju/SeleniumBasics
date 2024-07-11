package org.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BrowserLaunchEdge {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		String title = driver.getTitle();
		System.out.println(title);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		driver.close();

	}

}
