package testScripts;

import java.util.List;

import org.automationcore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base{
	@Test
	public void verifyHomePageTitle() {
		driver.get("https://demowebshop.tricentis.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Demo Web Shop";
		Assert.assertEquals(actualTitle, expectedTitle, "Title Mismatch");
	}
	
	@Test
	public void verifyCommunityPoolSelection() {
		driver.get("https://demowebshop.tricentis.com/");
		List<WebElement> pollList = driver.findElements(By.xpath("//li[@class='answer']"));
		for(int i=0;i<pollList.size();i++) {
			if(pollList.get(i).getText().equals("Poor")) {
				WebElement poorRadioButton = pollList.get(i).findElement(By.tagName("input"));
				poorRadioButton.click();
				boolean isPoorSelected = poorRadioButton.isSelected();
				Assert.assertTrue(isPoorSelected, "Poor is not selected");
				break;
			}
		}

	}

}
