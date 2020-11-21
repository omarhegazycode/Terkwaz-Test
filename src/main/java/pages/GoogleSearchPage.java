/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    15/11/2020  - GoogleSearchPage created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;
import utilities.Reporter;

public class GoogleSearchPage extends PageBase   //Creating the Google Search Page
{

	public GoogleSearchPage(WebDriver driver) 
	{
		super(driver);
		wait = new WebDriverWait(driver, 30);
	}
	
	By  text       = By.id("rcnt");
	
	public String Checkingext()     //Performing the search steps and getting text for assertion 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(text));
		String TextLine = driver.findElement(text).getText();
		Reporter.Log("Action Getting text successfully : " + "[" +TextLine+"]");
		return TextLine;
		
	}

}
