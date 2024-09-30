package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	ExtentReports report;
	@BeforeSuite
	public void configBS() {
		//spark report confi
				ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("crm test suite results");
				spark.config().setReportName("CRM report");
				spark.config().setTheme(Theme.STANDARD);
				
				//add env info & create test
				 report=new ExtentReports();
				report.attachReporter(spark);
				
				report.setSystemInfo("os", "windows-11");
				report.setSystemInfo("BROWSER", "CHROME-100");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	@Test
	public void createContactWithOrgTest() {
		
		ExtentTest test = report.createTest("createContactWithOrgTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("hdfc".equals("hdfc")) {
			test.log(Status.PASS,"contact with org is created");
		}
		else {
			test.log(Status.FAIL,"contact  with org is not created");
		}
		report.flush();
	
	}
@Test	
public void createContactWithPhoneNoTest() {
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	TakesScreenshot ts=(TakesScreenshot)driver;
	String filepath = ts.getScreenshotAs(OutputType.BASE64);
	
		
		ExtentTest test = report.createTest("createContactWithPhoneNoTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("hdfg".equals("hfgs")) {
			test.log(Status.PASS,"contact with phno is created");
		}
		else {
			//test.log(Status.FAIL, "ErrorFile");
			//test.log(Status.FAIL,"contact with phno is not created");
			test.addScreenCaptureFromBase64String(filepath,"ErrorFile");
		}
		
	
	}

}
