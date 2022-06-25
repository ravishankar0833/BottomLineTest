package com.bottomline.com.testListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.bottomline.com.utils.BaseClass;
import com.bottomline.com.utils.MyLogger;
import com.bottomline.com.utils.ScreenShotUtils;



public class MyTestListener implements ITestListener{

	
	@Override
	public void onTestStart(ITestResult result) {
		MyLogger.getLogger().info(result.getName()+" Started");
		MyLogger.getLogger().info("**********************************************");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		MyLogger.getLogger().info(result.getName()+" Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		MyLogger.getLogger().info("Test Failed. "+result.getName());
		MyLogger.getLogger().info("Taking screenshot of the failure page");
		new ScreenShotUtils().takeCurrentWindowScreenshot(BaseClass.driver,result.getName());
		MyLogger.getLogger().info("Taking screenshot is successful");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		MyLogger.getLogger().info("Test Skipped. "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
}