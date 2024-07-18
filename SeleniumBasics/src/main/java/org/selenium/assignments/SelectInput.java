package org.selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectInput {
	
	public void verifySelectInputDemo() {
		WebElement currentSelectedColor;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/select-input.php");	
		WebElement color=driver.findElement(By.xpath("//select[@id='single-input-field']"));
		Select colorDropDown = new Select(color);
		currentSelectedColor=colorDropDown.getFirstSelectedOption();
		System.out.println("Current selected color:"+currentSelectedColor.getText());
		colorDropDown.selectByValue("Yellow");
		currentSelectedColor=colorDropDown.getFirstSelectedOption();
		System.out.println("Current selected color:"+currentSelectedColor.getText());
		driver.close();
	}
	public void verifyMultipleSelectDemo() {
		WebElement currentSelectedColor;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/select-input.php");	
//		WebElement colorOne=driver.findElement(By.xpath("//select[@id='multi-select-field']//option[@value='Green']"));
//		colorOne.click();
//		WebElement colorTwo=driver.findElement(By.xpath("//select[@id='multi-select-field']//option[@value='Red']"));
//		colorTwo.click();
		WebElement color=driver.findElement(By.xpath("//select[@id='multi-select-field']"));
		Select colorDropDown=new Select(color);
		colorDropDown.selectByIndex(2);
		colorDropDown.selectByIndex(0);
		currentSelectedColor=colorDropDown.getFirstSelectedOption();
		System.out.println("First selected color:"+currentSelectedColor.getText());
		//driver.close();
	}
	

	public static void main(String[] args) {
		SelectInput selectInput =new SelectInput();
		//selectInput.verifySelectInputDemo();
		selectInput.verifyMultipleSelectDemo();

	}

}
