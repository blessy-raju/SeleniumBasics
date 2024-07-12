package org.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop {
	
	public void verifyLogin() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		WebElement loginLink = driver.findElement(By.className("ico-login"));
		loginLink.click();
		
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("blessy@gmail.com");
		
		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("Password@123");
		
		WebElement loginButton = driver.findElement(By.className("login-button"));
		loginButton.click();
		
		System.out.println("End of the code");
		driver.close();
	}

	public static void main(String[] args) {
		DemoWebShop demo = new DemoWebShop();
		demo.verifyLogin();
	}

}
