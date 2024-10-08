package com.vtiger.crm.baseclassutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.crm.generic.databaseutility.DatabaseUtility;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
import com.vtiger.crm.objectrepositoryutility.HomePage.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage.LoginPage;

public class BaseClass {
	public DatabaseUtility dlib=new DatabaseUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
	public void configBs() throws Throwable {
		dlib.getDBconnection();
		System.out.println("connect to db and report config");	
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest","RegressionTest"})
	public void conficBC(/*String browser*/) throws Throwable {
		
		String BROWSER =flib.getDataFromPropertiesFile("browser");//browser;
		
		//String BROWSER=System.getProperty("browser");
		if(BROWSER.equals("chrome")) {
			//ChromeOptions copt=new ChromeOptions();
			//copt.addArguments("--headless");
			
		
		driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			/*EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless");*/
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			//FirefoxOptions fopt=new FirefoxOptions();
			//fopt.addArguments("-Private");
			//fopt.addArguments("--headless");
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		System.out.println("launch browser");
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
	public void conficBM() throws Throwable {
		//String URL=System.getProperty("url");
		//String USERNAME=System.getProperty("username");
		//String PASSWORD=System.getProperty("password");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		
		driver.get(URL);
		wlib.getwaitForPageToLoad(driver);
		wlib.maximizeWindow(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("login");
	}
	@AfterMethod(groups = {"SmokeTest","RegressionTest"})
	public void conficAM() {
		System.out.println("logout");
		HomePage hp=new HomePage(driver);
		hp.signout(driver);
	}
	@AfterClass(groups = {"SmokeTest","RegressionTest"})
	public void conficAC() throws Throwable {
		System.out.println("close browser");
		driver.quit();
	}
	@AfterSuite(groups = {"SmokeTest","RegressionTest"})
	public void conficAS() throws Throwable {
		System.out.println("close connect to Db and report back to config");
		dlib.closeDBconnection();
		
	}
	

}
