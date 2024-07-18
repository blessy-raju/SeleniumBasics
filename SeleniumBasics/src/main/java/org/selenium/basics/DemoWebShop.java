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
	
	public void verifyUserRegistration() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		WebElement registerLink = driver.findElement(By.className("ico-register"));
		registerLink.click();
		
		WebElement gender=driver.findElement(By.id("gender-female"));
		WebElement firstName=driver.findElement(By.id("FirstName"));
		WebElement lastName = driver.findElement(By.id("LastName"));
		WebElement email=driver.findElement(By.id("Email"));
		WebElement password =driver.findElement(By.id("Password"));
		WebElement confirmPassword =driver.findElement(By.id("ConfirmPassword"));
		WebElement register = driver.findElement(By.id("register-button"));
		
		
		gender.click();
		firstName.sendKeys("Blessy");
		lastName.sendKeys("Raju");
		email.sendKeys("blessy1@gmail.com");
		password.sendKeys("Password@123");
		confirmPassword.sendKeys("Password@123");
		register.click();
		System.out.println("End of the code");
		driver.close();
	}
	
	public void verifyRegistrationUsingXpath() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		WebElement registerLink=driver.findElement(By.xpath("//a[@class='ico-register']"));
		registerLink.click();
		
		WebElement gender=driver.findElement(By.xpath("//input[@name='Gender' and @id='gender-male']"));
		gender.click();
		WebElement firstName=driver.findElement(By.xpath("//input[contains(@id,'FirstName')]"));
		firstName.sendKeys("Blessy");
		WebElement lastName = driver.findElement(By.xpath("//input[contains(@id,'LastName')]"));
		lastName.sendKeys("Raju");
		WebElement email=driver.findElement(By.xpath("//input[@name='Email']"));
		email.sendKeys("blessy1@gmail.com");
		WebElement password =driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("Password@123");
		WebElement confirmPassword =driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		confirmPassword.sendKeys("Password@123");
		WebElement register = driver.findElement(By.xpath("//input[@id='register-button']"));
		register.click();		
		System.out.println("End of the code");
		driver.close();
		
	}
	

	public static void main(String[] args) {
		DemoWebShop demo = new DemoWebShop();
		//demo.verifyUserRegistration();
		demo.verifyRegistrationUsingXpath();
		//demo.verifyLogin();
	}

}
