/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    16/11/2020  - InternetHomePage created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class InternetHomepage extends PageBase   //Creating InternetHome page
{

	public InternetHomepage(WebDriver driver) 
	{
		super(driver);
		wait = new WebDriverWait(driver, 30);
	}
	
	       By  uploadpage    = By.linkText("File Upload");
           By  Dynamicpage   = By.linkText("Dynamic Loading");
	
	public void OpenFileUpload()   //Opening the file upload page method
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(uploadpage));
		click(uploadpage);
	}
	
	public void OpenDynamicLoading()  //Opening the dynamic loading page method
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(Dynamicpage));
		click(Dynamicpage);
	}
	
}
