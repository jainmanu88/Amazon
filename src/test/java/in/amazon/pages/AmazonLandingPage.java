package in.amazon.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import in.amazon.base.PageObject;

public class AmazonLandingPage extends PageObject {
	public AmazonLandingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='nav-link-shopall']")
	private WebElement btnShopByCategory;

	@FindBy(xpath = "//span[@class='nav-hasPanel                              nav-item']")
	private List<WebElement> lnkMainCategory;

	@FindBy(xpath = "//span[@class='nav-link                                    nav-item']")
	private WebElement lnkSubCategory;

	public void clickShopByCategory() {
		clickElement(btnShopByCategory, "Shop By Category link.");
	}	
	
	public void mainMenu(String mainMenu){
		boolean mainMenuFound = false;
		
		for (WebElement mainCategory : lnkMainCategory) {
			if(mainCategory.getAttribute("aria-label").trim().equals(mainMenu)){
				mainMenuFound = true;
			} 
		}
		
		if(!mainMenuFound){
			System.out.println("Invalid Main Menu category.");
		}
	}
}
