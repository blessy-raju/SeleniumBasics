package testScripts;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends Base {
	@Test
	public void verifyUserRegistration() {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement registerLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
		registerLink.click();

		WebElement gender = driver.findElement(By.id("gender-female"));
		WebElement firstName = driver.findElement(By.id("FirstName"));
		WebElement lastName = driver.findElement(By.id("LastName"));
		WebElement email = driver.findElement(By.id("Email"));
		WebElement password = driver.findElement(By.id("Password"));
		WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
		WebElement register = driver.findElement(By.id("register-button"));

		gender.click();
		firstName.sendKeys("Blessy");
		lastName.sendKeys("Raju");
		email.sendKeys("blessy104@gmail.com");
		password.sendKeys("Password@123");
		confirmPassword.sendKeys("Password@123");
		register.click();

		String expectedRegisterMessage = "Your registration completed";
		String actualRegisterMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
		Assert.assertEquals(actualRegisterMessage, expectedRegisterMessage, "Invalid Register Message");

		String expectedRegisteredEmail = "blessy104@gmail.com";
		String actualRegisteredEmail = driver.findElement(By.xpath("//a[@class='account']")).getText();
		Assert.assertEquals(actualRegisteredEmail, expectedRegisteredEmail, "Invalid email id");
	}

}
