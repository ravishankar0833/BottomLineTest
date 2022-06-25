package com.bottomline.com.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShotUtils extends BaseClass{
	
	public void takeCurrentWindowScreenshot(WebDriver driver,String methodName) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(file, new File(FailedScreenShotLocation+"/"+methodName+".png"));
		} catch (IOException e) {
			MyLogger.getLogger().error(e.toString());
			Assert.fail("IO Exception while taking Current Window Screenshot");
			
		}
	}
	
	public void takeEntireWebPageScreenShot(WebDriver driver,String methodName) {
		Screenshot screenshot=new AShot().takeScreenshot(driver); 
	    try {
			ImageIO.write(screenshot.getImage(),"PNG",new File(FailedScreenShotLocation+"/"+methodName+".png"));
		} catch (IOException e) {
			MyLogger.getLogger().error(e.toString());
			Assert.fail("IO Exception while taking Entire Window Screenshot");
		}
	}
	
	public void takeWebElementScreenshot(WebDriver driver, WebElement element,String methodName) {
		Screenshot Screenshot_webelement = 
				new AShot().shootingStrategy(
						ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, element);
		 
	 
	     try {
			ImageIO.write(Screenshot_webelement.getImage(),"png",new File(FailedScreenShotLocation+"/"+methodName+".jpeg"));
		} catch (IOException e) {
			MyLogger.getLogger().error(e.toString());
			Assert.fail("IO Exception while taking Current Webelement Screenshot");
		}
	}
	
	public void CompareImages(WebDriver driver, WebElement element, String originalImageLocation) {
		  Screenshot logoSrcshot = new AShot().takeScreenshot(driver, element);
		 
		  // Reading the image for comparison
		 
		  BufferedImage expectedImage = null;
			try {
				expectedImage = ImageIO.read(new File(originalImageLocation));
			} catch (IOException e) {
				MyLogger.getLogger().error(e.toString());
				Assert.fail("IO Exception while taking Comparing Images");
			}
		  BufferedImage actualImage = logoSrcshot.getImage();
		 
		  ImageDiffer img_differnece = new ImageDiffer();
		 
		 // Creating ImageDiffer object and calling the method makeDiff()
		 
		  ImageDiff differnece = img_differnece.makeDiff(actualImage, expectedImage);
		 
		  if (differnece.hasDiff() == true)        //Checking the difference using in-built functions)
		  {
			  MyLogger.getLogger().info("Both logo images matched"); //in case when no difference found
		  }
		   
		  else
		  {
			  MyLogger.getLogger().info("The logo images are different"); //in case when difference found
		  }
		   
		   }
	

}
