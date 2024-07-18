package org.selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleFormDemo {
	
	public void verifySingleInputField() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		WebElement messageTextBox=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		messageTextBox.sendKeys("Hello Selenium");
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		showMessageButton.click();
		driver.close();
	}
	public void verifyTwoInputFields() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		WebElement valueA=driver.findElement(By.xpath("//input[@id='value-a']"));
		valueA.sendKeys("7");
		WebElement valueB=driver.findElement(By.xpath("//input[@id='value-b']"));
		valueB.sendKeys("11");		
		WebElement getTotalButton=driver.findElement(By.xpath("//button[@id='button-two']"));
		getTotalButton.click();	
		driver.close();
	}

	public static void main(String[] args) {
		SimpleFormDemo formDemo = new SimpleFormDemo();
		//formDemo.verifySingleInputField();
		formDemo.verifyTwoInputFields();
	}

}
