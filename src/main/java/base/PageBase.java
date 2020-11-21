/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    15/11/2019  - Script created.
 */
package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Reporter;

public class PageBase 
{
	public JavascriptExecutor jse;
	public Actions actions;
	public static WebDriverWait wait;
	public WebDriver driver;
	public static WebDriver jsWaitDriver;
	public static WebDriverWait jsWait;
	public static JavascriptExecutor jsExec;

	//Super constructor
	public PageBase(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void click(By element)   //Creating Click button function with reporting print
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		String text = driver.findElement(element).getText();
		driver.findElement(element).click();
		Reporter.Log("Action click successfully perfromed on " + "[" +text+"]");

	}
	
	public void type(By element,String input) //Creating function to get the text from an element
	{
		driver.findElement(element).sendKeys(input);
		Reporter.Log("Action type successfully perfromed with " + "[" +input+"]");
		
	}
	
}
