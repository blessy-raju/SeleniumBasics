package org.selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxDemo {

	public void verifySingleCheckboxDemo() {
		boolean isCheckboxSelected;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/check-box-demo.php");		
		WebElement singleCheckbox = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		isCheckboxSelected=singleCheckbox.isSelected();
		System.out.println("Checkbox before selection:"+isCheckboxSelected);
		singleCheckbox.click();
		isCheckboxSelected=singleCheckbox.isSelected();
		System.out.println("Checkbox after selection:"+isCheckboxSelected);
		driver.close();
	}
	
	public void verifyMultipleCheckboxDemo() {
		boolean isCheckboxSelected;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/check-box-demo.php");		
		WebElement checkboxThree = driver.findElement(By.xpath("//input[@id='check-box-three']"));
		isCheckboxSelected=checkboxThree.isSelected();
		System.out.println("Checkbox before selection:"+isCheckboxSelected);
		WebElement selectAllButton = driver.findElement(By.xpath("//input[@id='button-two']"));
		selectAllButton.click();
		isCheckboxSelected=checkboxThree.isSelected();
		System.out.println("Checkbox after selection:"+isCheckboxSelected);
		//driver.close();
	}

	public static void main(String[] args) {
		CheckboxDemo checkboxDemo = new CheckboxDemo();
		//checkboxDemo.verifySingleCheckboxDemo();
		checkboxDemo.verifyMultipleCheckboxDemo();

	}

}
