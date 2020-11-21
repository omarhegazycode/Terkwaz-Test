/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    16/11/2020  - SecondTestCase created.
 */
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.InternetHomepage;
import pages.UploadPage;
import utilities.Reporter;

public class SecondTest extends TestBase
{
	InternetHomepage internetHomepageobject;
	UploadPage UploadPageObject;
	String herokuappURL = utilities.LoadProperties.userData.getProperty("herokuappURL"); //Getting the URL from data file
	
	@Test
	public void SecondTestCase()
	{
		openBrowser(herokuappURL );  //Opening the browser to perform the test case Steps
		
		internetHomepageobject = new InternetHomepage(driver);
		UploadPageObject = new UploadPage(driver);
		internetHomepageobject.OpenFileUpload();
		UploadPageObject.FileUploading();
		String newtitle = UploadPageObject.GettingText();
		Assert.assertTrue(newtitle.contains("File Uploaded!"));  //Asserting that the uploading process completed
		Reporter.Log("### Second test case passed successfully ###");
		
	}

}
