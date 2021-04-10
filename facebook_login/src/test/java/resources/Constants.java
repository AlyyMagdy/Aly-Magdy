package resources;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Constants extends SystemProperties {
	private static WebDriver webDriver;

	@BeforeMethod
	public void setUp() throws Throwable {
		webDriver = getSeleniumBrowser();
		webDriver.manage().window().maximize();
		
	}

	@AfterMethod
	public static void closeBrowser() {
		webDriver.quit();
	}

	public static WebDriver getWebDriver() {
		return webDriver;
	}
}
