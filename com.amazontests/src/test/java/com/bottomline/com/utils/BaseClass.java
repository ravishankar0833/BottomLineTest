package com.bottomline.com.utils;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

@Parameters("browser")
public class BaseClass{

	public static String inputPropLocation;
	public static Properties inputPropertyFile;
	public static String BROWSER;
	public static String BASEURL;    
    public static WebDriver driver;
    public static final String FailedScreenShotLocation="./FailedTestCasesScreenshots";
    public static Actions actions;
    public static JavaScriptUtils js;

	@BeforeSuite(alwaysRun = true)
	public void intializeGlobalVariables() {
		MyLogger.getLogger().info("Global Variables intialization started");
		inputPropLocation = "src/test/resources/config/amazon.properties";
		inputPropertyFile = FileHandling.openPropertiesFile(inputPropLocation);
		BROWSER = inputPropertyFile.getProperty("browser");
		BASEURL = inputPropertyFile.getProperty("baseUrl");		
		MyLogger.getLogger().info("Global Variables intialization is completed");	
	}
	
	
	public static void IntialSetup() {

		switch (BROWSER.toLowerCase()) {
		case "chrome": {

			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(chromeOptions);
			break;
		}
		case "firefox": {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			break;
		}
		default: {
			Assert.fail("invalid Browser");
			break;
		}

		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	

}
