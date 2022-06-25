package com.bottomline.com.testListeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.bottomline.com.utils.MyLogger;


public class MySuiteListener implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {

		MyLogger.init();
		MyLogger.getLogger().info("Suite "+ suite.getName().toUpperCase()+" execution Started"  );
		}

	@Override
	public void onFinish(ISuite suite) {
		MyLogger.getLogger().info("Suite "+ suite.getName().toUpperCase()+" execution Finished"  );
	}

}