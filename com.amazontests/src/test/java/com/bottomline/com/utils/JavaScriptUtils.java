package com.bottomline.com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class JavaScriptUtils extends BaseClass{
	
	private static JavascriptExecutor js ;
	private static WebDriver driver;
	
	
	public static void setUp(WebDriver driver_inst) {
		driver=driver_inst;
		js=(JavascriptExecutor) driver;
	}
	
	
	public static void CheckifPageIsLoaded(WebDriver driver_inst) {
		setUp(driver_inst);
		if (js.executeScript("return document.readyState").toString().equals("complete")){
			MyLogger.getLogger().info("Page has loaded");
			}
	}
	
	public void ScrollUp(WebDriver driver_inst) {
		setUp(driver_inst);
		js.executeScript("window.scrollBy(0,-350)", "");
		MyLogger.getLogger().info("Scroll up completed");
	}
	
	public void ScrollDown(WebDriver driver_inst) {
		setUp(driver_inst);
		js.executeScript("window.scrollBy(0,350)", "");
		MyLogger.getLogger().info("Scroll down completed");
	}
	
	public static void ScrollToVisibleWebElement(WebDriver driver_inst,WebElement element) {
		setUp(driver_inst);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		CustomScroll(driver_inst,0, -25);
		MyLogger.getLogger().info("Scroll to Webelement:"+ element+" completed");
	}
	
	public void ScrollToBottomOfPage(WebDriver driver_inst) {
		setUp(driver_inst);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		MyLogger.getLogger().info("Scroll to Bottom of page completed");
	}
	
	public static void CustomScroll(WebDriver driver_inst,int pixel1, int pixel2) {
		setUp(driver_inst);
		js.executeScript("window.scrollBy("+pixel1+","+pixel2+")", "");
		MyLogger.getLogger().info("Scroll to "+pixel1+", "+pixel2+" is completed");
	}
	
	

}
