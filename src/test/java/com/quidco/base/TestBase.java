package com.quidco.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	public static WebDriver driver;
	public static boolean Initialize;
	public static Properties OR, Config;
	public static FileInputStream ip, cf;

	public void Initialized() throws IOException {
		if (!Initialize) {
			Config = new Properties();
			cf = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/quidco/Config/Config.properties");
			Config.load(cf);
		}
	}

	public void navigate(String url) {
		driver.get(Config.getProperty(url));
	}

	public void openBrowser(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "path");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "path");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	public void dropdown(WebElement ele, String value) {
		Select dropdown = new Select(ele);
		dropdown.selectByValue(value);
	}

	public void sendkeys(WebElement element, String value) {
		element.sendKeys(Config.getProperty(value));
	}
	public void sendkeysEnter(WebElement element, String value)
	{
		element.sendKeys(Config.getProperty(value),Keys.TAB);
	}

	public void validate_Joined_User(WebElement element, String expected) {
		waitForElement(element);
		String WelcomeUser = element.getText();
		String Actual = WelcomeUser.substring(19, WelcomeUser.length());
		System.out.println(WelcomeUser);
		System.out.println(Actual);
		if (Actual.equals(Config.getProperty(expected))) {
			System.out.println("The user " +Actual+ " has joined");
		} else {
			System.err.println("The user has not joined");
		}
	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public void assertEquals(WebElement element, String expected) throws InterruptedException {
		String Actual = element.getText();
		if (Actual.equals(Config.getProperty(expected))) {
			System.out.println("The Expected and Actual Results are Matched "+Config.getProperty(expected)+"="+Actual);
		} else {
			System.err.println("The Expected and Actual Results are not Matched ");
		}

	}
	public void waitForElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	@BeforeMethod
	public void setup() throws IOException
	{ 
		Initialized();
		openBrowser("firefox");
		driver.manage().window().maximize();
		navigate("url");
     }

}
