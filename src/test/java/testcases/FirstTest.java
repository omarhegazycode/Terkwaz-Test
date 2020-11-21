/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    15/11/2020  - FirstTestCase Created.
 */
package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.GoogleHomePage;
import pages.GoogleSearchPage;
import utilities.Reporter;


/**
 In this test case the search result will be different from system to another according to these reasons:
 -browser type
 -the timing of searching
 -User logged in his google account or not
 all of these reasons will affect on the arrangement of the results, so I made my assertion on the first search page that 
 contains "What is Selenium WebDriver?"
 */

public class FirstTest extends TestBase
{
	GoogleHomePage GoogleHomePageObject;
	GoogleSearchPage GoogleSearchPageObject;
	String googleURL = utilities.LoadProperties.userData.getProperty("googleURL");   //Getting the URL from data file
	
	
	@Test
	public void FirstTestCase()
	{
		
		openBrowser(googleURL);   //Opening the browser to perform the test case Steps
		
		GoogleHomePageObject = new GoogleHomePage(driver);
		GoogleHomePageObject.searchingByName("selenium webdriver");
		GoogleSearchPageObject = new GoogleSearchPage(driver);
		String newtextline = GoogleSearchPageObject.Checkingext();
		Assert.assertTrue(newtextline.contains("What is Selenium WebDriver?")); //Asserting on the search results
		Reporter.Log("### First test case passed successfully ###");
	}

}
