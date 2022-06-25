package com.bottomline.com.testListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {
	 
	  private int retryCount = 0;
	  private static final int maxRetryCount = 1;
	 
	    @Override
	    public boolean retry(ITestResult iTestResult) {
	        if (!iTestResult.isSuccess()) {                     //Check if test not succeed
	            if (retryCount < maxRetryCount) {                           //Check if maxTry count is reached
	            	retryCount++;                                    //Increase the maxTry count by 1
	                return true;                                //Tells TestNG to re-run the test
	            }
	        } else {
	            iTestResult.setStatus(ITestResult.SUCCESS);     //If test passes, TestNG marks it as passed
	        }
	        return false;
	    }
}