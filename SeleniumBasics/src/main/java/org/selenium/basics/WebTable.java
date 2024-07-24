package org.selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebTable {
	
	public void getColumnValues() {
		String company;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		List <WebElement> col= driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		for(int i=1;i<col.size();i++) {
			company = driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr["+i+"]//a")).getText();
			System.out.println(company);
		}
		
	}
	
	public void getRowValues() {
		//String company;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		List <WebElement> row = driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		for(int r=1;r<=row.size();r++) {
			//System.out.println(row.get(i).getLast());
		}
		
	}
	
	public static void main(String[] args) {
		WebTable wt= new WebTable();
		wt.getColumnValues();

	}

}
