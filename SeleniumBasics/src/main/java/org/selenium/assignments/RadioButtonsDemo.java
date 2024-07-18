package org.selenium.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsDemo {
	
	public void verifyRadioButtonDemo() {
		boolean isRadioButtonSelected;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/radio-button-demo.php");		
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		isRadioButtonSelected=femaleRadioButton.isSelected();
		System.out.println("Checkbox before selection:"+isRadioButtonSelected);
		femaleRadioButton.click();
		isRadioButtonSelected=femaleRadioButton.isSelected();
		System.out.println("Checkbox after selection:"+isRadioButtonSelected);
		driver.close();
	}
	
	public void verifyGroupRadioButtonDemo() {
		boolean isGenderButtonSelected, isAgeButtonSelected;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/radio-button-demo.php");
		WebElement genderRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio21']"));
		isGenderButtonSelected=genderRadioButton.isSelected();
		System.out.println("Gender Radio button before selection:"+isGenderButtonSelected);
		genderRadioButton.click();
		isGenderButtonSelected=genderRadioButton.isSelected();
		System.out.println("Gender radio button after selection:"+isGenderButtonSelected);
		
		WebElement ageRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio24']"));
		isAgeButtonSelected=ageRadioButton.isSelected();
		System.out.println("Age radio button before selection:"+isAgeButtonSelected);
		ageRadioButton.click();
		isAgeButtonSelected=ageRadioButton.isSelected();
		System.out.println("Age radio button after selection:"+isAgeButtonSelected);	
		WebElement getResultButton=driver.findElement(By.xpath("//button[@id='button-two']"));
		getResultButton.click();
		driver.close();
	}

	public static void main(String[] args) {
		RadioButtonsDemo radioButtonsDemo = new RadioButtonsDemo();
		//radioButtonsDemo.verifyRadioButtonDemo();
		radioButtonsDemo.verifyGroupRadioButtonDemo();

	}

}
