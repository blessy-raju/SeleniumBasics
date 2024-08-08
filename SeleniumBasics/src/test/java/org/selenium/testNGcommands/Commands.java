package org.selenium.testNGcommands;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.automationcore.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Commands extends Base {
	@Test
	public void verifyHomePageTitle() {
		driver.get("https://demowebshop.tricentis.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Demo Web Shop";
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
//		Assert.assertFalse(isButtonSelected, "Male is already selected");
//		System.out.println("End of the code to test soft assert");
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

	@Test
	public void verifyJavaScriptExecutorSendKeysAndClick() {
		driver.get("https://demowebshop.tricentis.com/");
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver; // another way of creating reference
		javascriptexecutor.executeScript("document.getElementById(\"newsletter-email\").value='test@gmail.com'");
		javascriptexecutor.executeScript("document.getElementById(\"newsletter-subscribe-button\").click()");
	}

	@Test
	public void verifyJavaScriptExecutorScroll() {
		driver.get("https://demoqa.com/forms");
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver;
//		javascriptexecutor.executeScript("window.scrollBy(0,500)");	//scrolls down
//		javascriptexecutor.executeScript("window.scrollBy(0,-500)");	//scrolls up
//		javascriptexecutor.executeScript("window.scrollBy(150,0)");	//scrolls right
//		javascriptexecutor.executeScript("window.scrollBy(-150,0)");	//scrolls left
		javascriptexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // scroll down to end
		javascriptexecutor.executeScript("window.scrollTo(document.body.scrollHeight,0)"); // scrolls left to the end

	}

	@Test
	public void verifyFileUploadUsingRobotClass() throws AWTException {

		driver.get("https://demo.guru99.com/test/upload/");
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='uploadfile_0']")); // since the button is an
																								// <input> tag, click()
																								// doesn't work. So use
																								// actions.moveToElement(uploadFile).click().perform()
		Actions actions = new Actions(driver);
		actions.moveToElement(uploadFile).click().perform();

		StringSelection strSelection = new StringSelection(
				"C:\\Users\\Lenovo\\git\\repository\\SeleniumBasics\\src\\main\\resources\\Book1.xlsx");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); // class that implements a mechanism to
																				// transfer data using cut/copy/paste
																				// operations
		clipboard.setContents(strSelection, null); // Sets the current contents of the clipboard to the specified
													// transferable object

		Robot robot = new Robot();
		robot.delay(300);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		WebElement checkboxButton = driver.findElement(By.id("terms"));
		checkboxButton.click();
		WebElement submitFileButton = driver.findElement(By.id("submitbutton"));
		submitFileButton.click();

	}
	
	@Test
	public void verifyWaitCommands() {
		driver.get("https://demoqa.com/alerts");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement clickMeButton = driver.findElement(By.id("timerAlertButton"));
		clickMeButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void verifyFluentWait() {
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement clickMeButton = driver.findElement(By.id("timerAlertButton"));
		FluentWait fluentWait=new FluentWait(driver);
		fluentWait.withTimeout(Duration.ofSeconds(10));
		fluentWait.pollingEvery(Duration.ofSeconds(2));
		fluentWait.ignoring(NoSuchElementException.class);
		clickMeButton.click();
		fluentWait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}

}
