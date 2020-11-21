/**
 * Copyright (c) Engineer Omar Hegazy.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Omar Hegazy	    15/11/2019  - Script created.
 */
package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties 
{
	/**
	 * Load the properties file from the folder
	 */
	public static Properties userData =  
			loadProperties(System.getProperty("user.dir")+"\\src\\test\\resources\\TestDataFiles\\TestData.properties"); 
	
	
	/**
	 * Load the properties file
	 * @param path insert the path of the properties file
	 * @return properties file
	 */
	private static Properties loadProperties(String path)
	{
		Properties pro = new Properties();
		// stream for reading file 
		try 
		{
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} 
		catch (FileNotFoundException e) 
		{
		System.out.println("Error occurred :  " + e.getMessage());
		} 
		catch (IOException e) 
		{
			System.out.println("Error occurred :  " + e.getMessage());
		} 
		catch (NullPointerException e) 
		{
			System.out.println("Error occurred :  " + e.getMessage());
		} 
	
		return pro; 
	}
}