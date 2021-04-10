package resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import resources.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class SystemProperties {
	
	/**Load System Properties only one time instead of calling the function several time**/
	
	private static final Properties SYSTEM_PROPS = loadSystemProperties();

	private static Properties loadSystemProperties() {
		Properties systemProps = new Properties();
		try {
			InputStream appConfigIn = SystemProperties.class.getClassLoader()
					.getResourceAsStream("resources\\application.properties");
			if (appConfigIn == null) {
				throw new IllegalArgumentException("system.properties not found");
			}
			systemProps.load(appConfigIn);

		} catch (IOException e) {

			throw new IllegalArgumentException(e);
		}
		return systemProps;
	}

	public static WebDriver getSeleniumBrowser() throws Throwable {
		BrowserFactory browserFactory = new BrowserFactory();
		String seleniumBrowser = SYSTEM_PROPS.getProperty("selenium.browser");
		if (seleniumBrowser == null) {
			throw new IllegalArgumentException("selenium.browser configuration not found in application.properties");
		} else {
			switch (seleniumBrowser) {
			case "Chrome":
				return browserFactory.getChromeDriver();
			case "Firefox":
				return browserFactory.getFirefoxDriver();
			default:
				throw new Exception(seleniumBrowser + " is not supported browser");
			}

		}
	}

	public static String getSystemURL() throws Throwable {
		String systemURL = SYSTEM_PROPS.getProperty("selenium.server.url");
		if (systemURL == null) {
			throw new IllegalArgumentException("selenium.browser configuration not found in application.properties");
		} else {
			return systemURL;

		}
	}
}
