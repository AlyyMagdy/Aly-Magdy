package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommonPage extends BasePage {

	public SeleniumCommonPage(WebDriver webDriver) {
		super(webDriver);
	}

	public boolean waitTillConditionalVisibilityOf(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, seconds);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return webDriver.findElement(by).isDisplayed();
		} catch (TimeoutException ex) {
			return false;
		}
	}

	public void waitTillInvisibilityOf(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, seconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

	}

	public void waitTillVisibilityOf(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}
	public void waitTillElementToBeClickable(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(by));

	}
}
