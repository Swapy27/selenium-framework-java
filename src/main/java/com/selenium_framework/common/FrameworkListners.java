package com.selenium_framework.common;

import javax.script.Invocable;

import org.omg.CORBA.portable.InvokeHandler;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class FrameworkListners implements IInvokedMethodListener{

	
	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
		if (arg0.isTestMethod())
		WebDriverFactory.getDriver();
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
		if (arg0.isTestMethod())///one liner if 
		WebDriverFactory.createWebdriverInstance();
	}

	
}
