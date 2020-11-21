/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    15/11/2020  - GoogleHomePage Created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class GoogleHomePage extends PageBase      //Creating GoogleHome page
{

	public GoogleHomePage(WebDriver driver) 
	{
		super(driver);
		wait = new WebDriverWait(driver, 30);
	}

	By googleSearchInput = By.name("q");
	By searchBtn 		 = By.name("btnK");
	
	
	public void searchingByName(String sarchInput) //Performing the search steps
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(googleSearchInput));
		type(googleSearchInput, sarchInput);
		click(searchBtn);
	}
}
