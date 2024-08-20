package testScripts;

import java.io.IOException;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class RegisterPageTest extends Base {
	@Test
	public void verifyUserRegistration() {
		driver.get("https://demowebshop.tricentis.com/");
		WebElement registerLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
		registerLink.click();

		String gender = ExcelUtility.getStringData(0, 0, "RegisterPage");
//		String fName = ExcelUtility.getStringData(0, 1, "RegisterPage");
//		String lName = ExcelUtility.getStringData(0, 2, "RegisterPage");
//		String emailId = ExcelUtility.getStringData(0, 3, "RegisterPage");
//		String pwd = ExcelUtility.getStringData(0, 4, "RegisterPage");
//		String confirmPwd = ExcelUtility.getStringData(0, 5, "RegisterPage");
		String expectedRegisterMessage = ExcelUtility.getStringData(2, 0, "RegisterPage");

		String fName = RandomDataUtility.getFirstName();
		String lName = RandomDataUtility.getLastName();
		String emailId = fName + "." + lName + "@yahoo.com";
		String pwd = fName + "@" + lName;
		WebElement genderRadioButton;
		if (gender.equals("Male")) {
			genderRadioButton = driver.findElement(By.id("gender-male"));
		} else {
			genderRadioButton = driver.findElement(By.id("gender-female"));
		}
		WebElement firstName = driver.findElement(By.id("FirstName"));
		WebElement lastName = driver.findElement(By.id("LastName"));
		WebElement email = driver.findElement(By.id("Email"));
		WebElement password = driver.findElement(By.id("Password"));
		WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
		WebElement register = driver.findElement(By.id("register-button"));

		genderRadioButton.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(emailId);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
		register.click();

		// String expectedRegisterMessage = "Your registration completed";
		String actualRegisterMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
		Assert.assertEquals(actualRegisterMessage, expectedRegisterMessage, "Invalid Register Message");

		// String expectedRegisteredEmail = "blessy104@gmail.com";
//		String actualRegisteredEmail = driver.findElement(By.xpath("//a[@class='account']")).getText();
//		Assert.assertEquals(actualRegisteredEmail, emailId, "Invalid email id");
	}

}
