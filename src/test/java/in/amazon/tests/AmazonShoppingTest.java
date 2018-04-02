package in.amazon.tests;

import org.testng.annotations.Test;

import in.amazon.base.PageObject;
import in.amazon.pages.AmazonLandingPage;

public class AmazonShoppingTest extends PageObject {
	
	@Test 
	public void amazonTest() {
		AmazonLandingPage amazonLandingPage = new AmazonLandingPage();
		amazonLandingPage.clickShopByCategory();
		amazonLandingPage.mainMenu("Men's fashion");
	}	
}
