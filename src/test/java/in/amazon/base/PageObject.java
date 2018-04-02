package in.amazon.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import in.amazon.base.PageTest;

public class PageObject extends PageTest {
	
	public void launchAUT(String url) {
		System.out.println("Launching application under test.");
		driver.get(url);
		System.out.println("Launched application under test.");
	}

	public void waitForElementToBeClickable(WebElement element) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, 30);
			explicitWait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception ex) {
			Reporter.log("Excception in waitForElementToBeVisible method." + ex.toString());
		}
	}

	public void clickElement(WebElement element, String elementText) {
		Reporter.log("Clicking on " + elementText);
		// waitForElementToBeClickable(element);
		element.click();
		Reporter.log(elementText + " element has been clicked successfully.");
	}

}
