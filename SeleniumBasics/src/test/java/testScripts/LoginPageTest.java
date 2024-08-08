package testScripts;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
	@Test
	public void verifyUserLoginWithValidCredentials() {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.className("ico-login"));
		loginLink.click();

		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("blessy@gmail.com");

		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("Password@123");

		WebElement loginButton = driver.findElement(By.className("login-button"));
		loginButton.click();

		String expectedEmail = "blessy@gmail.com";
		String actualEmail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"))
				.getText();
		Assert.assertEquals(actualEmail, expectedEmail, "Invalid login");
	}

	@Test
	public void verifyUserLoginWithValidEmailAndInvalidPassword() {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.className("ico-login"));
		loginLink.click();

		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("blessy@gmail.com");

		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("test");

		WebElement loginButton = driver.findElement(By.className("login-button"));
		loginButton.click();

		String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect";
		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"))
				.getText() + driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li")).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Login Message");

	}

	@Test
	public void verifyUserLoginWithInvalidEmailAndValidPassword() {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.className("ico-login"));
		loginLink.click();

		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("bless@gmail.com");

		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("Password@123");

		WebElement loginButton = driver.findElement(By.className("login-button"));
		loginButton.click();

		String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.No customer account found";
		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"))
				.getText() + driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li")).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Login Message");

	}

	@Test
	public void verifyUserLoginWithInvalidEmailAndInvalidPassword() {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.className("ico-login"));
		loginLink.click();

		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("bless@gmail.com");

		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("test");

		WebElement loginButton = driver.findElement(By.className("login-button"));
		loginButton.click();

		String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.No customer account found";
		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"))
				.getText() + driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li")).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Login Message");
	}
}
