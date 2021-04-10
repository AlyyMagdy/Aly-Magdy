package facebook.facebook_login;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import pages.LoginPage;
import resources.Constants;

public class LoginTest extends Constants {

	@Test(description = "Login with valid credentials")
	public void loginWithValidCredentials() throws Throwable {
		LoginPage loginPage = new LoginPage(getWebDriver());
		loginPage.openURL();
		JSONObject json = loginPage.getDataFile("target\\testdata.json", 0);
		loginPage.login(json.get("email").toString(), json.get("password").toString());
		assertEquals(loginPage.isLoginSuccessfull(), json.get("validUser"));

	}

	@Test(description = "Login with invalid password")
	public void loginWithInvalidPassword() throws Throwable {
		LoginPage loginPage = new LoginPage(getWebDriver());
		loginPage.openURL();
		JSONObject json = loginPage.getDataFile("target\\testdata.json", 1);
		loginPage.login(json.get("email").toString(), json.get("password").toString());
		assertEquals(loginPage.isLoginSuccessfull(), json.get("validUser"));
		assertTrue(loginPage.isPasswordErrorMessageAppearsAsExpected());

	}

	@Test(description = "Login with invalid email")
	public void loginWithInvalidEmail() throws Throwable {
		LoginPage loginPage = new LoginPage(getWebDriver());
		loginPage.openURL();
		JSONObject json = loginPage.getDataFile("target\\testdata.json", 2);
		loginPage.login(json.get("email").toString(), json.get("password").toString());
		assertEquals(loginPage.isLoginSuccessfull(), json.get("validUser"));
		assertTrue(loginPage.isEmailErrorMessageAppearsAsExpected());
	}

	@Test(description = "Login with empty credentials")
	public void loginWithEmptyEmailAndPassword() throws Throwable {
		LoginPage loginPage = new LoginPage(getWebDriver());
		loginPage.openURL();
		JSONObject json = loginPage.getDataFile("target\\testdata.json", 3);
		loginPage.login(json.get("email").toString(), json.get("password").toString());
		assertEquals(loginPage.isLoginSuccessfull(), json.get("validUser"));
		assertTrue(loginPage.isEmailErrorMessageAppearsAsExpected());
	}

	@Test(description = "Login with empty email")
	public void loginWithEmptyEmail() throws Throwable {
		LoginPage loginPage = new LoginPage(getWebDriver());
		loginPage.openURL();
		JSONObject json = loginPage.getDataFile("target\\testdata.json", 4);
		loginPage.login(json.get("email").toString(), json.get("password").toString());
		assertEquals(loginPage.isLoginSuccessfull(), json.get("validUser"));
		assertTrue(loginPage.isEmailErrorMessageAppearsAsExpected());

	}

	@Test(description = "Login with empty password")
	public void loginWithEmptyPassword() throws Throwable {
		LoginPage loginPage = new LoginPage(getWebDriver());
		loginPage.openURL();
		JSONObject json = loginPage.getDataFile("target\\testdata.json", 5);
		loginPage.login(json.get("email").toString(), json.get("password").toString());
		assertEquals(loginPage.isLoginSuccessfull(), json.get("validUser"));
		assertTrue(loginPage.isPasswordErrorMessageAppearsAsExpected());

	}

}
