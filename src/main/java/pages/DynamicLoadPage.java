/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    17/11/2020  - DynamicLoadPage created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;
import utilities.Reporter;

public class DynamicLoadPage extends PageBase  //Creating the Dynamic load Page
{

	public DynamicLoadPage(WebDriver driver) 
	{
		super(driver);
		wait = new WebDriverWait(driver, 30);
	}
	
	       By  EX2          = By.linkText("Example 2: Element rendered after the fact");
	       By  strtbtn      = By.xpath("//*[@id=\"start\"]/button");
	       By  Done         = By.id("finish");
	       
	    //Performing the dynamic load steps   
	
	public void OpenEXample2()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(EX2));
		click(EX2);
	}
	
	public void StartLoading()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(strtbtn));
		click(strtbtn);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Done));
	}
	
	 public String FinishLoading()
 	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(Done));
 		String Msg = driver.findElement(Done).getText();
 		Reporter.Log("Action Getting text successfully : " + "[" +Msg+"]");
 		return Msg;
 	}
 		
 	

}
