package com.bottomline.com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

public class FileHandling {
	
	public static Properties openPropertiesFile(String fileLocation) {
		Properties prop=new Properties();
		try {			
			FileReader reader = new FileReader(new File(fileLocation));
			prop.load(reader);
			
		} catch (FileNotFoundException e) {
			MyLogger.getLogger().info(e.toString());
			Assert.fail("File not Found Exception");
		} catch (IOException e) {
			MyLogger.getLogger().info(e.toString());
			Assert.fail("File Interuppeted Exception");
		}		
		return prop;
		
	}

}
