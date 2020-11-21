/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    15/11/2019  - Script created.
 */
package utilities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class Helper 
{
	//private static final String TIMESTAMP_FORMAT = "dd-MM-yyyy HH:mm:ss.SSSS aaa";
	//private static final Logger slf4jLogger = LoggerFactory.getLogger(ReportManager.class);

	public static final String PATTERN_1000_SEP_INT = "###,###";
	public static final String PATTERN_1000_SEP_FLOAT = "###,###.##";
	public static String text;

	/** Method to take screenshot in case the test case fail
	 * 
	 * @param driver used WebDriver
	 * @param screenshotname takes the screenshot wanted name
	 */
	public static void captureScreenShot(WebDriver driver, String screenshotname) 
	{
		Path dest = Paths.get("./Screenshots", screenshotname + ".png");
		try 
		{
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();

		} 
		catch (IOException e) 
		{
			System.out.println("Exception while taking screenshot" + e.getMessage());
		}
	}


	/**
	 * Method to add attachments to allure report 
	 * @param screenShotName insert the screenshotName
	 * @param screenShotPath insert the screenshot path
	 * @throws IOException
	 */
	public static void addAttachmenetsToAllure(String screenShotName, String screenShotPath) throws IOException 
	{
		Path content = Paths.get(System.getProperty("user.dir")+"\\"+screenShotPath);
		try (InputStream is = Files.newInputStream(content)) 
		{
			Allure.addAttachment(screenShotName, is);
		}
	}

	/**
	 * Add the created video as attachments into allure report
	 * @param attachmentType insert attachment Type 
	 * @param attachmentName insert attachment name
	 * @param attachmentContent insert the attachment content  
	 * @throws IOException
	 */
	public static void addAttachmenetsVideoToAllure(String attachmentType, String attachmentName, InputStream attachmentContent) throws IOException 
	{
		createAttachment(attachmentType, attachmentName, attachmentContent);
	}


	/**
	 * Create attachment to be inserted 
	 * @param attachmentType
	 * @param attachmentName
	 * @param attachmentContent
	 */
	private static void createAttachment(String attachmentType, String attachmentName, InputStream attachmentContent) 
	{
		//InputStream attachmentContentCopy = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		try 
		{
			while ((len = attachmentContent.read(buffer)) > -1) 
			{
				baos.write(buffer, 0, len);
			}
			baos.flush();
		} 
		catch (IOException e) 
		{
			//slf4jLogger.info("Error while creating Attachment", e);
		}

		attachmentContent = new ByteArrayInputStream(baos.toByteArray());
		//attachmentContentCopy = new ByteArrayInputStream(baos.toByteArray());

		String attachmentDescription = "Attachment: " + attachmentType + " - " + attachmentName;

		if (attachmentType.toLowerCase().contains("screenshot")) 
		{
			Allure.addAttachment(attachmentDescription, "image/png", attachmentContent, ".png");
		} 
		else if (attachmentType.toLowerCase().contains("recording")) 
		{
			Allure.addAttachment(attachmentDescription, "video/quicktime", attachmentContent, ".mov");
			// attachmentName, "video/mp4", attachmentContent, ".mp4"
		} 
		else if (attachmentType.toLowerCase().contains("gif")) 
		{
			Allure.addAttachment(attachmentDescription, "image/gif", attachmentContent, ".gif");
		} 
		else if (attachmentType.toLowerCase().contains("engine logs")) 
		{
			if (attachmentName.equals("Current Method log")) 
			{
				//Allure.addAttachment(attachmentDescription, "text/plain", new StringInputStream(currentTestLog.trim()),	".txt");
			} else 
			{
				Allure.addAttachment(attachmentDescription, "text/plain", attachmentContent, ".txt");
			}
		} 
		else if (attachmentType.toLowerCase().contains("csv") || attachmentName.toLowerCase().contains("csv")) 
		{
			Allure.addAttachment(attachmentDescription, "text/csv", attachmentContent, ".csv");
		} 
		else if (attachmentType.toLowerCase().contains("xml") || attachmentName.toLowerCase().contains("xml")) 
		{
			Allure.addAttachment(attachmentDescription, "text/xml", attachmentContent, ".xml");
		} 
		else if (attachmentType.toLowerCase().contains("json") || attachmentName.toLowerCase().contains("json")) 
		{
			Allure.addAttachment(attachmentDescription, "text/json", attachmentContent, ".json");
		} 
		else 
		{
			Allure.addAttachment(attachmentDescription, attachmentContent);
		}

	}


}
