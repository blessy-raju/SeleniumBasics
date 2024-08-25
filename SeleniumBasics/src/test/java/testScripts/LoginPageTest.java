package testScripts;

import java.io.IOException;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.DataProviders;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	@Test(groups={"Smoke","Regression"})
	public void verifyUserLoginWithValidCredentials() {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.className("ico-login"));
		loginLink.click();

		String emailId = ExcelUtility.getStringData(0, 0, "LoginPage");
		String pwd = ExcelUtility.getStringData(0, 1, "LoginPage");

		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys(emailId);

		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys(pwd);

		WebElement loginButton = driver.findElement(By.className("login-button"));
		loginButton.click();

		// String expectedEmail = "blessy@gmail.com";
		String actualEmail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"))
				.getText();
		Assert.assertEquals(actualEmail, emailId, "Invalid login");
	}

	@Test(dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class)
	public void verifyUserLoginWithInvalidUserCredentials(String userName, String userPassword) {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.className("ico-login"));
		loginLink.click();

//		String emailId = ExcelUtility.getStringData(1, 0, "LoginPage");
//		String pwd = ExcelUtility.getStringData(1, 1, "LoginPage");

		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys(userName);

		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys(userPassword);

		WebElement loginButton = driver.findElement(By.className("login-button"));
		loginButton.click();

		String expectedErrorMessage = ExcelUtility.getStringData(5, 0, "LoginPage");
		// String expectedErrorMessage = "Login was unsuccessful. Please correct the
		// errors and try again.The credentials provided are incorrect";
		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"))
				.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Login Message");

	}
}
//
//	@Test
//	public void verifyUserLoginWithInvalidEmailAndValidPassword() throws IOException {
//		driver.get("https://demowebshop.tricentis.com/");
//		WebElement loginLink = driver.findElement(By.className("ico-login"));
//		loginLink.click();
//
//		String emailId = ExcelUtility.getStringData(2, 0, "LoginPage");
//		String pwd = ExcelUtility.getStringData(2, 1, "LoginPage");
//		
//		WebElement email = driver.findElement(By.id("Email"));
//		email.sendKeys(emailId);
//
//		WebElement password = driver.findElement(By.id("Password"));
//		password.sendKeys(pwd);
//
//		WebElement loginButton = driver.findElement(By.className("login-button"));
//		loginButton.click();
//
//		String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.No customer account found";
//		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"))
//				.getText() + driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li")).getText();
//		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Login Message");
//
//	}
//
//	@Test
//	public void verifyUserLoginWithInvalidEmailAndInvalidPassword() throws IOException {
//		driver.get("https://demowebshop.tricentis.com/");
//		WebElement loginLink = driver.findElement(By.className("ico-login"));
//		loginLink.click();
//		
//		String emailId = ExcelUtility.getStringData(3, 0, "LoginPage");
//		String pwd = ExcelUtility.getStringData(3, 1, "LoginPage");
//
//		WebElement email = driver.findElement(By.id("Email"));
//		email.sendKeys(emailId);
//
//		WebElement password = driver.findElement(By.id("Password"));
//		password.sendKeys(pwd);
//
//		WebElement loginButton = driver.findElement(By.className("login-button"));
//		loginButton.click();
//
//		String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.No customer account found";
//		String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"))
//				.getText() + driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li")).getText();
//		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Login Message");
//	}
//}
