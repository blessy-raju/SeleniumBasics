package testScripts;

import java.io.IOException;
import java.util.List;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.RetryAnalyzer;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	//@Test(retryAnalyzer =RetryAnalyzer.class)
	@Test(groups="Sanity")
	public void verifyHomePageTitle() {
		driver.get("https://demowebshop.tricentis.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = ExcelUtility.getStringData(0, 0, "HomePage");
		Assert.assertEquals(actualTitle, expectedTitle, "Title Mismatch");
	}

	@Test(groups="Smoke")
	public void verifyCommunityPoolSelection() {
		driver.get("https://demowebshop.tricentis.com/");
		List<WebElement> pollList = driver.findElements(By.xpath("//li[@class='answer']"));
		String poll = ExcelUtility.getStringData(2, 0, "HomePage");
		boolean isPoorSelected;
		for (int i = 0; i < pollList.size(); i++) {
			if (pollList.get(i).getText().equals(poll)) {
				WebElement poorRadioButton = pollList.get(i).findElement(By.tagName("input"));
				poorRadioButton.click();
				isPoorSelected = poorRadioButton.isSelected();
				Assert.assertTrue(isPoorSelected, "Poor is not selected");
				break;
			}
		}

	}

}
