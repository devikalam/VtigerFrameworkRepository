package com.vtiger.crm.listenerutility;

import java.util.Date;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.crm.baseclassutility.BaseClass;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;

public class ListenerImpClass  implements ITestListener,ISuiteListener{

	ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("report configuration");
		String time = new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("crm test suite results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		//add env info & create test
		report=new ExtentReports();
		report.attachReporter(spark);

		report.setSystemInfo("os", "windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	public void onFinish(ISuite suite) {
		System.out.println("report backUp");
		report.flush();
	}
	public void onTestStart(ITestResult result) {
		System.out.println("========"+result.getMethod().getMethodName()+"====START===");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"==> STARTED");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("========"+result.getMethod().getMethodName()+"====PASS===");
		test.log(Status.PASS,result.getMethod().getMethodName()+"==> PASSED");
	}
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		WebDriverUtility wlib = new WebDriverUtility();
		String filepath = wlib.takingScreenshot(BaseClass.sdriver, testName);
		test.addScreenCaptureFromBase64String(filepath,testName);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==>FAILED");
	}
}