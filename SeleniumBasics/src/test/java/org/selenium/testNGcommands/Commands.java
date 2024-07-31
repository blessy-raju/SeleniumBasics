package org.selenium.testNGcommands;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Commands extends Base {
	@Test
	public void verifyHomePageTitle() {
		driver.get("https://demowebshop.tricentis.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Demo Web Shop";
		// System.out.println("Title:" + title);
		Assert.assertEquals(actualTitle, expectedTitle, "Title Mismatch");

	}

	@Test
	public void verifyLogin() {
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
	public void verifyRadioButton() {
		boolean isButtonSelected;
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radioButtonMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
		isButtonSelected = radioButtonMale.isSelected();
		Assert.assertFalse(isButtonSelected, "Male is already selected");
		radioButtonMale.click();
		isButtonSelected = radioButtonMale.isSelected();
		Assert.assertTrue(isButtonSelected, "Male is not selected");
	}

	@Test
	public void verifySwagLabsLogin() {
		driver.get("https://www.saucedemo.com/");
		WebElement userNameField = driver.findElement(By.id("user-name"));
		userNameField.sendKeys("standard_user");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		WebElement pageHeading = driver.findElement(By.xpath("//div[@class='app_logo']"));
		Assert.assertEquals(pageHeading.getText(), "Swag Labs", "Login is not successful");
	}

}
