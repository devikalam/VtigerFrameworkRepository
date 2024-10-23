package com.vtiger.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzerimp implements IRetryAnalyzer{
int c=0;
int limitCount=5;
	@Override
	public boolean retry(ITestResult result) {
	if(c<limitCount) {
		c++;
		return true;
	}
		return false;
	}

}
