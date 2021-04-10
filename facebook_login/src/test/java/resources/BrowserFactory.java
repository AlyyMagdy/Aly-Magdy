package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		return new ChromeDriver();
	}

	public WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
		return new FirefoxDriver();
	}
}
