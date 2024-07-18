package org.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Commands {

	public void verifySwagLabsLogin() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebElement userNameField = driver.findElement(By.id("user-name"));
		userNameField.sendKeys("standard_user");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		System.out.println("End of the code");
		driver.close();

	}

	public void verifyIsSelected() {
		boolean isButtonSelected;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radioButtonMale = driver.findElement(By.xpath("//input[@id='gender-male']"));
		isButtonSelected = radioButtonMale.isSelected();
		System.out.println("Male element before selection " + isButtonSelected);
		radioButtonMale.click();
		isButtonSelected = radioButtonMale.isSelected();
		System.out.println("Male element after selection " + isButtonSelected);
		driver.close();

	}
	public void verifyIsEnabled() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		WebElement subscribeButton= driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		boolean isButtonEnabled = subscribeButton.isEnabled();
		System.out.println("Button is enabled:"+isButtonEnabled);
		driver.close();
	}
	public void verifyIsDisplayed() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		WebElement voteButton =driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		boolean isButtondisplayed=voteButton.isDisplayed();
		System.out.println("Button is displayed:"+isButtondisplayed);
		driver.close();
	}
	
	public void verifyValuesFromDropdown() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropDown=driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countryDropDown);
		//select.selectByVisibleText("ANTARCTICA");
		//select.selectByValue("BAHAMAS");
		//select.selectByIndex(9);
		WebElement getCountryName=select.getFirstSelectedOption();
		System.out.println(getCountryName.getText());
		driver.close();
		
	}

	public static void main(String[] args) {
		Commands cmdObj = new Commands();
		//cmdObj.verifySwagLabsLogin();
		//cmdObj.verifyIsSelected();
		//cmdObj.verifyIsEnabled();
		//cmdObj.verifyIsDisplayed();
		cmdObj.verifyValuesFromDropdown();

	}

}
