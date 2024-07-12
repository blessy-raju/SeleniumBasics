package org.selenium.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/");
		driver.navigate().back();
		driver.navigate().forward();	
		driver.navigate().refresh();
		driver.navigate().to("https://www.javatpoint.com/");
		driver.close();

	}

}
