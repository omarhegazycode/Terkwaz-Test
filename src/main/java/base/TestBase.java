/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    15/11/2019  - Script created.
 */
package base;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;
import utilities.Reporter;

public class TestBase 
{
	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";
	
	public static ChromeOptions chromeOption() 
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		//options.addArguments("--headless");
		return options;
	}
	
	public FirefoxOptions firefoxOptions()
	{
		 FirefoxOptions options = new FirefoxOptions();
         options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
         HashMap<String, Object> firefoxPrefs = new HashMap<String, Object>();
         firefoxPrefs.put("profile.default.content_settings.popups", 0);
         firefoxPrefs.put("download.default_directory", downloadPath);
         options.addArguments("--start-maximized");
         options.addArguments("--headless");
         options.addArguments("--disable-gpu");
         //options.addArguments("--no-sandbox");
         //options.addArguments("--disable-extensions");
        // options.addArguments("--no-proxy-server");
         //options.addArguments("--max-gum-fps=20");
         //options.addArguments("--incognito");
         //driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 return options;
		
	}
	
		
	@BeforeClass(alwaysRun = true)
	@Parameters({"browser"})
	public void startDriver() throws IOException, InterruptedException 
	{
		String browserName = utilities.LoadProperties.userData.getProperty("browserName");
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOption());
		} else if (browserName.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.startRecording();
		
	}

	
	@AfterClass(alwaysRun = true)
	public void closeDriver() throws IOException 
	{
		Reporter.stopRecording();
		driver.quit();
		Reporter.attachRecording();
	}


	//////////////////////// take screenshot when test case failed and add it in the Screenshots folder ////////////////////////
	@AfterMethod(alwaysRun = true)
	public void screenShotOnFailure(ITestResult result) throws IOException 
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			System.out.println("Failed");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenShot(driver, result.getName());
			Helper.addAttachmenetsToAllure( result.getName(), "Screenshots\\"+ result.getName()+ ".png");
		}
	}

	public static void openBrowser(String URL)
	{
		driver.navigate().to(URL);
		Reporter.Log("Navigated to browser : " + URL);
	}
}