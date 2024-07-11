package org.selenium.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.javatpoint.com/");
		//driver.get("https://www.google.com/");
		
		String title =driver.getTitle();
		System.out.println(title);
		String currentUrl=driver.getCurrentUrl();
		System.out.println(currentUrl);
		String pageSource =driver.getPageSource();
		System.out.println(pageSource);
		driver.close();//closes active window
		driver.quit();//closes the entire chrome window, if more than one tab is opened
	}

}
