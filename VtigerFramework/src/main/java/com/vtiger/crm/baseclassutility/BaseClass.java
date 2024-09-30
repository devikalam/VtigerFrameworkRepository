package com.vtiger.crm.baseclassutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.vtiger.crm.generic.databaseutility.DatabaseUtility;
import com.vtiger.crm.generic.fileutility.ExcelUtility;
import com.vtiger.crm.generic.fileutility.FileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaUtility;
import com.vtiger.crm.generic.webdriverutility.UtilityClassObject;
import com.vtiger.crm.generic.webdriverutility.WebDriverUtility;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public DatabaseUtility dlib=new DatabaseUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBs() throws Throwable {
		dlib.getDBconnection();
		System.out.println("connect to db and report config");	
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void conficBC() throws Throwable {
		String BROWSER =flib.getDataFromPropertiesFile("browser");//browser;
		if(BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		System.out.println("launch browser");
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void conficBM() throws Throwable {
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
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void conficAM() {
		System.out.println("logout");
		HomePage hp=new HomePage(driver);
		hp.signout(driver);
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void conficAC() throws Throwable {
		System.out.println("close browser");
		driver.quit();
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void conficAS() throws Throwable {
		System.out.println("close connect to Db and report back to config");
		dlib.closeDBconnection();
		
	}
	

}
