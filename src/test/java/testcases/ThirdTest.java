/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    17/11/2020  - ThirdTestCase created.
 */
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DynamicLoadPage;
import pages.InternetHomepage;
import utilities.Reporter;


public class ThirdTest extends TestBase
{
	InternetHomepage internetHomepageobject;
	DynamicLoadPage DynamicLoadPageObject;
	String herokuappURL = utilities.LoadProperties.userData.getProperty("herokuappURL");   //Getting the URL from data file
	
	@Test
	
	public void ThirdTestCase()
	{
       
		openBrowser(herokuappURL );  //Opening the browser to perform the test case Steps
		
		internetHomepageobject = new InternetHomepage(driver);
		internetHomepageobject.OpenDynamicLoading();
		DynamicLoadPageObject = new DynamicLoadPage(driver);
		DynamicLoadPageObject.OpenEXample2();
		DynamicLoadPageObject.StartLoading();
		String NewMsg = DynamicLoadPageObject.FinishLoading();
		Assert.assertTrue(NewMsg.contains("Hello World!")); //Asserting that the loading process completed
		Reporter.Log("### Third test case passed successfully ###");
	}

}
