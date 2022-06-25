package com.bottomline.com.testListeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {
    public RetryListener() {
    }

	@Override
	public void transform(ITestAnnotation annotation,
			Class testClass,
			Constructor testConstructor, 
			Method testMethod) {
		
		
			annotation.setRetryAnalyzer(MyRetry.class);
			
}
}
