package org.selenium.basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

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
		WebElement subscribeButton = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		boolean isButtonEnabled = subscribeButton.isEnabled();
		System.out.println("Button is enabled:" + isButtonEnabled);
		driver.close();
	}

	public void verifyIsDisplayed() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		WebElement voteButton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		boolean isButtondisplayed = voteButton.isDisplayed();
		System.out.println("Button is displayed:" + isButtondisplayed);
		driver.close();
	}

	public void verifyValuesFromDropdown() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countryDropDown);
		// select.selectByVisibleText("ANTARCTICA");
		// select.selectByValue("BAHAMAS");
		// select.selectByIndex(9);
		WebElement getCountryName = select.getFirstSelectedOption();
		System.out.println(getCountryName.getText());
		driver.close();

	}

	public void getTotalDropDownValues() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countryDropDown);
		List<WebElement> dropDownList = select.getOptions();
		System.out.println("Number of values in dropdown list:" + dropDownList.size());
		driver.close();

	}

	public void displayDropDownValues() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='country']"));
		Select s = new Select(dropDown);
		List<WebElement> country = s.getOptions();
		for (int i = 1; i <= country.size(); i++) {
			System.out.println(i + "." + country.get(i).getText());
		}
		driver.close();
	}

	public void verifySimpleAlert() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
		clickMeButton.click();
		Alert al = driver.switchTo().alert();
		al.accept();
		driver.close();
	}

	public void verifyConfirmationAlert() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		clickMeButton.click();
		Alert al = driver.switchTo().alert();
		System.out.println("Alert text displayed:" + al.getText());
		al.dismiss();
		WebElement confrimResult = driver.findElement(By.xpath("//span[@id='confirmResult']"));
		System.out.println("Result after alert: " + confrimResult.getText());
		driver.close();

	}

	public void verifyPromptAlert() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
		clickMeButton.click();
		Alert al = driver.switchTo().alert();
		al.sendKeys("Blessy");
		al.accept();
		WebElement promptResult = driver.findElement(By.xpath("//span[@id='promptResult']"));
		System.out.println("Prompt result after alert: " + promptResult.getText());
		driver.close();
	}

	public void verifyRightClick() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions act = new Actions(driver);
		act.contextClick(rightClickButton).build().perform();
		driver.close();
	}

	public void verifyDoubleClick() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions act = new Actions(driver);
		act.doubleClick(doubleClickButton).build().perform();
		Alert al = driver.switchTo().alert();
		al.accept();
		driver.close();
	}

	public void verifyMouseHover() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/menu/");
		WebElement mouseHoverButton = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		WebElement subListMenu = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		WebElement subListMenu2 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHoverButton).moveToElement(subListMenu).moveToElement(subListMenu2).click().build()
				.perform();

	}

	public void verifyDragAndDrop() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/drag-drop.php");
		WebElement dragN1Button = driver.findElement(By.xpath("//span[text()='Draggable n°1']"));
		WebElement dropZoneSection = driver.findElement(By.xpath("//div[@id='mydropzone']"));
		Actions act = new Actions(driver);
//		act.moveToElement(dragN1Button).build().perform();
//		act.click(dragN1Button).build().perform();
		// act.contextClick(dragN1Button).build().perform(); //we can either use click
		// or right click method
		act.dragAndDrop(dragN1Button, dropZoneSection).build().perform();
		// driver.close();
	}

	public void verifyDragAndDropUsingOffset() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/dragabble");
		WebElement dragMeButton = driver.findElement(By.id("dragBox"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(dragMeButton, 150, 100).build().perform();

	}

	public void verifyFrames() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/guru99home/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
		driver.switchTo().frame(frame);
		WebElement image = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
		image.click();
		driver.quit();
	}

	public void verifyMultipleWindowHandles() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://webdriveruniversity.com/");
		WebElement contactUsLink = driver.findElement(By.xpath("//h1[text()='CONTACT US']"));
		contactUsLink.click();
		WebElement loginPortalLink = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
		loginPortalLink.click();
		String parent = driver.getWindowHandle();
		System.out.println("Parent Window:" + parent); // prints the parent window ID

		Set<String> allWindows = driver.getWindowHandles(); // getWindowHandles() returns all opened tabs in that
															// session(including parent tab)
		for (String temp : allWindows) {
			if (!temp.equals(parent)) {
				System.out.println("Windows:" + temp);
				driver.switchTo().window(temp); // switch to the new tab to perform any action on that tab
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				System.out.println("****************************************************************");
			}
		}
		driver.quit();
	}

	public void verifyDynamicWebTable() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/indices/nse");
		WebElement showMoreLink = driver.findElement(By.xpath("//a[@id='showMoreLess']"));
		showMoreLink.click();

		WebElement table = driver.findElement(By.xpath("//table[@id='dataTable']"));
		System.out.println(table.getText());

		// print first column
		List<WebElement> indicesColumn = driver
				.findElements(By.xpath("//table[@id='dataTable']//tbody//tr//td//following-sibling::a"));
		System.out.println("Indices:");
		for (int i = 0; i < indicesColumn.size(); i++) {
			System.out.println(indicesColumn.get(i).getText());
		}

		// prints a single row - 5th row here
		WebElement tableRow = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[5]"));
		System.out.println(tableRow.getText());

		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowSize = rows.size();
		for (int i = 0; i < rowSize; i++) {
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			int columnSize = columns.size();
			for (int j = 0; j < columnSize; j++) {
				String cellData = columns.get(j).getText();
				if (cellData.equals("NIFTY BANK")) {
					System.out.println("Prev Close value is " + columns.get(1).getText());
				}
			}
		}
		driver.close();
	}

	public void verifyFileUpload() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		chooseFileButton
				.sendKeys("C:\\Users\\Lenovo\\git\\repository\\SeleniumBasics\\src\\main\\resources\\Book1.xlsx");
		WebElement checkboxButton = driver.findElement(By.id("terms"));
		checkboxButton.click();
		WebElement submitFileButton = driver.findElement(By.id("submitbutton"));
		submitFileButton.click();
		driver.close();
	}

	public void verifyKeyboardEvents() throws AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		// driver.get("https://www.google.co.in/");
		driver.close();

	}

	public void verifyFileUploadUsingRobotClass() throws AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(uploadFile).click().perform();

		StringSelection strSelection = new StringSelection(
				"C:\\Users\\Lenovo\\git\\repository\\SeleniumBasics\\src\\main\\resources\\Book1.xlsx");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(strSelection, null);

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
		// driver.close();
	}

	public static void main(String[] args) throws AWTException {
		Commands cmdObj = new Commands();
		// cmdObj.verifySwagLabsLogin();
		// cmdObj.verifyIsSelected();
		// cmdObj.verifyIsEnabled();
		// cmdObj.verifyIsDisplayed();
		// cmdObj.verifyValuesFromDropdown();
		// cmdObj.displayDropDownValues();
		// cmdObj.getTotalDropDownValues();
		// cmdObj.verifySimpleAlert();
		// cmdObj.verifyConfirmationAlert();
		// cmdObj.verifyPromptAlert();
		// cmdObj.verifyRightClick();
		// cmdObj.verifyDoubleClick();
		// cmdObj.verifyMouseHover();
		// cmdObj.verifyDragAndDrop();
		// cmdObj.verifyFrames();
		// cmdObj.verifyMultipleWindowHandles();
		// cmdObj.verifyDynamicWebTable();
		// cmdObj.verifyFileUpload();
		// cmdObj.verifyKeyboardEvents();
		// cmdObj.verifyDragAndDropUsingOffset();
		cmdObj.verifyFileUploadUsingRobotClass();

	}

}
