package org.selenium.basics;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	public void getTotalDropDownValues() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropDown=driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countryDropDown);
		List<WebElement> dropDownList= select.getOptions();
		System.out.println("Number of values in dropdown list:"+dropDownList.size());
		driver.close();
		
	}	
	
	public void displayDropDownValues() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='country']"));
		Select s = new Select(dropDown);
		List<WebElement> country = s.getOptions();
		for(int i=1;i<=country.size();i++) {
			System.out.println(i+"."+country.get(i).getText());
		}
		driver.close();
	}
	
	
	
	public void verifySimpleAlert() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
		clickMeButton.click();
		Alert al = driver.switchTo().alert();
		al.accept();
		driver.close();
	}
	public void verifyConfirmationAlert() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		clickMeButton.click();
		Alert al = driver.switchTo().alert();
		System.out.println("Alert text displayed:"+al.getText());
		al.dismiss();
		WebElement confrimResult =driver.findElement(By.xpath("//span[@id='confirmResult']"));
		System.out.println("Result after alert: "+confrimResult.getText());
		driver.close();
		
	}
	
	public void verifyPromptAlert() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
		clickMeButton.click();
		Alert al =driver.switchTo().alert();
		al.sendKeys("Blessy");
		al.accept();
		WebElement promptResult =driver.findElement(By.xpath("//span[@id='promptResult']"));
		System.out.println("Prompt result after alert: "+promptResult.getText());
		driver.close();
	}
	
	public void verifyRightClick() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions act = new Actions(driver);
		act.contextClick(rightClickButton).build().perform();
		driver.close();
	}
	
	public void verifyDoubleClick() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions act= new Actions(driver);
		act.doubleClick(doubleClickButton).build().perform();
		Alert al = driver.switchTo().alert();
		al.accept();
		driver.close();
	}
	public void verifyMouseHover() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/menu/");
		WebElement mouseHoverButton = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		WebElement subListMenu = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		WebElement subListMenu2 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));		
		Actions act=new Actions(driver);
		act.moveToElement(mouseHoverButton).moveToElement(subListMenu).moveToElement(subListMenu2).click().build().perform();
		
	}

	public static void main(String[] args) {
		Commands cmdObj = new Commands();
		//cmdObj.verifySwagLabsLogin();
		//cmdObj.verifyIsSelected();
		//cmdObj.verifyIsEnabled();
		//cmdObj.verifyIsDisplayed();
		//cmdObj.verifyValuesFromDropdown();
		//cmdObj.displayDropDownValues();
		//cmdObj.getTotalDropDownValues();
		//cmdObj.verifySimpleAlert();
		//cmdObj.verifyConfirmationAlert();
		//cmdObj.verifyPromptAlert();
		//cmdObj.verifyRightClick();
		//cmdObj.verifyDoubleClick();
		cmdObj.verifyMouseHover();
	}

}
