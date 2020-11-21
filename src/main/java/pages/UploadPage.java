/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    16/11/2020  - UploadPage created.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;
import utilities.Reporter;

public class UploadPage extends PageBase   //Creating the Upload page
{

	public UploadPage(WebDriver driver) 
	{
		super(driver);
		wait = new WebDriverWait(driver, 30);
		
	}
	
        By  filebtn       = By.id("file-upload");
        By  upload        = By.id("file-submit");
        By  uploaded      = By.id("content");
        
        public void FileUploading()    //Performing the upload steps
    	{
    		String imagename = "index.png";
    		String imagepath = System.getProperty("user.dir")+"/Uploads/"+imagename;
    		wait.until(ExpectedConditions.visibilityOfElementLocated(filebtn));
    		type(filebtn, imagepath);
    		click(upload);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(uploaded));
    		
    	}
        
        public String GettingText()    //Getting the upload message for assertion
    	{
    		String title = driver.findElement(uploaded).getText();
    		Reporter.Log("Action Getting text successfully : " + "[" +title+"]");
    		return title;
    		
    	}
    	

}
