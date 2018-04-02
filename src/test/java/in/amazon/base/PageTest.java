package in.amazon.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class PageTest {
	public static WebDriver driver;
	
	@BeforeSuite
	public static void beforeSuite() {
		System.out.println("Inside beforeSuite method.");
	}
	
	@Parameters({ "browserName","url" })
	@BeforeMethod
	public void beforeMethod(String browserName, String url) {
		System.out.println("Inside beforeMethod method.");
		switch (browserName) {
		case "Chrome":
			initChrome(url);
			break;
		default:
			System.out.println("Invalid browser name.");
			Assert.fail("Invalid browser name.");
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside After Method method.");
	}
	
	@AfterSuite
	public static void afterSuite() {
		System.out.println("Inside After Suite Method.");
	}
	
	public void  initChrome(String url) {
		String basePath = System.getProperty("user.dir");
		String finalPath = basePath + "//servers//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", finalPath);
		
		System.out.println("Launching Chrome browser.");
		driver = new ChromeDriver();
		driver.get(url);
		System.out.println("Chrome browser launched.");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
}