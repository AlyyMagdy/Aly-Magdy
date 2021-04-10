package pages;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SeleniumCommonPage;
import resources.SystemProperties;

public class LoginPage extends BasePage {
	SeleniumCommonPage selenium = new SeleniumCommonPage(webDriver);

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	By userNameField = By.id("email");
	By passwordField = By.id("pass");
	By loginBtn = By.xpath("//button[contains(@data-testid,'royal_login_button')]");
	By acceptAllCookiesBtn = By.xpath("//button[contains(@data-testid,'cookie-policy-dialog-accept-button')]");
	By createNewAccountBtn = By.xpath("//button[contains(@data-testid,'open-registration-form-button')]");
	By emailErrorMsg = By.xpath("(//input[contains(@id,'email')]//following::div)[2]");
	By passwordErrorMsg = By.xpath("(//input[contains(@id,'pass')]//following::div)[4]");

	public void openURL() throws Throwable {
		webDriver.get(SystemProperties.getSystemURL());
	}
	public JSONObject getDataFile(String dataFilePath, int index) {
		JSONArray jsonArray = null;
		JSONObject testObjects = null;
		try {
			FileReader reader = new FileReader(dataFilePath);
			JSONParser jsonParser = new JSONParser();
			jsonArray = (JSONArray) jsonParser.parse(reader);
			testObjects = (JSONObject) jsonArray.get(index);
			// testObject = (JSONObject) jsonObject;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return testObjects;
	}

	public void login(String userName, String password) {
		if (selenium.waitTillConditionalVisibilityOf(acceptAllCookiesBtn, 5)) {
			webDriver.findElement(acceptAllCookiesBtn).click();
		}
		selenium.waitTillVisibilityOf(userNameField, 20);
		selenium.waitTillElementToBeClickable(loginBtn, 20);
		webDriver.findElement(userNameField).sendKeys(userName);
		webDriver.findElement(passwordField).sendKeys(password);
		webDriver.findElement(loginBtn).click();
	}

	public boolean isLoginSuccessfull() {
		selenium.waitTillInvisibilityOf(createNewAccountBtn, 20);
		return webDriver.getCurrentUrl().contains("welcome");

	}

	public boolean isPasswordErrorMessageAppearsAsExpected() {
		return webDriver.findElement(passwordErrorMsg).getText()
				.equals("The password you’ve entered is incorrect. Forgot Password?");
	}
	
	public boolean isEmailErrorMessageAppearsAsExpected() {
		return webDriver.findElement(emailErrorMsg).getText()
				.contains("isn’t connected to an account.");
	}

}
