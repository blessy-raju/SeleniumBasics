package org.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours {
	
	public void verifyRegistration() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		
		WebElement vacation =driver.findElement(By.linkText("Vacations"));
		vacation.click();
		driver.navigate().back();

		WebElement partialLink =driver.findElement(By.partialLinkText("here"));
		partialLink.click();
		driver.navigate().back();
		
		WebElement registerLink = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
		registerLink.click();
		
		WebElement fName = driver.findElement(By.name("firstName"));
		WebElement lName = driver.findElement(By.name("lastName"));
		WebElement phone = driver.findElement(By.name("phone"));
		WebElement email = driver.findElement(By.id("userName"));
		WebElement address =driver.findElement(By.name("address1"));
		WebElement city =driver.findElement(By.name("city"));
		WebElement state =driver.findElement(By.name("state"));
		WebElement postal =driver.findElement(By.name("postalCode"));
		WebElement userName =driver.findElement(By.id("email"));
		WebElement password =driver.findElement(By.name("password"));
		WebElement confirmPassword =driver.findElement(By.name("confirmPassword"));
		WebElement submit =driver.findElement(By.name("submit"));
		
		fName.sendKeys("Blessy");
		lName.sendKeys("Raju");
		phone.sendKeys("23456789");
		email.sendKeys("blessy@gmail.com");
		address.sendKeys("Abc Street");
		city.sendKeys("Perumbavoor");
		state.sendKeys("Kerala");
		postal.sendKeys("683542");
		userName.sendKeys("BlessyRaju");
		password.sendKeys("Password@123");
		confirmPassword.sendKeys("Password@123");
		submit.click();
	
		driver.close();
		
		
	}

	public static void main(String[] args) {
		MercuryTours tours = new MercuryTours();
		tours.verifyRegistration();

	}

}
